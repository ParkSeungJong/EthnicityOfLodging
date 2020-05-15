package com.mal_a.room;

import com.mal_a.cmn.DTO;

public class RoomVO extends DTO {

	private String rno			;/** 방번호  */
	private String name			;/** 방이름  */
	private String capacity		;/** 수용인원  */
	private String cont			;/** 방소개글  */
	private String price1		;/** 주중가  */
	private String price2		;/** 주말가  */
	private String fileId		;/** 파일ID */
	private String sno			;/** 업체번호  */
	private	String	opt1		;/**	방옵션1*/
	private	String	opt2		;/**	방옵션2*/
	private	String	opt3		;/**	방옵션3*/
	private	String	opt4		;/**	방옵션4*/
	private	String	opt5		;/**	방옵션5*/
	private	String	opt6		;/**	방옵션6*/

	
	public RoomVO() {}


	public RoomVO(String rno, String name, String capacity, String cont, String price1, String price2, String fileId,
			String sno, String opt1, String opt2, String opt3, String opt4, String opt5, String opt6) {
		super();
		this.rno = rno;
		this.name = name;
		this.capacity = capacity;
		this.cont = cont;
		this.price1 = price1;
		this.price2 = price2;
		this.fileId = fileId;
		this.sno = sno;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.opt5 = opt5;
		this.opt6 = opt6;
	}


	public String getRno() {
		return rno;
	}


	public void setRno(String rno) {
		this.rno = rno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCapacity() {
		return capacity;
	}


	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}


	public String getCont() {
		return cont;
	}


	public void setCont(String cont) {
		this.cont = cont;
	}


	public String getPrice1() {
		return price1;
	}


	public void setPrice1(String price1) {
		this.price1 = price1;
	}


	public String getPrice2() {
		return price2;
	}


	public void setPrice2(String price2) {
		this.price2 = price2;
	}


	public String getFileId() {
		return fileId;
	}


	public void setFileId(String fileId) {
		this.fileId = fileId;
	}


	public String getSno() {
		return sno;
	}


	public void setSno(String sno) {
		this.sno = sno;
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


	@Override
	public String toString() {
		return "RoomVO [rno=" + rno + ", name=" + name + ", capacity=" + capacity + ", cont=" + cont + ", price1="
				+ price1 + ", price2=" + price2 + ", fileId=" + fileId + ", sno=" + sno + ", opt1=" + opt1 + ", opt2="
				+ opt2 + ", opt3=" + opt3 + ", opt4=" + opt4 + ", opt5=" + opt5 + ", opt6=" + opt6 + ", toString()="
				+ super.toString() + "]";
	}

	
	

	
	
}
