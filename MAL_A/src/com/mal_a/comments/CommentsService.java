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

package com.mal_a.comments;

import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.board.BoardVO;
import com.mal_a.cmn.DTO;

/**
 * @author sist133
 *
 */
public class CommentsService {
	
	private final Logger LOG = Logger.getLogger(this.getClass());
	
	private CommentsDao commentsDao;
	
	public CommentsService() {
		commentsDao=new CommentsDao();
	}
	
	/**
	 * 
	 *메서드명 : doAdminSelectOne1
	 *작성일 : 2020. 3. 18.
	 *작성자 : sist133
	 *설명 : 관리자 단건조회
	 *@param dto
	 *@return DTO
	 */
	public DTO doAdminSelectOne1(DTO dto) {
		return commentsDao.doAdminSelectOne1(dto);
	}
	
	/**
	 * 
	 *메서드명 : doInsert
	 *작성일 : 2020. 3. 18.
	 *작성자 : sist133
	 *설명 : 사용자 댓글등록
	 *@param dto
	 *@return int
	 */
	 public int doInsert(DTO dto) {
		 return commentsDao.doInsert(dto);
		 
	 }
	 
	 /**
	  * 
	  *메서드명 : doUpdate
	  *작성일 : 2020. 3. 18.
	  *작성자 : sist133
	  *설명 : 사용자 댓글수정
	  *@param dto
	  *@return int
	  */
	 public int doUpdate(DTO dto) {
		 return commentsDao.doUpdate(dto);
	 }
	 
	 /**
	  * 
	  *메서드명 : doViewsUpdate
	  *작성일 : 2020. 3. 18.
	  *작성자 : sist133
	  *설명 : 사용자 뷰수정
	  *@param dto
	  *@return int
	  */
	 public int doViewsUpdate(DTO dto) {
		 return commentsDao.doViewsUpdate(dto);
	 }
	 
	 /**
	  * 
	  *메서드명 : doDelete
	  *작성일 : 2020. 3. 18.
	  *작성자 : sist133
	  *설명 : 사용자 댓글삭제
	  *@param dto
	  *@return int
	  */
	 public int doDelete(DTO dto) {
		 return commentsDao.doDelete(dto);
	 }
	 
	 /**
	  * 
	  *메서드명 : doRetrieveList
	  *작성일 : 2020. 3. 18.
	  *작성자 : sist133
	  *설명 : 사용자 다건조회
	  *@param dto
	  *@return List<?>
	  */
	 public  List<?> doRetrieveList(DTO dto) {
		 LOG.debug("dddddd");
		 return commentsDao.doRetrieveList(dto);
		 
	 }
	 
	 /**
	  * 
	  *메서드명 : doAdminRetrieveList
	  *작성일 : 2020. 3. 18.
	  *작성자 : sist133
	  *설명 : 관리자 다건조회
	  *@param dto
	  *@return List<?>
	  */
	 public  List<?> doAdminRetrieveList(DTO dto) {
		 LOG.debug("dddddd");
		 return commentsDao.doAdminRetrieveList(dto);
		 
	 }
	 
	
}
