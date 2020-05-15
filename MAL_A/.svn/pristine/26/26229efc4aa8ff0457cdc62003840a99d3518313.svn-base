package com.mal_a.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mal_a.cmn.DTO;
import com.mal_a.cmn.WorkDiv;
import com.mal_a.payment.PaymentVO;
import com.mal_a.cmn.JDBCResClose;
import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.ConnectionMaker;


public class ReviewDao extends WorkDiv {

	private ConnectionMaker connectionMaker;
	   //1.CRUD: 
	   //1.1. 등록: int doInsert(DTO dto) 
	   //1.2. 수정: int doUpdate(DTO dto)  
	   //1.3. 삭제: int doDelete(DTO dto)
	   //1.4. 단건조회:DTO doSelectOne(DTO dto)
	   //1.5. 목록조회:List<?> doRetrieve(DTO dto)
	   
	public ReviewDao() {
		connectionMaker = new ConnectionMaker();
	}
	
	@Override
	public DTO doSelectOne(DTO dto) {
		ReviewVO inVO = (ReviewVO) dto;//param
		ReviewVO outVO = null;//return
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
			sb.append("SELECT re.reno,                							       \n");
			sb.append("       re.cont,              							       \n");
			sb.append("       re.star,           								       \n");
			sb.append("       get_code('VIEWS',re.views) views,           		       \n");
			sb.append("       re.regid,           								       \n");
			sb.append("       TO_CHAR(re.regdt,'YYYY/MM/DD HH24:MI:SS') regdt,         \n");
			sb.append("       re.modid,                                                \n");
			sb.append("       TO_CHAR(re.regdt,'YYYY/MM/DD HH24:MI:SS') moddt,         \n");
			sb.append("       s.name sname,                                            \n");
			sb.append("       r.name rname,                                            \n");
			sb.append("       p.pno                                                    \n");
			sb.append("FROM review re, payment p, store s, room r                      \n");          
			sb.append("WHERE reno = ?                                                  \n");
			sb.append("AND re.pno = p.pno                                              \n");
			sb.append("AND p.sno = s.sno                                               \n");
			sb.append("AND p.rno = r.rno;	                                           \n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PreparedStatement="+pstmt);
			LOG.debug("2.1 sql \n="+sb.toString());
			//3.param
			LOG.debug("3. Param ="+inVO);
			pstmt.setString(1, inVO.getReno());
			//4.query수행
			rs = pstmt.executeQuery();
			if(rs.next()) {//Moves the cursor forward one fow from its current position. 
				//Data 1건을 outVO담기.
				outVO = new ReviewVO();
				outVO.setReno(rs.getString("reno"));
				outVO.setCont(rs.getString("cont"));
				outVO.setStar(rs.getString("star"));
				outVO.setViews(rs.getString("views"));		
				outVO.setRegId(rs.getString("regid"));
				outVO.setRegDt(rs.getString("regdt"));
				outVO.setModId(rs.getString("modid"));
				outVO.setModDt(rs.getString("moddt"));
				outVO.setPno(rs.getString("pno"));				
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
	
	public DTO doSelectOneAvgStar(DTO dto) {
		PaymentVO inVO = (PaymentVO) dto;//param
		ReviewVO outVO = null;//return
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
			sb.append("SELECT ROUND(avg(re.star),1) avgstar      \n");
			sb.append("FROM review re, payment p, store s        \n");    		 
			sb.append("WHERE re.pno = p.pno                      \n");
			sb.append("AND p.sno = s.sno                         \n");
			sb.append("AND p.sno = ?                             \n");
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
				outVO = new ReviewVO();
				outVO.setStar(rs.getString("avgstar"));				
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
		ReviewVO inVO = (ReviewVO) dto;//param
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
			sb.append(" UPDATE review             \n");
			sb.append(" SET  				      \n");
			sb.append("     views		= ?       \n");
			sb.append("     ,modid  	= ?       \n");
			sb.append("     ,moddt  	= SYSDATE \n");
			sb.append(" WHERE reno		= ?       \n");
			LOG.debug("2.1. query=\n"+sb.toString());
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PreparedStatement=\n"+pstmt);
			LOG.debug("2.1. query=\n"+sb.toString());
			//3. param
			LOG.debug("3. param="+inVO);
			//3.1 param binding
			pstmt.setString(1, inVO.getViews());	//정지상태
			pstmt.setString(2, inVO.getModId());	//수정자아이디
			pstmt.setString(3, inVO.getReno());		//리뷰번호
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
		sb.append(" DELETE FROM review \n");
		sb.append(" WHERE regid = ? \n");
		PreparedStatement pstmt = null;
		ReviewVO inVO = (ReviewVO) dto;
		try {
			LOG.debug("2.sql=\n"+sb.toString());
			LOG.debug("2.1 param=\n"+inVO);
			pstmt = connection.prepareStatement(sb.toString()); 
			LOG.debug("3.pstmt="+pstmt);
			// * 4. query실행
			//   4.1. Bind변수에 값 설정
			pstmt.setString(1, inVO.getRegId());//등록자 아이디
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
		sb.append(" INSERT INTO review (     				\n");
		sb.append("     reno,                				\n");
		sb.append("     cont,              					\n");
		sb.append("     star,           					\n");
		sb.append("     views,    							\n");
		sb.append("     regid,             					\n");
		sb.append("     regdt,             					\n");
		sb.append(" 	  pno    	    					\n");
		sb.append(" ) VALUES (              				\n");
		sb.append("     REVIEW_RENO.NEXTVAL,  				\n");
		sb.append("     ?,                  				\n");
		sb.append("     ?,                  				\n");
		sb.append("     1,                  				\n");
		sb.append("     ?,                  				\n");
		sb.append("     SYSDATE,            				\n");
		sb.append("     ?                  					\n");
		sb.append(" )                       				\n");   
		PreparedStatement pstmt = null;
		ReviewVO inVO = (ReviewVO) dto;
		try {
			LOG.debug("2.sql=\n"+sb.toString());
			LOG.debug("2.1 param=\n"+inVO);
			pstmt = connection.prepareStatement(sb.toString()); 
			LOG.debug("3.pstmt="+pstmt);
			// * 4. query실행
			//   4.1. Bind변수에 값 설정
			pstmt.setString(1, inVO.getCont());//내용
			pstmt.setString(2, inVO.getStar());//별점
			pstmt.setString(3, inVO.getRegId());//등록자ID
			pstmt.setString(4, inVO.getPno());//업체번호
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
	public List<?> doRetrieve(DTO dto) {
		//검색조건 : 검색조건
		//제목
		//내용
		SearchVO inVO = (SearchVO) dto;
		List<ReviewVO> outList = new ArrayList<ReviewVO>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sbWhere = new StringBuilder();//검색조건
		StringBuilder sb = new StringBuilder();//검색query
		//검색구분 : 1(업체번호),2(정지상태),3(회원아이디)
		if(null !=inVO.getSearchDiv()) {
			if("1".equals(inVO.getSearchDiv())) {
				//업체번호+비정지만
				sbWhere.append(" AND p.sno = ? \n");
				sbWhere.append(" AND t1.views = 1 \n");
			}else if("2".equals(inVO.getSearchDiv())) {
				//업체번호+정지까지 모두
				sbWhere.append(" AND p.sno = ? \n");
			}else if("3".equals(inVO.getSearchDiv())) {
				//회원아이디
				sbWhere.append(" AND t1.regid = ? \n");
				sbWhere.append(" AND t1.views = 1 \n");
			}
		}
		//main query
		sb.append("SELECT *                                                     \n");
		sb.append("FROM(                                                        \n");
		sb.append("    SELECT  rnum num,                                        \n");
		sb.append("			b.reno reno,                                        \n");
		sb.append("			b.cont cont,                                      	\n");
		sb.append("			b.star star,                                      	\n");
		sb.append("			get_code('VIEWS',b.views) views,                    \n");
		sb.append("			b.regid,                                      	    \n");
		sb.append("			TO_CHAR(b.regdt,'YYYY/MM/DD') regdt,                \n");
		sb.append("			b.modid,                                            \n");
		sb.append("			TO_CHAR(b.moddt,'YYYY/MM/DD')  moddt,               \n");
		sb.append("			b.pno                                       	    \n");
		sb.append("    FROM (                                                   \n");
		sb.append("        SELECT ROWNUM as rnum,A.*                            \n");
		sb.append("        FROM(                                                \n");
		sb.append("            SELECT t1.*                                      \n");
		sb.append("            FROM review t1, payment p, store s, room r       \n");
		sb.append("            WHERE t1.pno = p.pno                             \n");
		sb.append("            AND p.sno = s.sno                             	\n");
		sb.append("            AND p.rno = r.rno                             	\n");
		//---------------------------------where-------------------------------------
		if (null != inVO.getSearchDiv() || !inVO.getSearchDiv().equals("") ) {
			if(null != inVO.getSearchWord()) {
				sb.append(sbWhere.toString());
			}
		}
		//---------------------------------where-------------------------------------
		sb.append("            ORDER BY reno DESC                          		\n");
		sb.append("        )A                                                   \n");
		sb.append("        WHERE rownum <=(?*(?-1)+?) 							\n");
		sb.append("    )B                                                       \n");
		sb.append("    WHERE rnum >=(?*(?-1)+1) )              					\n");
		sb.append("CROSS JOIN                                                   \n");
		sb.append("(                                                            \n");
		sb.append("    SELECT COUNT(*) TOTAL                                    \n");
		sb.append("    FROM review t1, payment p, store s, room r               \n");
		sb.append("    --검색어                                                    							\n");
		sb.append("            WHERE t1.pno = p.pno                             \n");
		sb.append("            AND p.sno = s.sno                             	\n");
		sb.append("            AND p.rno = r.rno                             	\n");
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
			if(null != inVO.getSearchDiv() && !inVO.getSearchDiv().equals("") && null !=inVO.getSearchWord()) {
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
				ReviewVO outVO = new ReviewVO();
				outVO.setReno(rs.getString("reno"));
				outVO.setCont(rs.getString("cont"));
				outVO.setStar(rs.getString("star"));
				outVO.setViews(rs.getString("views"));
				outVO.setRegId(rs.getString("regid"));
				outVO.setRegDt(rs.getString("regdt"));
				outVO.setModId(rs.getString("modid"));
				outVO.setModDt(rs.getString("moddt"));
				outVO.setPno(rs.getString("pno"));
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
	
	public List<?> doRetrieveAvgStar(DTO dto, DTO dto02) {
		//검색조건 : 검색조건
		//제목
		//내용
		SearchVO inVO = (SearchVO) dto;
		PaymentVO inPaymentVO = (PaymentVO) dto02; 
		List<ReviewVO> outList = new ArrayList<ReviewVO>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sbWhere = new StringBuilder();//검색조건
		StringBuilder sb = new StringBuilder();//검색query
		//검색구분 : 1(업체번호),2(정지상태)
		if(null !=inVO.getSearchDiv()) {
			if("1".equals(inVO.getSearchDiv())) {
				//업체번호
				sbWhere.append(" WHERE p.sno = ? \n");
			}else if("2".equals(inVO.getSearchDiv())) {
				//정지상태
				sbWhere.append(" WHERE t1.views = ? \n");
			}
		}
		//main query
		sb.append("SELECT *                                                     \n");
		sb.append("FROM(                                                        \n");
		sb.append("    SELECT *,                                        		\n");
		sb.append("    FROM (                                                   \n");
		sb.append("        SELECT ROWNUM as rnum,A.*                            \n");
		sb.append("        FROM(                                                \n");
		sb.append("            SELECT ROUND(AVG(t1.star),1) avgstar             \n");
		sb.append("            FROM review t1, payment p                        \n");
		sb.append("            WHERE t1.pno = p.pno                             \n");
		sb.append("            AND p.sno = ?                                 	\n");
		sb.append("        )A                                                   \n");
		sb.append("        WHERE rownum <=(?*(?-1)+?) 							\n");
		sb.append("    )B                                                       \n");
		sb.append("    WHERE rnum >=(?*(?-1)+1) )              					\n");
		sb.append("CROSS JOIN                                                   \n");
		sb.append("(                                                            \n");
		sb.append("    SELECT COUNT(*) TOTAL                                    \n");
		sb.append("    FROM review t1                                           \n");
		sb.append("    WHERE t1.sno = ?                                 		\n");
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
			//1.PAGE_SIZE
			//2.PAGE_NUM
			//3.PAGE_SIZE
			//4.PAGE_SIZE
			//5.PAGE_NUM
			pstmt.setString(1, inPaymentVO.getSno());
			pstmt.setInt(2, inVO.getPageSize());
			pstmt.setInt(3, inVO.getPageNum());
			pstmt.setInt(4, inVO.getPageSize());
			pstmt.setInt(5, inVO.getPageSize());
			pstmt.setInt(6, inVO.getPageNum());
			pstmt.setString(7, inPaymentVO.getSno());
			//4.query수행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				//Data 1건을 outVO담기.
				ReviewVO outVO = new ReviewVO();
				outVO.setStar(rs.getString("avgstar"));
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

}
