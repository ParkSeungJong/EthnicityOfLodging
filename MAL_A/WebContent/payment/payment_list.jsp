<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 2. 26. 오전 10:11:37   sist         최초 생성
  *
  * author 쌍용교육센터 E반
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.mal_a.cmn.SearchVO"%>
<%@page import="com.mal_a.payment.PaymentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %>
<%
//req.setAttribute("list", list);//목록
//req.setAttribute("paramVO", inVO);//파람
//req.setAttribute("totalCnt", totalCnt);//총글수
	//param
	String searchDiv  = "";//검색구분
	String searchWord = "";//검색어
	String pageNum 	  = "1";//페이지 넘버
	String pageSize   = "10";//페이지 사이즈
	
	SearchVO inVO = (SearchVO)request.getAttribute("paramVO");
	if(inVO!=null){
		LOG.debug("===============");
		LOG.debug("=inVO="+inVO);
		LOG.debug("===============");
		searchDiv = inVO.getSearchDiv();
		searchWord = inVO.getSearchWord();
		pageNum = String.valueOf(inVO.getPageNum());
		pageSize = String.valueOf(inVO.getPageSize());
	}

	List<PaymentVO> list = (List<PaymentVO>)request.getAttribute("list");
	for(PaymentVO vo :list) {
		//out.print(vo+"<br>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<script  src="https://code.jquery.com/jquery-2.2.4.js"></script>
<style type="text/css">
	body {
		font-family: Arial, Verdana, sans-serif;
		color: #111111;}
	table {
		width: 90%;}
	th, td {
		padding: 7px 10px 10px 10px;}
	th {
		text-transform: uppercase;
		letter-spacing: 0.1em;
		font-size: 90%;
		border-bottom: 2px solid #111111;
		border-top: 1px solid #999;
		text-align: left;}
	tr.even {
		background-color: #efefef;}
	tr:hover {
		background-color: #c3e6e5;}
	.money {
		text-align: right;}
	select { width: 200px; /* 원하는 너비설정 */
		padding: .5em .3em; /* 여백으로 높이 설정 */ 
		font-family: inherit; /* 폰트 상속 */ 
		border: 1px solid #999; 
		border-radius: 0px; /* iOS 둥근모서리 제거 */  
		appearance: none; }
	input[type="text"], input[type="password"] { 
		height: auto; /* 높이 초기화 */ 
		line-height: normal; /* line-height 초기화 */
		padding: .5em .3em; /* 여백 설정 */ }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>예약 내역</h2>
	<hr/>
	
	<!-- Button -->
	<div>
		<input  type="button"  value="조회" onclick="javascript:doRetrieve();" id="to_list_btn" />
	</div>
	<!-- //Button -->
	
	<form action="/MAL_A/payment/payment.do" name="searchFrm" id="searchFrm" method="get">
		<input type="hidden" name="work_div" />
		<input type="hidden" name="page_num" />
		
		<!-- 검색 -->
		<table>
			<tr>
				<td>
					<div>구분
						<select name="search_div" id="search_div">
							<option value="">전체</option>
							<option value="1" <%if(searchDiv.equals("1"))out.print("selected"); %> >등록자ID</option>
							<option value="2" <%if(searchDiv.equals("2"))out.print("selected"); %> >업체번호</option>
						</select>
						<input type="text" name="search_word" id="search_word" />
						<select name="page_size" id="page_size">
							<option value="10" <%if(pageSize.equals("10"))out.print("selected"); %> >10</option>
							<option value="50" <%if(pageSize.equals("50"))out.print("selected"); %> >50</option>
							<option value="100" <%if(pageSize.equals("100"))out.print("selected"); %> >100</option>
							<option value="200" <%if(pageSize.equals("200"))out.print("selected"); %> >200</option>
						</select>
					</div>
				</td>
			</tr>
		</table>
		<!-- //검색 -->
		
		<table>
			<thead>
				<tr>
					<th>예약번호</th>
					<th>시작일</th>
					<th>종료일</th>
					<th>결제금액</th>
					<th>결제일</th>
					<th>사용포인트</th>
					<th>적립포인트</th>
					<th>예약상태</th>
					<th>구매확정일</th>
					<th>예약취소요청일</th>
					<th>예약취소완료일</th>
					<th>등록자ID</th>
					<th>업체명</th>
					<th>방이름</th>
				</tr>
			</thead>
				<%
					if(null!=list && list.size()>0){
						for(PaymentVO vo:list){
				%>
					<tr>
						<td><%=vo.getPno() %></td>
						<td><%=vo.getStartDt() %></td>
						<td><%=vo.getEndDt() %></td>
						<td><%=vo.getPay() %></td>
						<td><%=vo.getPayDt() %></td>
						<td><%=vo.getUsePoint() %></td>
						<td><%=vo.getSavePoint() %></td>
						<td><%=vo.getRs() %></td>
						<td><%=vo.getPayCmpDt() %></td>
						<td><%=vo.getCancDt() %></td>
						<td><%=vo.getCancCmpDt() %></td>
						<td><%=vo.getRegId() %></td>
						<td><%=vo.getSno() %></td>
						<td><%=vo.getRno() %></td>
					</tr>
				<%		
						}
					}else{
				%>
					<tr>
						<td colspan="99">No data found</td>
					</tr>
				<%
					}
				%>
			<tbody>
			</tbody>
		</table>
	</form>
	<script type="text/javascript">
		function doRetrieve(){
			//alert('doRetrieve');
			var frm = document.searchFrm;
			frm.work_div.value = "do_retrieve";
			frm.page_num.value = "1";
			frm.action = '/MAL_A/payment/payment.do';
			frm.submit();
		}
		
		$("#search_word").keypress(function(e){
			//console.log('#search_word');
			//alert('#search_word');
			//Enter Key 13
			if(e.which==13){
				doRetrieve();
			}
		});
	</script>
</body>
</html>