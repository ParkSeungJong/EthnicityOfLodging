/**
 *<pre>
 * com.mal_a.landmark
 * Class Name : LandmarkMain.java
 * Description : 관광명소 CURD 메인
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-02-03           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-02-03 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.landmark;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mal_a.cmn.SearchVO;

/**
 * @author sist
 *
 */
public class LandmarkMain {
	private final Logger LOG = Logger.getLogger(LandmarkMain.class);
	
	//Test Data
	private LandmarkVO lkVO01; 
	private LandmarkDao dao;
	
	public LandmarkMain() {
		lkVO01 = new LandmarkVO("0","배고파30","07109","부산시 동구 04번지","051-5555-5560","쩌러연","2","admin05","20/04/05","admin04","20/12/30","20200202_0000100");
		dao = new LandmarkDao();
	}
	
	/**
	 * 
	 *메서드명 : do_insert
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 관광명소 등록
	 *@param sclno
	 *@param scname
	 *@param scaddrno
	 *@param scaddr1
	 *@param scaddr2
	 *@param sctel
	 *@param sccont
	 *@param sccategory
	 *@param scregid
	 *@param scregdt
	 *@param scmodid
	 *@param scmoddt
	 *@param scfileid void
	 */
	public void doInsert(String sclno, String scname, String scaddrno, String scaddr,
			String sctel, String sccont, String sccategory, String scregid) {
		
		lkVO01.setLno(sclno);
		lkVO01.setName(scname);
		lkVO01.setAddrNo(scaddrno);
		lkVO01.setAddr(scaddr);
		lkVO01.setTel(sctel);
		lkVO01.setCont(sccont);
		lkVO01.setCategory(sccategory);
		lkVO01.setRegId(scregid);
				
		
		int mainFlag = dao.doInsert(lkVO01);
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
	
	/**
	 * 
	 *메서드명 : doSelectOne
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 관광명소 단건조회 
	 *@param sclno void
	 */
	 public void doSelectOne(String sclno) {
		    lkVO01.setLno(sclno);
		    LandmarkVO outVO = (LandmarkVO) dao.doSelectOne(lkVO01);
		       
		       LOG.debug("===============");
		      LOG.debug("outVO: "+outVO);
		      LOG.debug("===============");
		    }
		
	   
	   /**
	    * 
	    *메서드명 : doRetrieveAdmin
	    *작성일 : 2020. 2. 23.
	    *작성자 : LG
	    *설명 : 관리자용 다건조회
	    *@param scPgSize
	    *@param scPgNm
	    *@param scScDiv
	    *@param scScWd
	    *@param scScWd02 void
	    */
	   public void doRetrieveAdmin(int scPgSize,int scPgNm,String scScDiv,String scScWd, String scScWd02) {
			SearchVO searchVO = new SearchVO();
			searchVO.setPageSize(scPgSize);
			searchVO.setPageNum(scPgNm);
			searchVO.setSearchDiv(scScDiv);
			searchVO.setSearchWord(scScWd);
	//		searchVO.setSearchWord02(scScWd02);
			
			List<LandmarkVO> list = (List<LandmarkVO>) dao.doRetrieveAdmin(searchVO);
			
			LOG.debug("*************************************************");
			//Data출력
			for(LandmarkVO vo:list) {
				LOG.debug(vo);
			}
			LOG.debug("*************************************************");
		}
	   
	   /**
	    * 
	    *메서드명 : doRetrieveMember
	    *작성일 : 2020. 2. 23.
	    *작성자 : LG
	    *설명 : 회원용 다건조회 
	    *@param scPgSize
	    *@param scPgNm
	    *@param scScDiv
	    *@param scScWd
	    *@param scScWd02 void
	    */
	   public void doRetrieveMember(int scPgSize,int scPgNm,String scScDiv,String scScWd, String scScWd02) {
				SearchVO searchVO = new SearchVO();
				searchVO.setPageSize(scPgSize);
				searchVO.setPageNum(scPgNm);
				searchVO.setSearchDiv(scScDiv);
				searchVO.setSearchWord(scScWd);
				searchVO.setSearchWord02(scScWd02);
				
				List<LandmarkVO> list = (List<LandmarkVO>) dao.doRetrieveMember(searchVO);
				
				LOG.debug("*************************************************");
				//Data출력
				for(LandmarkVO vo:list) {
					LOG.debug(vo);
				}
				LOG.debug("*************************************************");
			}	   
	   
	
		/**
		 * 
		 *메서드명 : doUpdate
		 *작성일 : 2020. 2. 18.
		 *작성자 : sist
		 *설명 : 관광명소 수정
		 *@param scaddrno
		 *@param scaddr1
		 *@param scaddr2
		 *@param sctel
		 *@param sccont
		 *@param scmodid
		 *@param scmoddt
		 *@param scfileid
		 *@param sclno void
		 */
	   public void doUpdate(String scaddrno,String scaddr,String sctel,String sccont,
	             String scmodid,String scfileid,String sclno){
			lkVO01.setAddrNo(scaddrno);
			lkVO01.setAddr(scaddr);
			lkVO01.setTel(sctel);
			lkVO01.setCont(sccont);
			lkVO01.setModId(scmodid);
			lkVO01.setFileId(scfileid);  
			lkVO01.setLno(sclno);
			
			int updateFlag = dao.doUpdate(lkVO01);
			if(updateFlag ==1) {
				LOG.debug("===============");
				LOG.debug("		성공		");
				LOG.debug("===============");
			}else {
				LOG.debug("===============");
				LOG.debug("		실패		");
				LOG.debug("===============");
			}
			LOG.debug("===============================================");
			LOG.debug("delFlag = "+updateFlag);
			LOG.debug("===============================================");
			}
	
	/**
	 * 
	 *메서드명 : doDelete
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 관광명소 삭제
	 *@param sclno void
	 */
	public void doDelete(String sclno) {
		lkVO01.setLno(sclno); 
		int delFlag = dao.doDelete(lkVO01);
		if(delFlag ==1) {
			LOG.debug("===============");
			LOG.debug("		성공		");
			LOG.debug("===============");
		}else {
			LOG.debug("===============");
			LOG.debug("		실패		");
			LOG.debug("===============");
		}
		LOG.debug("===============================================");
		LOG.debug("delFlag = "+delFlag);
		LOG.debug("===============================================");
	}
		
		
	//main
	public static void main(String[] args) {
		LandmarkMain lkTest = new LandmarkMain();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("lno: ");
		String sclno = scanner.next();
		System.out.println("------");
//		
//		System.out.println("name: ");
//		String scname = scanner.next();
//		System.out.println("------");
//		
//		System.out.println("addrno: ");
//		String scaddrno = scanner.next();
//		System.out.println("------");
//
//		
//		System.out.println("addr: ");
//		String scaddr = scanner.next();
//		System.out.println("------");
//		
//		
//		System.out.println("tel: ");
//		String sctel = scanner.next();
//		System.out.println("------");
//		
//		System.out.println("cont: ");
//		String sccont = scanner.next();
//		System.out.println("------");
//		
//		System.out.println("category: ");
//		String sccategory = scanner.next();
//		System.out.println("------");
//		
//		System.out.println("regid: ");
//		String scregid = scanner.next();
//		System.out.println("------");
//		
//		System.out.println("regdt: ");
//		String scregdt = scanner.next();
//		System.out.println("------");
//		
//		System.out.println("modid: ");
//		String scmodid = scanner.next();
//		System.out.println("------");
//		
//		System.out.println("moddt: ");
//		String scmoddt = scanner.next();
//		System.out.println("------");
//		
//		System.out.println("fileid: ");
//		String scfileid = scanner.next();
//		System.out.println("------");
//
//		System.out.println("PageSize: ");
//		int scPgSize = scanner.nextInt();
//		System.out.println("------");
//		
//		System.out.println("PageNumber: ");
//		int scPgNm = scanner.nextInt();
//		System.out.println("------");
//		
//		System.out.println("SearchDiv(관리자-1:지역별,2:카테고리별,3:지역+카테고리/ 회원-1:업체+카테고리): ");
//		String scScDiv = scanner.next();
//		System.out.println("------");
//		
//		System.out.println("SearchWord(관리자-지역번호/ 회원-업체번호): ");
//		String scScWd = scanner.next();
//		System.out.println("------");
//		
//		System.out.println("SearchWord02(카테고리): ");
//		String scScWd02 = scanner.next();
//		System.out.println("------");

		
//		lkTest.doInsert(sclno, scname,scaddrno,scaddr,sctel,sccont,sccategory,scregid);
		lkTest.doDelete(sclno);
//		lkTest.doUpdate(scaddrno,scaddr, sctel, sccont,scmodid,scfileid, sclno);
//		lkTest.doSelectOne(sclno);
//		lkTest.doRetrieve(scPgSize, scPgNm, scScDiv, scScWd, scScWd02);
//		lkTest.doRetrieveAdmin(scPgSize, scPgNm, scScDiv, scScWd, scScWd02);
//		lkTest.doRetrieveMember(scPgSize, scPgNm, scScDiv, scScWd, scScWd02);
				
		
	}//main
	
}
