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
package com.mal_a.payment;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.mal_a.member.MemberService;
import com.mal_a.member.MemberVO;
import com.mal_a.room.RoomService;
import com.mal_a.room.RoomVO;

/**
 * @author sist
 *
 */
@WebServlet(description = "예약내역", urlPatterns = { "/roxandrea/payment.do" })
public class PaymentCont extends HttpServlet implements ContHandler {
	private static final long serialVersionUID = 1L;
	/** PaymentService객체*/
	private PaymentService service;
	private MemberService memService;
	private RoomService roomService;
	
	public PaymentCont() {
		super();
		service = new PaymentService();
		memService = new MemberService();
		roomService = new RoomService();
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
			case "goPaymentInsert"://단건조회, 단건조회 화면으로 이동
				this.goPaymentInsert(req, res);
				break;
			case "doSelectOnePno"://단건조회, 단건조회 화면으로 이동
				this.doSelectOnePno(req, res);
				break;
			case "doSelectOneRoomPrice"://단건조회, 단건조회 화면으로 이동
				this.doSelectOneRoomPrice(req, res);
				break;
			case "doRetrievePayPossibleRoom"://단건조회, 단건조회 화면으로 이동
				this.doRetrievePayPossibleRoom(req, res);
				break;
			case "doSelectOne"://단건조회, 단건조회 화면으로 이동
				this.doSelectOne(req, res);
				break;
//			case "move_to_save"://등록화면으로 이동
//				doMoveToSave(req, res);
//			break;
			case "doInsert"://단건 등록
				this.doInsert(req, res);
				break;
			case "doUpdateCanc"://환불 요청 업데이트
				this.doUpdateCanc(req, res);
				break;
				
			case "doUpdateCancCanc"://환불 요청 취소 업데이트
				this.doUpdateCancCanc(req, res);
				break;	
			case "doUpdateCancCmp"://환불 완료 업데이트
				this.doUpdateCancCmp(req, res);
				break;
			case "doUpdatePay"://취소완료 업데이트
				this.doUpdatePay(req, res);
				break;
			case "doRetrieve"://목록조회
				this.doRetrieve(req, res);
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
		//1. param
		//2. param setVO
		//3. service 호출
		//4. 특정화면+data
		SearchVO inVO = new SearchVO();
		
		String searchDiv  = StringUtil.nvl(req.getParameter("searchDiv"));
		String searchWord = StringUtil.nvl(req.getParameter("searchWord"));
		String pageSize   = StringUtil.nvl(req.getParameter("pageSize"),"10");
		String pageNum 	  = StringUtil.nvl(req.getParameter("pageNum"),"1");
		
		HttpSession httpSession = req.getSession();
		MemberVO memvo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String SesId = memvo.getMid(); //selectOne 값에서  Mid를 추출
		String sno = memvo.getSno(); //selectOne 값에서  Mid를 추출
		
		inVO.setSearchDiv(searchDiv);
		if(searchDiv.equals("1")) {
			inVO.setSearchWord(SesId);
		}else if(searchDiv.equals("2")) {
			inVO.setSearchWord(sno);
		}
		inVO.setPageSize(Integer.parseInt(pageSize));
		inVO.setPageNum(Integer.parseInt(pageNum));
		
		LOG.debug("================================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("================================");
		
		List<PaymentVO> list = (List<PaymentVO>) this.service.doRetrieve(inVO);
		LOG.debug("------------------------------------");
		for(PaymentVO vo : list) {
			LOG.debug(vo);
		}
		LOG.debug("------------------------------------");
		//http://localhost:8080/MAL_A/payment/payment.do?search_div=&serch_word=&page_size=10&page_num=1&work_div=do_retrieve
		
		int totalCnt = 0;
		//총글수
		if(null!=list && list.size()>0) {
			PaymentVO totalVO = list.get(0);
			totalCnt = totalVO.getTotal();
		}
		
		req.setAttribute("list", list);//목록
		req.setAttribute("paramVO", inVO);//파람
		req.setAttribute("totalCnt", totalCnt);//총글수
		if(searchDiv=="1" || searchDiv.equals("1")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/member_payment_list.jsp");
			dispatcher.forward(req, res);
		}else if(searchDiv=="2" || searchDiv.equals("2")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/bis_payment_list.jsp");
			dispatcher.forward(req, res);
		}
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/payment/payment_list.jsp");
//		dispatcher.forward(req, res);
	}
	
	/**
	 * 
	 *메서드명 : doRetrievePayPossibleRoom
	 *작성일 : 2020. 2. 28.
	 *작성자 : sist
	 *설명 : 선택한 업체의 체크인, 체크아웃 날짜에 따른 예약 가능한 방 출력 메서드
	 *@param req
	 *@param res
	 *@throws ServletException
	 *@throws IOException void
	 */
	public void doRetrievePayPossibleRoom(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//응답 인코딩
		res.setContentType("text/html;charset=utf-8");
		
		//VO 객체 생성
		PaymentVO paymentVO = new PaymentVO();
		RoomVO  roomVO = new RoomVO();
		
		//ajax에서 보낸 데이터 String 변수에 할당
		String startDt  = StringUtil.nvl(req.getParameter("startDt"));
		String endDt  	= StringUtil.nvl(req.getParameter("endDt"));
		String sno  	= StringUtil.nvl(req.getParameter("sno"));
		
		//VO에 String 데이터 셋팅
		paymentVO.setStartDt(startDt);
		paymentVO.setEndDt(endDt);
		roomVO.setSno(sno);
		
		//VO 데이터 확인
		LOG.debug("================================");
		LOG.debug("=paymentVO="+paymentVO);
		LOG.debug("=roomVO="+roomVO);
		LOG.debug("================================");
		
		//서비스 실행해서 List에 담기
		List<RoomVO> roomName = (List<RoomVO>) this.roomService.doRetrievePayPossible(paymentVO, roomVO);
		
		//Json 배열 생성
		JsonArray jsonArray = new JsonArray();
		
		//List에 담긴 db 정보 Json배열에 담기
		LOG.debug("------------------------------------");
		for(RoomVO vo : roomName) {
			LOG.debug(vo);
			jsonArray.add("<option value='"+vo.getRno()+"'>"+vo.getName()+"</option>");//방이름
			LOG.debug("jsonArray:"+jsonArray);
		}
		LOG.debug("------------------------------------");
		
		//ajax로 보낼 객체 생성
		PrintWriter out = res.getWriter();
		PrintWriter out02 = res.getWriter();
		
		//ajax로 Json 배열 송출
		out.println(jsonArray);
	}
	
	public void doSelectOneRoomPrice(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//응답 인코딩
		res.setContentType("text/html;charset=utf-8");
		
		//VO 객체 생성
		PaymentVO paymentVO = new PaymentVO();
		
		//ajax에서 보낸 데이터 String 변수에 할당
		String startDt  = StringUtil.nvl(req.getParameter("checkInDate"));
		String endDt  	= StringUtil.nvl(req.getParameter("checkOutDate"));
		String rno  	= StringUtil.nvl(req.getParameter("rno"));
		
		//VO에 String 데이터 셋팅
		paymentVO.setStartDt(startDt);
		paymentVO.setEndDt(endDt);
		paymentVO.setRno(rno);
		
		//VO 데이터 확인
		LOG.debug("================================");
		LOG.debug("=paymentVO="+paymentVO);
		LOG.debug("================================");
		
		//서비스 실행해서 List에 담기
		RoomVO vo = (RoomVO) this.roomService.doSelectOneRoomPrice(paymentVO);
		
		//Json 배열 생성
		JsonArray jsonArray = new JsonArray();
		
		//List에 담긴 db 정보 Json배열에 담기
		LOG.debug("------------------------------------");
		LOG.debug("vo:"+vo);
		jsonArray.add(vo.getPrice1());//방이름
		LOG.debug("jsonArray:"+jsonArray);
		LOG.debug("------------------------------------");
		
		//ajax로 보낼 객체 생성
		PrintWriter out = res.getWriter();
		
		//ajax로 Json 배열 송출
		out.println(jsonArray);
	}
	
	public DTO doSelectOneMember(String mid) {
		//VO 객체 생성
		MemberVO inVO = new MemberVO();
		
		//VO에 String 데이터 셋팅
		inVO.setMid(mid);
		
		//VO 데이터 확인
		LOG.debug("================================");
		LOG.debug("=memberVO="+inVO);
		LOG.debug("================================");
		
		//서비스 실행해서 List에 담기
		MemberVO outVO = (MemberVO) memService.doSelectOne(inVO);
		
		return outVO;
	}

	@Override
	public void doSelectOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PaymentVO inPaymentVO = new PaymentVO();
		LOG.debug("*** doSelectOne");
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String regId = sseVO.getMid();
		LOG.debug("regId: "+regId);
		
		inPaymentVO.setRegId(regId);
		PaymentVO outPaymentVO = (PaymentVO) service.doSelectOne(inPaymentVO);
		
		req.setAttribute("paymentVO", outPaymentVO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/payment_select_one.jsp");
		dispatcher.forward(req, res);
	}
	
	public void goPaymentInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("*** goPaymentInsert");
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String point = sseVO.getPoint();
		LOG.debug("point: "+point);
		String email = sseVO.getEmail();
		LOG.debug("email: "+email);
		String name = sseVO.getName();
		LOG.debug("name: "+name);
		String tel = sseVO.getTel();
		LOG.debug("tel: "+tel);
		String addr = sseVO.getAddr();
		LOG.debug("addr: "+addr);
		String addrNo = sseVO.getAddrNo();
		LOG.debug("addrNo: "+addrNo);
		
		//파람 받기
		String sno  = StringUtil.nvl(req.getParameter("sno"));
		LOG.debug("sno: "+sno);
		
		req.setAttribute("point", point);
		req.setAttribute("email", email);
		req.setAttribute("name", name);
		req.setAttribute("tel", tel);
		req.setAttribute("addr", addr);
		req.setAttribute("addrNo", addrNo);
		req.setAttribute("sno", sno);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/payment_insert.jsp");
		dispatcher.forward(req, res);
	}
	
	public void doSelectOnePno(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PaymentVO inPaymentVO = new PaymentVO();
		LOG.debug("*** doSelectOne");
		
		//파람 받기
		String pno  = StringUtil.nvl(req.getParameter("pno"));
		LOG.debug("pno: "+pno);
		
		inPaymentVO.setPno(pno);
		PaymentVO outPaymentVO = (PaymentVO) service.doSelectOnePno(inPaymentVO);
		
		req.setAttribute("paymentVO", outPaymentVO);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/review_insert.jsp");
		dispatcher.forward(req, res);
	}

	@Override
	public void doDel(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3==================");
		LOG.debug("3=do_insert=");
		LOG.debug("3==================");
		
		//inVO 객체 생성
		PaymentVO inPaymentVO = new PaymentVO();
		MemberVO inMemberVO = new MemberVO();
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String regId = sseVO.getMid();
		LOG.debug("regId: "+regId);
		
		//파람 받기
		String startDt = StringUtil.nvl(req.getParameter("startDt"),"");
		String endDt = StringUtil.nvl(req.getParameter("endDt"),"");
		String pay = StringUtil.nvl(req.getParameter("pay"),"");
		String usePoint = StringUtil.nvl(req.getParameter("usePoint"),"");
		String sno = StringUtil.nvl(req.getParameter("sno"),"");
		String rno = StringUtil.nvl(req.getParameter("rno"),"");
		
		inPaymentVO.setRegId(regId);
		inMemberVO.setMid(regId);
		inMemberVO.setModId(regId);
		
		//결제 inVO 셋팅
		inPaymentVO.setStartDt(startDt);
		inPaymentVO.setEndDt(endDt);
		inPaymentVO.setPay(pay);
		inPaymentVO.setUsePoint(usePoint);
		inPaymentVO.setSno(sno);
		inPaymentVO.setRno(rno);
		
		//회원 inVO 셋팅
		inMemberVO.setPoint(usePoint);
		
		int flag = this.service.doInsert(inPaymentVO);
		LOG.debug("3==================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==================");
		
		if(flag==1) {
			flag = this.memService.doUpdatePayment(inMemberVO);
		}
		
		//응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
//		if(flag==1) {
//			out.println("<script>alert('등록 성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		}else {
//			out.println("<script>alert('실패!');history.go(-1);</script>");
//		}
		String msg = "";
		Gson gson = new Gson();
		if(flag==1) {
			msg = "등록 되었습니다.";
		}else {
			msg = "등록 실패.";
		}
		
		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));
		LOG.debug("============================");
		LOG.debug("=gsonStr="+gsonStr);
		LOG.debug("============================");
		out.println(gsonStr);
	}

	@Override
	public void doUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	
	public void doUpdateCanc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3=============================");
		LOG.debug("3=doUpdate==");
		LOG.debug("3=============================");

		PaymentVO inVO = new PaymentVO();//param
		
		//1. param read
		//2. param BoardVO
		//3. service 메소드 호출
		
		//수정자 ID
		String modId = StringUtil.nvl(req.getParameter("modId"),"");
		//예약번호
		String pno = StringUtil.nvl(req.getParameter("pno"),"");
		
		HttpSession httpSession = req.getSession();
		MemberVO vo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String SesId = vo.getMid(); // selectOne 값에서 Mid를 추출
		
		//TODO
		//login 처리후 session 으로 변환 할것
		inVO.setModId(SesId); //세션값
		inVO.setPno(pno);
		
		int flag = this.service.doUpdateCanc(inVO);
		LOG.debug("3==================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==================");
		
		//응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
//		if(flag==1) {
//			out.println("<script>alert('등록 성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		}else {
//			out.println("<script>alert('실패!');history.go(-1);</script>");
//		}
		String msg = "";
		Gson gson = new Gson();
		if(flag==1) {
			msg = inVO.getPno()+"\n수정 되었습니다.";
		}else {
			msg = inVO.getPno()+"\n수정 실패.";
		}
		
		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));
		LOG.debug("============================");
		LOG.debug("=gsonStr="+gsonStr);
		LOG.debug("============================");
		out.println(gsonStr);
	}
	
	public void doUpdateCancCanc(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3=============================");
		LOG.debug("3=doUpdate==");
		LOG.debug("3=============================");

		PaymentVO inVO = new PaymentVO();//param
		
		//1. param read
		//2. param BoardVO
		//3. service 메소드 호출
		
		//예약번호
		String pno = StringUtil.nvl(req.getParameter("pno"),"");
		
		HttpSession httpSession = req.getSession();
		MemberVO vo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String SesId = vo.getMid(); // selectOne 값에서 Mid를 추출
		
		//TODO
		//login 처리후 session 으로 변환 할것
		inVO.setModId(SesId); //세션값
		inVO.setPno(pno);
		
		int flag = this.service.doUpdateCancCanc(inVO);
		LOG.debug("3==================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==================");
		
		//응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
//		if(flag==1) {
//			out.println("<script>alert('등록 성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		}else {
//			out.println("<script>alert('실패!');history.go(-1);</script>");
//		}
		String msg = "";
		Gson gson = new Gson();
		if(flag==1) {
			msg = inVO.getPno()+"\n수정 되었습니다.";
		}else {
			msg = inVO.getPno()+"\n수정 실패.";
		}
		
		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));
		LOG.debug("============================");
		LOG.debug("=gsonStr="+gsonStr);
		LOG.debug("============================");
		out.println(gsonStr);
	}
	
	public void doUpdateCancCmp(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3=============================");
		LOG.debug("3=doUpdate==");
		LOG.debug("3=============================");

		PaymentVO inVO = new PaymentVO();//param
		MemberVO inVO02 = new MemberVO();//param02
		
		//1. param read
		//2. param BoardVO
		//3. service 메소드 호출
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String modId = sseVO.getMid();
		LOG.debug("modId: "+modId);
		
		//예약번호
		String pno = StringUtil.nvl(req.getParameter("pno"),"");
		//예약자 ID
		String mid = StringUtil.nvl(req.getParameter("mid"),"");
		
		inVO.setPno(pno);
		inVO.setModId(modId);
		inVO02.setMid(mid);
		
		int flag = this.service.doUpdateCancCmp(inVO);
//		LOG.debug("3==================");
//		LOG.debug("3=flag="+flag);
//		LOG.debug("3==================");
//		//응답처리
//		res.setContentType("text/html;charset=utf-8");
//		PrintWriter out = res.getWriter();
////		if(flag==1) {
////			out.println("<script>alert('등록 성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
////		}else {
////			out.println("<script>alert('실패!');history.go(-1);</script>");
////		}
//		String msg = "";
//		Gson gson = new Gson();
//		if(flag==1) {
//			msg = inVO.getPno()+"\n수정 되었습니다.";
//		}else {
//			msg = inVO.getPno()+"\n수정 실패.";
//		}
		
		flag = this.memService.doUpdateCancCmp(inVO, inVO02);
		LOG.debug("3==================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==================");
		//응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
//		if(flag==1) {
//			out.println("<script>alert('등록 성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		}else {
//			out.println("<script>alert('실패!');history.go(-1);</script>");
//		}
		String msg = "";
		Gson gson = new Gson();
		if(flag==1) {
			msg = inVO.getPno()+"\n수정 되었습니다.";
		}else {
			msg = inVO.getPno()+"\n수정 실패.";
		}
		
		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));
		LOG.debug("============================");
		LOG.debug("=gsonStr="+gsonStr);
		LOG.debug("============================");
		out.println(gsonStr);
	}
	
	public void doUpdatePay(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3=============================");
		LOG.debug("3=doUpdate==");
		LOG.debug("3=============================");

		PaymentVO inVO = new PaymentVO();//param
		
		//1. param read
		//2. param BoardVO
		//3. service 메소드 호출
		
		//수정자 ID
		String modId = StringUtil.nvl(req.getParameter("modId"),"");
		//예약번호
		String pno = StringUtil.nvl(req.getParameter("pno"),"");
		
		//TODO
		//login 처리후 session 으로 변환 할것
		inVO.setModId(modId);
		inVO.setPno(pno);
		
		int flag = this.service.doUpdatePay(inVO);
		LOG.debug("3==================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==================");
		
		//응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
//		if(flag==1) {
//			out.println("<script>alert('등록 성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		}else {
//			out.println("<script>alert('실패!');history.go(-1);</script>");
//		}
		String msg = "";
		Gson gson = new Gson();
		if(flag==1) {
			msg = inVO.getPno()+"\n수정 되었습니다.";
		}else {
			msg = inVO.getPno()+"\n수정 실패.";
		}
		
		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));
		LOG.debug("============================");
		LOG.debug("=gsonStr="+gsonStr);
		LOG.debug("============================");
		out.println(gsonStr);
	}

}
