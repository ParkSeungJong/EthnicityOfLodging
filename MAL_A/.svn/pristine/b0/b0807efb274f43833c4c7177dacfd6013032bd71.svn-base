/**
 *<pre>
 * Project Name : MAL_A
 * Package Name : com.mal_a.landmark
 * Class Name : LandmarkService.java
 * Description : 
 * Modification Information
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-25    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-25 오후 3:37:38
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.landmark;

import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.DTO;



/**
 * @author sist
 *
 */
public class LandmarkService {

	private final Logger LOG = Logger.getLogger(this.getClass());
	private LandmarkDao landmarkDao ;
	
	public LandmarkService() {
		landmarkDao = new LandmarkDao();
	}
	
	public int doInsert(DTO dto) {
		return landmarkDao.doInsert(dto);
	}
	
	public DTO doSelectOne(DTO dto) {
		LOG.debug("dto: "+dto);
		return landmarkDao.doSelectOne(dto);
	}
	
	public List<?> doRetrieveAdmin(DTO dto) {
		return landmarkDao.doRetrieveAdmin(dto);
	}
	
	public List<?> doRetrieveMember(DTO dto) {
		return landmarkDao.doRetrieveMember(dto);
	}
	
	public int doUpdate(DTO dto) {
		return landmarkDao.doUpdate(dto);
	}
	public int doDelete(DTO dto) {
		return landmarkDao.doDelete(dto);
	}
}
