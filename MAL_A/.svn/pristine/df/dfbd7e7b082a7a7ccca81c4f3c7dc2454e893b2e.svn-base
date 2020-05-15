/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.store
 * 클래스명 : StoreService.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-06    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-06 오후 9:52:19
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.store;

import java.util.List;
import org.apache.log4j.Logger;
import com.mal_a.cmn.DTO;

/**
 * @author sist
 *
 */
public class StoreService {

	 private final Logger LOG = Logger.getLogger(this.getClass());
	 
	 private StoreDao storedao;
	 
	 public StoreService() {
		 storedao = new StoreDao();
	 }
	

	public DTO doSelectOne(DTO dto) { 
	      return storedao.doSelectOne(dto);
	   }
	   
	   public int doUpdate(DTO dto) {
		   return storedao.doUpdate(dto);
	   }
	   
	   public int doUpdateViews(DTO dto) {
		   return storedao.doUpdateViews(dto);
	   }
	   
	   public int doDelete(DTO dto) {
		   return storedao.doDelete(dto);
	   }
	   
	   public int doInsert(DTO dto) {
		   return storedao.doInsert(dto);
	   }
	   
	   public List<?> doRetrieve(DTO dto){
		   return storedao.doRetrieve(dto);
	   }
	   public List<?> doStoreRetrieve(DTO dto, DTO dto02){
		   return storedao.doStoreRetrieve(dto, dto02);
	   }
	 
}
