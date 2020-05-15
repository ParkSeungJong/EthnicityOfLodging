/**
 *<pre>
 * com.mal_a.landmark
 * Class Name : LandmarkVO.java
 * Description : 관광명소 VO
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-02-03           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-02-03 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.landmark;

import com.mal_a.cmn.DTO;

public class LandmarkVO extends DTO {
	private String lno     ; /** 관광업체번호 */
	private String name    ; /** 상호명 */
	private String addrNo  ; /** 우편번호*/
	private String addr    ; /** 주소 */
	private String tel     ; /** 전화번호 */
	private String cont    ; /** 상세내용 */
	private String category; /** 카테고리 */
	private String regId   ; /** 등록자아이디 */
	private String regDt   ; /** 등록일 */
	private String modId   ; /** 수정자아이디 */
	private String modDt   ; /** 수정일 */
	private String fileId  ; /** 파일ID */
	
	
	public LandmarkVO() {}

	public LandmarkVO(String lno, String name, String addrNo, String addr, String tel, String cont, String category,
			String regId, String regDt, String modId, String modDt, String fileId) {
		super();
		this.lno = lno;
		this.name = name;
		this.addrNo = addrNo;
		this.addr = addr;
		this.tel = tel;
		this.cont = cont;
		this.category = category;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
		this.fileId = fileId;
	}


	public String getLno() {
		return lno;
	}


	public void setLno(String lno) {
		this.lno = lno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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


	public void setAddr(String addr1) {
		this.addr = addr1;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getCont() {
		return cont;
	}


	public void setCont(String cont) {
		this.cont = cont;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
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


	public String getFileId() {
		return fileId;
	}


	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	@Override
	public String toString() {
		return "LandmarkVO [lno=" + lno + ", name=" + name + ", addrNo=" + addrNo + ", addr=" + addr + ", tel=" + tel
				+ ", cont=" + cont + ", category=" + category + ", regId=" + regId + ", regDt=" + regDt + ", modId="
				+ modId + ", modDt=" + modDt + ", fileId=" + fileId + ", toString()=" + super.toString() + "]";
	}

	
		
}