/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.room
 * 클래스명 : RoomMain.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-18    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-18 오후 5:26:03
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mal_a.cmn.SearchVO;
import com.mal_a.store.StoreMain;
import com.mal_a.store.StoreVO;

/**
 * @author sist
 *
 */
public class RoomMain {

private final Logger LOG = Logger.getLogger(RoomMain.class);
	
	//Test Data
		private RoomVO roomVO01;
		private RoomDao dao;
		
		public RoomMain() {
			roomVO01 = new RoomVO();
			dao	= new RoomDao();
		}
		
		//등록
		public void doInsert(String scrno,String scname,String sccapacity,String sccont,String scprice1,
							 String scprice2,String scsno) {
			
			roomVO01.setRno(scrno);
			roomVO01.setName(scname);
			roomVO01.setCapacity(sccapacity);
			roomVO01.setCont(sccont);
			roomVO01.setPrice1(scprice1);
			roomVO01.setPrice2(scprice2);
			roomVO01.setSno(scsno);
		      
			int mainFlag = dao.doInsert(roomVO01);
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
		
		public void doDelete(String scrno) {
			roomVO01.setRno(scrno);
			
			int delFlag = dao.doDelete(roomVO01);
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
					
			roomVO01.setName("99방");					//방이름
			roomVO01.setCapacity("11");					//수용인원
			roomVO01.setCont("쪄럿");						//방소개글
			roomVO01.setPrice1("1000000");				//주중가
			roomVO01.setPrice2("1000000");				//주말가
			roomVO01.setSno("02_2");					//업체번호
			roomVO01.setRno("02_2_6");					//방번호
					
			int updateFlag = dao.doUpdate(roomVO01);
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
		public void doSelectOne(String scrno) {
					
			roomVO01.setRno(scrno);
			RoomVO outVO = (RoomVO) dao.doSelectOne(roomVO01);
					
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
				      
			List<RoomVO> list = (List<RoomVO>) dao.doRetrieve(searchVO);
			LOG.debug("=========================");
			for(RoomVO vo:list) {
				  LOG.debug(vo);
			}
			LOG.debug("=========================");
		}
	
	
	/**
	 *메서드명 : main
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 
	 *@param args void
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List dlist  =new ArrayList();
		RoomMain store = new RoomMain();
//		dlist = store.doRetrieve(scPageSize, scPageNum, scSearchDiv, scSearchWord);
		
		
		
//		  System.out.println("rno_ : ");
//	      String scrno = sc.next();
//	      System.out.println("------");
//		  System.out.println("name : ");
//	      String scname = sc.next();
//	      System.out.println("------");
//	      System.out.println("capacity : ");
//	      String sccapacity = sc.next();
//	      System.out.println("------");
//	      System.out.println("cont : ");
//	      String sccont = sc.next();
//	      System.out.println("------");
//	      System.out.println("주중가 : ");
//	      String scprice1 = sc.next();
//	      System.out.println("------");
//	      System.out.println("주말가 : ");
//	      String scprice2 = sc.next();
//	      System.out.println("------");
//	      System.out.println("sno : ");
//	      String scsno = sc.next();
//	      System.out.println("------");

	      
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
	      System.out.println("------");
//
//		
//		store.doInsert(scrno,scname,sccapacity,sccont,scprice1,scprice2,scsno);
//		
//		store.doDelete(scrno);
//		store.doUpdate();
//		store.doSelectOne(scrno);
	    store.doRetrieve(scPageSize, scPageNum, scSearchDiv, scSearchWord);



	}

}
