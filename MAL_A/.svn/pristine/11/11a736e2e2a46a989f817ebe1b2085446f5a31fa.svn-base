/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.roomoption
 * 클래스명 : RoomOptionTestMain.java
 * 설명 : RoomOption CRUD Main
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-06    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-06 오후 5:45:21
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */

package com.mal_a.roomoption;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mal_a.cmn.SearchVO;

/**
 * @author sist
 *
 */
public class RoomOptionTestMain {
	private final Logger LOG = Logger.getLogger(RoomOptionTestMain.class);
	
	//Test Data
	private RoomOptionVO ROVO01 = new RoomOptionVO();
	private RoomOptionDao dao;
	
	public RoomOptionTestMain() {
		dao = new RoomOptionDao();
	}
	
	/**
	 * 
	*@Method Name:doInsert
	*@작성일: 2020. 2. 18.
	*@작성자: sist
	*@설명: 방 옵션 등록
	*@param scRNO void
	 */
	public void doInsert(String scRNO,String[] scYNList) {
		for(int i=0;i<scYNList.length;i++) {
			ROVO01.setRno(scRNO);
			ROVO01.setOpt(Integer.toString(i+1));
			ROVO01.setYn(scYNList[i]);
			
			int mainFlag=dao.doInsert(ROVO01);
			if(mainFlag ==1) {
				LOG.debug("===============");
				LOG.debug("		성공		");
				LOG.debug("===============");
			}else {
				LOG.debug("===============");
				LOG.debug("		실패		");
				LOG.debug("===============");
			
			}
		}
	}
	

	/**
	 * 
	*@Method Name:doRetrieve
	*@작성일: 2020. 2. 18.
	*@작성자: sist
	*@설명: 방 옵션 다건조회
	*@param scPgSize
	*@param scPgNm
	*@param scScWd void
	 */
	public void doRetrieve(int scPgSize,int scPgNm,String scScDiv,String scScWd ) {
		SearchVO searchVO = new SearchVO();
		searchVO.setPageSize(scPgSize);
		searchVO.setPageNum(scPgNm);
		searchVO.setSearchDiv(scScDiv);
		searchVO.setSearchWord(scScWd);
		
		List<RoomOptionVO> list = (List<RoomOptionVO>) dao.doRetrieve(searchVO);
		
		LOG.debug("*************************************************");
		//Data출력
		for(RoomOptionVO vo:list) {
			LOG.debug(vo);
		}
		LOG.debug("*************************************************");
	}
	
	/**
	 * 
	*@Method Name:doDelete
	*@작성일: 2020. 2. 19.
	*@작성자: sist
	*@설명: 방 옵션/옵션 번호에 따른 삭제
	*@param scRNO void
	 */
	public void doDelete(String scRNO) {
		ROVO01.setRno(scRNO); 
		int delFlag = dao.doDelete(ROVO01);
		LOG.debug("delFlag="+delFlag);
		if(delFlag ==1) {
			LOG.debug("===============");
			LOG.debug("		성공		");
			LOG.debug("===============");
		}else {
			LOG.debug("===============");
			LOG.debug("		실패		");
			LOG.debug("===============");
		}
	}
  
	//main
	public static void main(String[] args) {
		RoomOptionTestMain roTest = new RoomOptionTestMain();
		Scanner scanner = new Scanner(System.in);
		
		String[] scYNList = {"0","1","1","0","0","1",};
		
		System.out.println("RNO: ");
		String scRNO = scanner.next();
		System.out.println("------");
//		
//		System.out.println("OPT: ");
//		int scOPT = scanner.nextInt();
//		System.out.println("------");
//		
//		System.out.println("YN: ");
//		int scYN = scanner.nextInt();
//		System.out.println("------");
		
		System.out.println("PageSize: ");
		int scPgSize = scanner.nextInt();
		System.out.println("------");
		
		System.out.println("PageNumber: ");
		int scPgNm = scanner.nextInt();
		System.out.println("------");
		
		System.out.println("SearchDiv(1:rno): ");
		String scScDiv = scanner.next();
		System.out.println("------");
		
		System.out.println("SearchWord(rno): ");
		String scScWd = scanner.next();
		System.out.println("------");


		
//		roTest.doInsert(scRNO,scYNList);
		roTest.doRetrieve(scPgSize, scPgNm,scScDiv,scScWd);
//		roTest.doDelete(scRNO);
		
		
	}//main
	
}
