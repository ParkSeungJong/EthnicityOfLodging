/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.roomoption
 * 클래스명 : RoomOptionDao.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-03-09    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-03-09 오후 3:17:17
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.roomoption;

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
import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.WorkDiv;
import com.mal_a.code.CodeVO;

/**
 * @author sist
 *
 */
public class RoomOptionDao extends WorkDiv {
	private final Logger LOG = Logger.getLogger(RoomOptionDao.class);
	private ConnectionMaker connectionMaker;
	
	public RoomOptionDao() {
		connectionMaker = new ConnectionMaker();
	}

	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		Connection connection = connectionMaker.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO roomoption VALUES (?, ?, ?)        \n");
		PreparedStatement pstmt = null;
		RoomOptionVO inVO = (RoomOptionVO) dto;
		try {
			LOG.debug("2. sql=\n"+sb.toString());
			LOG.debug("2.1. param=\n"+inVO);
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("3. pstmt="+pstmt);
			pstmt.setString(1, inVO.getRno());
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
		int flag = 0;
		Connection connection = connectionMaker.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append(" DELETE FROM roomoption \n");
		sb.append(" WHERE rno = ?     \n");	
		PreparedStatement pstmt = null;
		RoomOptionVO inVO = (RoomOptionVO) dto;
		try {
			LOG.debug("2.sql=\n"+sb.toString());
			LOG.debug("2.1 param=\n"+inVO);
			
			pstmt = connection.prepareStatement(sb.toString()); 
			LOG.debug("3.pstmt="+pstmt);
			
			pstmt.setString(1, inVO.getRno());
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

	@Override
	public List<?> doRetrieve(DTO dto) {
		RoomOptionVO inVO = (RoomOptionVO) dto; //param
		List<RoomOptionVO> list = new ArrayList<RoomOptionVO>(); //return
		
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
			sb.append("	 rno                   				\n");
			sb.append("	,opt                   				\n");
			sb.append("	,yn                   				\n");
			sb.append("	,get_code('ROOMOPT',opt) optName    \n");
			sb.append("FROM                      			\n");
			sb.append("	roomoption                	 		\n");
			sb.append("WHERE	rno = ?        				\n");
			sb.append("ORDER BY opt              			\n");
			LOG.debug("2.SQL :\n"+sb.toString());
			//2.2.pstmt
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1.PreparedStatement : "+pstmt);
			
			//3.Param setting 
			LOG.debug("3.param : "+inVO);
			//3.1.Param binding
			pstmt.setString(1, inVO.getRno());
			
			//4.Query 수행
			rs = pstmt.executeQuery();
			while(rs.next()) { //Moves the cursor forward one row from its current position. A ResultSet cursor is initially positioned before the first row;
				//데이터를 1건씩 outVO에 담기
				RoomOptionVO outVO = new RoomOptionVO();
				outVO.setRno(rs.getString("rno"));
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
	
	public List<?> doRetrievePossibleRoomOpt(DTO dto) {
		RoomOptionVO inVO = (RoomOptionVO) dto;//param
		
		List<RoomOptionVO> list = new ArrayList<RoomOptionVO>(); //return
		
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
			sb.append("SELECT rno                                    \n");
			sb.append("      ,get_code('ROOMOPT', opt) opt          \n");
			sb.append("FROM roomoption                               \n");
			sb.append("WHERE rno = ? --방번호                         			 	 \n");
			sb.append("AND yn = 1                          			 \n");
			sb.append("ORDER BY opt                         		 \n");
			LOG.debug("2.SQL :\n"+sb.toString());
			
			//2.2.pstmt
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1.PreparedStatement : "+pstmt);
			
			//3.Param setting 
			LOG.debug("3.param01 : "+inVO);
			//3.1.Param binding
			pstmt.setString(1, inVO.getRno());
			
			//4.Query 수행
			rs = pstmt.executeQuery();
			while(rs.next()) { //Moves the cursor forward one row from its current position. A ResultSet cursor is initially positioned before the first row;
				//데이터를 1건씩 outVO에 담기
				RoomOptionVO outVO = new RoomOptionVO();
				outVO.setRno(rs.getString("rno"));
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
