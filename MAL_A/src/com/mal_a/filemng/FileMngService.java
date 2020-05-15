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
package com.mal_a.filemng;

import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.DTO;

/**
 * @author sist
 *
 */
public class FileMngService {
	private final Logger LOG = Logger.getLogger(this.getClass());
	
	private FileMngDao fileMngDao;
	
	public FileMngService() {
		fileMngDao = new FileMngDao();
	}
	
	public int doInsert(List<FileMngVO> dto) {
		int flag = 0;
		for(FileMngVO vo:dto) {
			int result = fileMngDao.doInsert(vo);
			if(result==1) {
				flag = result;
			}else {
				flag = 0;
				break;
			}
		}
		return flag;
	}
	
	public int doDelete(DTO dto) {
		int flag = fileMngDao.doDelete(dto);
		return flag;
	}
	
	public List<?> doRetrieve(DTO dto) {
		return fileMngDao.doRetrieve(dto);
	}
	
}
