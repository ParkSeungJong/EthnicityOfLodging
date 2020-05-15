/**
 *<pre>
 * com.hr.board
 * Class Name : BoardTestServiceMain.java
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

import org.apache.log4j.Logger;

/**
 * @author sist133
 *
 */
public class CommentsTestServiceMain {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private CommentsService boardService;
	private CommentsVO boardVO01;
	public CommentsTestServiceMain() {
		boardService =new CommentsService();
		//boardVO01=new BoardVO(99,"ㅎㅎ","입니다",0,"admin","등록일","admin","수정일");
	}
	

	public static void main(String[] args) {
		CommentsTestServiceMain boardTestServiceMain=new CommentsTestServiceMain();


	}

}
