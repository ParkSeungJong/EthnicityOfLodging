/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.heart
 * 클래스명 : HeartDao.java
 * 설명 : Heart CRUD
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
package com.mal_a.heart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.ConnectionMaker;
import com.mal_a.cmn.DTO;
import com.mal_a.cmn.JDBCResClose;
import com.mal_a.cmn.MessageVO;
import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.WorkDiv;
import com.mal_a.store.StoreVO;

/**
 * @author SIST
 *
 */
public class HeartDao extends WorkDiv {
	private final Logger LOG = Logger.getLogger(HeartDao.class);
	
	private ConnectionMaker connectionMaker;
	
	public HeartDao() {
		connectionMaker = new ConnectionMaker();
	}
	/**
	 * 
	 *메서드명 : doInsert
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 선호 업체 등록
	 *@param dto
	 *@return int
	 */
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		HeartVO inVO =  (HeartVO) dto;// param

		Connection connection = null;// DB Connection
		PreparedStatement pstmt = null;// VS Statement

		try {
			// 1.Connection
			connection = this.connectionMaker.getConnection();
			LOG.debug("1.Connection=" + connection);

			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO heart ( \n");
			sb.append("    sno,             \n");
			sb.append("    regid              \n");
			sb.append(") VALUES (           \n");
			sb.append("    ?,              \n");
			sb.append("    ?              \n");
			sb.append(")                   \n");

			// 2.pstmt
			LOG.debug("2.query=\n" + sb.toString());
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1 pstmt=" + pstmt);

			// 3.param
			LOG.debug("3.  param=" + inVO);
			pstmt.setString(1, inVO.getSno());
			pstmt.setString(2, inVO.getRegId());

			// 4. query 수행
			flag = pstmt.executeUpdate();
			LOG.debug("4. flag =" + flag);

		} catch (SQLException e) {
			LOG.debug("===========================");
			LOG.debug("=SQLException=" + e.getMessage());
			LOG.debug("===========================");
			e.printStackTrace();
			// Rollback
			JDBCResClose.rollBack(connection);

		} finally { // 자원반납
			// 사용 역순으로 close
			JDBCResClose.close(pstmt);// prepareStatement
			JDBCResClose.close(connection);// connection
		}
		return flag;
	}
	
	@Override
	public DTO doSelectOne(DTO dto) {
		HeartVO inVO = (HeartVO) dto; //param
		MessageVO outVO = null; //return
		
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
			sb.append("SELECT count(1) cnt  \n");
			sb.append("FROM heart       	\n");
			sb.append("WHERE sno = ? 		\n");
			sb.append("AND regid = ?    	\n");
			LOG.debug("2.SQL(Query) :\n"+sb.toString());
			
			//2.2.pstmt
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1.PreparedStatement : "+pstmt);
			
			//3.Param setting 
			LOG.debug("3.param :\n"+inVO);
			//3.1.Param binding
			pstmt.setString(1, inVO.getSno());
			pstmt.setString(2, inVO.getRegId());
			
			//4.Query 수행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//데이터를 1건씩 outVO에 담기
				outVO = new MessageVO();
				int result = rs.getInt("cnt"); //아이디
				//좋아요 있으면 1 그렇치 않으면 0
				if(0 == result) {
					outVO.setMsgId("0");//ID가 없는 경우
					outVO.setMsgContents("좋아요가 있습니다.");//ID가 없는 경우
				}else {
					outVO.setMsgId("1");//ID가 있는 경우
					outVO.setMsgId("좋아요가 없습니다.");//ID가 있는 경우
				}
				LOG.debug("4.return :\n"+outVO);
			}
		} catch(SQLException e) {
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
		return outVO;
	}
	
	/**
	 * 
	 *메서드명 : doSelectOneSno
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 로그인한 아이디와 현재 접속한 업체페이지가 일치하는지 체크
	 *@param dto
	 *@return int
	 */
	public int doSelectOneCheck(DTO dto) {
		//inVO 객체 생성
		HeartVO inVO = (HeartVO) dto;//param
		
		//return 객체 생성
		int flag = 0;
		
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
			sb.append("SELECT count(1) cnt  \n");
			sb.append("FROM heart       	\n");
			sb.append("WHERE sno = ? 		\n");
			sb.append("AND regid = ?    	\n");
			LOG.debug("2.SQL(Query) :\n"+sb.toString());
			
			//2.2.pstmt
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1.PreparedStatement : "+pstmt);
			
			//3.Param setting 
			LOG.debug("3.param :\n"+inVO);
			//3.1.Param binding
			pstmt.setString(1, inVO.getSno());
			pstmt.setString(2, inVO.getRegId());
			
			//4.Query 수행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//좋아요 있으면 1 없으면 0
				flag = rs.getInt("cnt"); //아이디
			}
		} catch(SQLException e) {
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
		return flag;
	}

	@Override
	public int doUpdate(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 
	 *메서드명 : doDelete
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 선호 업체 삭제
	 *@param dto
	 *@return int
	 */
	@Override
	public int doDelete(DTO dto) {
		int flag = 0;
		HeartVO inVO = (HeartVO) dto;// param

		Connection connection = null;// DB Connection
		PreparedStatement pstmt = null;// VS Statement
		try {
			// 1. connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection =" + connection);

			// 2.query
			StringBuilder sb = new StringBuilder();
			sb.append(" DELETE FROM heart \n");
			sb.append(" WHERE sno = ?   \n");
			sb.append(" AND regid = ?   \n");
			LOG.debug("2.query=\n" + sb.toString());

			// 2.1 pstmt
			pstmt = connection.prepareStatement(sb.toString());
			// 3. param
			LOG.debug("3.param=\n" + inVO);
			pstmt.setString(1, inVO.getSno());
			pstmt.setString(2, inVO.getRegId());

			// 4. query수행
			flag = pstmt.executeUpdate();
			LOG.debug("4.flag=" + flag);

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
	public List<?> doRetrieve(DTO dto) {
		return null;
	}
	
	/**
	 * 
	 *메서드명 : doRetrieveHeart
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 선호업체(마이페이지) 다건조회 아이디 검색
	 *@param dto
	 *@return int
	 */
	public List<?> doRetrieveHeart(DTO dto2,DTO dto) {
		
		SearchVO inVO = (SearchVO) dto;
		HeartVO HinVO = (HeartVO) dto2;
		
		List<StoreVO> outList = new ArrayList<StoreVO>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sbWhere = new StringBuilder();// 검색조건
		StringBuilder sb = new StringBuilder();// 검색query
		
		if(null !=inVO.getSearchDiv()) {
			if("1".equals(inVO.getSearchDiv())) {
				//업체번호+비정지만
				sbWhere.append(" AND p.sno = ? \n");
				sbWhere.append(" AND t1.views = 1 \n");
			}
		}
		
		// 검색구분-------------------------------------------------------------
		sb.append("SELECT *                                                     \n");
		sb.append("FROM(                                                        \n");
		sb.append("    SELECT b.rnum NO                                         \n");
		sb.append("          ,b.*                                               \n");
		sb.append("    FROM (                                                   \n");
		sb.append("        SELECT ROWNUM as rnum,A.*                            \n");
		sb.append("        FROM(                                                \n");
		sb.append("            SELECT t2.*                                      \n");
		sb.append("            FROM heart t1,store t2                           \n");
		sb.append("            WHERE t1.sno = t2.sno                            \n");
		sb.append("            AND t1.regid = ?                         		\n");
		sb.append("            --검색조건                                          \n");
		// Where-----------------------------------------------------------------------
		// ----------------------------------------------------------------------------
		sb.append("            ORDER BY t1.MODDT DESC                           \n");
		sb.append("        )A                                                   \n");
		sb.append("        WHERE rownum <=(?*(?-1)+?) 							\n");
		sb.append("    )B                                                       \n");
		sb.append("    WHERE rnum >=(?*(?-1)+1) )            					\n");
		sb.append("CROSS JOIN                                                   \n");
		sb.append("(                                                            \n");
		sb.append("    SELECT COUNT(*) TOTAL                                    \n");
		sb.append("    FROM heart t1                                            \n");
		sb.append("    WHERE t1.regid = ?                         				\n");
		sb.append("    --검색조건                                           					        \n");
		// Where-----------------------------------------------------------------------
		// ----------------------------------------------------------------------------
		sb.append(" )                                                             \n");

		try {
			// 1.connection
			connection = this.connectionMaker.getConnection();
			LOG.debug("1.connection=" + connection);

			// 2.pstmt
			// 2.1.
			LOG.debug("2.query=\n" + sb.toString());
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1. pstmt=" + pstmt);
			LOG.debug("3. param=" + inVO);
				// 1.PAGE_SIZE
				// 2.PAGE_NUM
				// 3.PAGE_SIZE
				// 4.PAGE_SIZE
				// 5.PAGE_NUM
				pstmt.setString(1, HinVO.getRegId());
				pstmt.setInt(2, inVO.getPageSize());
				pstmt.setInt(3, inVO.getPageNum());
				pstmt.setInt(4, inVO.getPageSize());
				pstmt.setInt(5, inVO.getPageSize());
				pstmt.setInt(6, inVO.getPageNum());
				pstmt.setString(7, HinVO.getRegId());

			   // 4.query수행
				rs = pstmt.executeQuery();
				while (rs.next()) {
				StoreVO outVO = new StoreVO();

				outVO.setNum(rs.getInt("no"));
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

				outList.add(outVO);
			}

		} catch (SQLException e) {
			LOG.debug("==================");
			LOG.debug("=SQLException=" + e.getMessage());
			LOG.debug("==================");
			e.printStackTrace();
		} finally {
			JDBCResClose.close(rs);
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}

		return outList;
	}

}
