/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.payment
 * 클래스명 : PaymentTestMain.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-06    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-06 오후 6:58:43
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.payment;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mal_a.cmn.SearchVO;

/**
 * @author sist
 *
 */
public class PaymentTestMain {
	private final Logger LOG = Logger.getLogger(PaymentTestMain.class);
	
	private PaymentVO paymentVO01 = new PaymentVO();
	private PaymentDao paymentDao;
	
	public PaymentTestMain() {
		paymentDao = new PaymentDao();
	}
	
	/**
	 * 
	 *메서드명 : doInsert
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 결제시 결제내역 추가 메서드
	 *@param scStartDt
	 *@param scEndDt
	 *@param scPay
	 *@param scUsePoint
	 *@param scSavePoint
	 *@param scRegId
	 *@param scSno
	 *@param scRno void
	 */
	public void doInsert(String scStartDt, String scEndDt, String scPay, String scUsePoint, String scSavePoint, String scRegId, String scSno, String scRno) {
		paymentVO01.setStartDt(scStartDt);
		paymentVO01.setEndDt(scEndDt);
		paymentVO01.setPay(scPay);
		paymentVO01.setUsePoint(scUsePoint);
		paymentVO01.setSavePoint(scSavePoint);
		paymentVO01.setRegId(scRegId);
		paymentVO01.setSno(scSno);
		paymentVO01.setRno(scRno);
		int mainFlag = paymentDao.doInsert(paymentVO01);
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
	
	public void doSelectOne(String scPno) {
		paymentVO01.setPno(scPno);
		PaymentVO outVO = (PaymentVO) paymentDao.doSelectOne(paymentVO01);
		LOG.debug("=====================");
		LOG.debug("outVO:"+outVO);
		LOG.debug("=====================");
	}
	
	/**
	 * 
	 *메서드명 : doUpdate
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 구매확정 업데이트 메서드
	 *@param scPno void
	 */
	public void doUpdate(String scPno) {
		paymentVO01.setPno(scPno);
		int mainFlag = paymentDao.doUpdate(paymentVO01);
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
	
	/**
	 * 
	 *메서드명 : doCancUpdate
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 취소요청 업데이트 메서드
	 *@param scModId
	 *@param scPno void
	 */
	public void doCancUpdate(String scModId, String scPno) {
		paymentVO01.setModId(scModId);
		paymentVO01.setPno(scPno);
		int mainFlag = paymentDao.doUpdateCanc(paymentVO01);
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
	
	/**
	 * 
	 *메서드명 : doCancCmpUpdate
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 취소완료 업데이트 메서드
	 *@param scModId
	 *@param scPno void
	 */
	public void doCancCmpUpdate(String scModId, String scPno) {
		paymentVO01.setModId(scModId);
		paymentVO01.setPno(scPno);
		int mainFlag = paymentDao.doUpdateCancCmp(paymentVO01);
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
	
	/**
	 * 
	 *메서드명 : doRetrieve
	 *작성일 : 2020. 2. 11.
	 *작성자 : sist
	 *설명 : 다건 조회 메서드
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
		List<PaymentVO> list = (List<PaymentVO>) paymentDao.doRetrieve(searchVO);
		LOG.debug("************************************************");
		for(PaymentVO vo:list) {
			LOG.debug(vo);
		}
		LOG.debug("************************************************");
	}

	
	
	/**
	 * 
	 *메서드명 : main
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 
	 *@param args void
	 */
	public static void main(String[] args) {
		PaymentTestMain pt = new PaymentTestMain();
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("pno : ");
//		int scPno = sc.nextInt();
		
//		System.out.println("startDt : ");
//		String scStartDt = sc.next();
//		
//		System.out.println("endDt : ");
//		String scEndDt = sc.next();
//		
//		System.out.println("pay : ");
//		String scPay = sc.next();
//		
//		System.out.println("usePoint : ");
//		String scUsePoint = sc.next();
//		
//		System.out.println("savePoint : ");
//		String scSavePoint = sc.next();
		
//		System.out.println("rs : ");
//		String scRs = sc.next();
		
//		System.out.println("regId : ");
//		String scRegId = sc.next();
		
//		System.out.println("modId : ");
//		String scModId = sc.next();
		
//		System.out.println("modDt : ");
//		String scModDt = sc.nextLine();
		
//		System.out.println("sno : ");
//		String scSno = sc.next();
//		
//		System.out.println("rno : ");
//		String scRno = sc.next();
		
		System.out.println("page size : ");
		int scPageSize = sc.nextInt();
		
		System.out.println("page num : ");
		int scPageNum = sc.nextInt();
		
		System.out.println("searchdiv : 1(회원아이디로 검색) or 2(업체번호로 검색)");
		String scSearchDiv = sc.next();
		
		System.out.println("searchword : ");
		String scSearchWord = sc.next();
		
//		pt.doInsert(scStartDt, scEndDt, scPay, scUsePoint, scSavePoint, scRegId, scSno, scRno);
//		pt.doSelectOne(scPno);
//		pt.doUpdate(scPno);
//		pt.doCancUpdate(scModId, scPno);
//		pt.doCancCmpUpdate(scModId, scPno);
		pt.doRetrieve(scPageSize, scPageNum, scSearchDiv, scSearchWord);
	}

}
