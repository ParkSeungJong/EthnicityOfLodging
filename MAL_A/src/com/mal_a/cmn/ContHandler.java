/**
 *<pre>
 * 프로젝트명 : AMAL_A
 * 패키지명 : com.mal_a.cmn
 * 클래스명 : ContHandler.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-24    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-24 오후 6:49:39
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.cmn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mal_a.cmn.ContHandler;

/**
 * @author sist
 *
 */
public interface ContHandler {
//	 serviceHandler()
//	 doUpdate()
//	 doInsert()
//	 doDelete()
//	 doSelectOne()
//	 doRetrieve()
	Logger LOG=Logger.getLogger(ContHandler.class);
	/**
	 * 
	 *Method Name:serviceHandler
	 *작성일: 2020. 2. 21.
	 *작성자: sist
	 *설명: doPost()/doGet() 요청을 받는다.
	 *@param req
	 *@param res
	 *@throws ServletException
	 *@throws IOException
	 */
	public void serviceHandler(HttpServletRequest req
				, HttpServletResponse res)
						throws ServletException,IOException;
	/**
	 * 
	 *Method Name:doRetrieve
	 *작성일: 2020. 2. 21.
	 *작성자: sist
	 *설명: 목록조회
	 *@param req
	 *@param res
	 *@throws ServletException
	 *@throws IOException
	 */
	public void doRetrieve(HttpServletRequest req
			, HttpServletResponse res)
					throws ServletException,IOException;
	
	/**
	 * 
	 *Method Name:doSelectOne
	 *작성일: 2020. 2. 21.
	 *작성자: sist
	 *설명: 단건조회
	 *@param req
	 *@param res
	 *@throws ServletException
	 *@throws IOException
	 */
	public void doSelectOne(HttpServletRequest req
			, HttpServletResponse res)
					throws ServletException,IOException;
	
	
	/**
	 * 
	 *Method Name:doDelete
	 *작성일: 2020. 2. 21.
	 *작성자: sist
	 *설명: 삭제
	 *@param req
	 *@param res
	 *@throws ServletException
	 *@throws IOException
	 */
	public void doDel(HttpServletRequest req
			, HttpServletResponse res)
					throws ServletException,IOException;  
	
	/**
	 * 
	 *Method Name:doInsert
	 *작성일: 2020. 2. 21.
	 *작성자: sist
	 *설명: 등록
	 *@param req
	 *@param res
	 *@throws ServletException
	 *@throws IOException
	 */
	public void doInsert(HttpServletRequest req
			, HttpServletResponse res)
					throws ServletException,IOException;
	
	/**
	 * 
	 *Method Name:doUpdate
	 *작성일: 2020. 2. 21.
	 *작성자: sist
	 *설명: update처리를 한다.
	 *@param req
	 *@param res
	 *@throws ServletException
	 *@throws IOException
	 */
	public void doUpdate(HttpServletRequest req
			, HttpServletResponse res)
					throws ServletException,IOException;	

}
