/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.room
 * 클래스명 : StoreService.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-18    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-18 오후 5:23:13
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.room;

import java.util.List;
import org.apache.log4j.Logger;
import com.mal_a.cmn.DTO;

/**
 * @author sist
 *
 */
public class RoomService {

	 private final Logger LOG = Logger.getLogger(this.getClass());
	 
	 private RoomDao roomdao;
	 
	 public RoomService() {
		 roomdao = new RoomDao();
	 }
	

	 public DTO doSelectOne(DTO dto) { 
	      return roomdao.doSelectOne(dto);
	   }
	
	public DTO doSelectOneRoomPrice(DTO dto) { 
	      return roomdao.doSelectOneRoomPrice(dto);
	   }
	   
	   public int doUpdate(DTO dto) {
		   return roomdao.doUpdate(dto);
	   }
	   
	   public int doDelete(DTO dto) {
		   return roomdao.doDelete(dto);
	   }
	   
	   public int doInsert(DTO dto) {
		   return roomdao.doInsert(dto);
	   }
	   
	   public List<?> doRetrieve(DTO dto){
		   return roomdao.doRetrieve(dto);
	   }
	   
	   public List<?> doRetrievePayPossible(DTO dto, DTO dto02){
		   return roomdao.doRetrievePayPossible(dto, dto02);
	   }
	   
	 
}
