package com.mal_a.member;

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
import com.mal_a.member.MemberVO;
import com.mal_a.payment.PaymentVO;
import com.mal_a.cmn.ContHandler;
import com.mal_a.cmn.MessageVO;
import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.StringUtil;
import com.mal_a.code.CodeService;
import com.mal_a.code.CodeVO;
import com.mal_a.mail.MailService;
import com.mal_a.mail.MailVO;
import com.mal_a.member.MemberService;
import com.mal_a.review.ReviewService;
import com.mal_a.review.ReviewVO;
import com.mal_a.room.RoomVO;
import com.mal_a.stooption.StoOptionVO;
import com.mal_a.store.StoreVO;

/**
 * Servlet implementation class BoardCont /DaoWEB/board/board.do ->
 * /board/board.do
 */
@WebServlet(description = "게시판", urlPatterns = { "/roxandrea/member.do" })
public class MemberCont extends HttpServlet implements ContHandler {
	private static final long serialVersionUID = 1L;

	/** BoardService객체 */
	private MemberService service;
	private ReviewService rservice;
	private CodeService codeService;
	private MailService mailService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberCont() {
		super();
		service = new MemberService();
		rservice = new ReviewService();
		codeService = new CodeService();
		mailService = new MailService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
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

	@Override
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
		String workDiv = StringUtil.nvl(req.getParameter("workDiv"));// null -> ""

		switch (workDiv) {// 거래분기
		case "doLogin":// 로그인
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doLogin(req, res);
			break;
		
		case "doLogout"://로그아웃
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doLogout(req, res);
		break;	

		case "doRetrieveReview":// 리뷰
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doRetrieveReview(req, res);
			break;

		case "doUpdate":// 수정
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doUpdate(req, res);
			break;

		case "doUpdateEmail":// 수정
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doUpdateEmail(req, res);
			break;

		case "doUpdateTel":// 수정
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doUpdateTel(req, res);
			break;

		case "doUpdateAddr":// 수정
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doUpdateAddr(req, res);
			break;

		case "doUpdatePw":// 수정
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doUpdatePw(req, res);
			break;

		case "doUpdateViews":// 수정
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doUpdateViews(req, res);
			break;

		case "doDelete":// 삭제
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doDel(req, res);
			break;

		case "doSelectOne":// 단건조회,단건조회 화면으로 이동
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doSelectOne(req, res);
			break;

		case "doSelectOnePw":// 비번찾기
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doSelectOnePw(req, res);
			break;
		
		case "doSelectOneId":// 아이디찾기
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doSelectOneId(req, res);
			break;
			
		case "doInsert":// 단건 등록
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doInsert(req, res);
			break;
		case "doRetrieve": // 목록조회
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doRetrieve(req, res);
			break;
		case "doRetrieveAdmin": // 관리자 회원관리
			LOG.debug("2====================");
			LOG.debug("2=workDiv=" + workDiv);
			LOG.debug("2====================");
			this.doRetrieveAdmin(req, res);
			break;

		default:
			LOG.debug("====================");
			LOG.debug("=작업구분을 확인 하세요.workDiv=" + workDiv);
			LOG.debug("====================");
			break;

		}

	}

	public void doLogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 1.param read
		// 2.param MemberVO
		// 3.service 메소드 호출
		MemberVO inVO = new MemberVO();
		MemberVO outVO = new MemberVO();

		String memberId = StringUtil.nvl(req.getParameter("memberId"));
		String password = StringUtil.nvl(req.getParameter("password"));
		String autho = StringUtil.nvl(req.getParameter("autho"));
		inVO.setMid(memberId);
		inVO.setPw(password);

		LOG.debug("-----------------------");
		LOG.debug("-inVO-" + inVO);
		LOG.debug("-----------------------");
		MessageVO checkMsg = (MessageVO) this.service.loginCheck(inVO);
		if (checkMsg.getMsgId().equals("1")) {
			outVO = (MemberVO) service.doSelectOne(inVO);
			LOG.debug(outVO);
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("user", outVO);
		}

		// checkMsg -> JSON
		Gson gson = new Gson();
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		String gsonStr = "";

		if (checkMsg.getMsgId().equals("1") && outVO.getAutho().equals("일반회원")) {
			gsonStr = "1";
			// LOG.debug("gsonStr:"+gsonStr);
		} else if (checkMsg.getMsgId().equals("1") && outVO.getAutho().equals("업체회원") && autho.equals("") || autho==null ) {
			gsonStr = "2";
			// LOG.debug("gsonStr:"+gsonStr);
		} else if (checkMsg.getMsgId().equals("1") && outVO.getAutho().equals("웹관리자")) {
			gsonStr = "3";
			// LOG.debug("gsonStr:"+gsonStr);
		} else if(checkMsg.getMsgId().equals("1") && outVO.getAutho().equals("업체회원") && autho.equals("4") && autho!=null) {
			gsonStr = "4";
		}
		LOG.debug("gsonStr:" + gsonStr);
		out.print(gsonStr);

	}
	
	public void doLogout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { 
    	//1.param read
		//2.param MemberVO
		//3.service 메소드 호출
        
        HttpSession  httpSession  =req.getSession();
        if(null !=httpSession) {
        	httpSession.removeAttribute("user");
        	httpSession.invalidate();
        	LOG.debug("httpSession:"+httpSession);
        }
        String path = "/roxandrea/log_in.jsp";
        RequestDispatcher dequestDispatcher=req.getRequestDispatcher(path);
        dequestDispatcher.forward(req, res);
        
    }
	
	/**
	 * 안씀, 관리자용으로 만들었지만 후훗 내가 해버림
	 */
	@Override
	public void doRetrieve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3-0 doRetrieve start ====================");
		// 1. param
		// 2. param set VO
		// 3. service 호출
		// 4. 특정화면+data
		SearchVO inVO = new SearchVO();
		String searchDiv = StringUtil.nvl(req.getParameter("searchDiv"));
		String searchWord = StringUtil.nvl(req.getParameter("searchWord"));
		String pageSize = StringUtil.nvl(req.getParameter("pageSize"), "10");
		String pageNum = StringUtil.nvl(req.getParameter("pageNum"), "1");

		inVO.setSearchDiv(searchDiv);
		inVO.setSearchWord(searchWord);
		inVO.setPageNum(Integer.parseInt(pageNum));
		inVO.setPageSize(Integer.parseInt(pageSize));

		LOG.debug("============================");
		LOG.debug("inVO+" + inVO);
		LOG.debug("============================");

		List<MemberVO> list = (List<MemberVO>) this.service.doRetrieve(inVO);

		LOG.debug("------------------------");
		for (MemberVO vo : list) {
			LOG.debug(vo);
		}

		LOG.debug("------------------------");
		// http://localhost:8080/DaoWEB/board/board.do?search_div=&search_word=&page_size=10&page_num=1&work_div=do_retrieve

		int totalCnt = 0;
		// 총글수
		if (null != list && list.size() > 0) {
			MemberVO totalVO = list.get(0);
			totalCnt = totalVO.getTotal();
		}

		req.setAttribute("memberList", list);// 목록
		req.setAttribute("paramVO", inVO);// param
		req.setAttribute("totalCnt", totalCnt);// 총글수

		RequestDispatcher dispatcher = req.getRequestDispatcher("/member/member_list.jsp");
		dispatcher.forward(req, res);
		LOG.debug("3-0 doRetrieve end ====================");

	}

	public void doRetrieveReview(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		SearchVO inSearchVO = new SearchVO();

		LOG.debug("*** doRetrieveReview");
		String searchDiv = StringUtil.nvl(req.getParameter("searchDiv"));
		LOG.debug("searchDiv=" + searchDiv);
		String searchWord = StringUtil.nvl(req.getParameter("searchWord"));
		LOG.debug("searchWord=" + searchWord);
		String pageSize = StringUtil.nvl(req.getParameter("pageSize"), "10");
		String pageNum = StringUtil.nvl(req.getParameter("pageNum"), "1");

		HttpSession httpSession = req.getSession();
		MemberVO vo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String SesId = vo.getMid(); // selectOne 값에서 Mid를 추출
		

		inSearchVO.setSearchDiv(searchDiv);
		inSearchVO.setSearchWord(SesId);
		inSearchVO.setPageSize(Integer.parseInt(pageSize));
		inSearchVO.setPageNum(Integer.parseInt(pageNum));

		List<ReviewVO> outListReviewVO = (List<ReviewVO>) rservice.doRetrieve(inSearchVO);

		LOG.debug("------------------------");
		for (ReviewVO reviewVO : outListReviewVO) {
			LOG.debug(reviewVO);
		}
		LOG.debug("------------------------");

		int totalCnt = 0;
		// 리뷰총글수
		if (null != outListReviewVO && outListReviewVO.size() > 0) {
			ReviewVO totalVO = outListReviewVO.get(0);
			totalCnt = totalVO.getTotal();
		}

		req.setAttribute("listReviewVO", outListReviewVO);
		req.setAttribute("paramVO", inSearchVO);// 파람
		req.setAttribute("totalCnt", totalCnt);// 리뷰총글수

		RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/member_review_list.jsp");
		dispatcher.forward(req, res);

	}

	public void doRetrieveAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3-0 doRetrieve start ====================");
		// 1. param
		// 2. param set VO
		// 3. service 호출
		// 4. 특정화면+data
		SearchVO inVO = new SearchVO();
		String searchDiv = StringUtil.nvl(req.getParameter("searchDiv"));
		String searchWord = StringUtil.nvl(req.getParameter("searchWord"));
		String pageSize = StringUtil.nvl(req.getParameter("pageSize"), "10");
		String pageNum = StringUtil.nvl(req.getParameter("pageNum"), "1");

		inVO.setSearchDiv(searchDiv);
		inVO.setSearchWord(searchWord);
		inVO.setPageNum(Integer.parseInt(pageNum));
		inVO.setPageSize(Integer.parseInt(pageSize));

		LOG.debug("============================");
		LOG.debug("inVO+" + inVO);
		LOG.debug("============================");

		List<MemberVO> memberList = (List<MemberVO>) this.service.doRetrieve(inVO);

		LOG.debug("------------------------");
		for (MemberVO vo : memberList) {
			LOG.debug(vo);
		}

		LOG.debug("------------------------");
		// http://localhost:8080/DaoWEB/board/board.do?search_div=&search_word=&page_size=10&page_num=1&work_div=do_retrieve

		int totalCnt = 0;
		// 총글수
		if (null != memberList && memberList.size() > 0) {
			MemberVO totalVO = memberList.get(0);
			totalCnt = totalVO.getTotal();
		}

		req.setAttribute("memberList", memberList);// 목록
		req.setAttribute("paramVO", inVO);// param
		req.setAttribute("totalCnt", totalCnt);// 총글수

		RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/admin_member_list_all.jsp");
		dispatcher.forward(req, res);
		LOG.debug("3-0 doRetrieve end ====================");

	}

	/**
	 * 단건조회
	 */
	@Override
	public void doSelectOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 1. param
		// 2. param to set vo
		// 3. service call
		// 4. request set
		// 5. forward

		MemberVO inVO = new MemberVO();

		HttpSession httpSession = req.getSession();
		MemberVO vo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String SesId = vo.getMid(); // selectOne 값에서 Mid를 추출
		String SesAutho = vo.getAutho(); // selectOne 값에서 Autho를 추출

		LOG.debug("==================================");
		LOG.debug("SesId:" + SesId);
		LOG.debug("SesAutho:"+SesAutho);
		LOG.debug("==================================");
		
		LOG.debug("*** doSelectOne");
		String mid = StringUtil.nvl(SesId); // 세션 Mid값 넣기
		LOG.debug("mid=" + mid);
		
		//파람 받기
		String autho = StringUtil.nvl(req.getParameter("autho"));
		LOG.debug("autho: "+autho);

		inVO.setMid(mid);
		MemberVO outVO = (MemberVO) service.doSelectOne(inVO);

		req.setAttribute("vo", outVO);
		
		//룸 옵션 코드 에서 뽑기
		CodeVO inCodeVO = new CodeVO();
		
		inCodeVO.setMstId("STOOPT");
		
		//코드 테이블에서 스토어 옵션 뽑기
		List<CodeVO> outListStoOption = (List<CodeVO>) this.codeService.doRetrieve(inCodeVO);
		
		req.setAttribute("outListStoOption", outListStoOption);//코드 업체 옵션
		
		if(SesAutho.equals("일반회원")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/member_select_one.jsp");
			dispatcher.forward(req, res);
		}else if(SesAutho.equals("업체회원") && autho.equals("2")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/bis_member_select_one.jsp");
			dispatcher.forward(req, res);
		}else if(SesAutho.equals("웹관리자")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/admin_member_select_one.jsp");
			dispatcher.forward(req, res);
		}else if(SesAutho.equals("업체회원") && autho.equals("4")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/bis_store_insert.jsp");
			dispatcher.forward(req, res);
		}
		
		
	}

	
	public void doSelectOneId(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 1. param
		// 2. param to set vo
		// 3. service call
		// 4. request set
		// 5. forward

		MemberVO inVO = new MemberVO();

		LOG.debug("*** doSelectOne");
		String email = StringUtil.nvl(req.getParameter("email")); 
		LOG.debug("email=" + email);

		inVO.setEmail(email);
		
		MemberVO outVO = (MemberVO) service.doSelectOneId(inVO);
		
		LOG.debug("3-0 sendMail start ====================");
		LOG.debug("3-0 ====================");
		LOG.debug("3-0 =sendMail=");
		LOG.debug("3-0 ====================");

		MailVO mailinVO = new MailVO();// param
		// 1.param read
		// 2.param BoardVO
		// 3.service 메소드 호출

		// 제목
		String from = "qkrtmdwhd2@naver.com";

		mailinVO.setTitle("---------숙박의 민족 : ID찾기---------");
		mailinVO.setRecAddr(email); //ID찾기에 입력한 email
		mailinVO.setMessage("사용자님의 ID는 '"+outVO.getMid()+"'입니다."); //SelectOneId 결과
		mailinVO.setSendAddr(from);//보낼아이디

		int flag = this.mailService.sendMail(mailinVO);
		LOG.debug("3-1====================");
		LOG.debug("3-1=flag=" + flag);
		LOG.debug("3-1====================");

		// 응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();

		
		String msg = "";
		Gson gson = new Gson();

		if (1 == flag) {
			msg ="입력하신 이메일로 아이디가 전송되었습니다.";
		} else {
			msg ="입력하신 회원정보가 없습니다.";
		}

		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));

		LOG.debug("==================================");
		LOG.debug("gsonStr=" + gsonStr);
		LOG.debug("==================================");

		out.print(gsonStr);
		LOG.debug("3-0 mailsend end ====================");

	}
	
	public void doSelectOnePw(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 1. param
		// 2. param to set vo
		// 3. service call
		// 4. request set
		// 5. forward

		MemberVO inVO = new MemberVO();


		LOG.debug("*** doSelectOne");
		String mid = StringUtil.nvl(req.getParameter("mid"));
		String name = StringUtil.nvl(req.getParameter("name"));
		String email = StringUtil.nvl(req.getParameter("email"));
		
		
		LOG.debug("=====================================");
		LOG.debug("mid=" + mid);
		LOG.debug("name=" + name);
		LOG.debug("email=" + email);
		LOG.debug("=====================================");

		inVO.setMid(mid);
		inVO.setName(name);
		inVO.setEmail(email);
		MemberVO outVO = (MemberVO) service.doSelectOnePw(inVO);

		LOG.debug("3-0 sendMail start ====================");
		LOG.debug("3-0 ====================");
		LOG.debug("3-0 =sendMail=");
		LOG.debug("3-0 ====================");

		MailVO mailinVO = new MailVO();// param
		// 1.param read
		// 2.param BoardVO
		// 3.service 메소드 호출

		// 제목
		String from = "qkrtmdwhd2@naver.com";

		mailinVO.setTitle("---------숙박의 민족 : 비밀번호 찾기---------");
		mailinVO.setRecAddr(email); //ID찾기에 입력한 email
		mailinVO.setMessage("사용자님의 비밀번호는 '"+outVO.getPw()+"' 입니다."); //SelectOneId 결과
		mailinVO.setSendAddr(from);//보낼아이디

		int flag = this.mailService.sendMail(mailinVO);
		LOG.debug("3-1====================");
		LOG.debug("3-1=flag=" + flag);
		LOG.debug("3-1====================");

		// 응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();

		
		String msg = "";
		Gson gson = new Gson();

		if (1 == flag) {
			msg ="입력하신 이메일로 비밀번호가 전송되었습니다.";
		} else {
			msg ="입력하신 회원정보가 없습니다.";
		}

		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));

		LOG.debug("==================================");
		LOG.debug("gsonStr=" + gsonStr);
		LOG.debug("==================================");

		out.print(gsonStr);
		LOG.debug("3-0 mailsend end ====================");

	}	

	@Override
	public void doInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3-0 doInsert start ====================");
		LOG.debug("3-0 ====================");
		LOG.debug("3-0 =doInsert=");
		LOG.debug("3-0 ====================");

		MemberVO inVO = new MemberVO();// param
		// 1.param read
		// 2.param BoardVO
		// 3.service 메소드 호출

		String mid = StringUtil.nvl(req.getParameter("mid"), "");
		String pw = StringUtil.nvl(req.getParameter("pw"), "");
		String name = StringUtil.nvl(req.getParameter("name"), "");
		String email = StringUtil.nvl(req.getParameter("email"), "");
		String birth = StringUtil.nvl(req.getParameter("birth"), "");
		String gender = StringUtil.nvl(req.getParameter("gender"), "");
		String tel = StringUtil.nvl(req.getParameter("tel"), "");
		String point = StringUtil.nvl(req.getParameter("point"), "");
		String autho = StringUtil.nvl(req.getParameter("autho"), "");
		String regId = StringUtil.nvl(req.getParameter("regid"), "");
		String addrNo = StringUtil.nvl(req.getParameter("addrno"), "");
		String addr = StringUtil.nvl(req.getParameter("addr"), "");

		inVO.setMid(mid);

		// TODO
		// login처리후 session으로 변환 할것
		inVO.setPw(pw);
		inVO.setName(name);
		inVO.setEmail(email);
		inVO.setBirth(birth);
		inVO.setGender(gender);
		inVO.setTel(tel);
		inVO.setPoint(point);
		inVO.setAutho(autho);
		inVO.setRegId(regId);
		inVO.setAddrNo(addrNo);
		inVO.setAddr(addr);

		int flag = this.service.doInsert(inVO); // DB에 갔다옴
		LOG.debug("3-1====================");
		LOG.debug("3-1=flag=" + flag);
		LOG.debug("3-1====================");

		// 응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
//		  if(flag==1) {
//			  out.println("<script>alert('등록성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		  }else {
//			  out.println("<script>alert('실패!');history.go(-1);</script>");
//		  }

		String msg = "";
		Gson gson = new Gson();

		if (1 == flag) {
			msg = inVO.getMid() + "님 \n등록되었습니다.";
		} else {
			msg = inVO.getMid() + "님 \n등록실패.";
		}

		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));

		LOG.debug("==================================");
		LOG.debug("gsonStr=" + gsonStr);
		LOG.debug("==================================");

		out.print(gsonStr);
		LOG.debug("3-0 doInsert end ====================");

	}

	@Override
	public void doUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3-0 update start ====================");
		LOG.debug("3-0 ====================");
		LOG.debug("3-0 =doUpdate=");
		LOG.debug("3-0 ====================");

		// 1. param
		// 2. param to set vo
		// 3. service call
		// 4. request set
		// 5. forward

		MemberVO inVO = new MemberVO();

		HttpSession httpSession = req.getSession();
		MemberVO vo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String SesId = vo.getMid(); // selectOne 값에서 Mid를 추출
		String SesAutho = vo.getAutho(); // selectOne 값에서 Autho를 추출

		LOG.debug("==================================");
		LOG.debug("SesId:" + SesId);
		LOG.debug("SesAutho:"+SesAutho);
		LOG.debug("==================================");
		
		LOG.debug("SesId:" + SesId);

		LOG.debug("*** doUpdate");
		String mid = StringUtil.nvl(SesId); // 세션 Mid값 넣기
		LOG.debug("mid=" + mid);

		inVO.setMid(mid);
		MemberVO outVO = (MemberVO) service.doSelectOne(inVO);

		req.setAttribute("vo", outVO);

		if(SesAutho.equals("일반회원")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/member_update.jsp");
			dispatcher.forward(req, res);
		}else if(SesAutho.equals("업체회원")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/bis_member_update.jsp");
			dispatcher.forward(req, res);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/admin_member_update.jsp");
			dispatcher.forward(req, res);
		}

	}

	public void doUpdatePw(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3-0 update start ====================");
		LOG.debug("3-0 ====================");
		LOG.debug("3-0 =doUpdate=");
		LOG.debug("3-0 ====================");

		MemberVO inVO = new MemberVO();// param
		// 1.param read
		// 2.param BoardVO
		// 3.service 메소드 호출
		// Mid
		String Mid = StringUtil.nvl(req.getParameter("mid"), "");

		// 전화번호
		String Pw = StringUtil.nvl(req.getParameter("pw"), "");

		inVO.setMid(Mid);
		inVO.setPw(Pw);

		// TODO
		// login처리후 session으로 변환 할것
		/*
		 * inVO.setRegId(regId); inVO.setModId(regId); inVO.setContents(contents);
		 */
		int flag = this.service.doUpdatePw(inVO); // DB에 갔다옴
		LOG.debug("3-1====================");
		LOG.debug("3-1=flag=" + flag);
		LOG.debug("3-1====================");

		// 응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
//		  if(flag==1) {
//			  out.println("<script>alert('등록성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		  }else {
//			  out.println("<script>alert('실패!');history.go(-1);</script>");
//		  }

		String msg = "";
		Gson gson = new Gson();

		if (1 == flag) {
			msg = inVO.getPw() + "이 \n수정되었습니다.";
		} else {
			msg = inVO.getPw() + "이 \n수정실패.";
		}

		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));

		LOG.debug("==================================");
		LOG.debug("gsonStr=" + gsonStr);
		LOG.debug("==================================");

		out.print(gsonStr);
		LOG.debug("3-0 doUpdate end ====================");

	}

	public void doUpdateAddr(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3-0 update start ====================");
		LOG.debug("3-0 ====================");
		LOG.debug("3-0 =doUpdate=");
		LOG.debug("3-0 ====================");

		MemberVO inVO = new MemberVO();// param
		// 1.param read
		// 2.param BoardVO
		// 3.service 메소드 호출
		// mid
		String Mid = StringUtil.nvl(req.getParameter("mid"), "");

		// 전화번호
		String Addr = StringUtil.nvl(req.getParameter("addr"), "");
		String AddrNo = StringUtil.nvl(req.getParameter("addrno"), "");

		inVO.setMid(Mid);
		inVO.setAddr(Addr);
		inVO.setAddrNo(AddrNo);

		// TODO
		// login처리후 session으로 변환 할것
		/*
		 * inVO.setRegId(regId); inVO.setModId(regId); inVO.setContents(contents);
		 */
		int flag = this.service.doUpdateAddr(inVO); // DB에 갔다옴
		LOG.debug("3-1====================");
		LOG.debug("3-1=flag=" + flag);
		LOG.debug("3-1====================");

		// 응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
//		  if(flag==1) {
//			  out.println("<script>alert('등록성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		  }else {
//			  out.println("<script>alert('실패!');history.go(-1);</script>");
//		  }

		String msg = "";
		Gson gson = new Gson();

		if (1 == flag) {
			msg = inVO.getTel() + "이 \n수정되었습니다.";
		} else {
			msg = inVO.getTel() + "이 \n수정실패.";
		}

		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));

		LOG.debug("==================================");
		LOG.debug("gsonStr=" + gsonStr);
		LOG.debug("==================================");

		out.print(gsonStr);
		LOG.debug("3-0 doUpdate end ====================");

	}

	public void doUpdateTel(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3-0 update start ====================");
		LOG.debug("3-0 ====================");
		LOG.debug("3-0 =doUpdate=");
		LOG.debug("3-0 ====================");

		MemberVO inVO = new MemberVO();// param
		// 1.param read
		// 2.param BoardVO
		// 3.service 메소드 호출
		// SEQ
		String Mid = StringUtil.nvl(req.getParameter("mid"), "");

		// 전화번호
		String Tel = StringUtil.nvl(req.getParameter("tel"), "");

		inVO.setMid(Mid);
		inVO.setTel(Tel);
		inVO.setModId(Mid);

		// TODO
		// login처리후 session으로 변환 할것
		/*
		 * inVO.setRegId(regId); inVO.setModId(regId); inVO.setContents(contents);
		 */
		int flag = this.service.doUpdateTel(inVO); // DB에 갔다옴
		LOG.debug("3-1====================");
		LOG.debug("3-1=flag=" + flag);
		LOG.debug("3-1====================");

		// 응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
//		  if(flag==1) {
//			  out.println("<script>alert('등록성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		  }else {
//			  out.println("<script>alert('실패!');history.go(-1);</script>");
//		  }

		String msg = "";
		Gson gson = new Gson();

		if (1 == flag) {
			msg = inVO.getTel() + "이 \n수정되었습니다.";
		} else {
			msg = inVO.getTel() + "이 \n수정실패.";
		}

		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));

		LOG.debug("==================================");
		LOG.debug("gsonStr=" + gsonStr);
		LOG.debug("==================================");

		out.print(gsonStr);
		LOG.debug("3-0 doUpdate end ====================");

	}

	public void doUpdateEmail(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3-0 update start ====================");
		LOG.debug("3-0 ====================");
		LOG.debug("3-0 =doUpdate=");
		LOG.debug("3-0 ====================");

		MemberVO inVO = new MemberVO();// param
		// 1.param read
		// 2.param BoardVO
		// 3.service 메소드 호출
		// ID
		String Mid = StringUtil.nvl(req.getParameter("mid"), "");

		// 이메일
		String Email = StringUtil.nvl(req.getParameter("email"), "");


		inVO.setMid(Mid);
		inVO.setEmail(Email);
		inVO.setModId(Mid);

		// TODO
		// login처리후 session으로 변환 할것
		/*
		 * inVO.setRegId(regId); inVO.setModId(regId); inVO.setContents(contents);
		 */
		int flag = this.service.doUpdateEmail(inVO); // DB에 갔다옴
		LOG.debug("3-1====================");
		LOG.debug("3-1=flag=" + flag);
		LOG.debug("3-1====================");

		// 응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
//		  if(flag==1) {
//			  out.println("<script>alert('등록성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		  }else {
//			  out.println("<script>alert('실패!');history.go(-1);</script>");
//		  }

		String msg = "";
		Gson gson = new Gson();

		if (1 == flag) {
			msg = inVO.getTel() + "이 \n수정되었습니다.";
		} else {
			msg = inVO.getTel() + "이 \n수정실패.";
		}

		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));

		LOG.debug("==================================");
		LOG.debug("gsonStr=" + gsonStr);
		LOG.debug("==================================");

		out.print(gsonStr);
		LOG.debug("3-0 doUpdate end ====================");

	}

	public void doUpdateViews(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3-0 update start ====================");
		LOG.debug("3-0 ====================");
		LOG.debug("3-0 =doUpdate=");
		LOG.debug("3-0 ====================");

		MemberVO inVO = new MemberVO();// param
		// 1.param read
		// 2.param BoardVO
		// 3.service 메소드 호출
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String modId = sseVO.getMid();
		LOG.debug("modId: "+modId);

		// 이메일
		String views = StringUtil.nvl(req.getParameter("views"), "");
		// ID
		String mid = StringUtil.nvl(req.getParameter("mid"), "");

		inVO.setViews(views);
		inVO.setModId(modId);
		inVO.setMid(mid);

		/*
		 * inVO.setRegId(regId); inVO.setModId(regId); inVO.setContents(contents);
		 */
		int flag = this.service.doUpdateViews(inVO); // DB에 갔다옴
		LOG.debug("3-1====================");
		LOG.debug("3-1=flag=" + flag);
		LOG.debug("3-1====================");

		// 응답처리
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
//		  if(flag==1) {
//			  out.println("<script>alert('등록성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		  }else {
//			  out.println("<script>alert('실패!');history.go(-1);</script>");
//		  }

		String msg = "";
		Gson gson = new Gson();

		if (1 == flag) {
			msg = inVO.getMid() + "이(가) \n수정 되었습니다.";
		} else {
			msg = inVO.getMid() + "이(가) \n수정 실패.";
		}

		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));

		LOG.debug("==================================");
		LOG.debug("gsonStr=" + gsonStr);
		LOG.debug("==================================");

		out.print(gsonStr);
		LOG.debug("3-0 doUpdate end ====================");

	}

	@Override
	public void doDel(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("==========================");
		LOG.debug("=do.del=");
		LOG.debug("==========================");

		// 1. vo 변수 선언
		// 2. param read
		// 3. vo에 param set
		// 4. service호출
		// 5. Gson message
		// 6. forward
		
		HttpSession httpSession = req.getSession();
		MemberVO vo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String SesId = vo.getMid(); // selectOne 값에서 Mid를 추출
		LOG.debug("SesId: " + SesId);
		String autho = vo.getAutho(); // selectOne 값에서 Mid를 추출
		LOG.debug("autho: " + autho);
		String sno = vo.getSno(); // selectOne 값에서 Mid를 추출
		LOG.debug("sno: " + sno);
		
		MemberVO inVO = new MemberVO();
		
		inVO.setMid(SesId);
		
		if(autho.equals("업체회원")) {
			inVO.setSno(sno);
		}
		
		LOG.debug("inVO: " + inVO);

		int flag = this.service.doDelete(inVO);

		Gson gson = new Gson();
		String msg = "";
		String gsonString = "";
		MessageVO msgVO = new MessageVO();

		if (flag > 0) {
			msg = "계정이 삭제되었습니다.";
		} else {
			msg = "삭제를 실패하였습니다.";
		}

		msgVO.setMsgId(String.valueOf(flag));
		msgVO.setMsgContents(msg);

		gsonString = gson.toJson(msgVO);
		LOG.debug("gsonString" + gsonString);

		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print(gsonString);

	}

}
