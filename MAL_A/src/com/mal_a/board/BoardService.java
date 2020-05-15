/**
 *<pre>
 * com.hr.board
 * Class Name : BoardService.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-02-06           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-02-06 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */

package com.mal_a.board;

import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.DTO;

/**
 * @author sist133
 *
 */
public class BoardService {
	
	private final Logger LOG = Logger.getLogger(this.getClass());
	private BoardDao boardDao;
	
	public BoardService() {
		boardDao=new BoardDao();
	}
	
	
	public DTO doSelectOne(DTO dto) {
		//조회Count증가
		int readCnt = boardDao.readCount(dto);
		LOG.debug("#####조회수증가!!#######");
		
		//단건조회
		return boardDao.doSelectOne(dto);
		
	}
	
	public DTO doAdminSelectOne(DTO dto) {
		//조회Count증가
		int readCnt = boardDao.readCount(dto);
		LOG.debug("#####조회수증가!!#######");
		
		//단건조회
		return boardDao.doAdminSelectOne(dto);
		
	}
	 //뷰 업데이트
	 public int doViewsUpdate(DTO dto) {
		 return boardDao.doViewsUpdate(dto);
	 }
	//게시글 등록
	 public int doInsert(DTO dto) {
		 return boardDao.doInsert(dto);
		 
	 }
	 //게시글 수정
	 public int doUpdate(DTO dto) {
		 return boardDao.doUpdate(dto);
	 }
	 
	 
	 //게시글 삭제
	 public int doDelete(DTO dto) {
		 return boardDao.doDelete(dto);
	 }
	 
	 public int doAdminDelete(DTO dto) {
		 return boardDao.doAdminDelete(dto);
	 }
	 
	 //게시글 다건조회
	 public List<?> doRetrieve(DTO dto) {
		 return boardDao.doRetrieve(dto);
	 }
	 //관리자 게시글 다건조회
	 public List<?> doAdminRetrieve(DTO dto) {
		 return boardDao.doAdminRetrieve(dto);
	 }
	
}
