<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 2. 25. 오후 6:15:47   sist         최초 생성
  *
  * author 쌍용교육센터 E반
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.mal_a.payment.PaymentVO"%>
<%@page import="com.mal_a.room.RoomVO"%>
<%@page import="com.mal_a.member.MemberVO"%>
<%@page import="com.mal_a.payment.PaymentCont"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/cmn/common.jsp" %>
<%
	PaymentVO paymentVO = (PaymentVO)request.getAttribute("paymentVO");
	request.setAttribute("pay", paymentVO.getPay());
%>
<c:url value="/roxandrea/member.do" var="logOut">
 <c:param name="workDiv" value="doLogout"></c:param>	
</c:url>

<c:url value="/roxandrea/member.do" var="myPage">
 <c:param name="workDiv" value="doSelectOne"></c:param>
</c:url>

<c:url value="/roxandrea/board.do" var="hrUrl">
 <c:param name="workDiv" value="doRetrieve"></c:param>
</c:url>
<!DOCTYPE html>
<html lang="en">
<head>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" ></script>
<title>숙박의 민족 - MAL_A</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
	<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700,700i" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">
    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="member_main.jsp">숙박의민족</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
	      	</button>
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
	          	  <li class="nav-item"><a href="/MAL_A/roxandrea/store_search.jsp" class="nav-link">업체검색</a></li>
		          <li class="nav-item"><a href="${hrUrl}" class="nav-link">자유게시판</a></li>
		          <li class="nav-item"><a href="${myPage}" class="nav-link">마이페이지</a></li>
				  <li class="nav-item"><a href="${logOut}" class="nav-link" onclick="if(false == confirm('로그아웃 하시겠습니까?')){return false;}">로그아웃</a></li>
	        	</ul>
	      	</div>
		</div>
	</nav>
    <!-- END nav -->
    
	<div class="hero-wrap" style="background-image: url('images/bg_1.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
          		<div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          			<div class="text">
	            		<p class="breadcrumbs mb-2"><span>PAYMENT</span></p>
	            		<h1 class="mb-4 bread">THANKS</h1>
            		</div>
          		</div>
        	</div>
		</div>
	</div>
	
	<section class="ftco-section">
		
		<form name="paymentFrm" action="<%=HR_PATH %>/roxandrea/payment.do" method="post">
	    	<input type="hidden" name="workDiv" id="workDiv" value="doInsert" />
			<div class="container">
				<div class="row justify-content-center mb-5 pb-3">
	          		<div class="col-md-7 heading-section text-center ftco-animate">
	          			<span class="subheading">Payment_SelectOne</span>
	            		<h2>결제 확인</h2>
	            	</div>
	            </div>
			</div>
			
			<!-- 결제 완료 확인란 -->
			<div class="container">    			
				<div class="row justify-content-center mb-5 pb-3">			
					<div class="wrap bg-white align-self-stretch py-3 px-4">			
						<div class="col-md-30 room-single mt-30 mb-30 ftco-animate">
							<div class="d-md-flex mt-10 mb-10 py-5">
								<table>
									<thead>
									</thead>
									<tbody>
										<tr>
											<td>예약번호: </td>
											<td><%=paymentVO.getPno() %></td>
										</tr>
										<tr>
											<td>결제일: </td>
											<td><%=paymentVO.getRegDt() %></td>
										</tr>
										<tr>
											<td>업체명: </td>
											<td><%=paymentVO.getSno() %></td>
										</tr>
										<tr>
											<td>방이름: </td>
											<td><%=paymentVO.getRno() %></td>
										</tr>
										<tr>
											<td>예약시작일: </td>
											<td><%=paymentVO.getStartDt() %></td>
										</tr>
										<tr>
											<td>예약종료일: </td>
											<td><%=paymentVO.getEndDt() %></td>
										</tr>
										<tr>
											<td>결제금액: </td>
											<td><fmt:formatNumber value="${pay }" pattern="#,###" />원</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //결제 완료 확인란 -->
			
			<!-- 버튼 -->
			<div class="container">    			
				<div class="row justify-content-center mb-5 pb-3">			
					<div class="wrap bg-white align-self-stretch py-3 px-4">			
						<div class="col-md-30 room-single mt-30 mb-30 ftco-animate">
							<div class="d-md-flex mt-10 mb-10 py-5">
								<input type="button" value="업체검색" onclick="javascript:goStoreSearch();"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //버튼 -->
			
			
        
    </section>

<%@ include file="/cmn/footer.jsp" %>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/jquery.mb.YTPlayer.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <!-- // <script src="js/jquery.timepicker.min.js"></script> -->
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
  <script type="text/javascript">
  	//업체 검색 페이지 이동
  	function goStoreSearch(){
  		window.location.href='/MAL_A/roxandrea/store_search.jsp';
  	}
  
  	//뒤로가기
  	function goBack(){
  		history.go(-1);
  	}
  	
  </script>
</html>