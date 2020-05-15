/**
 * 
 */
package com.mal_a.store;



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

import com.mal_a.cmn.SearchVO;
import com.google.gson.Gson;
import com.mal_a.cmn.ContHandler;
import com.mal_a.cmn.MessageVO;
import com.mal_a.cmn.StringUtil;
import com.mal_a.code.CodeService;
import com.mal_a.code.CodeVO;
import com.mal_a.filemng.FileMngService;
import com.mal_a.filemng.FileMngVO;
import com.mal_a.heart.HeartService;
import com.mal_a.heart.HeartVO;
import com.mal_a.member.MemberService;
import com.mal_a.member.MemberVO;
import com.mal_a.payment.PaymentVO;
import com.mal_a.review.ReviewService;
import com.mal_a.review.ReviewVO;
import com.mal_a.room.RoomService;
import com.mal_a.room.RoomVO;
import com.mal_a.roomoption.RoomOptionVO;
import com.mal_a.stooption.StoOptionService;
import com.mal_a.stooption.StoOptionVO;

/**
 * Servlet implementation class BoardCont
 * /DaoWEB/board/board.do -> /board/board.do
 */
@WebServlet(description = "옵션", urlPatterns = { "/roxandrea/store.do" })
public class StoreCont extends HttpServlet implements ContHandler {
	private static final long serialVersionUID = 1L;
	
	/** CodeService객체 */
    private CodeService  service;
    /** */
    private StoreService stoService;
    
    private ReviewService reviewService;
    
    private StoOptionService stoOptionService;
    
    private HeartService heartService;
    
    private FileMngService fileMngService;
    
    private MemberService memberService;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCont() {
        super();
        service = new CodeService();
        stoService = new StoreService();
        reviewService = new ReviewService();
        stoOptionService = new StoOptionService();
        heartService = new HeartService();
        fileMngService = new FileMngService();
        memberService = new MemberService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		LOG.debug("doGet------");
		serviceHandler(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("1. doPost------");
		serviceHandler(req, res);
	}

	@Override
	public void serviceHandler(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1.work_div: 작업구분
		//2.request Encoding: utf-8
		//3.기능별 분해
		    //거래분기:
	    	//do_update:수정
	    	//do_delete:삭제
	    	//do_insert:등록
	    	//do_retrieve:목록조회
	    	//do_selectOne:단건조회		
		
		req.setCharacterEncoding("utf-8");//request의 인코딩: utf-8
		String workDiv = StringUtil.nvl(req.getParameter("workDiv"));//null -> ""
			
			LOG.debug("2====================");
			LOG.debug("2=doInsert.workDiv="+workDiv);
			LOG.debug("2====================");	
			switch(workDiv) {//거래분기
			case "doUpdate"://수정
				this.doUpdate(req, res);
			break;
			case "doInsert"://수정
				this.doInsert(req, res);
			break;
//			case "move_to_save"://등록화면으로 이동
//				doMoveToSave(req, res);
//			break;
			case "doSelectOne"://수정
				this.doSelectOne(req, res);
			break;
			case "doUpdateViews"://수정
				this.doUpdateViews(req, res);
			break;
			
			case "doRetrieve"://목록조회
				this.doRetrieve(req, res);
				break;
			case "doRetrieveAdmin"://목록조회
				this.doRetrieveAdmin(req, res);
				break;
			case "doStoretrieve"://store목록조회
				this.doStoreRetrieve(req, res);
				break;
			default:
				  LOG.debug("====================");
				  LOG.debug("=작업구분을 확인 하세요.workDiv="+workDiv);
				  LOG.debug("====================");
				break;
		
		}
		
		
		
	}

	/**
	 * 
	 *메서드명 : doMoveToSave
	 *작성일 : 2020. 2. 26.
	 *작성자 : sist
	 *설명 : start화면으로 이동
	 *@param req
	 *@param res
	 *@throws ServletException
	 *@throws IOException void
	 */
//	public void doMoveToSave(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		RequestDispatcher dispatcher = 
//				req.getRequestDispatcher("/MAL_A/roxandrea/storemain.jsp");
//		dispatcher.forward(req, res);
//		
//	}
	
	public void doUpdateViews(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  LOG.debug("3-0 update start ====================");
		  LOG.debug("3-0 ====================");
		  LOG.debug("3-0 =doUpdate=");
		  LOG.debug("3-0 ====================");
		  
		  StoreVO inVO = new StoreVO();//param
		  //1.param read
		  //2.param BoardVO
		  //3.service 메소드 호출
		  
		  //세션에서 값 받기
		  HttpSession httpSession = req.getSession();
		  MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		  String modId = sseVO.getMid();
		  LOG.debug("modId: "+modId);
		  
		  //정지
		  String views = StringUtil.nvl(req.getParameter("views"),"");
		  //업체번호
		  String sno = StringUtil.nvl(req.getParameter("sno"),"");
		  //업체명
		  String name = StringUtil.nvl(req.getParameter("name"),"");
		  
		  inVO.setViews(views);
		  inVO.setModId(modId);
		  inVO.setSno(sno);
		  inVO.setName(name);
		  
		  //TODO
		  //login처리후 session으로 변환 할것
		 /*
		  inVO.setRegId(regId);
		  inVO.setModId(regId);
		  inVO.setContents(contents);
		  */
		  int flag = this.stoService.doUpdateViews(inVO); //DB에 갔다옴
		  LOG.debug("3-1====================");
		  LOG.debug("3-1=flag="+flag);
		  LOG.debug("3-1====================");
		  
		  //응답처리
		  res.setContentType("text/html;charset=utf-8");
		  PrintWriter out=res.getWriter();
//		  if(flag==1) {
//			  out.println("<script>alert('등록성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		  }else {
//			  out.println("<script>alert('실패!');history.go(-1);</script>");
//		  }
		  
		  String msg = "";
		  Gson gson = new Gson();
		  
		  if(1==flag) {
			  msg = inVO.getName()+"이(가) \n수정 되었습니다.";
		  }else {
			  msg = inVO.getName()+"이(가) \n수정 실패.";
		  }
		  
		  String gsonStr = gson.toJson(new MessageVO(String.valueOf(flag),msg));
		  
		  LOG.debug("==================================");
		  LOG.debug("gsonStr="+gsonStr);
		  LOG.debug("==================================");
		  
		  out.print(gsonStr);
		  LOG.debug("3-0 doUpdate end ====================");
		
	}
	
	@Override
	public void doRetrieve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				//1.param
				//2.param set VO
				//3.service호출
				//4.특정화면+data
				SearchVO inVO=new SearchVO();
				CodeVO codeVO = new CodeVO();
				StoreVO storeVO = new StoreVO();
				
				String searchDiv  = StringUtil.nvl(req.getParameter("searchDiv"));
				String searchWord = StringUtil.nvl(req.getParameter("searchWord"));
				String pageSize   = StringUtil.nvl(req.getParameter("pageSize"),"10");
				String pageNum    = StringUtil.nvl(req.getParameter("pageNum"),"1");
				
				LOG.debug("=======================");
				LOG.debug("=searchDiv="+searchDiv);
				LOG.debug("=searchWord="+searchWord);
				LOG.debug("=======================");
				
				inVO.setSearchDiv(searchDiv);
				inVO.setSearchWord(searchWord);
				inVO.setPageNum(Integer.parseInt(pageNum));
				inVO.setPageSize(Integer.parseInt(pageSize));
				
				LOG.debug("=======================");
				LOG.debug("=inVO="+inVO);
				LOG.debug("=======================");

				List<StoreVO> storeList = (List<StoreVO>) this.stoService.doRetrieve(inVO);
				
				LOG.debug("---------------------");
				LOG.debug("---------------------");
				for(StoreVO vo :storeList) {
					LOG.debug(vo);
				}
				
				LOG.debug("---------------------");
				
//				if(null !=list && list.size()>0) {
//					CodeVO totalVO=list.get(0);
//				}
				req.setAttribute("list", storeList);//목록
				req.setAttribute("paramVO", inVO);//param
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/MAL_A/roxandrea/store_list.jsp");
				dispatcher.forward(req, res);
	}
	
	public void doRetrieveAdmin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1.param
		//2.param set VO
		//3.service호출
		//4.특정화면+data
		SearchVO inVO=new SearchVO();
		
		String searchDiv  = StringUtil.nvl(req.getParameter("searchDiv"));
		String searchWord = StringUtil.nvl(req.getParameter("searchWord"));
		String pageSize   = StringUtil.nvl(req.getParameter("pageSize"),"10");
		String pageNum    = StringUtil.nvl(req.getParameter("pageNum"),"1");
		
		LOG.debug("=======================");
		LOG.debug("=searchDiv="+searchDiv);
		LOG.debug("=searchWord="+searchWord);
		LOG.debug("=======================");
		
		inVO.setSearchDiv(searchDiv);
		inVO.setSearchWord(searchWord);
		inVO.setPageNum(Integer.parseInt(pageNum));
		inVO.setPageSize(Integer.parseInt(pageSize));
		
		LOG.debug("=======================");
		LOG.debug("=inVO="+inVO);
		LOG.debug("=======================");

		List<StoreVO> storeList = (List<StoreVO>) this.stoService.doRetrieve(inVO);
		
		LOG.debug("---------------------");
		for(StoreVO vo :storeList) {
			LOG.debug(vo);
		}
		
		LOG.debug("---------------------");
		
		int totalCnt = 0;
		//총글수
		if(null != storeList && storeList.size()>0) {
			StoreVO totalVO = storeList.get(0);
			totalCnt = totalVO.getTotal();
		}
		req.setAttribute("storeList", storeList);//목록
		req.setAttribute("paramVO", inVO);//param
		req.setAttribute("totalCnt", totalCnt);//총글수
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/admin_store_list_all.jsp");
		dispatcher.forward(req, res);
	}

	/**
	 * 단건조회
	 */
	@Override
	public void doSelectOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//inVO 객체 생성
		StoreVO inStoreVO = new StoreVO();
		PaymentVO inPaymentVO = new PaymentVO();
		StoOptionVO inStoOptionVO = new StoOptionVO();
		SearchVO inSearchVO = new SearchVO();
		HeartVO inHeartVO = new HeartVO();
		FileMngVO inFileMngVO = new FileMngVO();
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String regId = sseVO.getMid();
		LOG.debug("regId: "+regId);
		String sno = null;
		
		//파람 받기
		LOG.debug("*** doSelectOne");
		String autho = StringUtil.nvl(req.getParameter("autho"));
		LOG.debug("autho="+autho);
		String searchDiv = StringUtil.nvl(req.getParameter("searchDiv"));
		LOG.debug("searchDiv="+searchDiv);
		String searchWord = StringUtil.nvl(req.getParameter("searchWord"));
		LOG.debug("searchWord="+searchWord);
		String pageSize   = StringUtil.nvl(req.getParameter("pageSize"),"10");
		String pageNum 	  = StringUtil.nvl(req.getParameter("pageNum"),"1");
		String fileId = StringUtil.nvl(req.getParameter("fileId"));
		LOG.debug("fileId="+fileId);
		
		if(autho.equals("1")) {
			sno = StringUtil.nvl(req.getParameter("sno"));
			LOG.debug("sno: "+sno);
		}else if(autho.equals("2")) {
			sno = sseVO.getSno();
			LOG.debug("sno: "+sno);
			searchWord = sseVO.getSno();
			LOG.debug("searchWord: "+searchWord);
		}else if(autho.equals("3")) {
			sno = StringUtil.nvl(req.getParameter("sno"));
			LOG.debug("sno: "+sno);
		}else if(autho.equals("4")) {
			sno = sseVO.getSno();
			LOG.debug("sno: "+sno);
			searchWord = sseVO.getSno();
			LOG.debug("searchWord: "+searchWord);
		}
		LOG.debug("sno: "+sno);
		
		//inVO 셋팅
		inStoreVO.setSno(sno);
		inPaymentVO.setSno(sno);
		inStoOptionVO.setSno(sno);
		inSearchVO.setSearchDiv(searchDiv);
		inSearchVO.setSearchWord(searchWord);
		inSearchVO.setPageSize(Integer.parseInt(pageSize));
		inSearchVO.setPageNum(Integer.parseInt(pageNum));
		inHeartVO.setSno(sno);
		inHeartVO.setRegId(regId);
		//inFileMngVO.setFileId(fileId);
		
		//업체 단건 조회 서비스 실행
		StoreVO outStoreVO = (StoreVO) stoService.doSelectOne(inStoreVO) ;
		LOG.debug("========================");
		LOG.debug("=outStoreVO:"+outStoreVO);
		LOG.debug("========================");
		
		//업체 평점 서비스 실행
		ReviewVO outReviewVO = (ReviewVO) reviewService.doSelectOneAvgStar(inPaymentVO);
		LOG.debug("========================");
		LOG.debug("=outReviewVO:"+outReviewVO);
		LOG.debug("========================");
		
		//해당업체 리뷰 리스트 서비스 실행
		List<ReviewVO> outListReviewVO = (List<ReviewVO>) reviewService.doRetrieve(inSearchVO);
		LOG.debug("========================");
		for(ReviewVO reviewVO:outListReviewVO) {
			LOG.debug(reviewVO);
		}
		LOG.debug("========================");
		int totalCnt = 0;
		//리뷰총글수
		if(null!=outListReviewVO && outListReviewVO.size()>0) {
			ReviewVO totalVO = outListReviewVO.get(0);
			totalCnt = totalVO.getTotal();
		}
		
		//해당업체 옵션 리스트 서비스 실행
		List<StoOptionVO> outListStoOptionVO = (List<StoOptionVO>) stoOptionService.doRetrievePossibleStoOpt(inStoOptionVO);
		LOG.debug("========================");
		LOG.debug("=outListStoOptionVO:"+outListStoOptionVO);
		LOG.debug("========================");
		
		//해당업체 좋아요 했으면1 아니면0
		int heartCheck = heartService.doSelectOneCheck(inHeartVO);
		LOG.debug("========================");
		LOG.debug("=heartCheck:"+heartCheck);
		LOG.debug("========================");
		
		inFileMngVO.setFileId(outStoreVO.getFileId());
		
		//첨부파일 리스트 서비스 실행
		List<FileMngVO> outListFileMng = (List<FileMngVO>) fileMngService.doRetrieve(inFileMngVO);
		
		//스토어 옵션 리스트 뽑기
		List<StoOptionVO> outListStoOption = (List<StoOptionVO>) this.stoOptionService.doRetrieve(inStoOptionVO);
		
		LOG.debug("---------------------");
		for(StoOptionVO vo :outListStoOption) {
			LOG.debug(vo);
		}
		LOG.debug("---------------------");
		
		req.setAttribute("storeVO", outStoreVO);
		req.setAttribute("reviewVO", outReviewVO);
		req.setAttribute("listReviewVO", outListReviewVO);
		req.setAttribute("listStoOptionVO", outListStoOptionVO);
		req.setAttribute("paramVO", inSearchVO);//파람
		req.setAttribute("totalCnt", totalCnt);//리뷰총글수
		req.setAttribute("heartCheck", Integer.toString(heartCheck));//좋아요
		req.setAttribute("outListFileMng", outListFileMng);//첨부파일
		req.setAttribute("outListStoOption", outListStoOption);//코드 스토어 옵션
		
		if(autho.equals("1")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/store_select_one.jsp");
			dispatcher.forward(req, res);
		}else if(autho.equals("2")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/bis_store_select_one.jsp");
			dispatcher.forward(req, res);
		}else if(autho.equals("3")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/admin_store_select_one.jsp");
			dispatcher.forward(req, res);
		}else if(autho.equals("4")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/bis_store_update.jsp");
			dispatcher.forward(req, res);
		}
	}

	@Override
	public void doInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		LOG.debug("3==================");
		LOG.debug("3=doInsert=");
		LOG.debug("3==================");
		
		//파람으로 던질 VO, List<VO> 객체 생성
		StoreVO inStoreVO = new StoreVO();
		List<FileMngVO> inListFileMngVO = new ArrayList<FileMngVO>();
		List<StoOptionVO> inListStoOptionVO = new ArrayList<StoOptionVO>();
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String regId = sseVO.getMid();
		LOG.debug("regId: "+regId);
		
		//스토어 파람 받기
		String local = req.getParameter("local");
		LOG.debug("local: "+local);
		String name = req.getParameter("name");
		LOG.debug("name: "+name);
		String addrNo = req.getParameter("addrNo");
		LOG.debug("addrNo: "+addrNo);
		String addr = req.getParameter("addr");
		LOG.debug("addr: "+addr);
		String tel = req.getParameter("tel");
		LOG.debug("tel: "+tel);
		String stoPart = req.getParameter("stoPart");
		LOG.debug("stoPart: "+stoPart);
		String cont = req.getParameter("cont");
		LOG.debug("cont: "+cont);
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
		
		//업체 옵션 배열 파람 받기
		String[] stoOption = req.getParameterValues("stoOption");
		for(int i=0;i<stoOption.length;i++) {
			LOG.debug(i+1+"번째 stoOption: "+stoOption[i]);
		}
		
		//inVO 셋팅
		inStoreVO.setSno(local);
		inStoreVO.setName(name);
		inStoreVO.setAddrNo(addrNo);
		inStoreVO.setAddr(addr);
		inStoreVO.setTel(tel);
		inStoreVO.setStoPart(stoPart);
		inStoreVO.setCont(cont);
		inStoreVO.setRegId(regId);
		inStoreVO.setOpt1(stoOption[0]);
		inStoreVO.setOpt2(stoOption[1]);
		inStoreVO.setOpt3(stoOption[2]);
		inStoreVO.setOpt4(stoOption[3]);
		inStoreVO.setOpt5(stoOption[4]);
		inStoreVO.setOpt6(stoOption[5]);
		inStoreVO.setOpt7(stoOption[6]);
		inStoreVO.setOpt8(stoOption[7]);
		inStoreVO.setOpt9(stoOption[8]);
		inStoreVO.setOpt10(stoOption[9]);
		inStoreVO.setOpt11(stoOption[10]);
		inStoreVO.setOpt12(stoOption[11]);
		inStoreVO.setOpt13(stoOption[12]);
		inStoreVO.setOpt14(stoOption[13]);
		inStoreVO.setOpt15(stoOption[14]);
		inStoreVO.setOpt16(stoOption[15]);
		inStoreVO.setOpt17(stoOption[16]);
		if(!fileId.equals("")) {
			inStoreVO.setFileId(fileId);
		}
		
		LOG.debug("------------------------------------");
		LOG.debug(inStoreVO);
		LOG.debug("------------------------------------");
		
		int flag = this.stoService.doInsert(inStoreVO);
		
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
		StoreVO inStoreVO = new StoreVO();
		List<FileMngVO> inListFileMngVO = new ArrayList<FileMngVO>();
		List<StoOptionVO> inListStoOptionVO = new ArrayList<StoOptionVO>();
		
		//세션에서 값 받기
		HttpSession httpSession = req.getSession();
		MemberVO sseVO = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String modId = sseVO.getMid();
		LOG.debug("modId: "+modId);
		
		//스토어 파람 받기
		String sno = req.getParameter("sno");
		LOG.debug("sno: "+sno);
		String name = req.getParameter("name");
		LOG.debug("name: "+name);
		String addrNo = req.getParameter("addrNo");
		LOG.debug("addrNo: "+addrNo);
		String addr = req.getParameter("addr");
		LOG.debug("addr: "+addr);
		String tel = req.getParameter("tel");
		LOG.debug("tel: "+tel);
		String stoPart = req.getParameter("stoPart");
		LOG.debug("stoPart: "+stoPart);
		String cont = req.getParameter("cont");
		LOG.debug("cont: "+cont);
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
		
		//업체 옵션 배열 파람 받기
		String[] stoOption = req.getParameterValues("stoOption");
		for(int i=0;i<stoOption.length;i++) {
			LOG.debug(i+1+"번째 stoOption: "+stoOption[i]);
		}
		
		//inVO 셋팅
		inStoreVO.setSno(sno);
		inStoreVO.setName(name);
		inStoreVO.setAddrNo(addrNo);
		inStoreVO.setAddr(addr);
		inStoreVO.setTel(tel);
		inStoreVO.setStoPart(stoPart);
		inStoreVO.setCont(cont);
		inStoreVO.setModId(modId);
		if(!fileId.equals("")) {
			inStoreVO.setFileId(fileId);
		}
		
		LOG.debug("------------------------------------");
		LOG.debug(inStoreVO);
		LOG.debug("------------------------------------");
		
		int flag = this.stoService.doUpdate(inStoreVO);
		
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
		
		//스토어 옵션 삭제용 VO 객체 생성
		StoOptionVO inStoOptionDeleteVO = new StoOptionVO();
		inStoOptionDeleteVO.setSno(sno);
		
		//스토어 옵션 전부 삭제
		this.stoOptionService.doDelete(inStoOptionDeleteVO);
		
		//스토어 옵션 VO 셋팅
		for(int i=0;i<stoOption.length;i++) {
			StoOptionVO inStoOptionVO = new StoOptionVO();
			
			inStoOptionVO.setSno(sno);
			inStoOptionVO.setOpt(Integer.toString(i+1));
			inStoOptionVO.setYn(stoOption[i]);
			
			inListStoOptionVO.add(inStoOptionVO);
		}
		
		LOG.debug("------------------------------------");
		for(StoOptionVO vo:inListStoOptionVO) {
			LOG.debug(vo);
		}
		LOG.debug("------------------------------------");
		
		flag = this.stoOptionService.doInsert(inListStoOptionVO);
		
		LOG.debug("5==================");
		LOG.debug("5=flag="+flag);
		LOG.debug("5==================");
		
		//응답처리
		res.setContentType("text/html;charset=utf-8");
		out = res.getWriter();
//		if(flag==1) {
//			out.println("<script>alert('등록 성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//		}else {
//			out.println("<script>alert('실패!');history.go(-1);</script>");
//		}
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
				inFileMngVO.setRegId(modId);
				
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
	public void doDel(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	public void doStoreRetrieve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//응답 인코딩
		res.setContentType("text/html;charset=utf-8");
	
		//VO 객체
		StoreVO inStoreVO = new StoreVO();
		PaymentVO inPaymentVO = new PaymentVO();
		StoOptionVO inStoOptionVO = new StoOptionVO();
		SearchVO inSearchVO = new SearchVO();
		
		//ajax 데이터 String 변수에 할당
		String autho  	= StringUtil.nvl(req.getParameter("autho"));
		String startDt  	= StringUtil.nvl(req.getParameter("checkInDate"));
		String endDt  		= StringUtil.nvl(req.getParameter("checkOutDate"));
		String sno 			= StringUtil.nvl(req.getParameter("sno"));
		String searchDiv 	= StringUtil.nvl(req.getParameter("searchDiv"));
		String searchWord 	= StringUtil.nvl(req.getParameter("searchWord"));
		String pageSize   	= StringUtil.nvl(req.getParameter("pageSize"),"10");
		String pageNum 	  	= StringUtil.nvl(req.getParameter("pageNum"),"1");
		String loc  		= StringUtil.nvl(req.getParameter("selectBox"));
		String options  	= StringUtil.nvl(req.getParameter("options"));
		
		startDt = startDt.replaceAll("-", "");
		endDt = endDt.replaceAll("-", "");
		
		System.out.println("checkInDate : " + startDt);
		System.out.println("checkOutDate : " + endDt);
		System.out.println("selectBox : " + loc);
		System.out.println("options : " + options);
		
		inStoreVO.setSno(sno);
		inPaymentVO.setSno(sno);
		
		inSearchVO.setSearchWord03(loc);
		inSearchVO.setSearchWord04(startDt);
		inSearchVO.setSearchWord05(endDt);
		inStoOptionVO.setOpt(options);
		
		inSearchVO.setSearchDiv(searchDiv);
		inSearchVO.setSearchWord(searchWord);
		inSearchVO.setPageSize(Integer.parseInt(pageSize));
		inSearchVO.setPageNum(Integer.parseInt(pageNum));
		
		ReviewVO outReviewVO = (ReviewVO) reviewService.doSelectOneAvgStar(inPaymentVO);
		List<ReviewVO> outListReviewVO = (List<ReviewVO>) reviewService.doRetrieve(inSearchVO);
		List<StoOptionVO> outListStoOptionVO = (List<StoOptionVO>) stoOptionService.doRetrievePossibleStoOpt(inStoOptionVO);
		List<StoreVO> storeList = (List<StoreVO>)stoService.doStoreRetrieve(inSearchVO, inStoOptionVO);
		
		for(int i=0; i<storeList.size(); i++) {
			System.out.println("sno : " + storeList.get(i).getSno());
		}
		
		LOG.debug("------------------------");
		for(ReviewVO reviewVO:outListReviewVO) {
			LOG.debug(reviewVO);
		}
		LOG.debug("------------------------");
		
		LOG.debug("------------------------");
		for(StoOptionVO stoOptionVO:outListStoOptionVO) {
			LOG.debug(stoOptionVO);
		}
		LOG.debug("------------------------");
		
		int totalCnt = 0;
		//리뷰총글수
		if(null!=outListReviewVO && outListReviewVO.size()>0) {
			ReviewVO totalVO = outListReviewVO.get(0);
			totalCnt = totalVO.getTotal();
		}
		
		req.setAttribute("storeList", storeList);
		req.setAttribute("reviewVO", outReviewVO);
		
		LOG.debug("---------------------");
		LOG.debug("---------------------");
		for(StoreVO vo :storeList) {
			LOG.debug(vo);
		}
		
		if(autho.equals("1")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/store_list.jsp");
			dispatcher.forward(req, res);
		}else if(autho.equals("3")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/admin_store_list.jsp");
			dispatcher.forward(req, res);
		}
	}
		

	

}

