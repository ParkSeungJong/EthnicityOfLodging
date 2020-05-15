/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.heart
 * 클래스명 : HeartVO.java
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
package com.mal_a.heart;

import com.mal_a.cmn.DTO;

public class HeartVO extends DTO{
	private String sno;	  /** 업체번호	*/
	private String regId; /** 등록자아이디	*/
	private String regDt; /** 등록일	*/
	private String modId; /** 수정자아이디	*/
	private String modDt; /** 수정일	*/

	public HeartVO() {}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
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

	public HeartVO(String sno, String regId, String regDt, String modId, String modDt) {
		super();
		this.sno = sno;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
	}

	@Override
	public String toString() {
		return "HeartVO [sno=" + sno + ", regId=" + regId + ", regDt=" + regDt + ", modId=" + modId + ", modDt=" + modDt
				+ ", toString()=" + super.toString() + "]";
	}

	

}

