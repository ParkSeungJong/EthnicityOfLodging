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

package com.mal_a.board;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * @author sist133
 *
 */
public class BoardTestServiceMain {
	private final Logger LOG = Logger.getLogger(this.getClass());
	private BoardService boardService;
	private BoardVO boardVO01;
	public BoardTestServiceMain() {
		boardService =new BoardService();
		boardVO01=new BoardVO();
	}
	
	public void doSelectOne(String scBno) {
		boardVO01.setBno(scBno);
		BoardVO outVO =(BoardVO) boardService.doSelectOne(boardVO01);
		LOG.debug("===============================");
		LOG.debug("outVO="+outVO);
		LOG.debug("===============================");
	}
	public static void main(String[] args) {
		BoardTestServiceMain boardTestServiceMain=new BoardTestServiceMain();
		Scanner sc = new Scanner(System.in);
		
		  System.out.println("bno : ");
	      String scBno = sc.next();
	      
		boardTestServiceMain.doSelectOne(scBno);

	}

}
