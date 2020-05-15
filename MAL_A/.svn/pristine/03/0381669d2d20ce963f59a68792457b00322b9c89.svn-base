/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.member
 * 클래스명 : MemberDao.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-06    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-06 오후 5:31:45
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.member;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.MessageVO;
import com.mal_a.cmn.ConnectionMaker;
import com.mal_a.cmn.DTO;
import com.mal_a.cmn.JDBCResClose;
import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.WorkDiv;
import com.mal_a.payment.PaymentVO;

/**
 *
 * @author SIST TODO 로그인기능 1._ ID_CHECK 2. PASS_CHECK 3. LOGIN 생성 Session
 *
 */
public class MemberDao extends WorkDiv {
	private final Logger LOG = Logger.getLogger(MemberDao.class);

	private ConnectionMaker connectionMaker;
	// 1.CRUD:
	// 1.1. 등록: int doInsert(DTO dto)
	// 1.2. 수정: int doUpdate(DTO dto)
	// 1.3. 삭제: int doDelete(DTO dto)
	// 1.4. 단건조회:DTO doSelectOne(DTO dto)
	// 1.5. 목록조회:List<?> doRetrieve(DTO dto)

	public MemberDao() {
		connectionMaker = new ConnectionMaker();
	}
	/**
	 * 
	 *메서드명 : idCheck
	 *작성일 : 2020. 3. 12.
	 *작성자 : SIST
	 *설명 : 
	 *@param dto
	 *@return DTO
	 */
	public DTO idCheck(DTO dto) {
		MemberVO inVO = (MemberVO) dto; //param
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
			sb.append(" SELECT count(*) cnt  \n");
			sb.append(" FROM member       \n");
			sb.append(" WHERE mid = ?  \n");
			
			LOG.debug("2.SQL(Query) :\n"+sb.toString());
			//2.2.pstmt
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1.PreparedStatement : "+pstmt);
			
			//3.Param setting 
			LOG.debug("3.param :\n"+inVO);
			//3.1.Param binding
			pstmt.setString(1, inVO.getMid());
			
			//4.Query 수행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//데이터를 1건씩 outVO에 담기
				outVO = new MessageVO();
				int result = rs.getInt("cnt"); //아이디
				//ID 있으면 1 그렇치 않으면 0
				if(0 == result) {
					outVO.setMsgId("10");//ID가 없는 경우
					outVO.setMsgContents("ID를 확인 하세요.");//ID가 없는 경우
				}else {
					outVO.setMsgId("1");//ID가 있는 경우
					outVO.setMsgContents("ID가 있습니다.");//ID가 있는 경우
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
	 *메서드명 : passCheck
	 *작성일 : 2020. 3. 12.
	 *작성자 : SIST
	 *설명 : 
	 *@param dto
	 *@return DTO
	 */
	public DTO passCheck(DTO dto) {
		MemberVO inVO = (MemberVO) dto; //param
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
			sb.append(" SELECT count(*) cnt  \n");
			sb.append(" FROM member       \n");
			sb.append(" WHERE mid = ?  \n");
			sb.append(" AND  pw   = ?  \n");
			
			LOG.debug("2.SQL(Query) :\n"+sb.toString());
			//2.2.pstmt
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1.PreparedStatement : "+pstmt);
			
			//3.Param setting 
			LOG.debug("3.param :\n"+inVO);
			//3.1.Param binding
			pstmt.setString(1, inVO.getMid());
			pstmt.setString(2, inVO.getPw());
			
			//4.Query 수행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//데이터를 1건씩 outVO에 담기
				outVO = new MessageVO();
				int result = rs.getInt("cnt"); //아이디
				//ID/비번 있으면 1 그렇치 않으면 0
				if(0 == result) {
					outVO.setMsgId("20");//ID/비번가 없는 경우
					outVO.setMsgContents("비번을 확인 하세요.");//ID/비번가 없는 경우
				}else {
					outVO.setMsgId("1");//ID/비번가 있는 경우
					outVO.setMsgContents("ID/비번OK");//ID/비번가 있는 경우
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
	 *메서드명 : doInsert
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 일반사용자 회원가입
	 *@param dto
	 *@return int
	 */
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;// param

		Connection connection = null;// DB Connection
		PreparedStatement pstmt = null;// VS Statement

		try {
			// 1.Connection
			connection = this.connectionMaker.getConnection();
			LOG.debug("1.Connection=" + connection);

			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO member (         \n");
			sb.append("    mid,                     \n");
			sb.append("    pw,                      \n");
			sb.append("    name,                    \n");
			sb.append("    email,                   \n");
			sb.append("    birth,                   \n");
			sb.append("    gender,                  \n");
			sb.append("    tel,                     \n");
			sb.append("    point,                   \n");
			sb.append("    autho,                   \n");
			sb.append("    regid,                   \n");
			sb.append("    addrno,                  \n");
			sb.append("    addr                     \n");
			sb.append(") VALUES (                   \n");
			sb.append("    ?,                       \n");
			sb.append("    ?,                       \n");
			sb.append("    ?,                       \n");
			sb.append("    ?,              			\n");
			sb.append("    TO_DATE(?,'YYYYMMDD'),	\n");
			sb.append("    ?,                       \n");
			sb.append("    ?,                       \n");
			sb.append("    ?,                       \n");
			sb.append("    ?,                       \n");
			sb.append("    ?,                       \n");
			sb.append("    ?,                       \n");
			sb.append("    ?                        \n");
			sb.append(")                            \n");
 
			// 2.pstmt
			LOG.debug("2.query=\n" + sb.toString());
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1 pstmt=" + pstmt);

			// 3.param
			LOG.debug("3.  param=" + inVO);
			pstmt.setString(1, inVO.getMid());
			pstmt.setString(2, inVO.getPw());
			pstmt.setString(3, inVO.getName());
			pstmt.setString(4, inVO.getEmail());
			pstmt.setString(5, inVO.getBirth());
			pstmt.setString(6, inVO.getGender());
			pstmt.setString(7, inVO.getTel());
			pstmt.setString(8, inVO.getPoint());
			pstmt.setString(9, inVO.getAutho());
			pstmt.setString(10, inVO.getRegId());
			pstmt.setString(11, inVO.getAddrNo());
			pstmt.setString(12, inVO.getAddr());

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

	/**
	 * 
	 *메서드명 : doSelectOne
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 마이페이지 회원정보 단건조회
	 *@param dto
	 *@return int
	 */
	@Override
	public DTO doSelectOne(DTO dto) {
		MemberVO inVO = (MemberVO) dto; // param
		MemberVO outVO = null; // return

		Connection connection = null; // DB Connection
		PreparedStatement pstmt = null; // VS
		ResultSet rs = null; // 결과값 처리 class

		StringBuilder sb = new StringBuilder(); // 검색 쿼리
		try {
			// 1. Connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection=" + connection);

			// 2. Query
			sb.append("SELECT                                \n");
			sb.append("    mid,                              \n");
			sb.append("    pw,                               \n");
			sb.append("    name,                             \n");
			sb.append("    email,                            \n");
			sb.append("    TO_CHAR(birth,'YYYY/MM/DD') birth,\n");
			sb.append("    get_code('GENDER',gender) gender, \n");
			sb.append("    tel,                              \n");
			sb.append("    point,                            \n");
			sb.append("    get_code('AUTHO',autho) autho,    \n");
			sb.append("    get_code('VIEWS',views) views,    \n");
			sb.append("    regid,                            \n");
			sb.append("    regdt,                            \n");
			sb.append("    modid,                            \n");
			sb.append("    moddt,                            \n");
			sb.append("    sno,                              \n");
			sb.append("    addrno,                           \n");
			sb.append("    addr                              \n");
			sb.append("FROM                                  \n");
			sb.append("    member                            \n");
			sb.append("WHERE mid = ? 	                     \n");

			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. prepareStatement :" + pstmt);
			LOG.debug("2.1. Query \n:" + sb.toString());

			// 3. Param
			LOG.debug("3. Param :" + inVO);
			pstmt.setString(1, inVO.getMid());

			// 4. Query 수행
			rs = pstmt.executeQuery();
			if (rs.next()) {
				outVO = new MemberVO();

				outVO.setMid(rs.getString("mid"));
				outVO.setPw(rs.getString("pw"));
				outVO.setName(rs.getString("name"));
				outVO.setEmail(rs.getString("email"));
				outVO.setBirth(rs.getString("birth"));
				outVO.setGender(rs.getString("gender"));
				outVO.setTel(rs.getString("tel"));
				outVO.setPoint(rs.getString("point"));
				outVO.setAutho(rs.getString("autho"));
				outVO.setViews(rs.getString("views"));
				outVO.setRegId(rs.getString("regid"));
				outVO.setRegDt(rs.getString("regdt"));
				outVO.setModId(rs.getString("modid"));
				outVO.setModDt(rs.getString("moddt"));
				outVO.setSno(rs.getString("sno"));
				outVO.setAddrNo(rs.getString("addrno"));
				outVO.setAddr(rs.getString("addr"));
				LOG.debug("5.outVO=\n" + outVO);

			}

		} catch (SQLException e) {
			LOG.debug("============================");
			LOG.debug("SQLException=" + e.getMessage());
			LOG.debug("============================");
			e.printStackTrace();
		} finally {
			JDBCResClose.close(rs);// ResultSet
			JDBCResClose.close(pstmt);// PreparedStatement
			JDBCResClose.close(connection);// connection
		}

		return outVO;
	}
	/**
	 * 
	 *메서드명 : doSelectOneId
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : ID찾기 단건조회
	 *@param dto
	 *@return int
	 */
	public DTO doSelectOneId(DTO dto) {
		MemberVO inVO = (MemberVO) dto; // param
		MemberVO outVO = null; // return

		Connection connection = null; // DB Connection
		PreparedStatement pstmt = null; // VS
		ResultSet rs = null; // 결과값 처리 class

		StringBuilder sb = new StringBuilder(); // 검색 쿼리
		try {
			// 1. Connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection=" + connection);

			// 2. Query
			sb.append("SELECT               \n");
			sb.append("    mid              \n");
			sb.append("FROM                 \n");
			sb.append("    member           \n");
			sb.append("WHERE email = ? 		\n");

			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. prepareStatement :" + pstmt);
			LOG.debug("2.1. Query \n:" + sb.toString());

			// 3. Param
			LOG.debug("3. Param :" + inVO);
			pstmt.setString(1, inVO.getEmail());

			// 4. Query 수행
			rs = pstmt.executeQuery();
			if (rs.next()) {
				outVO = new MemberVO();

				outVO.setMid(rs.getString("mid"));

				LOG.debug("5.outVO=\n" + outVO);

			}

		} catch (SQLException e) {
			LOG.debug("============================");
			LOG.debug("SQLException=" + e.getMessage());
			LOG.debug("============================");
			e.printStackTrace();
		} finally {
			JDBCResClose.close(rs);// ResultSet
			JDBCResClose.close(pstmt);// PreparedStatement
			JDBCResClose.close(connection);// connection
		}

		return outVO;
	}
	/**
	 * 
	 *메서드명 : doSelectOnePw
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : PW찾기 단건조회
	 *@param dto
	 *@return int
	 */
	public DTO doSelectOnePw(DTO dto) {
		MemberVO inVO = (MemberVO) dto; // param
		MemberVO outVO = null; // return

		Connection connection = null; // DB Connection
		PreparedStatement pstmt = null; // VS
		ResultSet rs = null; // 결과값 처리 class

		StringBuilder sb = new StringBuilder(); // 검색 쿼리
		try {
			// 1. Connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection=" + connection);

			// 2. Query
			sb.append("SELECT        \n");
			sb.append("    pw        \n");
			sb.append("FROM          \n");
			sb.append("    member    \n");
			sb.append("WHERE mid = ? \n");
			sb.append("AND name = ?  \n");
			sb.append("AND email = ? \n");

			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. prepareStatement :" + pstmt);
			LOG.debug("2.1. Query \n:" + sb.toString());

			// 3. Param
			LOG.debug("3. Param :" + inVO);
			pstmt.setString(1, inVO.getMid());
			pstmt.setString(2, inVO.getName());
			pstmt.setString(3, inVO.getEmail());

			// 4. Query 수행
			rs = pstmt.executeQuery();
			if (rs.next()) {
				outVO = new MemberVO();

				outVO.setPw(rs.getString("pw"));

				LOG.debug("5.outVO=\n" + outVO);

			}

		} catch (SQLException e) {
			LOG.debug("============================");
			LOG.debug("SQLException=" + e.getMessage());
			LOG.debug("============================");
			e.printStackTrace();
		} finally {
			JDBCResClose.close(rs);// ResultSet
			JDBCResClose.close(pstmt);// PreparedStatement
			JDBCResClose.close(connection);// connection
		}

		return outVO;
	}
	
	/**
	 * 
	 *메서드명 : doUpdateViews
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 사용정지 업데이트
	 *@param dto
	 *@return int
	 */
	public int doUpdateViews(DTO dto) {
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;// param

		Connection connection = null;// DB Connection
		PreparedStatement pstmt = null;// VS Statement
		try {
			// 1.connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection=" + connection);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE member          	\n");
			sb.append("SET  views    = ?      	\n");
			sb.append("		,modid   = ?		\n");
			sb.append("		,moddt   = SYSDATE  \n");
			sb.append("WHERE mid = ?    		\n");

			// 2.query
			LOG.debug("2. query=\n" + sb.toString());

			// 2.1 pstmt
			pstmt = connection.prepareStatement(sb.toString());
			// 3. param
			LOG.debug("3. param=" + inVO);
			pstmt.setString(1, inVO.getViews());
			pstmt.setString(2, inVO.getModId());
			pstmt.setString(3, inVO.getMid());

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
	
	/**
	 * 
	 *메서드명 : doUpdateEmail
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 이메일 업데이트
	 *@param dto
	 *@return int
	 */
	public int doUpdateEmail(DTO dto) {
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;// param

		Connection connection = null;// DB Connection
		PreparedStatement pstmt = null;// VS Statement
		try {
			// 1.connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection=" + connection);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE member          \n");
			sb.append("SET  email 	= ?    	  \n");
			sb.append("		,modid  = ?		  \n");
			sb.append("		,moddt  =SYSDATE  \n");
			sb.append("WHERE mid = ?    	  \n");

			// 2.query
			LOG.debug("2. query=\n" + sb.toString());

			// 2.1 pstmt
			pstmt = connection.prepareStatement(sb.toString());
			// 3. param
			LOG.debug("3. param=" + inVO);
			pstmt.setString(1, inVO.getEmail());
			pstmt.setString(2, inVO.getModId());
			pstmt.setString(3, inVO.getMid());

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
	
	/**
	 * 
	 *메서드명 : doUpdateTel
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 전화번호 업데이트
	 *@param dto
	 *@return int
	 */
	public int doUpdateTel(DTO dto) {
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;// param

		Connection connection = null;// DB Connection
		PreparedStatement pstmt = null;// VS Statement
		try {
			// 1.connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection=" + connection);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE member          \n");
			sb.append("SET  tel = ?    		  \n");
			sb.append("		,modid  =?		  \n");
			sb.append("		,moddt  =SYSDATE  \n");
			sb.append("WHERE mid = ?    	  \n");

			// 2.query
			LOG.debug("2. query=\n" + sb.toString());

			// 2.1 pstmt
			pstmt = connection.prepareStatement(sb.toString());
			// 3. param
			LOG.debug("3. param=" + inVO);
			pstmt.setString(1, inVO.getTel());
			pstmt.setString(2, inVO.getModId());
			pstmt.setString(3, inVO.getMid());

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

	/**
	 * 
	 *메서드명 : doUpdateAddr
	 *작성일 : 2020. 3. 10.
	 *작성자 : SIST
	 *설명 : 주소와 우편번호 수정
	 *@param dto
	 *@return int
	 */
	public int doUpdateAddr(DTO dto) {
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;// param

		Connection connection = null;// DB Connection
		PreparedStatement pstmt = null;// VS Statement
		try {
			// 1.connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection=" + connection);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE member          \n");
			sb.append("SET  addr = ?    	  \n");
			sb.append("     ,addrno =?   	  \n");
			sb.append("		,modid  =?		  \n");
			sb.append("		,moddt  =SYSDATE  \n");
			sb.append("WHERE mid = ?    	  \n");

			// 2.query
			LOG.debug("2. query=\n" + sb.toString());

			// 2.1 pstmt
			pstmt = connection.prepareStatement(sb.toString());
			// 3. param
			LOG.debug("3. param=" + inVO);
			pstmt.setString(1, inVO.getAddr());
			pstmt.setString(2, inVO.getAddrNo());
			pstmt.setString(3, inVO.getModId());
			pstmt.setString(4, inVO.getMid());

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
	
	/**
	 * 
	 *메서드명 : doUpdatePw
	 *작성일 : 2020. 3. 10.
	 *작성자 : SIST
	 *설명 : 비밀번호업데이트
	 *@param dto
	 *@return int
	 */
	public int doUpdatePw(DTO dto) {
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;// param

		Connection connection = null;// DB Connection
		PreparedStatement pstmt = null;// VS Statement
		try {
			// 1.connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection=" + connection);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE member          \n");
			sb.append("SET  pw = ?    		  \n");
			sb.append("		,modid  =?		  \n");
			sb.append("		,moddt  =SYSDATE  \n");
			sb.append("WHERE mid = ?    	  \n");

			// 2.query
			LOG.debug("2. query=\n" + sb.toString());

			// 2.1 pstmt
			pstmt = connection.prepareStatement(sb.toString());
			// 3. param
			LOG.debug("3. param=" + inVO);
			pstmt.setString(1, inVO.getPw());
			pstmt.setString(2, inVO.getModId());
			pstmt.setString(3, inVO.getMid());

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
	
	
	/**
	 * 
	 *메서드명 : doUpdatePayment
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 결제시 사용포인트 차감
	 *@param dto
	 *@return int
	 */
	public int doUpdatePayment(DTO dto) {
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;// param\

		Connection connection = null;// DB Connection
		PreparedStatement pstmt = null;// VS Statement
		try {
			// 1.connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection=" + connection);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE member                                                    \n");
			sb.append("SET                                                              \n");
			sb.append("    point = point - ?											\n");
			sb.append("	   ,modid  =?		  										    \n");
			sb.append("	   ,moddt  =SYSDATE  										    \n");
			sb.append("WHERE                                                            \n");
			sb.append("    mid = ?                                                      \n");

			// 2.query
			LOG.debug("2. query=\n" + sb.toString());

			// 2.1 pstmt
			pstmt = connection.prepareStatement(sb.toString());
			// 3. param
			LOG.debug("3. param=" + inVO);
			pstmt.setString(1, inVO.getPoint());
			pstmt.setString(2, inVO.getModId()); 
			pstmt.setString(3, inVO.getMid()); 

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
	
	/**
	 * 
	 *메서드명 : doUpdatePaymentCmp
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 구매확정시 포인트 적립
	 *@param dto
	 *@return int
	 */
	public int doUpdatePaymentCmp(DTO dto) {
		int flag = 0;
		PaymentVO inVO = (PaymentVO) dto;

		Connection connection = null;// DB Connection
		PreparedStatement pstmt = null;// VS Statement
		try {
			// 1.connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection=" + connection);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE member                                                        \n");
			sb.append("SET                                                                  \n");
			sb.append("    point = point + (SELECT savepoint FROM payment WHERE pno = ?)	\n");
			sb.append("	   ,modid  ='SYSTEM'		  										\n");/*등록한사람이 시스템*/
			sb.append("	   ,moddt  =SYSDATE  												\n");
			sb.append("WHERE                                                                \n");
			sb.append("    mid = ?                                                   		\n");

			// 2.query
			LOG.debug("2. query=\n" + sb.toString());

			// 2.1 pstmt
			pstmt = connection.prepareStatement(sb.toString());
			// 3. param
			LOG.debug("3. param=" + inVO);
			pstmt.setString(1, inVO.getPno());
			pstmt.setString(2, inVO.getRegId());

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
	
	/**
	 * 
	 *메서드명 : doUpdatePaymentCancCmp
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 예약 취소시 사용포인트 환불
	 *@param dto
	 *@return int
	 */
	public int doUpdatePaymentCancCmp(DTO dto2, DTO dto) {	
		int flag = 0;
		MemberVO inVO = (MemberVO) dto;// param
		PaymentVO inVO01 = (PaymentVO) dto2;

		Connection connection = null;// DB Connection
		PreparedStatement pstmt = null;// VS Statement
		try {
			// 1.connection
			connection = connectionMaker.getConnection();
			LOG.debug("1. Connection=" + connection);
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE member                                                    \n");
			sb.append("SET                                                              \n");
			sb.append("    point = point + (SELECT usepoint FROM payment WHERE pno = ?) \n");
			sb.append("	   ,modid  =?		  											\n");
			sb.append("	   ,moddt  =SYSDATE  											\n");
			sb.append("WHERE                                                            \n");
			sb.append("    mid = ?                                                      \n");

			// 2.query
			LOG.debug("2. query=\n" + sb.toString());

			// 2.1 pstmt
			pstmt = connection.prepareStatement(sb.toString());
			// 3. param
			LOG.debug("3. param=" + inVO);
			pstmt.setString(1, inVO01.getPno()); 
			pstmt.setString(2, inVO.getModId());
			pstmt.setString(3, inVO.getMid()); 


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
	
//------------------------------------------------------------------------------------------------	
	/**
	 * 
	 *메서드명 : doDelete
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 회원계정 삭제(연관 정보 모두 삭제)
	 *@param dto
	 *@return int
	 */
	@Override
	public int doDelete(DTO dto) {
		
		int flag = 0;
        
	      Connection connection = connectionMaker.getConnection();
	    //3. query수행을 위한 PreparedStatement
	      StringBuilder sb=new StringBuilder();
	      
	      sb.append("{call MEMBER_DELETE_PROC(?,?)}                               \n");
	      
	      CallableStatement cstmt = null;
	      MemberVO inVO = (MemberVO) dto;
		
	      try {
	          LOG.debug("2.sql=\n"+sb.toString());
	          LOG.debug("2.1 param=\n"+inVO);
	          cstmt = connection.prepareCall(sb.toString()); 
	          LOG.debug("3.cstmt="+cstmt);
	          // * 4. query실행
	          //   4.1. Bind변수에 값 설정
	         
	          cstmt.setString(1, inVO.getMid());		//ID
	          cstmt.setString(2, inVO.getSno());		//ID
	          
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



	// =------------------------------------------------------------------------------------------------------
	/**
	 * 
	 *메서드명 : doRetrieve
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 다건 조회
	 *@param dto
	 *@return int
	 */
	@Override
	public List<?> doRetrieve(DTO dto) {
//		1: 관리자권한
//		2: 정지상태
//		3: 성별

		SearchVO inVO = (SearchVO) dto;
		List<MemberVO> outList = new ArrayList<MemberVO>();

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sbWhere = new StringBuilder();// 검색조건
		StringBuilder sb = new StringBuilder();// 검색query

		if (null != inVO.getSearchDiv() || !inVO.getSearchDiv().equals("")) {
			if ("1".equals(inVO.getSearchDiv())) {// 관리자권한
				sbWhere.append(" WHERE t1.autho  = ? \n");
			} else if ("2".equals(inVO.getSearchDiv())) {// 정지상태
				sbWhere.append(" WHERE t1.views  = ? \n");
			} else if ("3".equals(inVO.getSearchDiv())) {// 성별
				sbWhere.append(" WHERE t1.gender = ? \n");
			}
		}
		// 검색구분-------------------------------------------------------------
		sb.append(" SELECT *                                                     \n");
		sb.append(" FROM(                                                        \n");
		sb.append("     SELECT b.rnum no                                         \n");
		sb.append("           ,b.mid                                             \n");
		sb.append("           ,b.pw                                              \n");
		sb.append("           ,b.name                                            \n");
		sb.append("           ,b.email                                           \n");
		sb.append(" 		  ,TO_CHAR(b.birth,'YYYYMMDD') birth                 \n");
		sb.append("           ,get_code('GENDER',gender) gender          	     \n");
		sb.append(" 		  ,b.tel                                             \n");
		sb.append(" 		  ,b.point                                           \n");
		sb.append("           ,get_code('AUTHO',autho) autho           		 	 \n");
		sb.append("			  ,get_code('VIEWS',views) views             		 \n");
		sb.append(" 		  ,b.regid                                           \n");
		sb.append(" 		  ,b.regdt                                           \n");
		sb.append(" 		  ,b.modid                                           \n");
		sb.append(" 		  ,b.moddt                                           \n");
		sb.append(" 		  ,b.sno                                             \n");
		sb.append(" 		  ,b.addrno                                          \n");
		sb.append(" 		  ,b.addr                                            \n");
		sb.append("     FROM (                                                   \n");
		sb.append("         SELECT ROWNUM as rnum,A.*                            \n");
		sb.append("         FROM(                                                \n");
		sb.append("             SELECT t1.*                                      \n");
		sb.append("             FROM member t1                                   \n");
		sb.append("             --검색조건                                           \n");
		// Where-----------------------------------------------------------------------
		if (null != inVO.getSearchDiv() || !inVO.getSearchDiv().equals("") ) {
			if(null != inVO.getSearchWord()) {
				sb.append(sbWhere.toString());
			}
		}
		// ----------------------------------------------------------------------------
		sb.append("             ORDER BY t1.regdt DESC                           \n");
		sb.append("         )A                                                   \n");
		sb.append("         WHERE rownum <=(?*(?-1)+?)                           \n");
		sb.append("     )B                                                       \n");
		sb.append("     WHERE rnum >=(?*(?-1)+1) )                               \n");
		sb.append(" CROSS JOIN                                                   \n");
		sb.append(" (                                                            \n");
		sb.append("     SELECT COUNT(*) TOTAL                                    \n");
		sb.append("     FROM member t1                                           \n");
		sb.append("     --검색조건                                      				             	 \n");
		// Where-----------------------------------------------------------------------
		if (null != inVO.getSearchDiv() || !inVO.getSearchDiv().equals("") ) {
			if(null != inVO.getSearchWord()) {
				sb.append(sbWhere.toString());
			}
		}
		// ----------------------------------------------------------------------------
		sb.append(" )                                                            \n");

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
			// 검색어 있는 경우
			if (null != inVO.getSearchDiv() && !inVO.getSearchDiv().equals("") && null != inVO.getSearchWord()) {
				// 검색어
				// &PAGE_SIZE*(&PAGE_NUM-1)+&PAGE_SIZE
				// &PAGE_SIZE*(&PAGE_NUM-1)+1)

				// 1.검색어
				// 2.PAGE_SIZE
				// 3.PAGE_NUM
				// 4.PAGE_SIZE
				// 5.PAGE_SIZE
				// 6.PAGE_NUM
				// 7.검색어
				pstmt.setString(1, inVO.getSearchWord());
				pstmt.setInt(2, inVO.getPageSize());
				pstmt.setInt(3, inVO.getPageNum());
				pstmt.setInt(4, inVO.getPageSize());
				pstmt.setInt(5, inVO.getPageSize());
				pstmt.setInt(6, inVO.getPageNum());
				pstmt.setString(7, inVO.getSearchWord());

				// 검색어 없을때
			} else {
				// 1.PAGE_SIZE
				// 2.PAGE_NUM
				// 3.PAGE_SIZE
				// 4.PAGE_SIZE
				// 5.PAGE_NUM
				pstmt.setInt(1, inVO.getPageSize());
				pstmt.setInt(2, inVO.getPageNum());
				pstmt.setInt(3, inVO.getPageSize());
				pstmt.setInt(4, inVO.getPageSize());
				pstmt.setInt(5, inVO.getPageNum());

			}

			// 4.query수행
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberVO outVO = new MemberVO();

				outVO.setNum(rs.getInt("no"));
				outVO.setMid(rs.getString("mid"));
				outVO.setPw(rs.getString("pw"));
				outVO.setName(rs.getString("name"));
				outVO.setEmail(rs.getString("email"));
				outVO.setBirth(rs.getString("birth"));
				outVO.setGender(rs.getString("gender"));
				outVO.setTel(rs.getString("tel"));
				outVO.setPoint(rs.getString("point"));
				outVO.setAutho(rs.getString("autho"));
				outVO.setViews(rs.getString("views"));
				outVO.setRegId(rs.getString("regid"));
				outVO.setRegDt(rs.getString("regdt"));
				outVO.setModId(rs.getString("modid"));
				outVO.setModDt(rs.getString("moddt"));
				outVO.setSno(rs.getString("sno"));
				outVO.setAddrNo(rs.getString("addrno"));
				outVO.setAddr(rs.getString("addr"));

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
	@Override
	public int doUpdate(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
