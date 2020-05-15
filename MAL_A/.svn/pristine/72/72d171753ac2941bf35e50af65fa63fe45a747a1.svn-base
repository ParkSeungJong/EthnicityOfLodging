/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.stooption
 * 클래스명 : StoOptionTestMain.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-18    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-18 오후 5:35:21
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.stooption;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mal_a.cmn.SearchVO;
import com.mal_a.payment.PaymentTestMain;

/**
 * @author sist
 *
 */
public class StoOptionTestMain {

	private final Logger LOG = Logger.getLogger(PaymentTestMain.class);
	
	private StoOptionVO stoOptionVO01 = new StoOptionVO();
	private StoOptionDao stoOptionDao;
	
	public StoOptionTestMain() {
		stoOptionDao = new StoOptionDao();
	}
	
	/**
	 * 
	 *메서드명 : doInsert
	 *작성일 : 2020. 2. 19.
	 *작성자 : sist
	 *설명 : 업체 옵션 업체 번호에 따른 인서트 메서드
	 *@param scSno
	 *@param scYnList void
	 */
	public void doInsert(String scSno, String[] scYnList) {
		for(int i=0;i<scYnList.length;i++) {
			stoOptionVO01.setSno(scSno);
			stoOptionVO01.setOpt(Integer.toString(i+1));;
			stoOptionVO01.setYn(scYnList[i]);
			int mainFlag = stoOptionDao.doInsert(stoOptionVO01);
			if(mainFlag==1) {
				LOG.debug("=====================");
				LOG.debug("성공");
				LOG.debug("=====================");
			}else {
				LOG.debug("=====================");
				LOG.debug("실패");
				LOG.debug("=====================");
			}
		}
	}
	
	/**
	 * 
	 *메서드명 : doDelete
	 *작성일 : 2020. 2. 19.
	 *작성자 : sist
	 *설명 : 업체 옵션 업체 번호에 따른 삭제 메서드
	 *@param scSno void
	 */
	public void doDelete(String scSno) {
		stoOptionVO01.setSno(scSno);
		int delFlag = stoOptionDao.doDelete(stoOptionVO01);
		LOG.debug("delFlag="+delFlag);
		if(delFlag==1) {
			LOG.debug("=====================");
			LOG.debug("성공");
			LOG.debug("=====================");
		}else {
			LOG.debug("=====================");
			LOG.debug("실패");
			LOG.debug("=====================");			
		}
	}
	
	/**
	 * 
	 *메서드명 : doRetrieve
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 업체 옵션 다건 조회 메서드
	 *@param scPageSize
	 *@param scPageNum
	 *@param scSearchDiv
	 *@param scSearchWord void
	 */
	public void doRetrieve(int scPageSize, int scPageNum, String scSearchDiv, String scSearchWord) {
		SearchVO searchVO = new SearchVO();
		searchVO.setPageSize(scPageSize);
		searchVO.setPageNum(scPageNum);
		searchVO.setSearchDiv(scSearchDiv);
		searchVO.setSearchWord(scSearchWord);
		List<StoOptionVO> list = (List<StoOptionVO>) stoOptionDao.doRetrieve(searchVO);
		LOG.debug("************************************************");
		for(StoOptionVO vo:list) {
			LOG.debug(vo);
		}
		LOG.debug("************************************************");
	}
	
	/**
	 *메서드명 : main
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 
	 *@param args void
	*/
	public static void main(String[] args) {
		StoOptionTestMain sot = new StoOptionTestMain();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("sno : ");
		String scSno = sc.next();
		
		String[] scYnList = {"9", "1", "1", "9", "9", "1", "1", "1", "1", "1", "1", "1", "1", "0", "0", "0", "0"};
		
//		System.out.println("page size : ");
//		int scPageSize = sc.nextInt();
//		
//		System.out.println("page num : ");
//		int scPageNum = sc.nextInt();
//		
//		System.out.println("searchdiv : 1(업체번호로 검색)");
//		String scSearchDiv = sc.next();
//		
//		System.out.println("searchword : ");
//		String scSearchWord = sc.next();
		
		sot.doDelete(scSno);
		sot.doInsert(scSno, scYnList);
//		sot.doRetrieve(scPageSize, scPageNum, scSearchDiv, scSearchWord);
	}

}
