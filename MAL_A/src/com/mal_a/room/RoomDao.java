package com.mal_a.room;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mal_a.cmn.ConnectionMaker;
import com.mal_a.cmn.DTO;
import com.mal_a.cmn.JDBCResClose;
import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.WorkDiv;
import com.mal_a.filemng.FileMngDao;
import com.mal_a.filemng.FileMngVO;
import com.mal_a.payment.PaymentVO;

public class RoomDao extends WorkDiv {

	private ConnectionMaker connectionMaker;
	   //1.CRUD: 
	   //1.1. 등록: int doInsert(DTO dto) 
	   //1.2. 수정: int doUpdate(DTO dto)  
	   //1.3. 삭제: int doDelete(DTO dto)
	   //1.4. 단건조회:DTO doSelectOne(DTO dto)
	   //1.5. 목록조회:List<?> doRetrieve(DTO dto)
	
	private FileMngDao fileMngDao;
	   
		public RoomDao() {
			connectionMaker = new ConnectionMaker();
			fileMngDao = new FileMngDao();
		}
	
	@Override
	public DTO doSelectOne(DTO dto) {
		RoomVO inVO = (RoomVO) dto;//param
		RoomVO outVO = null;//return
		
		Connection connection = null;//DB Connection
		PreparedStatement pstmt = null;// vs Statement(해킹에 취약해서 쓰이지않음)
		ResultSet rs = null;//결과값 처리 class
		
		try {
			//1. Connection
			connection = this.connectionMaker.getConnection();
			LOG.debug("1. connection ="+connection);
		
			//2. PreparedStatement
			//2.1 SQL
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT rno,                 							  \n");
			sb.append("        name,              								  \n");
			sb.append("        capacity,              							  \n");
			sb.append("        cont,           								  	  \n");
			sb.append("        price1,           								  \n");
			sb.append("        price2,           								  \n");
			sb.append("        fileId,           								  \n");
			sb.append("        sno        	                                 	  \n");
			sb.append(" FROM room                                            	  \n");
			sb.append(" WHERE rno = ?						                  	  \n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PreparedStatement="+pstmt);
			LOG.debug("2.1 sql \n="+sb.toString());
			
			//3.param
			LOG.debug("3. Param ="+inVO);
			pstmt.setString(1, inVO.getRno());
			
			//4.query수행
			rs = pstmt.executeQuery();
			if(rs.next()) {//Moves the cursor forward one fow from its current position. 
				//Data 1건을 outVO담기.
				outVO = new RoomVO();
				outVO.setRno(rs.getString("rno"));
				outVO.setName(rs.getString("name"));
				outVO.setCapacity(rs.getString("capacity"));
				outVO.setCont(rs.getString("cont"));
				outVO.setPrice1(rs.getString("price1"));
				outVO.setPrice2(rs.getString("price2"));		
				outVO.setFileId(rs.getString("fileId"));
				
				outVO.setSno(rs.getString("sno"));				
				LOG.debug("4. return="+outVO);
			}
		
		
	}catch(SQLException e) {
		LOG.debug("=============================");
		LOG.debug("SQLException="+e.getMessage());
		LOG.debug("=============================");
		e.printStackTrace();
	}finally {
    	//사용 역순으로 자원반납 close
			JDBCResClose.close(rs);
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection); 
	}
			
		return outVO;
	}
	
	public DTO doSelectOneRoomPrice(DTO dto) {
		PaymentVO inVO = (PaymentVO) dto;
		RoomVO outVO = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = connectionMaker.getConnection();
			LOG.debug("1. connection:	"+connection);
			StringBuilder sb=new StringBuilder();
			sb.append("SELECT SELECTROOMPRICE(?, ?, ?) price   \n");
			sb.append("FROM dual                               \n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PrepareStatement:	"+pstmt);
			LOG.debug("2.1. sql	:\n"+sb.toString());
			LOG.debug("3. param:	"+inVO);
			pstmt.setString(1,  inVO.getStartDt());/*예약 번호*/
			pstmt.setString(2,  inVO.getEndDt());/*예약 번호*/
			pstmt.setString(3,  inVO.getRno());/*예약 번호*/
			rs = pstmt.executeQuery();
			if(rs.next()) {
				outVO = new RoomVO();
				outVO.setPrice1(rs.getString("price"));/*방 금액*/
				LOG.debug("4. return :"+outVO);
			}
		}catch(SQLException e) {
			LOG.debug("===============================");
			LOG.debug("=SQLException="+e.getMessage());
			LOG.debug("===============================");
			e.printStackTrace();
		}finally {
			JDBCResClose.close(rs);
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return outVO;
	}

	@Override
		public int doUpdate(DTO dto) {
			
			int flag = 0;
			RoomVO inVO = (RoomVO) dto;//param
			
			Connection connection = null;//DB Connection
			PreparedStatement pstmt = null;// vs Statement(해킹에 취약해서 쓰이지않음)
			try {
				//1.Connection 생성
				connection = connectionMaker.getConnection();
				connection.setAutoCommit(false);//transaction 개발자가 관리
			
				
				LOG.debug("1 connection=\n"+connection);
				//2.PreparedStatement
				//2.1 SQL
				StringBuilder sb = new StringBuilder();//속도의 차이가 있기에 이걸씀
				
				sb.append(" UPDATE room               \n");
				sb.append(" SET  	   	    		  \n");
				sb.append("     name	 	= ?       \n");
				sb.append("     ,capacity  	= ?       \n");
				sb.append("     ,cont   	= ?       \n");
				sb.append("     ,price1    	= ?       \n");
				sb.append("     ,price2 	= ?       \n");
				sb.append("     ,fileid 	= ?       \n");
				sb.append(" WHERE rno		= ?       \n");
				
				pstmt = connection.prepareStatement(sb.toString());
				LOG.debug("2. PreparedStatement=\n"+pstmt);
				LOG.debug("2.1. query=\n"+sb.toString());
				//3. param
				LOG.debug("3. param="+inVO);
				//3.1 param binding
				
				pstmt.setString(1, inVO.getName());		//방이름
				pstmt.setString(2, inVO.getCapacity());	//수용인원
				pstmt.setString(3, inVO.getCont());		//방소개글
				pstmt.setString(4, inVO.getPrice1());	//주중가
				pstmt.setString(5, inVO.getPrice2());	//주말가
				pstmt.setString(6, inVO.getFileId());	//파일아이디
				pstmt.setString(7, inVO.getRno());		//방번호
				
				
				//4.query 수행
				flag = pstmt.executeUpdate();//DML발생에 사용.
				LOG.debug("4. flag="+flag);
			}catch(SQLException e) {
				LOG.debug("=============================");
				LOG.debug("SQLException="+e.getMessage());
				LOG.debug("=============================");
				e.printStackTrace();
				
				//RollBack
				JDBCResClose.rollBack(connection);
				
			}finally { //자원반납
				//사용 역순으로 자원반납 close
				JDBCResClose.close(pstmt);
				JDBCResClose.close(connection);
				
			}
			
			return flag;
		}

	@Override
	public int doDelete(DTO dto) {
		
		 int flag = 0;
	     
	      Connection connection = connectionMaker.getConnection();
	      
	      //3. query수행을 위한 PreparedStatement
	      StringBuilder sb=new StringBuilder();
	     
	      sb.append(" DELETE FROM room \n");
	      sb.append(" WHERE rno = ? \n");
	      
	      PreparedStatement pstmt = null;
	      RoomVO inVO = (RoomVO) dto;
	      
	      try {
	         LOG.debug("2.sql=\n"+sb.toString());
	         LOG.debug("2.1 param=\n"+inVO);
	         pstmt = connection.prepareStatement(sb.toString()); 
	         LOG.debug("3.pstmt="+pstmt);
	         // * 4. query실행
	         //   4.1. Bind변수에 값 설정
	         pstmt.setString(1, inVO.getRno());//게시순번
	         
	         //   4.2. query수행: 
	         flag = pstmt.executeUpdate();
	         LOG.debug("4.flag="+flag);
	         
	      } catch (SQLException e) {
	         LOG.debug("===================");
	         LOG.debug("SQLException="+e.getMessage());
	         LOG.debug("===================");
	         e.printStackTrace();
	      // * 6. PreparedStatement,ResultSet
	      // * 7. Connection종료 
	      } finally {
				//사용 역순으로 자원반납 close
				JDBCResClose.close(pstmt);
				JDBCResClose.close(connection);         
	      }
	      return flag;
	}

	@Override
public int doInsert(DTO dto) {
		
		int flag = 0;
        
	      Connection connection = connectionMaker.getConnection();
	      //3. query수행을 위한 PreparedStatement
	      StringBuilder sb=new StringBuilder();
	      
	      sb.append("{call ROOM_INSERT_PROC(                \n");
	      sb.append("	?                                   \n");
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?)}                               \n");
	      
	      CallableStatement cstmt = null;
	      RoomVO inVO = (RoomVO) dto;
		
	      try {
	          LOG.debug("2.sql=\n"+sb.toString());
	          LOG.debug("2.1 param=\n"+inVO);
	          cstmt = connection.prepareCall(sb.toString()); 
	          LOG.debug("3.pstmt="+cstmt);
	          // * 4. query실행
	          //   4.1. Bind변수에 값 설정
	         
	          cstmt.setString(1, inVO.getSno());		//방번호
	          cstmt.setString(2, inVO.getName());		//방이름
	          cstmt.setString(3, inVO.getCapacity());	//수용인원
	          cstmt.setString(4, inVO.getCont());		//방소개글
	          cstmt.setString(5, inVO.getPrice1());		//주중가
	          cstmt.setString(6, inVO.getPrice2());		//주말가
	          cstmt.setString(7, inVO.getFileId());		//파일ID
	          //방 옵션 1~6
	          cstmt.setString(8, inVO.getOpt1());
	          cstmt.setString(9, inVO.getOpt2());
	          cstmt.setString(10, inVO.getOpt3());
	          cstmt.setString(11, inVO.getOpt4());
	          cstmt.setString(12, inVO.getOpt5());
	          cstmt.setString(13, inVO.getOpt6());
	          
	          //   4.2. query수행: 
	          flag = cstmt.executeUpdate();
	          LOG.debug("4.flag="+flag);
	          
	          
	          
	       } catch (SQLException e) {
	          LOG.debug("===================");
	          LOG.debug("SQLException="+e.getMessage());
	          LOG.debug("===================");
	          e.printStackTrace();
	       // * 6. PreparedStatement,ResultSet
	       // * 7. Connection종료 
	       } finally {
	     	//사용 역순으로 자원반납 close
	 			JDBCResClose.close(cstmt);
	 			JDBCResClose.close(connection);    
	       }
	       return flag;
	      
	      
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		//검색조건 : 검색조건
		//제목
		//내용
		
		SearchVO inVO = (SearchVO) dto;
		List<List> outList = new ArrayList<List>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sbWhere = new StringBuilder();//검색조건
		StringBuilder sb = new StringBuilder();//검색query
		
		//검색구분 : 1(업체번호),2(수용인원)
		if(null !=inVO.getSearchDiv()) {
			if("1".equals(inVO.getSearchDiv())) {
				//업체번호
				sbWhere.append(" WHERE t1.sno = ? \n");
			}else if("2".equals(inVO.getSearchDiv())) {
				//수용인원
				sbWhere.append(" WHERE t1.capacity = ? \n");
			}
		}
		
		//main query
		
		sb.append("SELECT *                                                     \n");
		sb.append("FROM(                                                        \n");
		sb.append("    SELECT  rnum num,                                        \n");
		sb.append("			b.rno,                                         		\n");
		sb.append("			b.name,                                             \n");
		sb.append("			b.capacity,                                         \n");
		sb.append("			b.cont,                                             \n");
		sb.append("			b.price1,                                        	\n");
		sb.append("			b.price2,                                           \n");
		sb.append("			b.fileid,                                      	    \n");
		sb.append("			b.sno                                             	\n");
		sb.append("    FROM (                                                   \n");
		sb.append("        SELECT ROWNUM as rnum,A.*                            \n");
		sb.append("        FROM(                                                \n");
		sb.append("            SELECT t1.*                                      \n");
		sb.append("            FROM room t1                                    	\n");
//		sb.append("            --검색어                                           						\n");
		//---------------------------------where-------------------------------------
		if(null !=inVO.getSearchDiv()) {
			if(null !=inVO.getSearchWord()) {
				sb.append(sbWhere.toString());
			}
		}
		//---------------------------------where-------------------------------------
		sb.append("            ORDER BY t1.capacity DESC                        \n");
		sb.append("        )A                                                   \n");
		sb.append("        WHERE rownum <=(?*(?-1)+?) \n");
		sb.append("    )B                                                       \n");
		sb.append("    WHERE rnum >=(?*(?-1)+1) )              \n");
		sb.append("CROSS JOIN                                                   \n");
		sb.append("(                                                            \n");
		sb.append("    SELECT COUNT(*) TOTAL                                    \n");
		sb.append("    FROM room t1                                            \n");
		sb.append("    --검색어                                                    							\n");
		//---------------------------------where-------------------------------------
		if(null !=inVO.getSearchDiv()) {
			if(null !=inVO.getSearchWord()) {
				sb.append(sbWhere.toString());
			}
		}
		//---------------------------------where-------------------------------------
		sb.append(")                                                            \n");
		
		
		
		try {
			//1.
			connection = this.connectionMaker.getConnection();
			LOG.debug("1.connection="+connection);
			
			//2.pstmt
			//2.1
			LOG.debug("2.query=\n"+sb.toString());
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.pstmt="+pstmt);
			LOG.debug("3. param="+inVO);
			//검색어 있는 경우
			if(null !=inVO.getSearchDiv() && null !=inVO.getSearchWord()) {
				//검색어
				//&PAGE_SIZE*(&PAGE_NUM-1)+&PAGE_SIZE
				//&PAGE_SIZE*(&PAGE_NUM-1)+1
				
				//1.검색어
				//2.PAGE_SIZE
				//3.PAGE_NUM
				//4.PAGE_SIZE
				//5.PAGE_SIZE
				//6.PAGE_NUM
				//7.검색어
				pstmt.setString(1, inVO.getSearchWord());
				pstmt.setInt(2, inVO.getPageSize());
				pstmt.setInt(3, inVO.getPageNum());
				pstmt.setInt(4, inVO.getPageSize());
				pstmt.setInt(5, inVO.getPageSize());
				pstmt.setInt(6, inVO.getPageNum());
				pstmt.setString(7, inVO.getSearchWord());
				
			//검색어 없을때	
			}else {
				
				//1.PAGE_SIZE
				//2.PAGE_NUM
				//3.PAGE_SIZE
				//4.PAGE_SIZE
				//5.PAGE_NUM
				pstmt.setInt(1, inVO.getPageSize());
				pstmt.setInt(2, inVO.getPageNum());
				pstmt.setInt(3, inVO.getPageSize());
				pstmt.setInt(4, inVO.getPageSize());
				pstmt.setInt(5, inVO.getPageNum());
				
			}
			//4.query수행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//Data 1건을 outVO담기.
				RoomVO outVO = new RoomVO();
				
				outVO.setRno(rs.getString("rno"));
				outVO.setName(rs.getString("name"));		
				outVO.setCapacity(rs.getString("capacity"));
				outVO.setCont(rs.getString("cont"));
				outVO.setPrice1(rs.getString("price1"));
				outVO.setPrice2(rs.getString("price2"));
				outVO.setFileId(rs.getString("fileid"));
				outVO.setSno(rs.getString("sno"));
				
				outVO.setTotal(rs.getInt("total"));
				outVO.setNum(rs.getInt("num"));
				
				List<RoomVO> outListRoomVO = new ArrayList<RoomVO>();
				outListRoomVO.add(outVO);
				
				FileMngVO inFileMngVO = new FileMngVO();
				inFileMngVO.setFileId(outVO.getFileId());
				LOG.debug("inFileMngVO: "+inFileMngVO);
				
				List<FileMngVO> outListFileMngVO = (List<FileMngVO>) fileMngDao.doRetrieve(inFileMngVO);
				
				List<List> miniOutList = new ArrayList<List>();
				
				miniOutList.add(outListRoomVO);
				miniOutList.add(outListFileMngVO);
				
				outList.add(miniOutList);
			}
			LOG.debug("4. return="+outList);
			
		}catch(SQLException e) {
			LOG.debug("===================");
	        LOG.debug("SQLException="+e.getMessage());
	        LOG.debug("===================");
	        e.printStackTrace();
	        
		}finally {
			JDBCResClose.close(rs);
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		
		return outList;
	}
	
	public List<?> doRetrievePayPossible(DTO dto, DTO dto02) {
		PaymentVO inVO = (PaymentVO) dto;
		RoomVO inVO02 = (RoomVO) dto02; //param
		List<RoomVO> list = new ArrayList<RoomVO>(); //return
		
		Connection connection = null; //DB Connection
		PreparedStatement pstmt = null; //VS Statement 해킹에 취약
		ResultSet rs = null; //결과 값 처리 class
		
		try {
			//1.Connection
			connection = connectionMaker.getConnection();
			LOG.debug("1.connection : "+connection);
			
			//2.PreparedStatement
			//2.1.SQL-단건 조회 query
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT sno                                    	\n");
			sb.append("	  	 ,rno                                    	\n");
			sb.append("      ,name                                   	\n");
			sb.append("      ,capacity                               	\n");
			sb.append("      ,cont                                   	\n");
			sb.append("      ,price1                                 	\n");
			sb.append("      ,price2                                 	\n");
			sb.append("FROM room                                     	\n");
			sb.append("WHERE sno = ? --업체선택                         			 	\n");
			sb.append("AND NOT rno IN (SELECT rno                    	\n");
			sb.append("				FROM payment                     	\n");
			sb.append("				WHERE (rs = '1' OR rs = '3')     	\n");
			sb.append("				AND enddt > ? --시작날짜          			\n");
			sb.append("				AND startdt < ? --종료날짜			\n");
			sb.append("				)                                	\n");
			LOG.debug("2.SQL :\n"+sb.toString());
			//2.2.pstmt
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1.PreparedStatement : "+pstmt);
			
			//3.Param setting 
			LOG.debug("3.param01 : "+inVO);
			LOG.debug("3.param02 : "+inVO02);
			//3.1.Param binding
			pstmt.setString(1, inVO02.getSno());
			pstmt.setString(2, inVO.getStartDt());
			pstmt.setString(3, inVO.getEndDt());
			
			//4.Query 수행
			rs = pstmt.executeQuery();
			while(rs.next()) { //Moves the cursor forward one row from its current position. A ResultSet cursor is initially positioned before the first row;
				//데이터를 1건씩 outVO에 담기
				RoomVO outVO = new RoomVO();
				outVO.setSno(rs.getString("sno"));
				outVO.setRno(rs.getString("rno"));
				outVO.setName(rs.getString("name"));
				outVO.setCapacity(rs.getString("capacity"));
				outVO.setCont(rs.getString("cont"));
				outVO.setPrice1(rs.getString("price1"));
				outVO.setPrice2(rs.getString("price2"));
				LOG.debug("4.return : "+outVO);
				list.add(outVO);
			}
		} catch (SQLException e) {
			LOG.debug("===========================");
			LOG.debug("=======SQLException======="+e.getMessage());
			LOG.debug("===========================");
			e.printStackTrace();
		} finally {
			//5.preparedStatement, ResultSet 자원 반납 - 사용하는 역순으로 close
			//6.Connection 종료
			JDBCResClose.close(rs);
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return list;
	}

}
