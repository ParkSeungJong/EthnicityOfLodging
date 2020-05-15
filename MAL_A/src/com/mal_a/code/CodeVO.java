/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.code
 * 클래스명 : CodeVO.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-27    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-27 오전 11:55:58
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.code;

import com.mal_a.cmn.DTO;

/**
 * @author sist
 *
 */
public class CodeVO extends DTO {
	private String	mstId	;/**	마스터코드	 */
	private String	dtlId	;/**	상세코드	 */
	private String	mstNm	;/**	마스터코드명	 */
	private String	dtlNm	;/**	상세코드명	 */
	private String	seq		;/**	순번		 */
	private String	useYn	;/**	사용여부	 */
	private String	pMstId	;/**	상위마스터코드 */
	private String	regId	;/**	등록자아이디	 */
	private String	regDt	;/**	등록일		 */
	private String	modId	;/**	수정자아이디	 */
	private String	modDt	;/**	수정일		 */

	public CodeVO() {
		
	}

	public CodeVO(String mstId, String dtlId, String mstNm, String dtlNm, String seq, String useYn, String pMstId,
			String regId, String regDt, String modId, String modDt) {
		super();
		this.mstId = mstId;
		this.dtlId = dtlId;
		this.mstNm = mstNm;
		this.dtlNm = dtlNm;
		this.seq = seq;
		this.useYn = useYn;
		this.pMstId = pMstId;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
	}

	public String getMstId() {
		return mstId;
	}

	public void setMstId(String mstId) {
		this.mstId = mstId;
	}

	public String getDtlId() {
		return dtlId;
	}

	public void setDtlId(String dtlId) {
		this.dtlId = dtlId;
	}

	public String getMstNm() {
		return mstNm;
	}

	public void setMstNm(String mstNm) {
		this.mstNm = mstNm;
	}

	public String getDtlNm() {
		return dtlNm;
	}

	public void setDtlNm(String dtlNm) {
		this.dtlNm = dtlNm;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getpMstId() {
		return pMstId;
	}

	public void setpMstId(String pMstId) {
		this.pMstId = pMstId;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public String getModId() {
		return modId;
	}

	public void setModId(String modId) {
		this.modId = modId;
	}

	public String getModDt() {
		return modDt;
	}

	public void setModDt(String modDt) {
		this.modDt = modDt;
	}

	@Override
	public String toString() {
		return "CodeVO [mstId=" + mstId + ", dtlId=" + dtlId + ", mstNm=" + mstNm + ", dtlNm=" + dtlNm + ", seq=" + seq
				+ ", useYn=" + useYn + ", pMstId=" + pMstId + ", regId=" + regId + ", regDt=" + regDt + ", modId="
				+ modId + ", modDt=" + modDt + ", toString()=" + super.toString() + "]";
	}


	
	
}
