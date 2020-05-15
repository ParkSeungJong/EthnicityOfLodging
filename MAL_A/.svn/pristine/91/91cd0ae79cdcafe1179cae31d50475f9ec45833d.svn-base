/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.store
 * 클래스명 : StoreDao.java
 * 설명 : Store CRUD
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-06    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-06 오후 5:45:21
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.store;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.mal_a.cmn.JDBCResClose;
import com.mal_a.store.StoreVO;
import com.mal_a.cmn.SearchVO;
import com.mal_a.board.BoardVO;
import com.mal_a.cmn.ConnectionMaker;
import com.mal_a.cmn.DTO;
import com.mal_a.cmn.WorkDiv;
import com.mal_a.filemng.FileMngVO;
import com.mal_a.member.MemberVO;
import com.mal_a.stooption.StoOptionVO;

/**
 * @author sist
 *
 */
public class StoreDao extends WorkDiv {

	private final Logger LOG = Logger.getLogger(StoreDao.class);
	  
	private ConnectionMaker connectionMaker;

	   
		public StoreDao() {
			connectionMaker = new ConnectionMaker();
		}


	
	@Override
	public DTO doSelectOne(DTO dto) {
		
		StoreVO inVO = (StoreVO) dto;//param
		StoreVO outVO = null;//return
		
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
			sb.append(" SELECT sno,                                           \n");
			sb.append(" 	   name,                                          \n");
			sb.append("        addrno,                                        \n");
			sb.append("        addr,                                          \n");
			sb.append("        tel,                                           \n");
			sb.append("        get_code('STOPART',stopart) stopart,           \n");
			sb.append("        cont,                                          \n");
			sb.append("        get_code('VIEWS',views) views,                 \n");
			sb.append("        regid,                                         \n");
			sb.append("        TO_CHAR(regdt,'YYYY/MM/DD') regdt,  			  \n");
			sb.append("        modid,                                         \n");
			sb.append("        TO_CHAR(regdt,'YYYY/MM/DD') moddt,  			  \n");
			sb.append("        fileid                                         \n");
			sb.append(" FROM store                                            \n");
			sb.append(" WHERE sno = ?						                  \n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PreparedStatement="+pstmt);
			LOG.debug("2.1 sql \n="+sb.toString());
			
			//3.param
			LOG.debug("3. Param ="+inVO);
			pstmt.setString(1, inVO.getSno());
			
			//4.query수행
			rs = pstmt.executeQuery();
			if(rs.next()) {//Moves the cursor forward one fow from its current position. 
				//Data 1건을 outVO담기.
				outVO = new StoreVO();
				outVO.setSno(rs.getString("sno"));
				outVO.setName(rs.getString("name"));
				outVO.setAddrNo(rs.getString("addrno"));
				outVO.setAddr(rs.getString("addr"));
				outVO.setTel(rs.getString("tel"));
				outVO.setStoPart(rs.getString("stopart"));
				outVO.setCont(rs.getString("cont"));
				outVO.setViews(rs.getString("views"));				
				outVO.setRegId(rs.getString("regid"));
				outVO.setRegDt(rs.getString("regdt"));
				outVO.setModId(rs.getString("modid"));
				outVO.setModDt(rs.getString("moddt"));
				outVO.setFileId(rs.getString("fileid"));				
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

	@Override
	public int doUpdate(DTO dto) {
		
		int flag = 0;
		StoreVO inVO = (StoreVO) dto;//param
		
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
			
			sb.append(" UPDATE store              \n");
			sb.append(" SET  name   	= ?       \n");
			sb.append("     ,addrno 	= ?       \n");
			sb.append("     ,addr	  	= ?       \n");
			sb.append("     ,tel    	= ?       \n");
			sb.append("     ,stopart	= ?       \n");
			sb.append("     ,cont   	= ?       \n");
			sb.append("     ,modid  	= ?       \n");
			sb.append("     ,moddt  	= SYSDATE \n");
			sb.append("     ,fileid 	= ?       \n");
			sb.append(" WHERE sno		= ?       \n");
			LOG.debug("2.1. query=\n"+sb.toString());
			
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PreparedStatement=\n"+pstmt);
			LOG.debug("2.1. query=\n"+sb.toString());
			//3. param
			LOG.debug("3. param="+inVO);
			//3.1 param binding
			
			pstmt.setString(1, inVO.getName());		//가게명
			pstmt.setString(2, inVO.getAddrNo());	//우편번호
			pstmt.setString(3, inVO.getAddr());		//주소
			pstmt.setString(4, inVO.getTel());		//전화번호
			pstmt.setString(5, inVO.getStoPart());	//업체분류
			pstmt.setString(6, inVO.getCont());		//업체소개글
			pstmt.setString(7, inVO.getModId());	//수정자아이디
			pstmt.setString(8, inVO.getFileId());	//파일아이디
			pstmt.setString(9, inVO.getSno());		//업체번호
			
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
	
	public int doUpdateViews(DTO dto) {
		int flag = 0;
		StoreVO inVO = (StoreVO) dto;// param

		Connection connection = null;// DB Connection
		PreparedStatement pstmt = null;// VS Statement
		try {
			// 1.connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection=" + connection);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE store          	\n");
			sb.append("SET  views    = ?      	\n");
			sb.append("		,modid   = ?		\n");
			sb.append("		,moddt   = SYSDATE  \n");
			sb.append("WHERE sno = ?    		\n");

			// 2.query
			LOG.debug("2. query=\n" + sb.toString());

			// 2.1 pstmt
			pstmt = connection.prepareStatement(sb.toString());
			// 3. param
			LOG.debug("3. param=" + inVO);
			pstmt.setString(1, inVO.getViews());
			pstmt.setString(2, inVO.getModId());
			pstmt.setString(3, inVO.getSno());

			// 4. query 수행

			flag = pstmt.executeUpdate();

			LOG.debug("4. flag=" + flag);

		} catch (SQLException e) {
			LOG.debug("===========================");
			LOG.debug("=SQLException=" + e.getMessage());
			LOG.debug("===========================");
			e.printStackTrace();
		} finally { // 자원반납
			// 사용 역순으로 close
			JDBCResClose.close(pstmt);// prepareStatement
			JDBCResClose.close(connection);// connection
		}
		return flag;
	}

	@Override
	public int doDelete(DTO dto) {
		
		 int flag = 0;
	     
	      Connection connection = connectionMaker.getConnection();
	      
	      //3. query수행을 위한 PreparedStatement
	      StringBuilder sb=new StringBuilder();
	     
	      sb.append(" DELETE FROM store \n");
	      sb.append(" WHERE sno = ? \n");
	      
	      PreparedStatement pstmt = null;
	      StoreVO inVO = (StoreVO) dto;
	      
	      try {
	         LOG.debug("2.sql=\n"+sb.toString());
	         LOG.debug("2.1 param=\n"+inVO);
	         pstmt = connection.prepareStatement(sb.toString()); 
	         LOG.debug("3.pstmt="+pstmt);
	         // * 4. query실행
	         //   4.1. Bind변수에 값 설정
	         pstmt.setString(1, inVO.getSno());//게시순번
	         
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
	      
	      sb.append("{call STORE_INSERT_PROC(               \n");
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
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?                                 \n");
	      sb.append("	, ?)}                               \n");
	      
	      CallableStatement cstmt = null;
	      StoreVO inVO = (StoreVO) dto;
		
	      try {
	          LOG.debug("2.sql=\n"+sb.toString());
	          LOG.debug("2.1 param=\n"+inVO);
	          cstmt = connection.prepareCall(sb.toString()); 
	          LOG.debug("3.cstmt="+cstmt);
	          // * 4. query실행
	          //   4.1. Bind변수에 값 설정
	         
	          cstmt.setString(1, inVO.getSno());		//sno
	          cstmt.setString(2, inVO.getName());		//가게명
	          cstmt.setString(3, inVO.getAddrNo());		//우편번호
	          cstmt.setString(4, inVO.getAddr());		//주소
	          cstmt.setString(5, inVO.getTel());		//전화번호
	          cstmt.setString(6, inVO.getStoPart());	//업체분류
	          cstmt.setString(7, inVO.getCont());		//설명
	          cstmt.setString(8, inVO.getRegId());		//등록자ID
	          cstmt.setString(9, inVO.getFileId());		//파일ID
	          //업체 옵션 1~17
	          cstmt.setString(10, inVO.getOpt1());		
	          cstmt.setString(11, inVO.getOpt2());		
	          cstmt.setString(12, inVO.getOpt3());		
	          cstmt.setString(13, inVO.getOpt4());		
	          cstmt.setString(14, inVO.getOpt5());		
	          cstmt.setString(15, inVO.getOpt6());		
	          cstmt.setString(16, inVO.getOpt7());		
	          cstmt.setString(17, inVO.getOpt8());		
	          cstmt.setString(18, inVO.getOpt9());		
	          cstmt.setString(19, inVO.getOpt10());		
	          cstmt.setString(20, inVO.getOpt11());		
	          cstmt.setString(21, inVO.getOpt12());		
	          cstmt.setString(22, inVO.getOpt13());		
	          cstmt.setString(23, inVO.getOpt14());		
	          cstmt.setString(24, inVO.getOpt15());		
	          cstmt.setString(25, inVO.getOpt16());		
	          cstmt.setString(26, inVO.getOpt17());		
	          
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
		List<StoreVO> outList = new ArrayList<StoreVO>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sbWhere = new StringBuilder();//검색조건
		StringBuilder sb = new StringBuilder();//검색query
		
		//검색구분 : 1(업체분류),2(지역번호 + 업체분류),3(정지상태),4(수정자ID)
		if(null !=inVO.getSearchDiv()) {
			if("1".equals(inVO.getSearchDiv())) {
				//지역번호
				sbWhere.append(" WHERE SUBSTR(t1.sno,1,INSTR(t1.sno,'_')-1) = ? \n");
			}else if("2".equals(inVO.getSearchDiv())) {
				//지역번호 + 업체분류
				sbWhere.append(" WHERE SUBSTR(t1.sno,1,INSTR(t1.sno,'_')-1) = ? \n");
				sbWhere.append(" AND t1.stopart = ? 							\n");
			}else if("3".equals(inVO.getSearchDiv())) {
				//정지상태
				sbWhere.append(" WHERE t1.views   = ? 					  	  	\n");
			}else if("4".equals(inVO.getSearchDiv())) {
				//수정자ID
				sbWhere.append(" WHERE t1.modid   = ? 						 	\n");
			}
		}
		
		//main query
		sb.append("SELECT *                                                     \n");
		sb.append("FROM(                                                        \n");
		sb.append("    SELECT  rnum num,                                        \n");
		sb.append("			b.sno sno,                                          \n");
		sb.append("			b.name name,                                        \n");
		sb.append("			b.addrno addrno,                                    \n");
		sb.append("			b.addr addr,                                        \n");
		sb.append("			b.tel tel,                                          \n");
		sb.append("			get_code('STOPART',b.stopart) stopart,              \n");
		sb.append("			b.cont cont,                                      	\n");
		sb.append("			get_code('VIEWS',b.views) views,                    \n");
		sb.append("			b.regid regid,                                      \n");
		sb.append("			TO_CHAR(b.moddt,'YYYY/MM/DD') regdt,    			\n");
		sb.append("			b.modid modid,                                      \n");
		sb.append("			TO_CHAR(b.moddt,'YYYY/MM/DD') moddt,             	\n");
		sb.append("			b.fileid fileid                                     \n");
		sb.append("    FROM (                                                   \n");
		sb.append("        SELECT ROWNUM as rnum,A.*                            \n");
		sb.append("        FROM(                                                \n");
		sb.append("            SELECT t1.*                                      \n");
		sb.append("            FROM store t1                                    \n");
//		sb.append("            --검색어                                           						\n");
		//---------------------------------where-------------------------------------
		if (null != inVO.getSearchDiv() || !inVO.getSearchDiv().equals("") ) {
			if(null != inVO.getSearchWord()) {
				sb.append(sbWhere.toString());
			}
		}
		//---------------------------------where-------------------------------------
		//sb.append("            ORDER BY t1.moddt DESC                           \n");
		sb.append("        )A                                                   \n");
		sb.append("        WHERE rownum <=(?*(?-1)+?) 							\n");
		sb.append("    )B                            							\n");
		sb.append("    WHERE rnum >=(?*(?-1)+1) )             			 		\n");
		sb.append("CROSS JOIN                                                   \n");
		sb.append("(                                                            \n");
		sb.append("    SELECT COUNT(*) TOTAL                                    \n");
		sb.append("    FROM store t1                                            \n");
		sb.append("    --검색어                                                    							\n");
		//---------------------------------where-------------------------------------
		if (null != inVO.getSearchDiv() || !inVO.getSearchDiv().equals("") ) {
			if(null != inVO.getSearchWord()) {
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
			if(null != inVO.getSearchDiv() && !inVO.getSearchDiv().equals("") && null !=inVO.getSearchWord() && null ==inVO.getSearchWord02()) {
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
			}else if(null != inVO.getSearchDiv() && !inVO.getSearchDiv().equals("") && null !=inVO.getSearchWord() && null !=inVO.getSearchWord02()) {
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
				pstmt.setString(2, inVO.getSearchWord02());
				pstmt.setInt(3, inVO.getPageSize());
				pstmt.setInt(4, inVO.getPageNum());
				pstmt.setInt(5, inVO.getPageSize());
				pstmt.setInt(6, inVO.getPageSize());
				pstmt.setInt(7, inVO.getPageNum());
				pstmt.setString(8, inVO.getSearchWord());
				pstmt.setString(9, inVO.getSearchWord02());
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
				StoreVO outVO = new StoreVO();
				
				outVO.setSno(rs.getString("sno"));
				outVO.setName(rs.getString("name"));	
				outVO.setAddrNo(rs.getString("addrno"));
				outVO.setAddr(rs.getString("addr"));
				outVO.setTel(rs.getString("tel"));
				outVO.setStoPart(rs.getString("stopart"));
				outVO.setCont(rs.getString("cont"));
				outVO.setViews(rs.getString("views"));
				outVO.setRegId(rs.getString("regid"));
				outVO.setRegDt(rs.getString("regdt"));
				outVO.setModId(rs.getString("modid"));
				outVO.setModDt(rs.getString("moddt"));
				outVO.setFileId(rs.getString("fileid"));
				
				outVO.setTotal(rs.getInt("total"));
				outVO.setNum(rs.getInt("num"));
				outList.add(outVO);
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
	
	
	
	
	
	 public List<?> doStoreRetrieve(DTO dto, DTO dto02) {
	      //검색조건 : 검색조건
	      //제목
	      //내용
	      SearchVO inVO = (SearchVO) dto;
	      StoOptionVO inStoVO = (StoOptionVO) dto02;
	      List<StoreVO> outList = new ArrayList<StoreVO>();
	      
	      Connection connection = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      
	      StringBuilder sbWhere = new StringBuilder();//검색조건
	      StringBuilder sb = new StringBuilder();//검색query
	
	      sb.append(" SELECT *												   \n");
	      sb.append(" FROM(                                                    \n");
	      sb.append(" SELECT rnum num,                                         \n");
	      sb.append("        b.*                                               \n");
	      sb.append(" FROM(                                                    \n");
	      sb.append(" SELECT ROWNUM as rnum,A.*                                \n");
	      sb.append(" FROM(                                                    \n");
	      sb.append("            SELECT s.sno                                  \n");
	      sb.append("                  ,s.name                                 \n");
	      sb.append("                  ,s.addr                                 \n");
	      sb.append("                  ,s.tel                                  \n");
	      sb.append("                  ,REPLACE(SUBSTR(f.savepath,INSTR(savepath,'WebContent')+10,1000),'\\','/')||'/'||f.savenm savepath           \n");
	      sb.append("            FROM room r, stooption so, store s, filemng f \n");
	      sb.append("            WHERE r.rno LIKE ?||'%'--지역선택                 	   \n");
	      sb.append("            AND r.sno=so.sno                              \n");
	      sb.append("            AND r.sno=s.sno                               \n");
	      sb.append("            AND s.fileid=f.fileid                         \n");
	      sb.append("            AND f.seq=1                                   \n");
	      sb.append("            AND NOT r.rno IN                              \n");
	      sb.append("               (SELECT rno                                \n");
	      sb.append("               FROM payment                               \n");
	      sb.append("               WHERE (rs = '1' OR rs = '3')               \n");
	      sb.append("               AND enddt > ?--시작날짜             				   \n");
	      sb.append("               AND startdt < ?--종료날짜            			   \n");
	      sb.append("               )                                          \n");
	      sb.append("            AND s.sno IN                                  \n");
	      sb.append("                (select c.sno                             \n");
	      sb.append("                from (SELECT sno, sum(yn) syn             \n");
	      sb.append("                     FROM stooption                       \n");

	      if(inStoVO.getOpt()!=null && !inStoVO.getOpt().equals("")) {
		         try {
		        	 sb.append("            WHERE opt in (                         \n");
		            stoOptSbAppend(sb, inStoVO);
		            sb.append("                 )                                    \n");
		         }catch(SQLException e1) {
		            e1.printStackTrace();
		         }
				 
		      }

	      sb.append("                      group by sno) c                     \n");
	      sb.append("                 where 1=1        \n");

	      if(inStoVO.getOpt()!=null && !inStoVO.getOpt().equals("")) {
		         try {
		        	 sb.append("                 and c.syn >=           --키워드선택갯수         \n");
		            stoOptLength(sb, inStoVO);
		         }catch(SQLException e1) {
		            e1.printStackTrace();
		         }
		      }

	      sb.append("                )                                         \n");
	      sb.append("            group by (s.sno                               \n");
	      sb.append("                  ,s.name                                 \n");
	      sb.append("                  ,s.addr                                 \n");
	      sb.append("                  ,s.tel                                  \n");
	      sb.append("                  ,REPLACE(SUBSTR(f.savepath,INSTR(savepath,'WebContent')+10,1000),'\\','/')||'/'||f.savenm)                \n");
	      sb.append("             )A                                           \n");
	      sb.append("             WHERE rownum <=(?*(?-1)+?)                   \n");
	      sb.append("             )B                                           \n");
	      sb.append("             WHERE rnum >=(?*(?-1)+1)                     \n");
	      sb.append(" )                                                        \n");
	      sb.append(" CROSS JOIN                                               \n");
	      sb.append(" (                                                        \n");
	      sb.append("    SELECT COUNT(*) TOTAL                                 \n");
	      sb.append("    FROM store t1                                         \n");
	      sb.append(" )                                                        \n");
	

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
	         
	         pstmt.setString(1, inVO.getSearchWord03());
	         pstmt.setString(2, inVO.getSearchWord04());
	         pstmt.setString(3, inVO.getSearchWord05());
	         
	         pstmt.setInt(4, inVO.getPageSize());
	         pstmt.setInt(5, inVO.getPageNum());
	         pstmt.setInt(6, inVO.getPageSize());
	         pstmt.setInt(7, inVO.getPageSize());
	         pstmt.setInt(8, inVO.getPageNum());
	         //4.query수행
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            //Data 1건을 outVO담기.
	            StoreVO outVO = new StoreVO();
	            
	            outVO.setSno(rs.getString("sno"));
	            outVO.setName(rs.getString("name"));
	            outVO.setAddr(rs.getString("addr"));
	            outVO.setTel(rs.getString("tel"));
	            outVO.setFileId(rs.getString("savepath"));
	            
	            outVO.setTotal(rs.getInt("total"));
				outVO.setNum(rs.getInt("num"));
				outList.add(outVO);
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
	
	   public static void stoOptSbAppend(StringBuilder sb, StoOptionVO vo) throws SQLException{
		      String[] optArr = vo.getOpt().split(",");
		      
		      for(int i=0;i<optArr.length;i++) {
		         sb.append(optArr[i]);
		         if(i<optArr.length-1) {
		            sb.append(",");
		         }
		      }
		   }
		   
		   public static void stoOptLength(StringBuilder sb, StoOptionVO vo) throws SQLException{
		      String[] optArr = vo.getOpt().split(",");
		      
		      sb.append(optArr.length);
		   }
	
}
