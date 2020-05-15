/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.roomoption
 * 클래스명 : RoomOptionVO.java
 * 설명 : RoomOption VO
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-18    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-18 오후 4:02:46
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.roomoption;

import com.mal_a.cmn.DTO;

public class RoomOptionVO extends DTO {
	private String rno;	   		/**방번호 */
	private String opt;    		/**옵션 dtlId */
	private String yn;     		/**가능여부 */
	private String optName;     /**옵션 dtlNm */


	public RoomOptionVO() {}


	public RoomOptionVO(String rno, String opt, String yn, String optName) {
		super();
		this.rno = rno;
		this.opt = opt;
		this.yn = yn;
		this.optName = optName;
	}


	public String getRno() {
		return rno;
	}


	public void setRno(String rno) {
		this.rno = rno;
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
		return "RoomOptionVO [rno=" + rno + ", opt=" + opt + ", yn=" + yn + ", optName=" + optName + ", toString()="
				+ super.toString() + "]";
	}


	
	 

	
}