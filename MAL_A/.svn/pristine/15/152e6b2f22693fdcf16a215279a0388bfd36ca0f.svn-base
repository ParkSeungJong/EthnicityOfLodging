/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.code
 * 클래스명 : CodeServiceTestMain.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-27    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-27 오후 12:02:27
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.code;

import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.StringUtil;
import com.mal_a.code.CodeService;
import com.mal_a.code.CodeServiceTestMain;
import com.mal_a.code.CodeVO;

/**
 * @author sist
 *
 */
public class CodeServiceTestMain {
	private final Logger LOG = Logger.getLogger(CodeServiceTestMain.class);
	private CodeVO vo01;
	private CodeService service;
	
	public CodeServiceTestMain() {
		vo01 = new CodeVO();
		service = new CodeService();
	}
	
	public void doRetrieve() {
		vo01.setMstId("BOARD_SEARCH_DIV");
		List<CodeVO> list = (List<CodeVO>) service.doRetrieve(vo01);
		for(CodeVO vo :list) {
			LOG.debug(vo);
		}
		StringUtil.makeSelectBox(list, "search_div", "10", true);
	}
	
	/**
	 *메서드명 : main
	 *작성일 : 2020. 2. 27.
	 *작성자 : sist
	 *설명 : 
	 *@param args void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
