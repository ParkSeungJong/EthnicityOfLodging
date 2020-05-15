/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.code
 * 클래스명 : CodeDao.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-27    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-27 오전 11:58:48
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mal_a.cmn.JDBCResClose;
import com.mal_a.code.CodeVO;
import com.mal_a.cmn.ConnectionMaker;
import com.mal_a.cmn.DTO;
import com.mal_a.cmn.WorkDiv;

/**
 * @author sist
 *
 */
public class CodeDao extends WorkDiv {
	private ConnectionMaker connectionMaker;
	
	public CodeDao() {
		connectionMaker = new ConnectionMaker();
	}

	@Override
	public int doInsert(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doUpdate(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDelete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		CodeVO inVO = (CodeVO) dto; //param
		List<CodeVO> list = new ArrayList<CodeVO>(); //return
		
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
			sb.append("SELECT                    \n");
			sb.append("	 mstid                   \n");
			sb.append("	,dtlid                   \n");
			sb.append("	,mstnm                   \n");
			sb.append("	,dtlnm                   \n");
			sb.append("FROM                      \n");
			sb.append("	code                	 \n");
			sb.append("WHERE	mstid = ?        \n");
			sb.append("AND	useyn = 1            \n");
			sb.append("ORDER BY seq              \n");
			LOG.debug("2.SQL :\n"+sb.toString());
			//2.2.pstmt
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1.PreparedStatement : "+pstmt);
			
			//3.Param setting 
			LOG.debug("3.param : "+inVO);
			//3.1.Param binding
			pstmt.setString(1, inVO.getMstId());
			
			//4.Query 수행
			rs = pstmt.executeQuery();
			while(rs.next()) { //Moves the cursor forward one row from its current position. A ResultSet cursor is initially positioned before the first row;
				//데이터를 1건씩 outVO에 담기
				CodeVO outVO = new CodeVO();
				outVO.setMstId(rs.getString("mstid"));
				outVO.setDtlId(rs.getString("dtlid"));
				outVO.setMstNm(rs.getString("mstnm"));
				outVO.setDtlNm(rs.getString("dtlnm"));
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

	/**
	 *메서드명 : doAdminRetrieve
	 *작성일 : 2020. 3. 17.
	 *작성자 : sist133
	 *설명 : 
	 *@param dto
	 *@return List<?>
	*/
	public List<?> doAdminRetrieve(DTO dto) {
		CodeVO inVO = (CodeVO) dto; //param
		List<CodeVO> list = new ArrayList<CodeVO>(); //return
		
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
			sb.append("SELECT                    \n");
			sb.append("	 mstid                   \n");
			sb.append("	,dtlid                   \n");
			sb.append("	,mstnm                   \n");
			sb.append("	,dtlnm                   \n");
			sb.append("FROM                      \n");
			sb.append("	code                	 \n");
			sb.append("WHERE	mstid = ?        \n");
			sb.append("AND	useyn = 1            \n");
			sb.append("ORDER BY seq              \n");
			LOG.debug("2.SQL :\n"+sb.toString());
			//2.2.pstmt
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1.PreparedStatement : "+pstmt);
			
			//3.Param setting 
			LOG.debug("3.param : "+inVO);
			//3.1.Param binding
			pstmt.setString(1, inVO.getMstId());
			
			//4.Query 수행
			rs = pstmt.executeQuery();
			while(rs.next()) { //Moves the cursor forward one row from its current position. A ResultSet cursor is initially positioned before the first row;
				//데이터를 1건씩 outVO에 담기
				CodeVO outVO = new CodeVO();
				outVO.setMstId(rs.getString("mstid"));
				outVO.setDtlId(rs.getString("dtlid"));
				outVO.setMstNm(rs.getString("mstnm"));
				outVO.setDtlNm(rs.getString("dtlnm"));
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
