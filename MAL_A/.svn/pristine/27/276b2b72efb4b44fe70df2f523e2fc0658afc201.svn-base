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
package com.mal_a.room;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
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
import com.mal_a.code.CodeService;
import com.mal_a.code.CodeVO;
import com.mal_a.filemng.FileMngService;
import com.mal_a.filemng.FileMngVO;
import com.mal_a.member.MemberService;
import com.mal_a.member.MemberVO;
import com.mal_a.payment.PaymentVO;
import com.mal_a.room.RoomService;
import com.mal_a.room.RoomVO;
import com.mal_a.roomoption.RoomOptionService;
import com.mal_a.roomoption.RoomOptionVO;
import com.mal_a.stooption.StoOptionVO;

/**
 * @author sist
 *
 */
@WebServlet(description = "예약내역", urlPatterns = { "/roxandrea/room.do" })
public class RoomCont extends HttpServlet implements ContHandler {
	private static final long serialVersionUID = 1L;
	/** PaymentService객체*/
	private RoomService roomService;
	private FileMngService fileMngService;
	private static RoomOptionService roomOptService;
	private CodeService codeService;
	
	public RoomCont() {
		super();
		roomService = new RoomService();
		fileMngService = new FileMngService();
		roomOptService = new RoomOptionService();
		codeService = new CodeService();
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
			case "doDelete":
				this.doDel(req, res);
				break;
			case "doUpdate":
				this.doUpdate(req, res);
				break;
			case "doInsert":
				this.doInsert(req, res);
				break;
			case "doSelectOne":
				this.doSelectOne(req, res);
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
		//inVO 객체 생성
		SearchVO inVO = new SearchVO();
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String sno = sseVO.getSno();
		LOG.debug("sno: "+sno);
		
		//파람 받기
		String autho  = StringUtil.nvl(req.getParameter("autho"));
		String searchDiv  = StringUtil.nvl(req.getParameter("searchDiv"));
		String searchWord = StringUtil.nvl(req.getParameter("searchWord"));
		LOG.debug("searchWord: "+searchWord);
		String pageSize   = StringUtil.nvl(req.getParameter("pageSize"),"10");
		String pageNum 	  = StringUtil.nvl(req.getParameter("pageNum"),"1");
		
		//inVO 셋팅
		inVO.setSearchDiv(searchDiv);
		if(sno!=null) {
			inVO.setSearchWord(sno);
		}else if(sno==null) {
			inVO.setSearchWord(searchWord);
		}
		inVO.setPageSize(Integer.parseInt(pageSize));
		inVO.setPageNum(Integer.parseInt(pageNum));
		
		LOG.debug("================================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("================================");
		
		//방 리스트 서비스 실행
		List<List> list = (List<List>) this.roomService.doRetrieve(inVO);
		LOG.debug("------------------------------------");
		for(List vo : list) {
			LOG.debug(vo+"\n");
		}
		LOG.debug("------------------------------------");
		//http://localhost:8080/MAL_A_PRA/payment/payment.do?search_div=&serch_word=&page_size=10&page_num=1&work_div=do_retrieve
		
		//총글수
		int totalCnt = 0;
		if(null!=list && list.size()>0) {
			List testList = (List) list.get(0).get(0);
			//토탈 CNT
			RoomVO totalVO = (RoomVO) testList.get(0);
			LOG.debug("totalVO: "+totalVO);
			totalCnt = totalVO.getTotal();
		}
		LOG.debug("totalCnt: "+totalCnt);
		
		//응답 처리
		req.setAttribute("list", list);//목록
		req.setAttribute("paramVO", inVO);//파람
		req.setAttribute("totalCnt", totalCnt);//총글수
		
		if(autho.equals("1")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/room_list.jsp");
			dispatcher.forward(req, res);
		}else if(autho.equals("2")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/bis_room_list.jsp");
			dispatcher.forward(req, res);
		}else if(autho.equals("3")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/admin_room_list.jsp");
			dispatcher.forward(req, res);
		}
		
	}
	

	@Override
	public void doSelectOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1. param
		//2. param to set vo
		//3. service call
		//4. request set
		//5. forward
		
		LOG.debug("*** doSelectOne");
		
		//inVO 객체 생성
		RoomVO inRoomVO = new RoomVO();
		FileMngVO inFileMngVO = new FileMngVO();
		RoomOptionVO inRoomOptionVO = new RoomOptionVO();
		
		//파람 받기
		String rno = StringUtil.nvl(req.getParameter("rno"));
		LOG.debug("rno: "+rno);
		String fileId = StringUtil.nvl(req.getParameter("fileId"));
		LOG.debug("fileId: "+fileId);
		String autho = StringUtil.nvl(req.getParameter("autho"));
		LOG.debug("autho: "+autho);
		String roomPart = StringUtil.nvl(req.getParameter("roomPart"));
		LOG.debug("roomPart: "+roomPart);
		
		//inVO 셋팅
		inRoomVO.setRno(rno);
		inFileMngVO.setFileId(fileId);
		inRoomOptionVO.setRno(rno);
		
		//룸 셀렉트원 서비스 호출
		RoomVO outRoomVO = (RoomVO) roomService.doSelectOne(inRoomVO);
		
		//방 옵션 뽑기
		List<RoomOptionVO> outListRoomOption = (List<RoomOptionVO>) this.roomOptService.doRetrieve(inRoomOptionVO);
		LOG.debug("---------------------");
		for(RoomOptionVO vo :outListRoomOption) {
			LOG.debug(vo);
		}
		LOG.debug("---------------------");

		//코드테이블 방 옵션 뽑기
		CodeVO inCodeVO = new CodeVO();
		inCodeVO.setMstId("ROOMOPT");
		LOG.debug("inCodeVO: "+inCodeVO);
		List<CodeVO> outListCodeRoomOption = (List<CodeVO>) this.codeService.doRetrieve(inCodeVO);
		LOG.debug("---------------------");
		for(CodeVO vo :outListCodeRoomOption) {
			LOG.debug(vo);
		}
		LOG.debug("---------------------");
		
		//첨부파일 리스트 서비스 호출
		List<FileMngVO> outListFileMng = (List<FileMngVO>) fileMngService.doRetrieve(inFileMngVO);
		LOG.debug("---------------------");
		for(FileMngVO vo :outListFileMng) {
			LOG.debug(vo);
		}
		LOG.debug("---------------------");
		
		req.setAttribute("roomVO", outRoomVO);
		req.setAttribute("outListFileMng", outListFileMng);
		
		if(autho.equals("1")) {
			req.setAttribute("outListCodeRoomOption", outListCodeRoomOption);//코드 테이블 방 옵션
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/bis_room_insert.jsp");
			dispatcher.forward(req, res);
		}else if(autho.equals("2")) {
			req.setAttribute("outListRoomOption", outListRoomOption);//방 옵션
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/bis_room_update.jsp");
			dispatcher.forward(req, res);
		}
	}

	@Override
	public void doDel(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("=============================");
		LOG.debug("=doDel==");
		LOG.debug("=============================");
		
		//inVO 객체 생성
		RoomVO inRoomVO = new RoomVO();
		FileMngVO inFileMngVO = new FileMngVO();
		
		//파람 받기
		String rno = StringUtil.nvl(req.getParameter("rno"));
		String fileId = StringUtil.nvl(req.getParameter("fileId"));
		
		//inVO 셋팅
		inRoomVO.setRno(rno);
		inFileMngVO.setFileId(fileId);
		
		//서비스 실행
		int flag = this.roomService.doDelete(inRoomVO);
		LOG.debug("=============================");
		LOG.debug("1.flag: "+flag);
		LOG.debug("=============================");
		
		flag = this.fileMngService.doDelete(inFileMngVO);
		LOG.debug("=============================");
		LOG.debug("2.flag: "+flag);
		LOG.debug("=============================");
		
		Gson gson = new Gson();
		String msg = "";
		String gsonString = "";
		MessageVO msgVO = new MessageVO();
		
		if(flag>0) {
			msg = "삭제되었습니다.";
		}else {
			msg = "삭제 실패.";
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
	public void doInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3==================");
		LOG.debug("3=doInsert=");
		LOG.debug("3==================");
		
		//파람으로 던질 VO, List<VO> 객체 생성
		RoomVO inRoomVO = new RoomVO();
		List<FileMngVO> inListFileMngVO = new ArrayList<FileMngVO>();
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String regId = sseVO.getMid();
		LOG.debug("regId: "+regId);
		String sno = sseVO.getSno();
		LOG.debug("sno: "+sno);
		
		//룸 파람 받기
		String name = req.getParameter("name");
		LOG.debug("name: "+name);
		String capacity = req.getParameter("capacity");
		LOG.debug("capacity: "+capacity);
		String cont = req.getParameter("cont");
		LOG.debug("cont: "+cont);
		String price1 = req.getParameter("price1");
		LOG.debug("price1: "+price1);
		String price2 = req.getParameter("price2");
		LOG.debug("price2: "+price2);
		String fileId = req.getParameter("fileId");
		LOG.debug("fileId: "+fileId);
		
		//첨부파일 단건 파람 받기
		String filePart = req.getParameter("filePart");
		LOG.debug("filePart: "+filePart);
		
		//첨부파일 배열 파람 받기
		String[] orgNm = req.getParameterValues("orgNm");
		String[] saveNm = req.getParameterValues("saveNm");
		String[] savePath = req.getParameterValues("savePath");
		String[] fileSize = req.getParameterValues("fileSize");
		String[] ext = req.getParameterValues("ext");
		
		//룸 옵션 배열 파람 받기
		String[] roomOption = req.getParameterValues("roomOption");
		for(int i=0;i<roomOption.length;i++) {
			LOG.debug(i+1+"번째 roomOption: "+roomOption[i]);
		}
		
		//inVO 셋팅
		inRoomVO.setSno(sno);
		inRoomVO.setName(name);
		inRoomVO.setCapacity(capacity);
		inRoomVO.setCont(cont);
		inRoomVO.setPrice1(price1);
		inRoomVO.setPrice2(price2);
		inRoomVO.setOpt1(roomOption[0]);
		inRoomVO.setOpt2(roomOption[1]);
		inRoomVO.setOpt3(roomOption[2]);
		inRoomVO.setOpt4(roomOption[3]);
		inRoomVO.setOpt5(roomOption[4]);
		inRoomVO.setOpt6(roomOption[5]);
		if(!fileId.equals("")) {
			inRoomVO.setFileId(fileId);
		}
		
		LOG.debug("------------------------------------");
		LOG.debug(inRoomVO);
		LOG.debug("------------------------------------");
		
		int flag = this.roomService.doInsert(inRoomVO);
		
		LOG.debug("4==================");
		LOG.debug("4=flag="+flag);
		LOG.debug("4==================");
		
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
		
		//첨부파일 있을 경우
		if(flag==1 && orgNm!=null) {
			for(int i=0;i<orgNm.length;i++) {
				LOG.debug(i+"번째 "+"orgNm: "+orgNm[i]);
				LOG.debug(i+"번째 "+"saveNm: "+saveNm[i]);
				LOG.debug(i+"번째 "+"savePath: "+savePath[i]);
				LOG.debug(i+"번째 "+"fileSize: "+fileSize[i]);
				LOG.debug(i+"번째 "+"ext: "+ext[i]);
			}
			
			//첨부파일 VO 셋팅
			for(int i=0;i<orgNm.length;i++) {
				FileMngVO inFileMngVO = new FileMngVO();
				
				inFileMngVO.setFileId(fileId);
				inFileMngVO.setSeq(i+1);
				inFileMngVO.setOrgNm(orgNm[i]);
				inFileMngVO.setSaveNm(saveNm[i]);
				inFileMngVO.setSavePath(savePath[i]);
				inFileMngVO.setFileSize(Integer.parseInt(fileSize[i]));
				inFileMngVO.setExt(ext[i]);
				inFileMngVO.setFilePart(filePart);
				inFileMngVO.setRegId(regId);
				
				inListFileMngVO.add(inFileMngVO);
			}
			
			LOG.debug("------------------------------------");
			for(FileMngVO vo:inListFileMngVO) {
				LOG.debug(vo);
			}
			LOG.debug("------------------------------------");
			
			flag = this.fileMngService.doInsert(inListFileMngVO);
			
			LOG.debug("5==================");
			LOG.debug("5=flag="+flag);
			LOG.debug("5==================");
			
			//응답처리
			res.setContentType("text/html;charset=utf-8");
			out = res.getWriter();
//			if(flag==1) {
//				out.println("<script>alert('등록 성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//			}else {
//				out.println("<script>alert('실패!');history.go(-1);</script>");
//			}
			msg = "";
			gson = new Gson();
			if(flag==1) {
				msg = "등록 되었습니다.";
			}else {
				msg = "등록 실패.";
			}
			
			gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));
			LOG.debug("============================");
			LOG.debug("=gsonStr="+gsonStr);
			LOG.debug("============================");
		}
		out.println(gsonStr);
	}

	@Override
	public void doUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3==================");
		LOG.debug("3=doUpdate=");
		LOG.debug("3==================");
		
		//파람으로 던질 VO, List<VO> 객체 생성
		RoomVO inRoomVO = new RoomVO();
		List<FileMngVO> inListFileMngVO = new ArrayList<FileMngVO>();
		List<RoomOptionVO> inListRoomOptionVO = new ArrayList<RoomOptionVO>();
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String regId = sseVO.getMid();
		LOG.debug("regId: "+regId);
		
		//룸 파람 받기
		String rno = req.getParameter("rno");
		LOG.debug("rno: "+rno);
		String name = req.getParameter("name");
		LOG.debug("name: "+name);
		String capacity = req.getParameter("capacity");
		LOG.debug("capacity: "+capacity);
		String cont = req.getParameter("cont");
		LOG.debug("cont: "+cont);
		String price1 = req.getParameter("price1");
		LOG.debug("price1: "+price1);
		String price2 = req.getParameter("price2");
		LOG.debug("price2: "+price2);
		String fileId = req.getParameter("fileId");
		LOG.debug("fileId: "+fileId);
		
		//첨부파일 단건 파람 받기
		String filePart = req.getParameter("filePart");
		LOG.debug("filePart: "+filePart);
		
		//첨부파일 배열 파람 받기
		String[] orgNm = req.getParameterValues("orgNm");
		String[] saveNm = req.getParameterValues("saveNm");
		String[] savePath = req.getParameterValues("savePath");
		String[] fileSize = req.getParameterValues("fileSize");
		String[] ext = req.getParameterValues("ext");
		
		//룸 옵션 배열 파람 받기
		String[] roomOption = req.getParameterValues("roomOption");
		for(int i=0;i<roomOption.length;i++) {
			LOG.debug(i+1+"번째 roomOption: "+roomOption[i]);
		}
		
		//룸 VO 셋팅
		inRoomVO.setRno(rno);
		inRoomVO.setName(name);
		inRoomVO.setCapacity(capacity);
		inRoomVO.setCont(cont);
		inRoomVO.setPrice1(price1);
		inRoomVO.setPrice2(price2);
		if(!fileId.equals("")) {
			inRoomVO.setFileId(fileId);
		}
		
		LOG.debug("------------------------------------");
		LOG.debug(inRoomVO);
		LOG.debug("------------------------------------");
		
		int flag = this.roomService.doUpdate(inRoomVO);
		
		LOG.debug("4==================");
		LOG.debug("4=flag="+flag);
		LOG.debug("4==================");
		
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
			msg = "수정 되었습니다.";
		}else {
			msg = "수정 실패.";
		}
		
		String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));
		LOG.debug("============================");
		LOG.debug("=gsonStr="+gsonStr);
		LOG.debug("============================");
		
		//룸 옵션 삭제용 VO 객체 생성
		RoomOptionVO inRoomOptionDeleteVO = new RoomOptionVO();
		inRoomOptionDeleteVO.setRno(rno);
		
		//룸 옵션 전부 삭제
		this.roomOptService.doDelete(inRoomOptionDeleteVO);
		
		//룸 옵션 VO 셋팅
		for(int i=0;i<roomOption.length;i++) {
			RoomOptionVO inRoomOptionVO = new RoomOptionVO();
			
			inRoomOptionVO.setRno(rno);
			inRoomOptionVO.setOpt(Integer.toString(i+1));
			inRoomOptionVO.setYn(roomOption[i]);
			
			inListRoomOptionVO.add(inRoomOptionVO);
		}
		
		LOG.debug("------------------------------------");
		for(RoomOptionVO vo:inListRoomOptionVO) {
			LOG.debug(vo);
		}
		LOG.debug("------------------------------------");
		
		flag = this.roomOptService.doInsert(inListRoomOptionVO);
		
		LOG.debug("5==================");
		LOG.debug("5=flag="+flag);
		LOG.debug("5==================");
		
		//응답처리
		res.setContentType("text/html;charset=utf-8");
		out = res.getWriter();
//				if(flag==1) {
//					out.println("<script>alert('등록 성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//				}else {
//					out.println("<script>alert('실패!');history.go(-1);</script>");
//				}
		msg = "";
		gson = new Gson();
		if(flag==1) {
			msg = "등록 되었습니다.";
		}else {
			msg = "등록 실패.";
		}
		
		gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));
		LOG.debug("============================");
		LOG.debug("=gsonStr="+gsonStr);
		LOG.debug("============================");
		
		//첨부파일 삭제용 VO 객체 생성
		FileMngVO inFileMngDeleteVO = new FileMngVO();
		inFileMngDeleteVO.setFileId(fileId);
		
		//첨부파일 전부 삭제
		this.fileMngService.doDelete(inFileMngDeleteVO);
		
		//첨부파일 있을 경우
		if(flag==1 && orgNm!=null) {
			for(int i=0;i<orgNm.length;i++) {
				LOG.debug(i+"번째 "+"orgNm: "+orgNm[i]);
				LOG.debug(i+"번째 "+"saveNm: "+saveNm[i]);
				LOG.debug(i+"번째 "+"saveNm: "+savePath[i]);
				LOG.debug(i+"번째 "+"fileSize: "+fileSize[i]);
				LOG.debug(i+"번째 "+"ext: "+ext[i]);
			}
			
			//첨부파일 VO 셋팅
			for(int i=0;i<orgNm.length;i++) {
				FileMngVO inFileMngVO = new FileMngVO();
				
				inFileMngVO.setFileId(fileId);
				inFileMngVO.setSeq(i+1);
				inFileMngVO.setSavePath(savePath[i]);
				inFileMngVO.setOrgNm(orgNm[i]);
				inFileMngVO.setSaveNm(saveNm[i]);
				inFileMngVO.setFileSize(Integer.parseInt(fileSize[i]));
				inFileMngVO.setExt(ext[i]);
				inFileMngVO.setFilePart(filePart);
				inFileMngVO.setRegId(regId);
				
				inListFileMngVO.add(inFileMngVO);
			}
			
			LOG.debug("------------------------------------");
			for(FileMngVO vo:inListFileMngVO) {
				LOG.debug(vo);
			}
			LOG.debug("------------------------------------");
			
			flag = this.fileMngService.doInsert(inListFileMngVO);
			
			LOG.debug("5==================");
			LOG.debug("5=flag="+flag);
			LOG.debug("5==================");
			
			//응답처리
			res.setContentType("text/html;charset=utf-8");
			out = res.getWriter();
//			if(flag==1) {
//				out.println("<script>alert('등록 성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//			}else {
//				out.println("<script>alert('실패!');history.go(-1);</script>");
//			}
			msg = "";
			gson = new Gson();
			if(flag==1) {
				msg = "등록 되었습니다.";
			}else {
				msg = "등록 실패.";
			}
			
			gsonStr = gson.toJson(new MessageVO(String.valueOf(flag), msg));
			LOG.debug("============================");
			LOG.debug("=gsonStr="+gsonStr);
			LOG.debug("============================");
		}
		
		out.println(gsonStr);
	}
	
	public static String doRetrievePossibleRoomOpt(String rno) {
		//VO 객체 생성
		RoomOptionVO inVO = new RoomOptionVO();
		
		//스트링빌더
		StringBuilder sb = new StringBuilder();
		
		//VO에 String 데이터 셋팅
		inVO.setRno(rno);
		
		//VO 데이터 확인
		LOG.debug("================================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("================================");
		
		//서비스 실행해서 List에 담기
		List<RoomOptionVO> list = (List<RoomOptionVO>) roomOptService.doRetrievePossibleRoomOpt(inVO);
		
		for(RoomOptionVO vo:list) {
			if (sb.length() > 0) sb.append(", ");
			sb.append(vo.getOpt());
		}
		
		return sb.toString();
	}

}
