/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.member
 * 클래스명 : MemberServiceMain.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-06    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-06 오후 5:31:45
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.member;

import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.SearchVO;

/**
 * @author SIST
 *
 */
public class MemberTestServiceMain {
	private MemberService memberService;
	private MemberVO memberVO;
	private SearchVO searchVO;
	
	
	public MemberTestServiceMain() {
		memberService = new MemberService();
		searchVO = new SearchVO();
		memberVO = new MemberVO();
		
	}
	
	private final Logger LOG = Logger.getLogger(MemberTestServiceMain.class);
	
	public void doRetrieve() {
		searchVO.setPageSize(10);
		searchVO.setPageNum(1);
		List<MemberVO> list = (List<MemberVO>) memberService.doRetrieve(searchVO);
	
		LOG.debug("********************************");
		for(MemberVO vo:list) {
			LOG.debug(vo);
		}
		LOG.debug("********************************");
		
	}

	
	/**
	 *@Method Name:main
	 *@작성일: 2020. 2. 7.
	 *@작성자: SIST
	 *@설명:
	 *@param args
	*/

	public static void main(String[] args) {
		MemberTestServiceMain main = new MemberTestServiceMain();
		//main.doRetrieve();

	}

}
