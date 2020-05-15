package com.mal_a.review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mal_a.cmn.SearchVO;
import com.mal_a.store.StoreMain;

public class ReviewMain {

	private final Logger LOG = Logger.getLogger(ReviewMain.class);
	
	//Test Data
			private ReviewVO reviewVO01;
			private ReviewDao dao;
			
			public ReviewMain() {
				reviewVO01 = new ReviewVO();
				dao	= new ReviewDao();
			}
			
			//등록
			public void doInsert(String screno,String sccont,String scstar,String scviews,String scregid,String scsno) {
				
				reviewVO01.setReno(screno);
				reviewVO01.setCont(sccont);
				reviewVO01.setStar(scstar);
				reviewVO01.setViews(scviews);
				reviewVO01.setRegId(scregid);
				//reviewVO01.setSno(scsno);

			      
				int mainFlag = dao.doInsert(reviewVO01);
				if(mainFlag==1) {
					LOG.debug("=========================");
					LOG.debug("성공=");
					LOG.debug("=========================");
				}else {
					LOG.debug("=========================");
					LOG.debug("실패=");
					LOG.debug("=========================");
				}
			}
			
			//삭제
			public void doDelete(String screno) {
				reviewVO01.setReno(screno);
				
				int delFlag = dao.doDelete(reviewVO01);
				if(delFlag==1) {
					LOG.debug("=========================");
					LOG.debug("성공=");
					LOG.debug("=========================");
				}else {
					LOG.debug("=========================");
					LOG.debug("실패=");
					LOG.debug("=========================");
				}
			}
			
			//수정
			public void doUpdate() {
				
				reviewVO01.setViews("권한");					//가게명
				reviewVO01.setModId("데헷");					//우편번호
				reviewVO01.setReno("02_4_2");				//주소
				
				
				int updateFlag = dao.doUpdate(reviewVO01);
				if(updateFlag==1) {
					LOG.debug("=========================");
					LOG.debug("성공=");
					LOG.debug("=========================");
				}else {
					LOG.debug("=========================");
					LOG.debug("실패=");
					LOG.debug("=========================");
				}
			}
			
			//단건조회
			public void doSelectOne(String screno) {
				
				reviewVO01.setReno(screno);
				ReviewVO outVO = (ReviewVO) dao.doSelectOne(reviewVO01);
				
				LOG.debug("=========================");
				LOG.debug("outVO="+outVO);
				LOG.debug("=========================");
				
			}
			
			//다건조회
			public void doRetrieve(int scPageSize, int scPageNum, String scSearchDiv, String scSearchWord) {
			      SearchVO searchVO = new SearchVO();
			      
			      searchVO.setPageSize(scPageSize);
			      searchVO.setPageNum(scPageNum);
			      searchVO.setSearchDiv(scSearchDiv);
			      searchVO.setSearchWord(scSearchWord);
			      
			      List<ReviewVO> list = (List<ReviewVO>) dao.doRetrieve(searchVO);
			      LOG.debug("=========================");
			      for(ReviewVO vo:list) {
			         LOG.debug(vo);
			      }
			      LOG.debug("=========================");
			   }
			
			public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				
				List dlist  =new ArrayList();
				ReviewMain reviewMain = new ReviewMain();
//				dlist = store.doRetrieve(scPageSize, scPageNum, scSearchDiv, scSearchWord);
				
				  
//				  System.out.println("reno : ");
//			      String screno = sc.next();
//			      System.out.println("------");
				
//				  System.out.println("cont : ");
//			      String sccont = sc.next();
//			      System.out.println("------");
				
//				  System.out.println("star : ");
//			      String scstar = sc.next();
//			      System.out.println("------");
				
//				  System.out.println("정지권한 : ");
//			      String scviews = sc.next();
//			      System.out.println("------");
				
//				  System.out.println("등록자ID : ");
//			      String scregid = sc.next();
//			      System.out.println("------");
				
//				  System.out.println("sno : ");
//			      String scsno = sc.next();
//			      System.out.println("------");
				
				
				  System.out.println("scPageSize : ");
			      int scPageSize = sc.nextInt();
			      System.out.println("------");
			      System.out.println("scPageNum : ");
			      int scPageNum = sc.nextInt();
			      System.out.println("------");
			      System.out.println("scSearchDiv : ");
			      String scSearchDiv = sc.next();
			      System.out.println("------");
			      System.out.println("scSearchWord : ");
			      String scSearchWord = sc.next();
//			      System.out.println("------");
//			      System.out.println("scSearchWord02 : ");
//			      String scSearchWord02 = sc.next();
				
			      
			      //
//					
//					reviewMain.doInsert(screno,sccont,scstar,scviews,scregid,scsno);
//					
//					reviewMain.doDelete(screno);
//					reviewMain.doUpdate();
//					reviewMain.doSelectOne(screno);
			      reviewMain.doRetrieve(scPageSize, scPageNum, scSearchDiv, scSearchWord);
				
			}
	
}
