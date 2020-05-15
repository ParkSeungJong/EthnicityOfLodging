/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.store
 * 클래스명 : StoreVO.java
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
package com.mal_a.store;

import com.mal_a.cmn.DTO;

/**
 * @author sist
 *
 */
public class StoreVO extends DTO {

	
	private String sno			;/**  업체번호 */
	private String name			;/**  가게명 */
	private String addrNo		;/**  우편번호 */
	private String addr			;/**  주소 */
	private String tel			;/**  전화번호 */
	private String stoPart		;/**  업체분류 */
	private String cont			;/**  업체소개글 */
	private String views		;/**  정지상태 */
	private String regId		;/**  등록자아이디 */
	private String regDt		;/**  등록일 */
	private String modId		;/**  수정자아이디 */
	private String modDt		;/**  수정일 */
	private String fileId		;/**  파일ID */
	private	String	opt1		;/**	업체옵션1	*/
	private	String	opt2		;/**	업체옵션2	*/
	private	String	opt3		;/**	업체옵션3	*/
	private	String	opt4		;/**	업체옵션4	*/
	private	String	opt5		;/**	업체옵션5	*/
	private	String	opt6		;/**	업체옵션6	*/
	private	String	opt7		;/**	업체옵션7	*/
	private	String	opt8		;/**	업체옵션8	*/
	private	String	opt9		;/**	업체옵션9	*/
	private	String	opt10		;/**	업체옵션10	*/
	private	String	opt11		;/**	업체옵션11	*/
	private	String	opt12		;/**	업체옵션12	*/
	private	String	opt13		;/**	업체옵션13	*/
	private	String	opt14		;/**	업체옵션14	*/
	private	String	opt15		;/**	업체옵션15	*/
	private	String	opt16		;/**	업체옵션16	*/
	private	String	opt17		;/**	업체옵션17	*/

	
	public StoreVO() {}


	public StoreVO(String sno, String name, String addrNo, String addr, String tel, String stoPart, String cont,
			String views, String regId, String regDt, String modId, String modDt, String fileId, String opt1,
			String opt2, String opt3, String opt4, String opt5, String opt6, String opt7, String opt8, String opt9,
			String opt10, String opt11, String opt12, String opt13, String opt14, String opt15, String opt16,
			String opt17) {
		super();
		this.sno = sno;
		this.name = name;
		this.addrNo = addrNo;
		this.addr = addr;
		this.tel = tel;
		this.stoPart = stoPart;
		this.cont = cont;
		this.views = views;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
		this.fileId = fileId;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.opt5 = opt5;
		this.opt6 = opt6;
		this.opt7 = opt7;
		this.opt8 = opt8;
		this.opt9 = opt9;
		this.opt10 = opt10;
		this.opt11 = opt11;
		this.opt12 = opt12;
		this.opt13 = opt13;
		this.opt14 = opt14;
		this.opt15 = opt15;
		this.opt16 = opt16;
		this.opt17 = opt17;
	}


	public String getSno() {
		return sno;
	}


	public void setSno(String sno) {
		this.sno = sno;
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


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getStoPart() {
		return stoPart;
	}


	public void setStoPart(String stoPart) {
		this.stoPart = stoPart;
	}


	public String getCont() {
		return cont;
	}


	public void setCont(String cont) {
		this.cont = cont;
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


	public String getFileId() {
		return fileId;
	}


	public void setFileId(String fileId) {
		this.fileId = fileId;
	}


	public String getOpt1() {
		return opt1;
	}


	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}


	public String getOpt2() {
		return opt2;
	}


	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}


	public String getOpt3() {
		return opt3;
	}


	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}


	public String getOpt4() {
		return opt4;
	}


	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}


	public String getOpt5() {
		return opt5;
	}


	public void setOpt5(String opt5) {
		this.opt5 = opt5;
	}


	public String getOpt6() {
		return opt6;
	}


	public void setOpt6(String opt6) {
		this.opt6 = opt6;
	}


	public String getOpt7() {
		return opt7;
	}


	public void setOpt7(String opt7) {
		this.opt7 = opt7;
	}


	public String getOpt8() {
		return opt8;
	}


	public void setOpt8(String opt8) {
		this.opt8 = opt8;
	}


	public String getOpt9() {
		return opt9;
	}


	public void setOpt9(String opt9) {
		this.opt9 = opt9;
	}


	public String getOpt10() {
		return opt10;
	}


	public void setOpt10(String opt10) {
		this.opt10 = opt10;
	}


	public String getOpt11() {
		return opt11;
	}


	public void setOpt11(String opt11) {
		this.opt11 = opt11;
	}


	public String getOpt12() {
		return opt12;
	}


	public void setOpt12(String opt12) {
		this.opt12 = opt12;
	}


	public String getOpt13() {
		return opt13;
	}


	public void setOpt13(String opt13) {
		this.opt13 = opt13;
	}


	public String getOpt14() {
		return opt14;
	}


	public void setOpt14(String opt14) {
		this.opt14 = opt14;
	}


	public String getOpt15() {
		return opt15;
	}


	public void setOpt15(String opt15) {
		this.opt15 = opt15;
	}


	public String getOpt16() {
		return opt16;
	}


	public void setOpt16(String opt16) {
		this.opt16 = opt16;
	}


	public String getOpt17() {
		return opt17;
	}


	public void setOpt17(String opt17) {
		this.opt17 = opt17;
	}


	@Override
	public String toString() {
		return "StoreVO [sno=" + sno + ", name=" + name + ", addrNo=" + addrNo + ", addr=" + addr + ", tel=" + tel
				+ ", stoPart=" + stoPart + ", cont=" + cont + ", views=" + views + ", regId=" + regId + ", regDt="
				+ regDt + ", modId=" + modId + ", modDt=" + modDt + ", fileId=" + fileId + ", opt1=" + opt1 + ", opt2="
				+ opt2 + ", opt3=" + opt3 + ", opt4=" + opt4 + ", opt5=" + opt5 + ", opt6=" + opt6 + ", opt7=" + opt7
				+ ", opt8=" + opt8 + ", opt9=" + opt9 + ", opt10=" + opt10 + ", opt11=" + opt11 + ", opt12=" + opt12
				+ ", opt13=" + opt13 + ", opt14=" + opt14 + ", opt15=" + opt15 + ", opt16=" + opt16 + ", opt17=" + opt17
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	
	
	

	
	
	
}
