<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 2. 26. 오후 12:19:26   sist         최초 생성
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
<%@page session="true"%>
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
	<h2>업체 마이페이지 예약내역</h2>
	<hr/>
	
	<!-- Button -->
	<table border="0" cellpadding="5" cellspacing="0" width="600">
		<tr>
			<td colspan="2" align="right">
				<div>
					<input  type="button"  value="조회" onclick="javascript:doRetrieve();" id="to_list_btn" />
					<input  type="button"  value="취소완료" id="update_cancCmp_btn" />
					<input  type="button"  value="취소요청반송" id="update_pay_btn" />
				</div>
			</td>
		</tr>
	</table>
	<!-- //Button -->
	
	<form action="/MAL_A_PRA/payment/payment.do" name="searchFrm" id="searchFrm" method="get">
		<input type="hidden" name="work_div" />
		<input type="hidden" name="search_div" />
		<input type="hidden" name="search_word" />
		<input type="hidden" name="page_num" />
		<input type="text" name="loginId" id="loginId" value="admin01" />
		<table>
			<thead>
				<tr>
					<th>체크</th>
					<th>예약번호</th>
					<th>방이름</th>
					<th>시작일</th>
					<th>종료일</th>
					<th>결제금액</th>
					<th>예약상태</th>
					<th>결제일</th>
					<th>예약취소요청일</th>
					<th>예약취소완료일</th>
					<th>예약회원ID</th>
				</tr>
			</thead>
			<%
				if(null!=list && list.size()>0){
					for(PaymentVO vo:list){
			%>
			<tr>
				<td><input type="radio" value="<%=vo.getPno() %>" name="radioBtn"/></td>
				<td><%=vo.getPno() %></td>
				<td><%=vo.getRno() %></td>
				<td><%=vo.getStartDt() %></td>
				<td><%=vo.getEndDt() %></td>
				<td><%=vo.getPay() %></td>
				<td><%=vo.getRs() %></td>
				<td><%=vo.getPayDt() %></td>
				<td><%=vo.getCancDt() %></td>
				<td><%=vo.getCancCmpDt() %></td>
				<td><%=vo.getRegId() %></td>
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
		//취소완료
		$("#update_cancCmp_btn").on("click",function(){
			var modId = $("#loginId").val();
			//console.log(modId);
			if(modId==null || modId.trim().length==0){
				alert("로그인 ID를 확인 하세요.");
				return;
			}
			
			var rowData = new Array();
			var tdArr = new Array();
			var radio = $("input[name=radioBtn]:checked");
			
			radio.each(function(i){
				var tr = radio.parent().parent().eq(i);
				var td = tr.children();
				
				rowData.push(tr.text());
				
				var tPno = td.eq(1).text();
				var tMid = td.eq(10).text();
				
				tdArr.push(tPno);
				tdArr.push(tMid);
			});
			var pno = tdArr[0];
			var mid = tdArr[1];
			
			if(false==confirm('예약번호: '+pno+' 을(를)\n취소완료 하시겠습니까?'))return;
			
			//ajax
			$.ajax({
			    type:"POST",
			    url:"/MAL_A_PRA/payment/payment.do",
			    dataType:"html", 
			    data:{"work_div":"do_updateCancCmp",
			    	  "modId":$("#loginId").val(),
			    	  "pno":pno,
			    	  "mid":mid
			    },
			    success:function(data){ //성공
					console.log("data="+data);
					//alert("data:"+data);
					var jData = JSON.parse(data);
					//성공
					if(jData!=null && jData.msgId=="1"){
						alert(jData.msgContents);
						doRetrieve();
					}else{
						alert(jData.msgId+"||"+jData.msgContents);
					}
			    },
			    error:function(xhr,status,error){
					alert("error:"+error);
			    },
			    complete:function(data){
			    
			    }   
		  	});//--ajax
		});
		
		//취소요청반송
		$("#update_pay_btn").on("click",function(){
			var modId = $("#loginId").val();
			//console.log(modId);
			if(modId==null || modId.trim().length==0){
				alert("로그인 ID를 확인 하세요.");
				return;
			}
			var radPno = document.querySelector('input[name="radioPno"]:checked').value;
			//console.log(radPno);
			
			if(false==confirm('예약번호: '+radPno+' 의\n취소요청을 반송 하시겠습니까?'))return;
			
			//ajax
			$.ajax({
			    type:"POST",
			    url:"/MAL_A_PRA/payment/payment.do",
			    dataType:"html", 
			    data:{"work_div":"do_updatePay",
			    	  "modId":$("#loginId").val(),
			    	  "pno":document.querySelector('input[name="radioPno"]:checked').value
			    },
			    success:function(data){ //성공
					console.log("data="+data);
					//alert("data:"+data);
					var jData = JSON.parse(data);
					//성공
					if(jData!=null && jData.msgId=="1"){
						alert(jData.msgContents);
						doRetrieve();
					}else{
						alert(jData.msgId+"||"+jData.msgContents);
					}
			    },
			    error:function(xhr,status,error){
					alert("error:"+error);
			    },
			    complete:function(data){
			    
			    }   
		  	});//--ajax
		});
		
		function doRetrieve(){
			//alert('doRetrieve');
			var frm = document.searchFrm;
			frm.work_div.value = "do_retrieve";
			frm.search_div.value = "2";
			frm.search_word.value = "02_1";
			frm.page_num.value = "1";
			frm.action = '/MAL_A_PRA/payment/payment.do';
			frm.submit();
		}
	</script>
</body>
</html>