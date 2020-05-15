/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.store
 * 클래스명 : StoreServiceMain.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-06    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-06 오후 10:25:01
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.store;

import org.apache.log4j.Logger;

import com.mal_a.store.StoreServiceMain;
import com.mal_a.store.StoreService;
import com.mal_a.store.StoreVO;

/**
 * @author sist
 *
 */
public class StoreServiceMain {

	private final Logger LOG = Logger.getLogger(this.getClass());
	private StoreService storeService;
	private StoreVO storeVO01;
	
	public StoreServiceMain() {
		storeService = new StoreService();
		storeVO01 = new StoreVO();
	}
	
	public void doSelectOne(){
		storeVO01.setSno("0332154");
		//int outVO =  storeService.doSelectOne(storeVO01);
		
		LOG.debug("==================");
		//LOG.debug("=outVO="+outVO);
		LOG.debug("==================");
		
	}
	
	/**
	 *메서드명 : main
	 *작성일 : 2020. 2. 6.
	 *작성자 : sist
	 *설명 : 
	 *@param args void
	*/
	public static void main(String[] args) {
		
		StoreServiceMain storeServiceMain= new StoreServiceMain();
		storeServiceMain.doSelectOne();

	}

}
