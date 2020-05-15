/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.member
 * 클래스명 : MemberVO.java
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

import com.mal_a.cmn.DTO;

/**
 * @author SIST
 *
 */
public class MemberVO extends DTO {
	private String	mid		;	/**	회원아이디	*/
	private String	pw		;	/**	비번		*/
	private String	name	;	/**	이름		*/
	private String	email	;	/**	이메일	*/
	private String	birth	;	/**	생년월일	*/
	private String	gender	;	/**	성별		*/
	private String	tel		;	/**	전화번호	*/
	private String	point	;	/**	보유포인트	*/
	private String	autho	;	/**	관리자권한	*/
	private String	views	;	/**	정지상태	*/
	private String	regId	;	/**	등록자아이디*/
	private String	regDt	;	/**	등록일	*/
	private String	modId	;	/**	수정자아이디*/
	private String	modDt	;	/**	수정일	*/
	private String	sno		;	/**	업체번호	*/
	private String  addrNo  ;   /** 우편번호    */
	private String  addr   ;   /** 주소          */
	
	
	
	public MemberVO () {}



	public String getMid() {
		return mid;
	}



	public void setMid(String mid) {
		this.mid = mid;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getBirth() {
		return birth;
	}



	public void setBirth(String birth) {
		this.birth = birth;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getPoint() {
		return point;
	}



	public void setPoint(String point) {
		this.point = point;
	}



	public String getAutho() {
		return autho;
	}



	public void setAutho(String autho) {
		this.autho = autho;
	}



	public String getViews() {
		return views;
	}



	public void setViews(String views) {
		this.views = views;
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



	public String getSno() {
		return sno;
	}



	public void setSno(String sno) {
		this.sno = sno;
	}



	public String getAddrNo() {
		return addrNo;
	}



	public void setAddrNo(String addrNo) {
		this.addrNo = addrNo;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	public MemberVO(String mid, String pw, String name, String email, String birth, String gender, String tel,
			String point, String autho, String views, String regId, String regDt, String modId, String modDt,
			String sno, String addrNo, String addr) {
		super();
		this.mid = mid;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
		this.tel = tel;
		this.point = point;
		this.autho = autho;
		this.views = views;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
		this.sno = sno;
		this.addrNo = addrNo;
		this.addr = addr;
	}



	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", pw=" + pw + ", name=" + name + ", email=" + email + ", birth=" + birth
				+ ", gender=" + gender + ", tel=" + tel + ", point=" + point + ", autho=" + autho + ", views=" + views
				+ ", regId=" + regId + ", regDt=" + regDt + ", modId=" + modId + ", modDt=" + modDt + ", sno=" + sno
				+ ", addrNo=" + addrNo + ", addr=" + addr + ", toString()=" + super.toString() + "]";
	}


	

	

}
