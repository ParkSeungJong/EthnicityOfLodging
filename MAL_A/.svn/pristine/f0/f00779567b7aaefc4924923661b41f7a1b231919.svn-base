/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.store
 * 클래스명 : StoreMain.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-06    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-06 오후 9:56:23
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.mal_a.cmn.SearchVO;
import com.mal_a.stooption.StoOptionVO;
import com.mal_a.store.StoreDao;
import com.mal_a.store.StoreVO;
import com.mal_a.store.StoreMain;

/**
 * @author sist
 *
 */
public class StoreMain {

	private final Logger LOG = Logger.getLogger(StoreMain.class);
	
	//Test Data
		private StoreVO storeVO01;
		private StoreDao dao;
		
		public StoreMain() {
			storeVO01 = new StoreVO();
			dao	= new StoreDao();
		}
		
		//등록
		public void doInsert(String scsno,String scname,String scaddrno,String scaddr,
							 String sctel,String scstopart,String scregId) {
			
			storeVO01.setSno(scsno);
			storeVO01.setName(scname);
			storeVO01.setAddrNo(scaddrno);
			storeVO01.setAddr(scaddr);
			storeVO01.setTel(sctel);
			storeVO01.setStoPart(scstopart);
			storeVO01.setRegId(scregId);
		      
			int mainFlag = dao.doInsert(storeVO01);
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
		public void doDelete(String scsno) {
			storeVO01.setSno(scsno);
			
			int delFlag = dao.doDelete(storeVO01);
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
			
			storeVO01.setName("현귱호텔");					//가게명
			storeVO01.setAddrNo("24580");				//우편번호
			storeVO01.setAddr("삼척시근덕면78-99");		//주소
			storeVO01.setTel("0335747878");				//전화번호
			storeVO01.setStoPart("2");					//업체분류
			storeVO01.setCont("방갑습니다");				//업체소개글
			storeVO01.setViews("1");					//정지상태
			storeVO01.setRegId("bis99");				//등록자아이디
			storeVO01.setModId("bis99");				//수정자아이디
			storeVO01.setFileId("20200202_0000099");	//파일아이디
			storeVO01.setSno("051_10");					//업체번호
			
			int updateFlag = dao.doUpdate(storeVO01);
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
		public void doSelectOne(String scsno) {
			
			storeVO01.setSno(scsno);
			StoreVO outVO = (StoreVO) dao.doSelectOne(storeVO01);
			
			LOG.debug("=========================");
			LOG.debug("outVO="+outVO);
			LOG.debug("=========================");
			
		}
		
		//다건조회
		public void doRetrieve(int scPageSize, int scPageNum, String scSearchDiv, String scSearchWord, String scSearchWord02) {
		      SearchVO searchVO = new SearchVO();
		      
		      searchVO.setPageSize(scPageSize);
		      searchVO.setPageNum(scPageNum);
		      searchVO.setSearchDiv(scSearchDiv);
		      searchVO.setSearchWord(scSearchWord);
//		      searchVO.setSearchWord02(scSearchWord02);
		      
		      List<StoreVO> list = (List<StoreVO>) dao.doRetrieve(searchVO);
		      LOG.debug("=========================");
		      for(StoreVO vo:list) {
		         LOG.debug(vo);
		      }
		      LOG.debug("=========================");
		   }
		
		
		
		//다건조회
		public void doStoreRetrieve() {
			SearchVO searchVO = new SearchVO();
            StoOptionVO stoVO = new StoOptionVO();
		      
            
            
            searchVO.setSearchWord03("02");
            searchVO.setSearchWord04("20200503");
            searchVO.setSearchWord05("20200508");
            searchVO.setPageSize(10);
            searchVO.setPageNum(1);
            searchVO.setSearchDiv("1");
            
            String arrTest = ("1,2");
            stoVO.setOpt(arrTest);
		      
		      List<StoreVO> list = (List<StoreVO>) dao.doStoreRetrieve(searchVO, stoVO);
		      LOG.debug("=========================");
		      LOG.debug("=========성공=========");
		      for(StoreVO vo:list) {
		         LOG.debug(vo);
		      }
		      LOG.debug("=========================");
		   }
		
		
	
	/**
	 *메서드명 : main
	 *작성일 : 2020. 2. 6.
	 *작성자 : sist
	 *설명 : 
	 *@param args void
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List dlist  =new ArrayList();
		StoreMain store = new StoreMain();
//		dlist = store.doRetrieve(scPageSize, scPageNum, scSearchDiv, scSearchWord);
		
		
		
//		  System.out.println("sno_ : ");
//	      String scsno = sc.next();
//	      System.out.println("------");
//		  System.out.println("name : ");
//	      String scname = sc.next();
//	      System.out.println("------");
//	      System.out.println("addrno : ");
//	      String scaddrno = sc.next();
//	      System.out.println("------");
//	      System.out.println("addr1 : ");
//	      String scaddr1 = sc.next();
//	      System.out.println("------");
//	      System.out.println("addr2 : ");
//	      String scaddr2 = sc.next();
//	      System.out.println("------");
//	      System.out.println("tel : ");
//	      String sctel = sc.next();
//	      System.out.println("------");
//	      System.out.println("stopart : ");
//	      String scstopart = sc.next();
//	      System.out.println("------");
//	      System.out.println("regId : ");
//	      String scregId = sc.next();
//	      System.out.println("------");

	      
//	      System.out.println("scPageSize : ");
//	      int scPageSize = sc.nextInt();
//	      System.out.println("------");
//	      System.out.println("scPageNum : ");
//	      int scPageNum = sc.nextInt();
//	      System.out.println("------");
//	      System.out.println("scSearchDiv : ");
//	      String scSearchDiv = sc.next();
//	      System.out.println("------");
//	      System.out.println("scSearchWord : ");
//	      String scSearchWord = sc.next();
//	      System.out.println("------");
//	      System.out.println("scSearchWord02 : ");
//	      String scSearchWord02 = sc.next();
//	      System.out.println("loc : ");
//	      String scSearchWord03 = sc.next();
//	      System.out.println("stdt : ");
//	      String scSearchWord04 = sc.next();
//	      System.out.println("enddt : ");
//	      String scSearchWord05 = sc.next();
//	      System.out.println("opt : ");
//	      String scSearchWord06 = "1,2,3";
	      
	      
	      

		
//		store.doInsert(scsno,scname,scaddrno,scaddr1,scaddr2,sctel,scstopart,scregId);
//		
//		store.doDelete(scsno);
//		store.doUpdate();
//		store.doSelectOne(scsno);
//	    store.doStoreRetrieve(scSearchWord03,scSearchWord04,scSearchWord05,scSearchWord06,scPageSize, scPageNum);
		store.doStoreRetrieve();

	}

}
