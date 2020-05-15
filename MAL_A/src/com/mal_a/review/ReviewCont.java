/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.payment
 * 클래스명 : PaymentCont.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-26    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-26 오전 9:53:33
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.review;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.mal_a.cmn.ContHandler;
import com.mal_a.cmn.DTO;
import com.mal_a.cmn.MessageVO;
import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.StringUtil;
import com.mal_a.filemng.FileMngService;
import com.mal_a.filemng.FileMngVO;
import com.mal_a.member.MemberService;
import com.mal_a.member.MemberVO;
import com.mal_a.payment.PaymentVO;
import com.mal_a.room.RoomService;
import com.mal_a.room.RoomVO;
import com.mal_a.roomoption.RoomOptionService;
import com.mal_a.roomoption.RoomOptionVO;

/**
 * @author sist
 *
 */
@WebServlet(description = "리뷰", urlPatterns = { "/roxandrea/review.do" })
public class ReviewCont extends HttpServlet implements ContHandler {
	private static final long serialVersionUID = 1L;
	/** PaymentService객체*/
	private ReviewService reviewService;
	
	public ReviewCont() {
		super();
		reviewService = new ReviewService();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		LOG.debug("doGet--------");
		serviceHandler(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("1doPost--------");
		serviceHandler(request, response);
	}
	
	@Override
	public void serviceHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1. work_div: 작업구분
		//2. request Encoding: UTF-8
		//3. 기능별 분해
			//거래분기:
	    	//do_update:수정
	    	//do_delete:삭제
	    	//do_insert:등록
	    	//do_retrieve:목록조회
	    	//do_selectOne:단건조회
		req.setCharacterEncoding("utf-8");//request의 인코딩: utf-8
		String workDiv = req.getParameter("workDiv");//null -> ""
		
		LOG.debug("2==================");
		LOG.debug("2=workDiv="+workDiv);
		LOG.debug("2==================");
		
		switch(workDiv) {//거래분기
			case "doInsert":
				this.doInsert(req, res);
				break;
			case "doUpdate":
				this.doUpdate(req, res);
				break;
			default:
				LOG.debug("==================");
				LOG.debug("=작업구분을 확인 하세요. workDiv="+workDiv);
				LOG.debug("==================");
				break;
			}
	}

	@Override
	public void doRetrieve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}
	

	@Override
	public void doSelectOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	}

	@Override
	public void doDel(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

	@Override
	public void doInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3==================");
		LOG.debug("3=doInsert=");
		LOG.debug("3==================");
		
		//inVO 객체 생성
		ReviewVO inReviewVO = new ReviewVO();
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String regId = sseVO.getMid();
		LOG.debug("regId: "+regId);
		
		//파람 받기
		String cont = StringUtil.nvl(req.getParameter("cont"));
		LOG.debug("=cont: "+cont);
		String star = StringUtil.nvl(req.getParameter("star"));
		LOG.debug("=star: "+star);
		String pno = StringUtil.nvl(req.getParameter("pno"));
		LOG.debug("=pno: "+pno);
		
		//inVO 셋팅
		inReviewVO.setCont(cont);
		inReviewVO.setStar(star);
		inReviewVO.setRegId(regId);
		inReviewVO.setPno(pno);
		
		//서비스 실행
		int flag = this.reviewService.doInsert(inReviewVO);
		LOG.debug("4==================");
		LOG.debug("4=flag: "+flag);
		LOG.debug("4==================");
		
		//응답처리
		Gson gson = new Gson();
		String msg = "";
		String gsonString = "";
		MessageVO msgVO = new MessageVO();
		
		if(flag>0) {
			msg = "리뷰가 등록되었습니다.";
		}else {
			msg = "리뷰 등록 실패.";
		}
		
		msgVO.setMsgId(String.valueOf(flag));
		msgVO.setMsgContents(msg);
		
		gsonString = gson.toJson(msgVO);
		LOG.debug("gsonString="+gsonString);
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(gsonString);
	}

	@Override
	public void doUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3=============================");
		LOG.debug("3=doUpdate=");
		LOG.debug("3=============================");
		
		//inVO 객체 생성
		ReviewVO inReviewVO = new ReviewVO();
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String modId = sseVO.getMid();
		LOG.debug("modId: "+modId);
		
		//파람 받기
		String reno = StringUtil.nvl(req.getParameter("reno"));
		LOG.debug("=reno: "+reno);
		String views = StringUtil.nvl(req.getParameter("views"));
		LOG.debug("=views: "+views);
		
		//inVO 셋팅
		inReviewVO.setReno(reno);
		inReviewVO.setViews(views);
		inReviewVO.setModId(modId);
		
		//서비스 실행
		int flag = this.reviewService.doUpdate(inReviewVO);
		LOG.debug("4=============================");
		LOG.debug("4=flag: "+flag);
		LOG.debug("4=============================");
		
		//응답처리
		Gson gson = new Gson();
		String msg = "";
		String gsonString = "";
		MessageVO msgVO = new MessageVO();
		
		if(flag>0) {
			msg = "수정되었습니다.";
		}else {
			msg = "수정 실패.";
		}
		
		msgVO.setMsgId(String.valueOf(flag));
		msgVO.setMsgContents(msg);
		
		gsonString = gson.toJson(msgVO);
		LOG.debug("gsonString="+gsonString);
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(gsonString);
	}
	
}
