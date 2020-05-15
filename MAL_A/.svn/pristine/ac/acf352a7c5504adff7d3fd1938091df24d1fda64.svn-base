/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.stooption
 * 클래스명 : StoOptionCont.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-24    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-24 오후 6:48:19
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.stooption;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.ContHandler;
import com.mal_a.cmn.StringUtil;
import com.mal_a.code.CodeService;
import com.mal_a.code.CodeVO;
import com.mal_a.roomoption.RoomOptionVO;

/**
 * Servlet implementation class BoardCont
 * /DaoWEB/board/board.do -> /board/board.do
 */
@WebServlet(description = "옵션", urlPatterns = { "/roxandrea/sto_option_list.do" })
public class StoOptionCont extends HttpServlet implements ContHandler {
	private static final long serialVersionUID = 1L;
	/** BoardService객체 */
    private CodeService  service;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoOptionCont() {
        super();
        service = new CodeService();
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
		String workDiv = StringUtil.nvl(req.getParameter("work_div"));//null -> ""
			
			LOG.debug("2====================");
			LOG.debug("2=do_insert.workDiv="+workDiv);
			LOG.debug("2====================");	
			
			
			switch(workDiv) {//거래분기
			
			case "move_to_save"://store_list화면으로 이동
				doMoveToSave(req, res);
			break;
			case "move_to_save2"://Start화면으로 이동
				doMoveToSave(req, res);
			break;
			
			case "do_retrieve"://목록조회
				this.doRetrieve(req, res);
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
	 *설명 : store_list화면으로 이동
	 *@param req
	 *@param res
	 *@throws ServletException
	 *@throws IOException void
	 */
	public void doMoveToSave(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String startDt  = StringUtil.nvl(req.getParameter("checkIn"));
		String endDt  = StringUtil.nvl(req.getParameter("checkOut"));
		String loc  = StringUtil.nvl(req.getParameter("selectBox"));
		String options  = StringUtil.nvl(req.getParameter("options"));
		
		System.out.println(startDt);
		System.out.println(endDt);
		System.out.println(loc);
		System.out.println(options);
		
		
		req.setAttribute("checkIn", startDt);
		req.setAttribute("checkOut", endDt);
		req.setAttribute("selectBox", loc);
		req.setAttribute("options", options);
		
		
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/roxandrea/store_list.jsp");
		dispatcher.forward(req, res);
		
	}
	/**
	 * 
	 *메서드명 : doMoveToSave2
	 *작성일 : 2020. 3. 10.
	 *작성자 : sist
	 *설명 : start화면으로 이동
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doMoveToSave2(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = 
				req.getRequestDispatcher("/roxandrea/store_search.jsp");
		dispatcher.forward(req, res);
		
	}
	
	
	@Override
	public void doRetrieve(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				
		
		//1.param
				//2.param set VO
				//3.service호출
				//4.특정화면+data
				SearchVO inVO=new SearchVO();
				CodeVO codeVO = new CodeVO();
				
				String searchDiv  = StringUtil.nvl(req.getParameter("search_div"));
				String searchWord = StringUtil.nvl(req.getParameter("search_word"));
				String pageSize   = StringUtil.nvl(req.getParameter("page_size"),"10");
				String pageNum    = StringUtil.nvl(req.getParameter("page_num"),"1");
				
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

				codeVO.setMstId("STOOPT");
				List<CodeVO> list = (List<CodeVO>) this.service.doRetrieve(codeVO);
				
				LOG.debug("---------------------");
				for(CodeVO vo :list) {
					LOG.debug(vo);
				}
				
				LOG.debug("---------------------");
				
//				if(null !=list && list.size()>0) {
//					CodeVO totalVO=list.get(0);
//				}
				req.setAttribute("list", list);//목록
				req.setAttribute("paramVO", inVO);//param
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("/roxandrea/sto_option_list.jsp");
				dispatcher.forward(req, res);
	}

	@Override
	public void doSelectOne(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doDel(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	

}
