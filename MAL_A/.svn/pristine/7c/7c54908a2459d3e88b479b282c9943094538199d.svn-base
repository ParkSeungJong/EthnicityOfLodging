/**
 *<pre>
 * com.hr.board
 * Class Name : BoardTestMain.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-02-03           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-02-03 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */

package com.mal_a.comments;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mal_a.board.BoardVO;
import com.mal_a.cmn.DTO;
import com.mal_a.cmn.SearchVO;

/**
 * @author sist133
 *
 */
public class CommentsTestMain {
	
	private final Logger LOG =Logger.getLogger(CommentsTestMain.class);
	
	//Test Data
	private CommentsVO boardVO01;
	private CommentsDao dao;
	
	
	public CommentsTestMain() {
		boardVO01=new CommentsVO();
		dao=new CommentsDao();
	}
	
	//등록
	public void doinsert(String scCont,String scRegid) {
		boardVO01.setCont(scCont);
		boardVO01.setRegId(scRegid);
		int mainFlag = dao.doInsert(boardVO01);
		if(mainFlag==1) {
			LOG.debug("======================");
			LOG.debug("성공");
			LOG.debug("======================");
		}else {
			LOG.debug("======================");
			LOG.debug("실패");
			LOG.debug("======================");
		}
	}
	
	public void doUpdate(String scCno,String scCont) {
		boardVO01.setCont(scCont);
		boardVO01.setCno(scCno);
		
		int updateFlag=dao.doUpdate(boardVO01);
		if(updateFlag==1) {
			LOG.debug("======================");
			LOG.debug("성공");
			LOG.debug("======================");
		}else {
			LOG.debug("======================");
			LOG.debug("실패");
			LOG.debug("======================");
		}
		
	}
	
	
	public void doViewsUpdate(String scCno,String scViews) {
		boardVO01.setCno(scCno);
		boardVO01.setViews(scViews);
		
		int updateFlag=dao.doViewsUpdate(boardVO01);
		if(updateFlag==1) {
			LOG.debug("======================");
			LOG.debug("성공");
			LOG.debug("======================");
		}else {
			LOG.debug("======================");
			LOG.debug("실패");
			LOG.debug("======================");
		}
		
	}
	
	
	
	public void doDelete(String scCno) {
		boardVO01.setCno(scCno);
		int delFlag = dao.doDelete(boardVO01);
		LOG.debug("delFlag="+delFlag);
		if(delFlag==1) {
			LOG.debug("======================");
			LOG.debug("성공");
			LOG.debug("======================");
		}else {
			LOG.debug("======================");
			LOG.debug("실패");
			LOG.debug("======================");
		}
		
	}

	
	public void doRetrieve(int scPageSize,int scPageNum,String scSearchDiv,String scSearchWord) {
		SearchVO searchVO=new SearchVO();
		searchVO.setPageSize(scPageSize);
		searchVO.setPageNum(scPageNum);
		searchVO.setSearchDiv(scSearchDiv);
		searchVO.setSearchWord(scSearchWord);
		
		List<CommentsVO>list=(List<CommentsVO>) dao.doRetrieve(searchVO);
		
		LOG.debug("************************************************");
		LOG.debug("성공");
		//Data출력
		for(CommentsVO vo:list) {
			LOG.debug(vo);
		}
		LOG.debug("************************************************");
	}
	
	
	
	public static void main(String[] args) {
		CommentsTestMain boardTest=new CommentsTestMain();
		
		Scanner sc = new Scanner(System.in);
		
//		 System.out.println("cno : ");
//	      String scCno = sc.next();
	      
	      System.out.println("cont : ");
	      String scCont = sc.next();
//	      
//	      System.out.println("views : ");
//	      String scViews = sc.next();
//	      
	      System.out.println("regid : ");
	      String scRegid = sc.next();
	      
//	      System.out.println("regDt : ");
//	      String scRegDt = sc.next();
//	      
//	      System.out.println("modId : ");
//	      String scModId = sc.next();
//	      
//	      System.out.println("modDt : ");
//	      String scModDt = sc.next();
//	      
//	      System.out.println("bno : ");
//	      int scBno = sc.next();
	      
//	      System.out.println("page size : ");
//	      int scPageSize = sc.nextInt();
//	      
//	      System.out.println("page num : ");
//	      int scPageNum = sc.nextInt();
//	      
//	      System.out.println("searchdiv : 10(입력) ");
//	      String scSearchDiv = sc.next();
//	      
//	      System.out.println("searchword:개시글 번호 입력) : ");
//	      String scSearchWord = sc.next();
		
		
		boardTest.doinsert(scCont,scRegid);
		//boardTest.doDelete(scCno);
		//boardTest.doUpdate(scCno,scCont,scViews);
	     // boardTest.doViewsUpdate(scCno,scViews);
		//boardTest.doSelectOne();
		//boardTest.doRetrieve(scPageSize,scPageNum,scSearchDiv,scSearchWord);
	}

}
















