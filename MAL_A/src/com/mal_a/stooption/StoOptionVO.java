/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.stooption
 * 클래스명 : StoOptionVO.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-18    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-18 오후 3:55:04
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.stooption;

import com.mal_a.cmn.DTO;

/**
 * @author sist
 *
 */
public class StoOptionVO extends DTO {

	public StoOptionVO() {
		
	}
	
	private String sno;
	private String opt;
	private String yn;
	private String optName;
	public StoOptionVO(String sno, String opt, String yn, String optName) {
		super();
		this.sno = sno;
		this.opt = opt;
		this.yn = yn;
		this.optName = optName;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	public String getYn() {
		return yn;
	}
	public void setYn(String yn) {
		this.yn = yn;
	}
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
	}
	@Override
	public String toString() {
		return "StoOptionVO [sno=" + sno + ", opt=" + opt + ", yn=" + yn + ", optName=" + optName + ", toString()="
				+ super.toString() + "]";
	}

	
		
	
	
}
