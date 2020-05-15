/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.stooption
 * 클래스명 : StoOptionDao.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-18    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-18 오후 3:57:10
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.stooption;

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
import com.mal_a.roomoption.RoomOptionVO;

/**
 * @author sist
 *
 */
public class StoOptionDao extends WorkDiv {

private ConnectionMaker connectionMaker;
	
	public StoOptionDao() {
		connectionMaker = new ConnectionMaker();
	}
	
	/**
	 * 
	 *메서드명 : doInsert
	 *작성일 : 2020. 2. 19.
	 *작성자 : sist
	 *설명 : 업체 옵션 업체 번호에 따른 인서트 메서드
	 *@param dto
	 *@return int
	 */
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		Connection connection = connectionMaker.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO stooption VALUES (?, ?, ?)               \n");
		PreparedStatement pstmt = null;
		StoOptionVO inVO = (StoOptionVO) dto;
		try {
			LOG.debug("2. sql=\n"+sb.toString());
			LOG.debug("2.1. param=\n"+inVO);
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("3. pstmt="+pstmt);
			pstmt.setString(1, inVO.getSno());
			pstmt.setString(2, inVO.getOpt());
			pstmt.setString(3, inVO.getYn());
			flag = pstmt.executeUpdate();
			LOG.debug("4. flag="+flag);
		}catch(SQLException e) {
			LOG.debug("===================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("===================");
			e.printStackTrace();
		}finally {
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return flag;
	}
	
	@Override
	public DTO doSelectOne(DTO dto) {
		return null;
	}

	@Override
	public int doUpdate(DTO dto) {
		return 0;
	}

	/**
	 * 
	 *메서드명 : doDelete
	 *작성일 : 2020. 2. 19.
	 *작성자 : sist
	 *설명 : 업체 옵션 업체 번호에 따른 삭제 메서드
	 *@param dto
	 *@return int
	 */
	@Override
	public int doDelete(DTO dto) {
		int flag = 0;
		Connection connection = connectionMaker.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append(" DELETE FROM stooption \n");
		sb.append(" WHERE sno = ?     \n");	
		PreparedStatement pstmt = null;
		StoOptionVO inVO = (StoOptionVO) dto;
		try {
			LOG.debug("2.sql=\n"+sb.toString());
			LOG.debug("2.1 param=\n"+inVO);
			pstmt = connection.prepareStatement(sb.toString()); 
			LOG.debug("3.pstmt="+pstmt);
			pstmt.setString(1, inVO.getSno());
			flag = pstmt.executeUpdate();
			LOG.debug("4.flag="+flag);
		} catch (SQLException e) {
			LOG.debug("===================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("===================");
			e.printStackTrace();
		} finally {
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return flag;
	}

	/**
	 * 
	 *메서드명 : doRetrieve
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 업체 옵션 다건 조회 메서드
	 *@param dto
	 *@return List<?>
	 */
	@Override
	public List<?> doRetrieve(DTO dto) {
		StoOptionVO inVO = (StoOptionVO) dto; //param
		List<StoOptionVO> list = new ArrayList<StoOptionVO>(); //return
		
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
			sb.append("SELECT                    			\n");
			sb.append("	 sno                   				\n");
			sb.append("	,opt                   				\n");
			sb.append("	,yn                   				\n");
			sb.append("	,get_code('STOOPT',opt) optName  \n");
			sb.append("FROM                      			\n");
			sb.append("	stooption                	 		\n");
			sb.append("WHERE	sno = ?        				\n");
			sb.append("ORDER BY opt              			\n");
			LOG.debug("2.SQL :\n"+sb.toString());
			//2.2.pstmt
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1.PreparedStatement : "+pstmt);
			
			//3.Param setting 
			LOG.debug("3.param : "+inVO);
			//3.1.Param binding
			pstmt.setString(1, inVO.getSno());
			
			//4.Query 수행
			rs = pstmt.executeQuery();
			while(rs.next()) { //Moves the cursor forward one row from its current position. A ResultSet cursor is initially positioned before the first row;
				//데이터를 1건씩 outVO에 담기
				StoOptionVO outVO = new StoOptionVO();
				outVO.setSno(rs.getString("sno"));
				outVO.setOpt(rs.getString("opt"));
				outVO.setYn(rs.getString("yn"));
				outVO.setOptName(rs.getString("optName"));
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
	
	public List<?> doRetrievePossibleStoOpt(DTO dto) {
		StoOptionVO inVO = (StoOptionVO) dto;//param
		
		List<StoOptionVO> list = new ArrayList<StoOptionVO>(); //return
		
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
			sb.append("SELECT sno                                    \n");
			sb.append("      ,get_code('STOOPT', opt) opt            \n");
			sb.append("FROM stooption                                \n");
			sb.append("WHERE sno = ? --방번호                         			 \n");
			sb.append("AND yn = 1                          			 \n");
			sb.append("ORDER BY opt                         		 \n");
			LOG.debug("2.SQL :\n"+sb.toString());
			
			//2.2.pstmt
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1.PreparedStatement : "+pstmt);
			
			//3.Param setting 
			LOG.debug("3.param01 : "+inVO);
			//3.1.Param binding
			pstmt.setString(1, inVO.getSno());
			
			//4.Query 수행
			rs = pstmt.executeQuery();
			while(rs.next()) { //Moves the cursor forward one row from its current position. A ResultSet cursor is initially positioned before the first row;
				//데이터를 1건씩 outVO에 담기
				StoOptionVO outVO = new StoOptionVO();
				outVO.setSno(rs.getString("sno"));
				outVO.setOpt(rs.getString("opt"));
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
