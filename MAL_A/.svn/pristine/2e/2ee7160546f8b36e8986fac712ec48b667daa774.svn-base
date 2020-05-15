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

package com.mal_a.board;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mal_a.cmn.SearchVO;

/**
 * @author sist133
 *
 */
public class BoardTestMain {
	
	private final Logger LOG =Logger.getLogger(BoardTestMain.class);
	
	//Test Data
	private BoardVO boardVO01;
	private BoardDao dao;
	
	
	public BoardTestMain() {
		boardVO01=new BoardVO();
		dao=new BoardDao();
	}
	
	//등록
	public void do_insert() {
		boardVO01.setBno("52");
		boardVO01.setTitle("1");
		boardVO01.setCont("2");
		boardVO01.setRegId("3");
		boardVO01.setFileId("4");

		
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
	
	public void doUpdate(String scBno,String scTitle,String scCont,String scModid) {
		boardVO01.setBno(scBno);
		boardVO01.setTitle(scTitle);
		boardVO01.setCont(scCont);
		boardVO01.setModId(scModid);
		
		
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
	
	
	public void doViewsUpdate(String scBno,String scViews) {
		boardVO01.setBno(scBno);
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
	
	
	
	public void doDelete(String scBno) {
		boardVO01.setBno(scBno);
		
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
	public void doSelectOne(String scBno) {
		boardVO01.setBno(scBno);
		BoardVO outVO =(BoardVO) dao.doSelectOne(boardVO01);
		
		LOG.debug("======================");
		LOG.debug("=========성공=============");
		LOG.debug("outVO"+outVO);
		LOG.debug("======================");
		
	}
	
	public void doRetrieve(int scPageSize,int scPageNum,String scSearchDiv,String scSearchWord) {
		SearchVO searchVO=new SearchVO();
		searchVO.setPageSize(scPageSize);
		searchVO.setPageNum(scPageNum);
		searchVO.setSearchDiv(scSearchDiv);
		searchVO.setSearchWord(scSearchWord);
		
		List<BoardVO>list=(List<BoardVO>) dao.doRetrieve(searchVO);
		
		LOG.debug("************************************************");
		//Data출력
		for(BoardVO vo:list) {
			LOG.debug(vo);
		}
		LOG.debug("************************************************");
	}
	
	
	public static void main(String[] args) {
		BoardTestMain boardTest=new BoardTestMain();
		
		Scanner sc = new Scanner(System.in);
		
//		  System.out.println("bno : ");
//	      int scBno = sc.next();
//	      
//	      System.out.println("title : ");
//	      String scTitle = sc.next();
//	      
//	      System.out.println("cont : ");
//	      String scCont = sc.next();
//	      
//	      System.out.println("cnt : ");
//	      int scCnt = sc.next();
//	      
//	      System.out.println("views : ");
//	      String scViews = sc.next();
//	      
//	      System.out.println("regId : ");
//	      String scRegId = sc.next();
//	      
//	      System.out.println("regDt : ");
//	      String scRegDt = sc.next();
//	      
//	      System.out.println("modId : ");
//	      String scModId = sc.next();
//	      
//	      System.out.println("moddt : ");
//	      String scModDt = sc.next();
//	      
//	      System.out.println("fileId : ");
//	      String scFileId = sc.next();
	      
	      System.out.println("page size : ");
	      int scPageSize = sc.nextInt();
	      
	      System.out.println("page num : ");
	      int scPageNum = sc.nextInt();
	      
	      System.out.println("searchdiv : 1(입력) ");
	      String scSearchDiv = sc.next();
	      
	      
	      System.out.println("searchword:검색어입력 : ");
	      String scSearchWord = sc.next();
		
		
//		boardTest.do_insert(scBno,scTitle,scCont,scCnt,scViews,scRegid,scModid,scFileid);
//		boardTest.do_insert();
		//boardTest.doDelete(scBno);
		//boardTest.doUpdate(scBno,scTitle,scCont,scModid);
	    // boardTest.doViewsUpdate(scBno,scViews);
		//boardTest.doSelectOne(scBno);
		boardTest.doRetrieve(scPageSize,scPageNum,scSearchDiv,scSearchWord);
		
	
	}

}
















