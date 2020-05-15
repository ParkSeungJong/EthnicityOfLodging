/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.filemng
 * 클래스명 : FileMngService.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-03-12    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-03-12 오후 12:34:25
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.heart;

import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.DTO;

/**
 * @author sist
 *
 */
public class HeartService {
	private final Logger LOG = Logger.getLogger(this.getClass());
	
	private HeartDao heartDao;
	
	public HeartService() {
		heartDao = new HeartDao();
	}
	
	public int doInsert(DTO dto) {
		return heartDao.doInsert(dto);
	}
	
	public int doDelete(DTO dto) {
		return heartDao.doDelete(dto);
	}
	
	public int doSelectOneCheck(DTO dto) {
		return heartDao.doSelectOneCheck(dto);
	}
	
	public List<?> doRetrieveHeart(DTO dto2,DTO dto){
		return heartDao.doRetrieveHeart(dto2, dto);
	}
	
}
