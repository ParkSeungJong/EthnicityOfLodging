/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.code
 * 클래스명 : CodeService.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-27    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-27 오후 12:01:27
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.code;

import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.DTO;
import com.mal_a.code.CodeDao;
import com.mal_a.code.CodeService;

/**
 * @author sist
 *
 */
public class CodeService {
	private final Logger  LOG = Logger.getLogger(CodeService.class);
	private CodeDao dao;
	
	public CodeService() {
		dao = new CodeDao();
	}
	
	public List<?> doRetrieve(DTO dto) {
		return dao.doRetrieve(dto);
	}
	public List<?> doAdminRetrieve(DTO dto) {
		return dao.doAdminRetrieve(dto);
	}
	
}
