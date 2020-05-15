/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.payment
 * 클래스명 : PaymentService.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-26    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-26 오전 9:12:35
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.payment;

import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.DTO;

/**
 * @author sist
 *
 */
public class PaymentService {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private PaymentDao payDao;
	
	public PaymentService() {
		payDao = new PaymentDao();
	}
	
	public int doInsert(DTO dto) {
		return payDao.doInsert(dto);
	}
	
	public DTO doSelectOne(DTO dto) {
		return payDao.doSelectOne(dto);
	}
	
	public DTO doSelectOnePno(DTO dto) {
		return payDao.doSelectOnePno(dto);
	}
	
	public DTO doSelectOnePayCmpCount() {
		return payDao.doSelectOnePayCmpCount();
	}
	
	public DTO doSelectOnePayCmpPno(DTO dto) {
		return payDao.doSelectOnePayCmpPno(dto);
	}
	
	public int doUpdatePayCmp(DTO dto) {
		return payDao.doUpdatePayCmp(dto);
	}
	
	public int doUpdateCanc(DTO dto) {
		return payDao.doUpdateCanc(dto);
	}
	
	public int doUpdateCancCanc(DTO dto) {
		return payDao.doUpdateCancCanc(dto);
	}

	public int doUpdateCancCmp(DTO dto) {
		return payDao.doUpdateCancCmp(dto);
	}
	
	public int doUpdatePay(DTO dto) {
		return payDao.doUpdatePay(dto);
	}
	
	public List<?> doRetrieve(DTO dto) {
		return payDao.doRetrieve(dto);
	}
}
