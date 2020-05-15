/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.member
 * 클래스명 : MemberMain.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-06    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-06 오후 5:31:45
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.member;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mal_a.cmn.DTO;
import com.mal_a.cmn.SearchVO;
import com.mal_a.payment.PaymentVO;

public class MemberTestMain {
	private final Logger LOG = Logger.getLogger(MemberTestMain.class);

	// Test Data
	private MemberVO memberVO01;
	private PaymentVO paymentVO01;
	private MemberDao dao;

	public MemberTestMain() {
		memberVO01 = new MemberVO();
		paymentVO01 = new PaymentVO();
		dao = new MemberDao();

	}

	public void doInsert(String scMid, String scPw, String scName, String scEmail, String scBirth, String scGender,
			String scTel, String scPoint, String scAutho, String scRegId) {

		memberVO01.setMid(scMid);
		memberVO01.setPw(scPw);
		memberVO01.setName(scName);
		memberVO01.setEmail(scEmail);
		memberVO01.setBirth(scBirth);
		memberVO01.setGender(scGender);
		memberVO01.setTel(scTel);
		memberVO01.setPoint(scPoint);
		memberVO01.setAutho(scAutho);
		memberVO01.setRegId(scRegId);

		int flag = dao.doInsert(memberVO01);

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

	public void doSelectOne(String scMid) {
		memberVO01.setMid(scMid);
		MemberVO outVO = (MemberVO) dao.doSelectOne(memberVO01);
		if (null != outVO) {
			LOG.debug("===========================");
			LOG.debug("성공");
			LOG.debug("===========================");
		} else {
			LOG.debug("===========================");
			LOG.debug("실패");
			LOG.debug("===========================");
		}

		LOG.debug("====================");
		LOG.debug("outVO:" + outVO);
		LOG.debug("====================");
	}

	public void doSelectOneId(String scEmail) {
		memberVO01.setEmail(scEmail);
		MemberVO outVO = (MemberVO) dao.doSelectOneId(memberVO01);
		if (null != outVO) {
			LOG.debug("===========================");
			LOG.debug("성공");
			LOG.debug("===========================");
		} else {
			LOG.debug("===========================");
			LOG.debug("실패");
			LOG.debug("===========================");
		}

		LOG.debug("====================");
		LOG.debug("outVO:" + outVO);
		LOG.debug("====================");
	}

	public void doSelectOnePw(String scMid, String scName, String scEmail, String scTel) {
		memberVO01.setMid(scMid);
		memberVO01.setName(scName);
		memberVO01.setTel(scTel);
		memberVO01.setEmail(scEmail);
		MemberVO outVO = (MemberVO) dao.doSelectOnePw(memberVO01);
		if (null != outVO) {
			LOG.debug("===========================");
			LOG.debug("성공");
			LOG.debug("===========================");
		} else {
			LOG.debug("===========================");
			LOG.debug("실패");
			LOG.debug("===========================");
		}

		LOG.debug("====================");
		LOG.debug("outVO:" + outVO);
		LOG.debug("====================");
	}

	public void doUpdate() {
		memberVO01 = new MemberVO();
		int flag = dao.doUpdate(memberVO01);
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

//------------------------------------------------------------------------------------------------

	public void doUpdateViews(String scViews, String scModId, String scMid) {
		memberVO01.setViews(scViews);
		memberVO01.setModId(scModId);
		memberVO01.setMid(scMid);

		int flag = dao.doUpdateViews(memberVO01);
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

	public void doUpdateEmail(String scEmail, String scModId, String scMid) {
		memberVO01.setEmail(scEmail);
		memberVO01.setModId(scModId);
		memberVO01.setMid(scMid);

		int flag = dao.doUpdateEmail(memberVO01);
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

	public void doUpdateTel(String scTel, String scModId, String scMid) {
		memberVO01.setTel(scTel);
		memberVO01.setModId(scModId);
		memberVO01.setMid(scMid);

		int flag = dao.doUpdateTel(memberVO01);
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

	public void doUpdatePayment(String scPno, String scModId, String scMid) {
		paymentVO01.setPno(scPno);
		memberVO01.setModId(scModId);
		memberVO01.setMid(scMid);

		int flag = dao.doUpdatePayment(memberVO01);
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

	public void doUpdatePaymentCancCmp(String scPno, String scModId, String scMid) {
		paymentVO01.setPno(scPno);
		memberVO01.setModId(scModId);
		memberVO01.setMid(scMid);

		int flag = dao.doUpdatePaymentCancCmp(paymentVO01, memberVO01);
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

	public void doDelete(String scMid) {
		memberVO01.setMid(scMid);
		int flag = dao.doDelete(memberVO01);
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

	public void doRetrieve(int scPageSize, int scPageNum, String scSearchDiv, String scSearchWord) {
		SearchVO searchVO = new SearchVO();
		searchVO.setPageSize(scPageSize);
		searchVO.setPageNum(scPageNum);
		searchVO.setSearchDiv(scSearchDiv);
		searchVO.setSearchWord(scSearchWord);

		List<MemberVO> list = (List<MemberVO>) dao.doRetrieve(searchVO);

		LOG.debug("*****************************************");
		// Data출력
		for (MemberVO vo : list) {
			LOG.debug(vo);
		}
		LOG.debug("*****************************************");
	}
//------------------------------------------------------------------------------------------------

	public static void main(String[] args) {
		MemberTestMain memberTestMain = new MemberTestMain();

		Scanner sc = new Scanner(System.in);

//		System.out.println("Mid : ");
//		String scMid = sc.next();
//
//		System.out.println("Pw : ");
//		String scPw = sc.next();
//
//		System.out.println("Name : ");
//		String scName = sc.next();
//
		System.out.println("Email : ");
		String scEmail = sc.next();
//
//		System.out.println("Birth : ");
//		String scBirth = sc.next();
//
//		System.out.println("Gender : ");
//		String scGender = sc.next();
//
//		System.out.println("Tel : ");
//		String scTel = sc.next();
//
//		System.out.println("Point : ");
//		String scPoint = sc.next();
//
//		System.out.println("Autho : ");
//		String scAutho = sc.next();

//		System.out.println("Views : ");
//		String scViews = sc.next();

//		System.out.println("RegId : ");
//		String scRegId = sc.next();

//		System.out.println("RegDt : ");
//		String scRegDt = sc.next();
//
//		System.out.println("ModId : ");
//		String scModId = sc.next();

//		System.out.println("ModDt : ");
//		String scModDt = sc.next();

//		System.out.println("Sno : ");
//		String scSno = sc.next();
//
//		System.out.println("PageSize : ");
//		int scPageSize = sc.nextInt();
//
//		System.out.println("PageNum : ");
//		int scPageNum = sc.nextInt();
//
//		System.out.println("SearchDiv : ");
//		String scSearchDiv = sc.next();
//
//		System.out.println("SearchWord : ");
//		String scSearchWord = sc.next();
//
//		System.out.println("Pno : ");
//		String scPno = sc.next();

//		memberTestMain.doInsert(scMid, scPw, scName, scEmail, scBirth, scGender, scTel,scPoint,scAutho, scRegId);

//		memberTestMain.doSelectOne(scMid);
		memberTestMain.doSelectOneId(scEmail);
//		memberTestMain.doSelectOnePw(scMid, scName, scEmail, scTel);
//
//		memberTestMain.doUpdate(); /* 사용 x */
//		memberTestMain.doUpdateViews(scViews, scModId, scMid);
//		memberTestMain.doUpdateEmail(scEmail, scModId, scMid);
//		memberTestMain.doUpdateTel(scTel, scModId, scMid);
//		memberTestMain.doUpdatePayment(scPno, scModId, scMid);
//		memberTestMain.doUpdatePaymentCancCmp(scPno, scModId, scMid);
//
//		memberTestMain.doDelete(scMid);
//
//		memberTestMain.doRetrieve(scPageSize, scPageNum, scSearchDiv, scSearchWord);
	}

}
