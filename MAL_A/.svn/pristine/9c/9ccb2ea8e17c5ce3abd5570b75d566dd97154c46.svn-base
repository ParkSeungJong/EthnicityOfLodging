/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.payment
 * 클래스명 : PaymentUpdatePayCmpMain.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-20    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-20 오전 11:11:58
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.payment;

import org.apache.log4j.Logger;

import com.mal_a.cmn.DTO;
import com.mal_a.member.MemberDao;

/**
 * @author sist
 *
 */
public class PaymentUpdatePayCmpMain {
	private final Logger LOG = Logger.getLogger(PaymentUpdatePayCmpMain.class);
	
	private PaymentVO paymentVO = new PaymentVO();
	private PaymentDao paymentDao;
	private MemberDao memberDao;
	
	public PaymentUpdatePayCmpMain() {
		paymentDao = new PaymentDao();
		memberDao = new MemberDao();
	}
	
	/**
	 * 
	 *메서드명 : doUpdatePayCmp
	 *작성일 : 2020. 2. 20.
	 *작성자 : sist
	 *설명 : 구매 확정 해야 할 모든 건 구매 확정 업데이트 메서드
	 *@return DTO
	 */
	public DTO doUpdatePayCmp() {
		PaymentVO outVO = (PaymentVO) paymentDao.doSelectOnePayCmpCount();
		LOG.debug("=====================");
		LOG.debug("outVO:"+outVO);
		LOG.debug("=====================");
		int count = outVO.getNum();
		for(int i=0;i<count;i++) {
			outVO = (PaymentVO) paymentDao.doSelectOnePayCmpPno(paymentVO);
			LOG.debug("=====================");
			LOG.debug("outVO:"+outVO);
			LOG.debug("=====================");
			paymentVO.setPno(outVO.getPno());
			paymentVO.setSavePoint(outVO.getSavePoint());
			paymentVO.setRegId(outVO.getRegId());
			int mainFlag = paymentDao.doUpdatePayCmp(paymentVO);
			if(mainFlag==1) {
				LOG.debug("=====================");
				LOG.debug("성공");
				LOG.debug("=====================");
			}else {
				LOG.debug("=====================");
				LOG.debug("실패");
				LOG.debug("=====================");
			}
			int mainFlag02 = memberDao.doUpdatePaymentCmp(paymentVO);
			if(mainFlag02==1) {
				LOG.debug("=====================");
				LOG.debug("성공");
				LOG.debug("=====================");
			}else {
				LOG.debug("=====================");
				LOG.debug("실패");
				LOG.debug("=====================");
			}
		}
		return outVO;
	}
	
	/**
	 *메서드명 : main
	 *작성일 : 2020. 2. 20.
	 *작성자 : sist
	 *설명 : 
	 *@param args void
	*/
	public static void main(String[] args) {
		PaymentUpdatePayCmpMain pt = new PaymentUpdatePayCmpMain();
		pt.doUpdatePayCmp();
	}

}
