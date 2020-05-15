/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.heart
 * 클래스명 : HeartMain.java
 * 설명 :
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-06    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-06 오후 5:45:21
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.heart;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mal_a.cmn.SearchVO;
import com.mal_a.member.MemberVO;
import com.mal_a.store.StoreVO;

public class HeartTestMain {
	private final Logger LOG = Logger.getLogger(HeartTestMain.class);
	
	//Test Data
	private HeartVO heartVO01;
	private HeartDao dao;
	
	public HeartTestMain() {
		heartVO01 = new HeartVO();
		dao = new HeartDao();
	}
	
	public void doInsert(String scSno ,String scRegId) {
		heartVO01.setSno(scSno);
		heartVO01.setRegId(scRegId);
		
		int flag = dao.doInsert(heartVO01);

		if (1 == flag) {
			LOG.debug("===========================");
			LOG.debug("성공");
			LOG.debug("===========================");
		} else {
			LOG.debug("===========================");
			LOG.debug("실패");
			LOG.debug("===========================");
		}
	}
	
	public void doSelectOneSno(String scSno ,String scRegId) {
//		heartVO01.setSno(scSno);
//		heartVO01.setRegId(scRegId);
//		
//		HeartVO outVO = (HeartVO) dao.doSelectOneSno(heartVO01);
//		
//		if (null != outVO) {
//			LOG.debug("===========================");
//			LOG.debug("성공");
//			LOG.debug("===========================");
//		} else {
//			LOG.debug("===========================");
//			LOG.debug("실패");
//			LOG.debug("===========================");
//		}
//
//		LOG.debug("====================");
//		LOG.debug("outVO:" + outVO);
//		LOG.debug("====================");
	}
	
	public void doDelete(String scSno,String scRegId) {
		heartVO01.setSno(scSno);
		heartVO01.setRegId(scRegId);
		
		int flag = dao.doDelete(heartVO01);
		if (1 == flag) {
			LOG.debug("===========================");
			LOG.debug("성공");
			LOG.debug("===========================");
		} else {
			LOG.debug("===========================");
			LOG.debug("실패");
			LOG.debug("===========================");
		}
	}
	
	public void doRetrieve(int scPageSize, int scPageNum) {
		SearchVO searchVO = new SearchVO();

		
		searchVO.setPageSize(scPageSize);
		searchVO.setPageNum(scPageNum);
//		searchVO.setSearchDiv(scSearchDiv);
//		searchVO.setSearchWord(scSearchWord);

		List<StoreVO> list = (List<StoreVO>) dao.doRetrieve(searchVO);

		LOG.debug("*****************************************");
		// Data출력
		for (StoreVO vo : list) {
			LOG.debug(vo);
		}
		LOG.debug("*****************************************");
	}
	
	public void doRetrieveHeart(String scRegId,int scPageSize, int scPageNum) {
		SearchVO searchVO = new SearchVO();
		HeartVO heartVO = new HeartVO();
		
		heartVO.setRegId(scRegId);
		searchVO.setPageSize(scPageSize);
		searchVO.setPageNum(scPageNum);
//		searchVO.setSearchDiv(scSearchDiv);
//		searchVO.setSearchWord(scSearchWord);

		List<StoreVO> list = (List<StoreVO>) dao.doRetrieveHeart(heartVO,searchVO);

		LOG.debug("*****************************************");
		// Data출력
		for (StoreVO vo : list) {
			LOG.debug(vo);
		}
		LOG.debug("*****************************************");
	}
	
	public static void main(String[] args) {
		HeartTestMain heartMain = new HeartTestMain();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Sno : ");
		String scSno = sc.next();
		
		System.out.println("RegId : ");
		String scRegId = sc.next();
		
		//---------------------------------------------------------------------
		
//		System.out.println("PageSize : ");
//		int scPageSize = sc.nextInt();
//
//		System.out.println("PageNum : ");
//		int scPageNum = sc.nextInt();

//		System.out.println("SearchDiv : ");
//		String scSearchDiv = sc.next();

//		System.out.println("SearchWord : ");
//		String scSearchWord = sc.next();
		
		
		
		heartMain.doInsert(scSno, scRegId);
		//heartMain.doSelectOneSno(scSno, scRegId);
		
		//heartMain.doDelete(scSno, scRegId);
		//heartMain.doRetrieve(scPageSize, scPageNum);
		//heartMain.doRetrieveHeart(scRegId, scPageSize, scPageNum);
		
	}

}
