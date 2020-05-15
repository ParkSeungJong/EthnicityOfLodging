<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 2. 24.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.mal_a.cmn.StringUtil"%>
<%@page import="com.mal_a.code.CodeVO"%>
<%@page import="com.mal_a.cmn.SearchVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    errorPage="/cmn/error.jsp"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %> 
 <%
 	
//param
	String pageNum    ="1";//페이지 넘버
	String searchDiv  = "";//검색구분
	String searchWord ="";//검색어
	String pageSize   ="10";//페이지 사이즈

	SearchVO inVO= (SearchVO)request.getAttribute("paramVO");
	if(null !=inVO){
		LOG.debug("===========");
		LOG.debug("=inVO="+inVO);
		LOG.debug("===========");
		pageNum    = String.valueOf(inVO.getPageNum());
		searchDiv  = inVO.getSearchDiv();
		searchWord = inVO.getSearchWord();
		pageSize   = String.valueOf(inVO.getPageSize());
	}
 
	List<CodeVO> searchList = (List<CodeVO>)request.getAttribute("searchList");
 	List<CodeVO> list = (List<CodeVO>)request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>숙박의 민족 - MAL_A</title>
</head>
<body>


		<form name="list_sto_option_list" action="/MAL_A/roxandrea/sto_option_list.do"  method="post">	
		 <table ID="listTable">
			<thead>
				<tr>
					<th>Keywords</th>
				</tr>
			</thead>
			<tbody>
			
				<%
					if(null !=list && list.size()>0){
						for(CodeVO vo:list){
				%>		
						<tr>
						<td>
						<input type="checkbox" id="option" name="option" value="<%=vo.getDtlId() %>" /><font size="4" id="<%=vo.getDtlId() %>"><%=vo.getDtlNm() %></font>
						</td>
						</tr>
				<%
					    }//for
					}else{	
				%>
						<tr>
							<td colspan="99">No data found</td>
						</tr>
				<%
					}
				%>
	
			</tbody>
		</table>
				 <center>
					<!-- Button -->
					<div>
						
						<input  type="button" value="확인"  class="btn-custom px-3 py-2" onclick="javascript:moveToSave();" id="insert_btn" />
						<input  type="button" value="닫기"  class="btn-custom px-3 py-2" onclick="javascript:moveToSave2();" id="close_btn" />
					</div>
					<!-- //Button -->
			 	</center>
			 	
		</form>
		
    
    <script type="text/javascript">
	
	function doRetrieve(){
		//alert('doRetrieve');
		var frm = document.searchFrm;
		frm.work_div.value = "do_retrieve";
		frm.action = '/roxandrea/sto_option_list.do';
		frm.submit();
	}
	
	function moveToSave(){
		//alert('moveToSave');
		if(false==confirm('메인 화면으로 이동 하시겠습니까?'))return;
		

		var arr = new Array();
		var optionText ="";
		
		$('#option:checked').each(function() { 
			arr.push($(this).val());
			optionText += $("#"+$(this).val()).html();
			
	   });
		
	
		$(opener.document).find("#options").val(arr); 
		$(opener.document).find("#options1").val(optionText); 
		$(opener.document).find("#optionText").val(optionText);
		opener.btnClick();
		
	}
	
	function moveToSave2(){
		if(false==confirm('메인 화면으로 이동 하시겠습니까?'))return;
		opener.btnClick2();
	}
	
</script>
<script src="../roxandrea/js/jquery.min.js"></script>
</body>
</html>


