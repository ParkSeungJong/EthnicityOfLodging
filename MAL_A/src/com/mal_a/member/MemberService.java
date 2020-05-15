/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.member
 * 클래스명 : MemberService.java
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

import java.util.List;

import com.mal_a.cmn.MessageVO;
import com.mal_a.cmn.DTO;
import com.mal_a.member.MemberDao;

/**
 * @author sist
 *
 */
public class MemberService {

	private MemberDao memberDao;

	public MemberService() {
		memberDao = new MemberDao();
		
	}
	
	/**
	 * 
	 *메서드명 : loginCheck
	 *작성일 : 2020. 3. 12.
	 *작성자 : SIST
	 *설명 : ID/비번 Check
	 *@param dto
	 *@return MessageVO
	 */
	public DTO loginCheck(DTO dto) {
		MessageVO outVO = new MessageVO();
		//ID Check
		outVO = (MessageVO) memberDao.idCheck(dto);
		if(outVO.getMsgId().equals("10")) {
			return outVO;
		}
		
		//ID/비번 Check
		outVO = (MessageVO) memberDao.passCheck(dto);
		if(outVO.getMsgId().equals("20")) {
			return outVO;
		}

		return outVO;
		
	}
	
	
	/**
	 * 
	 *Method Name:doSelectOne
	 *작성일: 2020. 2. 7.
	 *작성자: sist
	 *설명:
	 *@param dto
	 *@return
	 */
	public DTO doSelectOne(DTO dto) {
		
		return memberDao.doSelectOne(dto);
	}
	
	public DTO doSelectOneId(DTO dto) {
		
		return memberDao.doSelectOneId(dto);
	}
	public DTO doSelectOnePw(DTO dto) {
	
		return memberDao.doSelectOnePw(dto);
	}
	
	/**
	 * 
	 *@Method Name:doUpdate
	 *@작성일: 2020. 2. 7.
	 *@작성자: SIST
	 *@설명:
	 *@param dto
	 *@return
	 */
	public int doUpdate(DTO dto) {
		return memberDao.doUpdate(dto);
	}
	
	/**
	 * 
	 *메서드명 : doUpdateTel
	 *작성일 : 2020. 2. 27.
	 *작성자 : SIST
	 *설명 : 
	 *@param dto
	 *@return int
	 */
	public int doUpdateTel(DTO dto) {
		return memberDao.doUpdateTel(dto);
	}
	
	/**
	 * 
	 *메서드명 : doUpdateTel
	 *작성일 : 2020. 2. 27.
	 *작성자 : SIST
	 *설명 : 
	 *@param dto
	 *@return int
	 */
	public int doUpdateEmail(DTO dto) {
		return memberDao.doUpdateEmail(dto);
	}
	
	public int doUpdateAddr(DTO dto) {
		return memberDao.doUpdateAddr(dto);
	}
	
	public int doUpdatePw(DTO dto) {
		return memberDao.doUpdatePw(dto);
	}
	
	public int doUpdateViews(DTO dto) {
		return memberDao.doUpdateViews(dto);
	}
	
	/**
	 * 
	 *메서드명 : doDelete
	 *작성일 : 2020. 2. 28.
	 *작성자 : SIST
	 *설명 : 
	 *@param dto
	 *@return int
	 */
	public int doDelete(DTO dto) {
		return memberDao.doDelete(dto);
	}
	/**
	 * 
	 *@Method Name:doInsert
	 *@작성일: 2020. 2. 7.
	 *@작성자: SIST
	 *@설명:
	 *@param dto
	 *@return
	 */
	public int doInsert(DTO dto) {
		return memberDao.doInsert(dto);
	}
	
	
	/**
	 * 
	 *@Method Name:doRetrieve
	 *@작성일: 2020. 2. 7.
	 *@작성자: SIST
	 *@설명:
	 *@param dto
	 *@return
	 */
	public List<?> doRetrieve(DTO dto) {
		return memberDao.doRetrieve(dto);
	}
	
	/**
	 * 
	 *메서드명 : doUpdateCancCmp
	 *작성일 : 2020. 2. 27.
	 *작성자 : sist
	 *설명 : 취소완료시 포인트 업데이트 메서드
	 *@param dto
	 *@param dto2
	 *@return int
	 */
	public int doUpdateCancCmp(DTO dto, DTO dto2) {
		return memberDao.doUpdatePaymentCancCmp(dto, dto2);
	}
	
	public int doUpdatePayment(DTO dto) {
		return memberDao.doUpdatePayment(dto);
	}
	
	
	
	
}








