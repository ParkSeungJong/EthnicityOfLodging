/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.room
 * 클래스명 : RoomServiceMain.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-18    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-18 오후 5:59:40
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.room;

import org.apache.log4j.Logger;

import com.mal_a.room.RoomService;
import com.mal_a.room.RoomVO;
import com.mal_a.room.RoomServiceMain;

/**
 * @author sist
 *
 */
public class RoomServiceMain {

	
	private final Logger LOG = Logger.getLogger(this.getClass());
	private RoomService roomService;
	private RoomVO roomVO01;
	
	public RoomServiceMain() {
		roomService = new RoomService();
		roomVO01 = new RoomVO();
	}
	
//	public void doSelectOne(){
//		roomVO01.setRno("02_2_5");
//		int outVO =  roomService.doSelectOne(roomVO01);
//		
//		LOG.debug("==================");
//		LOG.debug("=outVO="+outVO);
//		LOG.debug("==================");
//		
//	}
	
	/**
	 *메서드명 : main
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 
	 *@param args void
	*/
	public static void main(String[] args) {
		RoomServiceMain roomServiceMain= new RoomServiceMain();
//		roomServiceMain.doSelectOne();

	}

}
