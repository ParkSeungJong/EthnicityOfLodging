/**
 *<pre>
 * com.hr.cmn
 * Class Name : WorkDiv.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-02-04           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-02-04 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.cmn;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author SIST
 *
 */
public abstract class WorkDiv {
	//공통변수 : log
	protected Logger LOG= Logger.getLogger(WorkDiv.class);
	
	/**
	 * 
	 *메서드명 : doInsert
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 
	 *@param dto
	 *@return int (1->성공,0->실패)
	 */
	public abstract int doInsert(DTO dto);
	
	/**
	 * 
	 *메서드명 : doSelectOne
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 단건조회
	 *@param dto
	 *@return DTO (1->성공,0->실패)
	 */
	public abstract DTO doSelectOne(DTO dto);
	
	/**
	 * 
	 *메서드명 : doUpdate
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 수정
	 *@param dto
	 *@return int (1->성공,0->실패)
	 */
	public abstract int doUpdate(DTO dto);
	
	/**
	 * 
	 *메서드명 : doDelete
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 삭제
	 *@param dto
	 *@return int (1->성공,0->실패)
	 */
	public abstract int doDelete(DTO dto);
	
	/**
	 * 
	 *메서드명 : doRetrieve
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 목록조회
	 *@param dto
	 *@return List<?>
	 */
	public abstract List<?> doRetrieve(DTO dto);
	
}
