/**
 *<pre>
 * com.hr.cmn
 * Class Name : JDBCResClose.java
 * Description : Board CRUD
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-02-04           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-02-04 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.cmn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * @author SIST
 *
 */
public class JDBCResClose {
	private final static Logger LOG = Logger.getLogger(JDBCResClose.class);
	
	/**
	 * 
	 *@Method Name:rollBack
	 *@작성일: 2020. 2. 4.
	 *@작성자: SIST
	 *@설명: rollBack
	 *@param Connection
	 */
	public static void rollBack(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			LOG.debug("===========================");
			LOG.debug("rollBack="+e.getMessage());
			LOG.debug("===========================");
			e.printStackTrace();
			
		}
	}
	
	
	/**
	 * 
	 *@Method Name:close
	 *@작성일: 2020. 2. 4.
	 *@작성자: SIST
	 *@설명: ResultSet 자원반납
	 *@param rs
	 */
	public static void close(ResultSet rs) {
		if(null !=rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				LOG.debug("===================");
				LOG.debug("rs close="+e.getMessage());
				LOG.debug("===================");
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 
	 *@Method Name:close
	 *@작성일: 2020. 2. 4.
	 *@작성자: SIST
	 *@설명: PreparedStatement 자원반납
	 *@param pstmt
	 */
	public static void close(PreparedStatement pstmt) {
		if(null !=pstmt) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				LOG.debug("===================");
				LOG.debug("pstmt close="+e.getMessage());
				LOG.debug("===================");
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 
	 *@Method Name:close
	 *@작성일: 2020. 2. 4.
	 *@작성자: SIST
	 *@설명: connection 지원반납
	 *@param connection
	 */
	public static void close(Connection connection) {
		
		if(null !=connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOG.debug("===================");
				LOG.debug("connection close="+e.getMessage());
				LOG.debug("===================");
				e.printStackTrace();
			}
		}
	}
	
	
	
}



















