package com.mal_a.mail;

import com.google.gson.Gson;
import com.mal_a.cmn.ContHandler;
import com.mal_a.cmn.MessageVO;
import com.mal_a.cmn.StringUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailCont
 */
@WebServlet(description = "naver.smtp", urlPatterns = { "/mail/mail.do", "/MailCont" })
public class MailCont extends HttpServlet implements ContHandler {
	private static final long serialVersionUID = 1L;

	private MailService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MailCont() {
		super();
		service = new MailService();
	}

	/**
	 * @see ContHandler#doInsert(HttpServletRequest, HttpServletResponse)
	 */
	public void doInsert(HttpServletRequest seq, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ContHandler#doDel(HttpServletRequest, HttpServletResponse)
	 */
	public void doDel(HttpServletRequest seq, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ContHandler#doSelectOne(HttpServletRequest, HttpServletResponse)
	 */
	public void doSelectOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

	public void sendMail(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3-0 sendMail start ====================");
		LOG.debug("3-0 ====================");
		LOG.debug("3-0 =sendMail=");
		LOG.debug("3-0 ====================");

		MailVO inVO = new MailVO();// param
		// 1.param read
		// 2.param BoardVO
		// 3.service 메소드 호출

		// 제목
		String title = StringUtil.nvl(req.getParameter("title"), "");
		String recAddr = StringUtil.nvl(req.getParameter("rec_addr"), "");
		String message = StringUtil.nvl(req.getParameter("message"), "");
		String from = "qkrtmdwhd2@naver.com";

		inVO.setTitle(title);
		inVO.setRecAddr(recAddr);
		inVO.setMessage(message);
		inVO.setSendAddr(from);

		int flag = this.service.sendMail(inVO);
		LOG.debug("3-1====================");
		LOG.debug("3-1=flag=" + flag);
		LOG.debug("3-1====================");

		// 응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();

		String msg = "";
		Gson gson = new Gson();

		if (1 == flag) {
			msg = inVO.getTitle() + "이 \n mail 전송되었습니다.";
		} else {
			msg = inVO.getTitle() + "이 \n mail 전송실패.";
		}

		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));

		LOG.debug("==================================");
		LOG.debug("gsonStr=" + gsonStr);
		LOG.debug("==================================");

		out.print(gsonStr);
		LOG.debug("3-0 sendMail end ====================");
	}

	/**
	 * @see ContHandler#doUpdate(HttpServletRequest, HttpServletResponse)
	 */
	public void doUpdate(HttpServletRequest seq, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ContHandler#serviceHandler(HttpServletRequest, HttpServletResponse)
	 */
	public void serviceHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 1.work_div: 작업구분
		// 2.request Encoding: utf-8
		// 3.기능별 분해
		// 거래분기:
		// do_update:수정
		// do_delete:삭제
		// do_insert:등록
		// do_retrieve:목록조회
		// do_selectOne:단건조회

		req.setCharacterEncoding("utf-8");// request의 인코딩: utf-8
		String workDiv = StringUtil.nvl(req.getParameter("work_div"));// null -> ""

		LOG.debug("2====================");
		LOG.debug("2=workDiv=" + workDiv);
		LOG.debug("2====================");
		switch (workDiv) {// 거래분기
		case "send_mail":// 수정
			this.sendMail(req, res);
			break;

		default:
			LOG.debug("====================");
			LOG.debug("=작업구분을 확인 하세요.workDiv=" + workDiv);
			LOG.debug("====================");
			break;
		}
	}

	/**
	 * @see ContHandler#doRetrieve(HttpServletRequest, HttpServletResponse)
	 */
	public void doRetrieve(HttpServletRequest seq, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("1. doGet------");
		serviceHandler(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOG.debug("1. doPost------");
		serviceHandler(request, response);
	}

}
