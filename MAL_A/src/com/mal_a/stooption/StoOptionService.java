
package com.mal_a.stooption;
import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.DTO;
import com.mal_a.filemng.FileMngVO;

public class StoOptionService {
	private final Logger LOG = Logger.getLogger(StoOptionService.class);
	private StoOptionDao stoOptionDao;
	
	public StoOptionService() {
		stoOptionDao = new StoOptionDao();
	}
	
	public DTO doSelectOne(DTO dto) {
		return stoOptionDao.doSelectOne(dto);
	}
	
	public int doInsert(List<StoOptionVO> dto) {
		int flag = 0;
		for(StoOptionVO vo:dto) {
			int result = stoOptionDao.doInsert(vo);
			if(result==1) {
				flag = result;
			}else {
				flag = 0;
				break;
			}
		}
		return flag;
	}
	
	public int doUpdate(DTO dto) {
		return stoOptionDao.doUpdate(dto);
	}
	
	public int doDelete(DTO dto) {
		return stoOptionDao.doDelete(dto);
	}
	
	public List<?> doRetrieve(DTO dto) {
		return stoOptionDao.doRetrieve(dto);
	}
	
	public List<?> doRetrievePossibleStoOpt(DTO dto) {
		return stoOptionDao.doRetrievePossibleStoOpt(dto);
	}
}