package com.mal_a.board;

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
import com.mal_a.cmn.ContHandler;
import com.mal_a.cmn.MessageVO;
import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.StringUtil;
import com.mal_a.code.CodeService;
import com.mal_a.code.CodeVO;
import com.mal_a.comments.CommentsService;
import com.mal_a.comments.CommentsVO;
import com.mal_a.member.MemberVO;

/**
 * Servlet implementation class BoardCont
 * /DaoWEB/board/board.do -> /board/board.do
 */
@WebServlet(description = "게시판", urlPatterns = { "/roxandrea/board.do" })
public class BoardCont extends HttpServlet implements ContHandler {   
   private static final long serialVersionUID = 1L;//클래스 UID값을 고정시켜주는역할
   /** BoardService객체 */
    private BoardService  service;
    private CommentsService  commentsService;
    /**CodeService 객체*/
    CodeService cdService;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCont() {
        super();
        service = new BoardService();
        cdService = new CodeService();
        commentsService = new CommentsService();
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      //response.getWriter().append("Served at: ").append(request.getContextPath());
      LOG.debug("doGet------");
      serviceHandler(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      LOG.debug("1. doPost------");
      serviceHandler(request, response);
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
      LOG.debug("2=workDiv="+workDiv);
      LOG.debug("2====================");   
      switch(workDiv) {//거래분기
      
         case "doUpdate"://수정
            this.doUpdate(req, res);
            break;
      
          case "doDelete":
             this.doDel(req, res);
             break;
          case "doAdminDelete":
              this.doAdminDel(req, res);
              break;   
             
         case "doSelectOne"://단건조회,단건조회 화면으로 이동
            this.doSelectOne(req, res);
            break;
            
         case "doSelectOne1"://단건조회,단건조회 화면으로 이동
             this.doSelectOne1(req, res);
             break;
             
         case "doSelectOne2"://단건조회,단건조회 화면으로 이동
             this.doSelectOne2(req, res);
             break;
             
         case "doAdminSelectOne"://단건조회,단건조회 화면으로 이동
             this.doAdminSelectOne(req, res);
             break;  
             
         case "moveToSave"://등록화면으로 이동
        	 LOG.debug("moveToSave");
            doMoveToSave(req,res);
            break;
            
         case "moveToAdminSave"://등록화면으로 이동
        	 doMoveToAdminSave(req,res);   
            break;  
            
         case "doInsert"://단건 등록
            this.doInsert(req, res);
            break;
            
         case "doRetrieve"://목록조회
            this.doRetrieve(req, res);
            break;
            
         case "doAdminRetrieve"://목록조회
             this.doAdminRetrieve(req, res);
             break;
             
         case "doViewsUpdate"://목록조회
             this.doViewsUpdate(req, res);
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
    *@Method Name:doMoveToSave
    *@작성일: 2020. 2. 26.
    *@작성자: sist133
    *@설명:등록화면으로이동
    *@param req
    *@param res
    *@throws ServletException
    *@throws IOException
    */
   public void doMoveToSave(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   
	   
	   HttpSession httpSession = req.getSession();
	   MemberVO memvo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
	   String SesId1 = memvo.getMid(); //selectOne 값에서  Mid를 추출
	   LOG.debug("************SesID*********"+SesId1);
	   req.setAttribute("SesId1", SesId1);
	   
       RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/board_insert.jsp");
       dispatcher.forward(req, res);
   }
   
   
   public void doMoveToAdminSave(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   
	   
	   HttpSession httpSession = req.getSession();
	   MemberVO memvo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
	   String SesId1 = memvo.getMid(); //selectOne 값에서  Mid를 추출
	   LOG.debug("************SesID*********"+SesId1);
	   req.setAttribute("SesId1", SesId1);
	   
       RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/admin_board_insert.jsp");
       dispatcher.forward(req, res);
   }
   
   //사용자 다건조회
   @Override
   public void doRetrieve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      //1.param
      //2.param set VO
      //3.service호출
      //4.특정화면+data
      SearchVO inVO=new SearchVO();//검색구분,검색어
      
      String searchDiv  = StringUtil.nvl(req.getParameter("searchDiv"));//StringUtil->파라미터 값으로 null을 주더라도 절대 NullPointException을 발생시키지 않음.
      //String searchDiv  = req.getParameter("search_div");
      String searchWord = StringUtil.nvl(req.getParameter("searchWord"));
      String pageSize   = StringUtil.nvl(req.getParameter("pageSize"),"10");//10은 nvl처리로인한 디폴트값
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
      
      //----------------------------------------------
      //Code조회
      // BOARD_SEARCH_DIV(검색조건)
      //COM_PAGE_SIZE(페이지 사이즈)
      //----------------------------------------------
       CodeVO searchDIV = new CodeVO();
         searchDIV.setMstId("boardSearchDiv");
       List<CodeVO> searchList = (List<CodeVO>) this.cdService.doRetrieve(searchDIV);
         
       searchDIV.setMstId("comPageSize");
        List<CodeVO> pageSizeList = (List<CodeVO>) this.cdService.doRetrieve(searchDIV);
      
      List<BoardVO> list = (List<BoardVO>) this.service.doRetrieve(inVO);
      
      LOG.debug("---------------------");
      for(BoardVO vo :list) {
         LOG.debug(vo);
      }
      
      LOG.debug("---------------------");
      //http://localhost:8080/DaoWEB/board/board.do?search_div=10&search_word=&page_size=10&page_num=1&work_div=do_retrieve
      //총글수
      int totalCnt =0;
      if(null !=list && list.size()>0) {
         BoardVO totalVO=list.get(0);//0번째열의갯수.그래서뭐넣든노상관 
         totalCnt = totalVO.getTotal();
      }
      //code
      req.setAttribute("searchList",searchList);//search Code
      req.setAttribute("pageSizeList",pageSizeList);//pageSizeList
      
      
      req.setAttribute("list", list);//목록
      req.setAttribute("paramVO", inVO);//param
      req.setAttribute("totalCnt", totalCnt);//총글수
      
      
      RequestDispatcher  dispatcher= req.getRequestDispatcher("/roxandrea/board_list.jsp");//총글수
      dispatcher.forward(req, res);
      
   }
   
   //관리자 다건조회
   public void doAdminRetrieve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	      //1.param
	      //2.param set VO
	      //3.service호출
	      //4.특정화면+data
	      SearchVO inVO=new SearchVO();//검색구분,검색어
	      
	      String searchDiv  = StringUtil.nvl(req.getParameter("searchDiv"));//StringUtil->파라미터 값으로 null을 주더라도 절대 NullPointException을 발생시키지 않음.
	      //String searchDiv  = req.getParameter("search_div");
	      String searchWord = StringUtil.nvl(req.getParameter("searchWord"));
	      String pageSize   = StringUtil.nvl(req.getParameter("pageSize"),"10");//10은 nvl처리로인한 디폴트값
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
	      
	      //----------------------------------------------
	      //Code조회
	      // BOARD_SEARCH_DIV(검색조건)
	      //COM_PAGE_SIZE(페이지 사이즈)
	      //----------------------------------------------
	       CodeVO searchDIV = new CodeVO();
	       searchDIV.setMstId("adminBoardSearchDiv");
	       List<CodeVO> searchList = (List<CodeVO>) this.cdService.doAdminRetrieve(searchDIV);
	         
	       searchDIV.setMstId("comPageSize");
	        List<CodeVO> pageSizeList = (List<CodeVO>) this.cdService.doAdminRetrieve(searchDIV);
	      
	      List<BoardVO> list = (List<BoardVO>) this.service.doAdminRetrieve(inVO);
	      
	      LOG.debug("---------------------");
	      for(BoardVO vo :list) {
	         LOG.debug(vo);
	      }
	      
	      LOG.debug("---------------------");
	      //http://localhost:8080/DaoWEB/board/board.do?search_div=10&search_word=&page_size=10&page_num=1&work_div=do_retrieve
	      //총글수
	      int totalCnt =0;
	      if(null !=list && list.size()>0) {
	         BoardVO totalVO=list.get(0);//0번째열의갯수.그래서뭐넣든노상관 
	         totalCnt = totalVO.getTotal();
	      }
	      //code
	      req.setAttribute("searchList",searchList);//search Code
	      req.setAttribute("pageSizeList",pageSizeList);//pageSizeList
	      
	      
	      req.setAttribute("list", list);//목록
	      req.setAttribute("paramVO", inVO);//param
	      req.setAttribute("totalCnt", totalCnt);//총글수
	      
	      
	      RequestDispatcher  dispatcher= req.getRequestDispatcher("/roxandrea/admin_board_list.jsp");//총글수
	      dispatcher.forward(req, res);
	      
	   }
   
   
   
   
   
   //사용자 단건조회
   @Override
   public void doSelectOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      //1.param
      //2.param to set vo
      //3.service call
      //4.request set
      //5.forward
      BoardVO inVO = new BoardVO();
      SearchVO inVO1 = new SearchVO();
      MemberVO inVO2 = new MemberVO();
      LOG.debug("doSelectOne");
      String seq = StringUtil.nvl(req.getParameter("seq"));
      String regId = StringUtil.nvl(req.getParameter("regId"));
      
      String check1 = StringUtil.nvl(req.getParameter("check"));
      String check = check1;
      
      HttpSession httpSession = req.getSession();
	  MemberVO memvo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
	  String SesId = memvo.getMid(); //selectOne 값에서  Mid를 추출
      
      
      inVO.setBno(seq);
      inVO.setRegId(regId);
      inVO1.setPageNum(1);
      inVO1.setPageSize(100);
      inVO1.setSearchDiv("1");
      inVO1.setSearchWord(seq);
      inVO2.setMid(SesId);
      
      
      BoardVO outVO = (BoardVO)service.doSelectOne(inVO);
      List<CommentsVO> commentsList = (List<CommentsVO>)commentsService.doRetrieveList(inVO1);
      
      String ri = outVO.getRegId();
      
      LOG.debug("---------------------");
      for(CommentsVO vo :commentsList) {
         LOG.debug(vo);
      }
      LOG.debug("---------------------");
      
      req.setAttribute("vo", outVO);
      req.setAttribute("commentList", commentsList);
      req.setAttribute("commentList", commentsList);
      req.setAttribute("SesId", SesId);
      
      
      LOG.debug("SesId******="+SesId);
      LOG.debug("regId******="+regId);
      LOG.debug("check******="+check);
      if(SesId.equals(regId)) {
    	  check ="1";
      }else {
    	  check="0";
      }
      req.setAttribute("check", check);
      req.setAttribute("regId", regId);
      RequestDispatcher dispatcher=req.getRequestDispatcher("/roxandrea/board_select_one.jsp");
      dispatcher.forward(req,res);
      
   }
   
   //사용자가 게시글수정화면으로갈때 값전달을위한메서드
   public void doSelectOne1(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	      //1.param
	      //2.param to set vo
	      //3.service call
	      //4.request set
	      //5.forward
	      BoardVO inVO = new BoardVO();
	      SearchVO inVO1 = new SearchVO();
	      MemberVO inVO2 = new MemberVO();
	      LOG.debug("doSelectOne1");
	      String seq = StringUtil.nvl(req.getParameter("seq1"));
	      String regId = StringUtil.nvl(req.getParameter("regId"));
	      String check = "0";
	      
	      HttpSession httpSession = req.getSession();
		  MemberVO memvo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		  String SesId = memvo.getMid(); //selectOne 값에서  Mid를 추출
	      
	      LOG.debug("seq="+seq);
	      LOG.debug("SesId*******************="+SesId);
	      inVO.setBno(seq);
	      inVO.setRegId(regId);
	      inVO1.setPageNum(1);
	      inVO1.setPageSize(100);
	      inVO1.setSearchDiv("1");
	      inVO1.setSearchWord(seq);
	      inVO2.setMid(SesId);
	      
	      BoardVO outVO = (BoardVO)service.doSelectOne(inVO);
	      List<CommentsVO> commentsList = (List<CommentsVO>)commentsService.doRetrieveList(inVO1);
	      
	      LOG.debug("---------------------");
	      for(CommentsVO vo :commentsList) {
	         LOG.debug(vo);
	      }
	      LOG.debug("---------------------");
	      
	      req.setAttribute("vo", outVO);
	      req.setAttribute("commentList", commentsList);
	      req.setAttribute("loginId", inVO2);
	      if(SesId.equals(regId)) {
	    	  check ="1";
	      }else {
	    	  check="0";
	      }
		  
	      req.setAttribute("check", check);
	      
	      RequestDispatcher dispatcher=req.getRequestDispatcher("/roxandrea/board_update.jsp");
	      dispatcher.forward(req,res);
	      
	   }
   
 //관리자가 게시글수정화면으로갈때 값전달을위한메서드
   public void doSelectOne2(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	      //1.param
	      //2.param to set vo
	      //3.service call
	      //4.request set
	      //5.forward
	      BoardVO inVO = new BoardVO();
	      SearchVO inVO1 = new SearchVO();
	      MemberVO inVO2 = new MemberVO();
	      LOG.debug("doSelectOne2");
	      String seq = StringUtil.nvl(req.getParameter("seq1"));
	      String regId = StringUtil.nvl(req.getParameter("regId"));
	      String check = "0";
	      
	      HttpSession httpSession = req.getSession();
		  MemberVO memvo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		  String SesId = memvo.getMid(); //selectOne 값에서  Mid를 추출
	      
	      LOG.debug("seq="+seq);
	      LOG.debug("SesId*******************="+SesId);
	      inVO.setBno(seq);
	      inVO.setRegId(regId);
	      inVO1.setPageNum(1);
	      inVO1.setPageSize(100);
	      inVO1.setSearchDiv("2");
	      inVO1.setSearchWord(seq);
	      //inVO2.setMid(SesId);
	      LOG.debug("inVO1: "+inVO1);
	      
	      BoardVO outVO = (BoardVO)service.doAdminSelectOne(inVO);
	      List<CommentsVO> commentsList = (List<CommentsVO>)commentsService.doAdminRetrieveList(inVO1);
	      
	      LOG.debug("---------------------");
	      for(CommentsVO vo :commentsList) {
	         LOG.debug(vo);
	      }
	      LOG.debug("---------------------");
	      
	      req.setAttribute("vo", outVO);
	      req.setAttribute("commentList", commentsList);
	      //req.setAttribute("loginId", inVO2);
	      if(SesId.equals(regId)) {
	    	  check ="1";
	      }else {
	    	  check="0";
	      }
		  
	      req.setAttribute("check", check);
	      
	      RequestDispatcher dispatcher=req.getRequestDispatcher("/roxandrea/admin_board_update.jsp");
	      dispatcher.forward(req,res);
	      
	   }
   
   
   //관리자 단건조회
   public void doAdminSelectOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	      //1.param
	      //2.param to set vo
	      //3.service call
	      //4.request set
	      //5.forward
	      BoardVO inVO = new BoardVO();
	      CommentsVO CommentsinVO = new CommentsVO();
	      SearchVO inVO1 = new SearchVO();
	      MemberVO inVO2 = new MemberVO();
	      
	      LOG.debug("doAdminSelectOne!!");
	      String seq = StringUtil.nvl(req.getParameter("seq"));
	      String regId = StringUtil.nvl(req.getParameter("regId"));
	      String check = "0";
	      String viewsCheck ="0";
	      String commentsViewsCheck ="0";
	      
	      HttpSession httpSession = req.getSession();
		  MemberVO memvo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		  String SesId = memvo.getMid(); //selectOne 값에서  Mid를 추출
	      
	      
	      LOG.debug("seq="+seq);
	      LOG.debug("SesId*******************="+SesId);
	      inVO.setBno(seq);
	      inVO.setRegId(regId);
	      inVO1.setPageNum(1);
	      inVO1.setPageSize(100);
	      inVO1.setSearchDiv("1");
	      inVO1.setSearchWord(seq);
	      inVO2.setMid(SesId);
	      
	      
	      BoardVO outVO = (BoardVO)service.doAdminSelectOne(inVO);
	      //CommentsVO commentsOutVO = (CommentsVO)commentsService.doAdminSelectOne1(CommentsinVO);
	      List<CommentsVO> commentsList = (List<CommentsVO>)commentsService.doAdminRetrieveList(inVO1);
	      
	      LOG.debug("outVO###!!"+outVO);
	      String ri = outVO.getRegId();
	      String views = outVO.getViews();
	      //String commentsViews = commentsOutVO.getViews();
	     // LOG.debug("commentsViews###"+commentsViews);
	      
	      LOG.debug("---------------------");
	      for(CommentsVO vo :commentsList) {
	         LOG.debug(vo);
	      }
	      LOG.debug("---------------------");
	      

	      
	      if(SesId.equals(regId)) {
	    	  check ="1";
	      }else {
	    	  check="0";
	      }
	      
	      
	      if(views.equals("정지")) {
	    	  viewsCheck ="2";
	      }else {
	    	  viewsCheck="1";
	      }
	      
	      
		/*
		 * if(commentsViews.equals("정지")) { commentsViewsCheck ="2"; }else {
		 * commentsViewsCheck="1"; }
		 */
	      
	      req.setAttribute("vo", outVO);
	      req.setAttribute("commentList", commentsList);
	      req.setAttribute("ri", ri);
	      req.setAttribute("SesId", SesId);
	      req.setAttribute("views", views);
	      req.setAttribute("check", check);
	      req.setAttribute("viewsCheck", viewsCheck);
	      req.setAttribute("commentsViewsCheck", commentsViewsCheck);
	      RequestDispatcher dispatcher=req.getRequestDispatcher("/roxandrea/admin_board_select_one.jsp");
	      dispatcher.forward(req,res);
	      
	   }
   
   
   
   //사용자 게시글등록
   @Override
   public void doInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        LOG.debug("3====================");
        LOG.debug("3=doInsert=");
        LOG.debug("3====================");
        
        BoardVO  inVO=new BoardVO();//param
        //1.param read
        //2.param BoardVO
        //3.service 메소드 호출
        //제목
        String title = StringUtil.nvl(req.getParameter("title"),"");
        //작성자/수정자
        String regId = StringUtil.nvl(req.getParameter("regId"),"");
        //내용
        String contents = StringUtil.nvl(req.getParameter("contents"),"");
        
      //login처리후 session으로 변환 할것
        inVO.setTitle(title);
        inVO.setRegId(regId);
        inVO.setModId(regId);
        inVO.setCont(contents);
        
        int flag = this.service.doInsert(inVO);
        LOG.debug("3====================");
        LOG.debug("3=flag="+flag);
        LOG.debug("3====================");
        
        //응답처리
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out=res.getWriter();//자바에서 웹으로 데이터출력하기위해서 printwriter씀.
//        if(flag==1) {
//           out.println("<script>alert('등록성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//        }else {
//           out.println("<script>alert('실패!');history.go(-1);</script>");
//        }

        String msg = "";
        Gson  gson = new Gson(); 
        if(1==flag) {
           msg = inVO.getTitle()+"이\n등록 되었습니다.";
        }else {
           msg = inVO.getTitle()+"이\n등록 실패.";
        }
        
        String gsonStr =  gson.toJson(new MessageVO(String.valueOf(flag), msg));//valueof는 객체생성과비슷하지만 조금의차이가있음.
        LOG.debug("====================");
        LOG.debug("=gsonStr="+gsonStr);
        LOG.debug("====================");
        
        out.println(gsonStr);
        
   }

   
   
   //정지,비정지 수정
   public void doViewsUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       LOG.debug("3====================");
       LOG.debug("3=doViewsUpdate=");
       LOG.debug("3====================");
       
       BoardVO inVO=new BoardVO();//param
       //1.param read
       //2.param BoardVO
       //3.service 메소드 호출
       
       //게시판글번호
       String seq = StringUtil.nvl(req.getParameter("seq"),"");
       //수정자아이디
       String modId = StringUtil.nvl(req.getParameter("modId"),"");
       //정지여부
       String views = StringUtil.nvl(req.getParameter("views"),"");
       
       //login처리후 session으로 변환 할것
       inVO.setBno(seq);
       inVO.setModId(modId);
       inVO.setViews(views);
       
       int flag = this.service.doViewsUpdate(inVO);
       LOG.debug("3====================");
       LOG.debug("3=flag="+flag);
       LOG.debug("3====================");
       
       //응답처리
       res.setContentType("text/html;charset=utf-8");
       PrintWriter out=res.getWriter();
//       if(flag==1) {
//          out.println("<script>alert('등록성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//       }else {
//          out.println("<script>alert('실패!');history.go(-1);</script>");
//       }

       String msg = "";
       Gson  gson = new Gson(); 
       if(1==flag) {
          msg = inVO.getBno()+"번 게시글이\n수정 되었습니다.";
       }else {
          msg = inVO.getBno()+"이\n수정 실패.";
       }
       
       String gsonStr =  gson.toJson(new MessageVO(String.valueOf(flag), msg));//int를String으로형변환한 flag인 메세지객체를 Json으로 변환. 
       LOG.debug("====================");
       LOG.debug("=gsonStr="+gsonStr);
       LOG.debug("====================");
       out.println(gsonStr);
     
  }
   
   
   
   
   
   //사용자 게시글 수정
   @Override
	public void doUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        LOG.debug("3====================");
        LOG.debug("3=doUpdate=");
        LOG.debug("3====================");
        
        BoardVO inVO=new BoardVO();//param
        //1.param read
        //2.param BoardVO
        //3.service 메소드 호출
        
          //SEQ
        String seq = StringUtil.nvl(req.getParameter("seq"),"");
        //제목
        String title = StringUtil.nvl(req.getParameter("title"),"");
        //작성자/수정자
        String regId = StringUtil.nvl(req.getParameter("regId"),"");
        //내용
        String contents = StringUtil.nvl(req.getParameter("contents"),"");
        
        
	    HttpSession httpSession = req.getSession();
        MemberVO memvo = (MemberVO) httpSession.getAttribute("user"); // 세션값 loginID 의 doselectOne
		String SesId = memvo.getMid(); //selectOne 값에서  Mid를 추출
	      
		req.setAttribute("SesId", SesId);
        
        //login처리후 session으로 변환 할것
        inVO.setBno(seq);
        inVO.setTitle(title);
        inVO.setRegId(regId);
        inVO.setModId(regId);
        inVO.setCont(contents);
        
        int flag = this.service.doUpdate(inVO);
        LOG.debug("3====================");
        LOG.debug("3=flag="+flag);
        LOG.debug("3====================");
        
        //응답처리
        res.setContentType("text/html;charset=utf-8");
        PrintWriter out=res.getWriter();
//        if(flag==1) {
//           out.println("<script>alert('등록성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//        }else {
//           out.println("<script>alert('실패!');history.go(-1);</script>");
//        }

        String msg = "";
        Gson  gson = new Gson(); 
        if(1==flag) {
           msg = inVO.getTitle()+"이\n수정 되었습니다.";
        }else {
           msg = inVO.getTitle()+"이\n수정 실패.";
        }
        
        String gsonStr =  gson.toJson(new MessageVO(String.valueOf(flag), msg));//int를String으로형변환한 flag인 메세지객체를 Json으로 변환. 
        LOG.debug("====================");
        LOG.debug("=gsonStr="+gsonStr);
        LOG.debug("====================");
     
			
			LOG.debug("5==================");
			LOG.debug("5=flag="+flag);
			LOG.debug("5==================");
			
			//응답처리
			res.setContentType("text/html;charset=utf-8");
			out = res.getWriter();
//  				if(flag==1) {
//  					out.println("<script>alert('등록 성공!');location.href='/DaoWEB/board/board_list.jsp'</script>");
//  				}else {
//  					out.println("<script>alert('실패!');history.go(-1);</script>");
//  				}
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
			
        
        out.println(gsonStr);
      
	}

   
   //사용자 게시글 삭제
   @Override
   public void doDel(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      LOG.debug("===================");
      LOG.debug("=doDel=");
      LOG.debug("===================");
      
      //1.vo 변수 선언
      //2.param read
      //3.vo에 param set
      //4.service호출
      //5.Gson message
      //6.forward
      
      BoardVO inVO =new BoardVO();
      String seq = StringUtil.nvl(req.getParameter("seq"));
      inVO.setBno(seq);
      
      int flag = this.service.doDelete(inVO);
      
      Gson gson =new Gson();
      String msg ="";
      String gsonString ="";
      MessageVO msgVO=new MessageVO();
      
      if(flag>0) {
         msg = "삭제되었습니다.";
      }else {
         msg = "삭제실패.";
      }
      msgVO.setMsgId(String.valueOf(flag));
      msgVO.setMsgContents(msg);
      
      gsonString = gson.toJson(msgVO);
      LOG.debug("gsonString="+gsonString);
      
      res.setContentType("text/html;charset=utf-8");
      PrintWriter out = res.getWriter();
      out.print(gsonString);
      
   }
   
   
   public void doAdminDel(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	      LOG.debug("===================");
	      LOG.debug("=doDel=");
	      LOG.debug("===================");
	      
	      //1.vo 변수 선언
	      //2.param read
	      //3.vo에 param set
	      //4.service호출
	      //5.Gson message
	      //6.forward
	      
	      BoardVO inVO =new BoardVO();
	      String seq = StringUtil.nvl(req.getParameter("seq"));
	      inVO.setBno(seq);
	      
	      int flag = this.service.doAdminDelete(inVO);
	      
	      Gson gson =new Gson();
	      String msg ="";
	      String gsonString ="";
	      MessageVO msgVO=new MessageVO();
	      
	      if(flag>0) {
	         msg = "삭제되었습니다.";
	      }else {
	         msg = "삭제실패.";
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







