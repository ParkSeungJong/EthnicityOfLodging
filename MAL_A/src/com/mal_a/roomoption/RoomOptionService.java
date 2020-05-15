/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.roomoption
 * 클래스명 : RoomOptionService.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-03-09    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-03-09 오후 3:14:39
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.roomoption;

import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.DTO;
import com.mal_a.stooption.StoOptionVO;

/**
 * @author sist
 *
 */
public class RoomOptionService {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private RoomOptionDao roomOptDao;
	
	public RoomOptionService() {
		roomOptDao = new RoomOptionDao();
	}
	
	public int doInsert(List<RoomOptionVO> dto) {
		int flag = 0;
		for(RoomOptionVO vo:dto) {
			int result = roomOptDao.doInsert(vo);
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
		return roomOptDao.doDelete(dto);
	}
	
	public List<?> doRetrieve(DTO dto) {
		return roomOptDao.doRetrieve(dto);
	}
	
	public List<?> doRetrievePossibleRoomOpt(DTO dto) {
		return roomOptDao.doRetrievePossibleRoomOpt(dto);
	}
}
