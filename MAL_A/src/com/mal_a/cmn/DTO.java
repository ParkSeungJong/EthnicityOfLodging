/**
 *<pre>
 * com.hr.cmn
 * Class Name : DTO.java
 * Description : 
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
package com.mal_a.cmn;

/**
 * @author SIST
 *
 */
public class DTO {
	private int pageSize; //페이지 사이즈 : 10,30,50,100
	private int pageNum; //페이지 넘버 : 1,2,3,...
	private int total; // 총글수
	private int num; // 글번호
	
	public DTO() {
		
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "DTO [pageSize=" + pageSize + ", pageNum=" + pageNum + ", total=" + total + ", num=" + num + "]";
	}
	
	
}
