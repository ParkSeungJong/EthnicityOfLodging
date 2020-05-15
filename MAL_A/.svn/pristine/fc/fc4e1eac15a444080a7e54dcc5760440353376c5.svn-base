/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.filemng
 * 클래스명 : FileMngTestMain.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-17    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-17 오후 6:04:36
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.filemng;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mal_a.cmn.SearchVO;
import com.mal_a.payment.PaymentTestMain;

/**
 * @author sist
 *
 */
public class FileMngTestMain {

	private final Logger LOG = Logger.getLogger(PaymentTestMain.class);
	
	private FileMngVO fileMngVO01 = new FileMngVO();
	private FileMngDao fileMngDao;
	
	public FileMngTestMain() {
		fileMngDao = new FileMngDao();
	}
	
	/**
	 * 
	 *메서드명 : doInsert
	 *작성일 : 2020. 2. 17.
	 *작성자 : sist
	 *설명 : 첨부파일 최초 인서트 메서드
	 *@param scOrgNm
	 *@param scSaveNm
	 *@param scOrgPath
	 *@param scFileSize
	 *@param scExt
	 *@param scFilePart
	 *@param scRegId void
	 */
	public void doInsert(String scOrgNm, String scSaveNm, String scOrgPath, String scFileSize, String scExt, String scFilePart, String scRegId) {
		fileMngVO01.setOrgNm(scOrgNm);
		fileMngVO01.setSaveNm(scSaveNm);
		fileMngVO01.setSavePath(scOrgPath);
		//fileMngVO01.setFileSize(scFileSize);
		fileMngVO01.setExt(scExt);
		fileMngVO01.setFilePart(scFilePart);
		fileMngVO01.setRegId(scRegId);
		int mainFlag = fileMngDao.doInsert(fileMngVO01);
		if(mainFlag==1) {
			LOG.debug("=====================");
			LOG.debug("성공");
			LOG.debug("=====================");
		}else {
			LOG.debug("=====================");
			LOG.debug("실패");
			LOG.debug("=====================");
		}
	}
	
	/**
	 * 
	 *메서드명 : doInsertAdd
	 *작성일 : 2020. 2. 17.
	 *작성자 : sist
	 *설명 : 첨부파일 추가 인서트 메서드
	 *@param scFileId
	 *@param scSeq
	 *@param scOrgNm
	 *@param scSaveNm
	 *@param scOrgPath
	 *@param scFileSize
	 *@param scExt
	 *@param scFilePart
	 *@param scRegId void
	 */
	public void doInsertAdd(String scFileId, String scSeq, String scOrgNm, String scSaveNm, String scOrgPath, String scFileSize, String scExt, String scFilePart, String scRegId) {
		fileMngVO01.setOrgNm(scFileId);
		//fileMngVO01.setSeq(scSeq);
		fileMngVO01.setOrgNm(scOrgNm);
		fileMngVO01.setSaveNm(scSaveNm);
		fileMngVO01.setSavePath(scOrgPath);
		//fileMngVO01.setFileSize(scFileSize);
		fileMngVO01.setExt(scExt);
		fileMngVO01.setFilePart(scFilePart);
		fileMngVO01.setRegId(scRegId);
		int mainFlag = fileMngDao.doInsertAdd(fileMngVO01);
		if(mainFlag==1) {
			LOG.debug("=====================");
			LOG.debug("성공");
			LOG.debug("=====================");
		}else {
			LOG.debug("=====================");
			LOG.debug("실패");
			LOG.debug("=====================");
		}
	}
	
	/**
	 * 
	 *메서드명 : doSelectOne
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 첨부파일 대표(seq = 1) 1건만 출력 메서드
	 *@param scFileId void
	 */
	public void doSelectOne(String scFileId) {
		fileMngVO01.setFileId(scFileId);
		FileMngVO outVO = (FileMngVO) fileMngDao.doSelectOne(fileMngVO01);
		LOG.debug("=====================");
		LOG.debug("outVO:"+outVO);
		LOG.debug("=====================");
	}
	
	/**
	 * 
	 *메서드명 : doDelete
	 *작성일 : 2020. 2. 17.
	 *작성자 : sist
	 *설명 : 첨부파일 fileid 해당건 전체 삭제 메서드
	 *@param scFileId void
	 */
	public void doDelete(String scFileId) {
		fileMngVO01.setFileId(scFileId);
		int delFlag = fileMngDao.doDelete(fileMngVO01);
		LOG.debug("delFlag="+delFlag);
		if(delFlag==1) {
			LOG.debug("=====================");
			LOG.debug("성공");
			LOG.debug("=====================");
		}else {
			LOG.debug("=====================");
			LOG.debug("실패");
			LOG.debug("=====================");			
		}
	}
	
	/**
	 * 
	 *메서드명 : doDeleteSeq
	 *작성일 : 2020. 2. 17.
	 *작성자 : sist
	 *설명 : 첨부파일 fileid 과 seq 해당건 삭제 메서드
	 *@param scFileId
	 *@param scSeq void
	 */
	public void doDeleteSeq(String scFileId, String scSeq) {
		fileMngVO01.setFileId(scFileId);
		//fileMngVO01.setSeq(scSeq);
		int delFlag = fileMngDao.doDeleteSeq(fileMngVO01);
		LOG.debug("delFlag="+delFlag);
		if(delFlag==1) {
			LOG.debug("=====================");
			LOG.debug("성공");
			LOG.debug("=====================");
		}else {
			LOG.debug("=====================");
			LOG.debug("실패");
			LOG.debug("=====================");			
		}
	}
	
	/**
	 * 
	 *메서드명 : doRetrieve
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 첨부파일 파일ID별, 파일생성페이지 별 셀렉트 리스트 메서드
	 *@param scPageSize
	 *@param scPageNum
	 *@param scSearchDiv
	 *@param scSearchWord void
	 */
	public void doRetrieve(int scPageSize, int scPageNum, String scSearchDiv, String scSearchWord) {
		SearchVO searchVO = new SearchVO();
		searchVO.setPageSize(scPageSize);
		searchVO.setPageNum(scPageNum);
		searchVO.setSearchDiv(scSearchDiv);
		searchVO.setSearchWord(scSearchWord);
		List<FileMngVO> list = (List<FileMngVO>) fileMngDao.doRetrieve(searchVO);
		LOG.debug("************************************************");
		for(FileMngVO vo:list) {
			LOG.debug(vo);
		}
		LOG.debug("************************************************");
	}
	
	/**
	 *메서드명 : main
	 *작성일 : 2020. 2. 17.
	 *작성자 : sist
	 *설명 : 
	 *@param args void
	*/
	public static void main(String[] args) {
		FileMngTestMain fmt = new FileMngTestMain();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("파일ID(20200217_1):");
		String scFileId = sc.next();
		
//		System.out.println("순번:");
//		String scSeq = sc.next();
//		
//		System.out.println("원본파일명(256):");
//		String scOrgNm = sc.next();
//		
//		System.out.println("저장파일명(256):");
//		String scSaveNm = sc.next();
//		
//		System.out.println("저장경로(256):");
//		String scOrgPath = sc.next();
//		
//		System.out.println("사이즈(number 12):");
//		String scFileSize = sc.next();
//		
//		System.out.println("확장자(4):");
//		String scExt = sc.next();
//		
//		System.out.println("파일파트(1):");
//		String scFilePart = sc.next();
//		
//		System.out.println("등록자아이디:");
//		String scRegId = sc.next();
		
//		System.out.println("page size : ");
//		int scPageSize = sc.nextInt();
//		
//		System.out.println("page num : ");
//		int scPageNum = sc.nextInt();
//		
//		System.out.println("searchdiv : 1(파일ID 검색) or 2(파일생성페이지 검색)");
//		String scSearchDiv = sc.next();
//		
//		System.out.println("searchword(div: 1->20200202_1, 2->1,2,3,4 : ");
//		String scSearchWord = sc.next();
		
//		fmt.doInsert(scOrgNm, scSaveNm, scOrgPath, scFileSize, scExt, scFilePart, scRegId);
//		fmt.doInsertAdd(scFileId, scSeq, scOrgNm, scSaveNm, scOrgPath, scFileSize, scExt, scFilePart, scRegId);
		fmt.doSelectOne(scFileId);
//		fmt.doDelete(scFileId);
//		fmt.doDeleteSeq(scFileId, scSeq);
//		fmt.doRetrieve(scPageSize, scPageNum, scSearchDiv, scSearchWord);
	}

}
