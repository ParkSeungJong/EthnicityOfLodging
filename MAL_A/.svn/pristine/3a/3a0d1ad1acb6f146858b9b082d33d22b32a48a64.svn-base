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
<%@page import="com.mal_a.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<!-- OPTION 에 따른 업체들 나열식필요 -->
  <head>
    <title>숙박의 민족 - MAL_A</title>
    <meta charset="utf-8">
    <script  src="https://code.jquery.com/jquery-2.2.4.js"></script>
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
	      <a class="navbar-brand" href="index.html">숙박의민족</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> 메뉴
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item"><a href="log_in.jsp" class="nav-link">로그인</a></li>
	          <li class="nav-item"><a href="sign_up.jsp" class="nav-link">회원가입</a></li>
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
	            <p class="breadcrumbs mb-2"> <span>FIND ID/PW</span></p>
	            <h1 class="mb-4 bread">FIND ID/PW</h1>
            </div>
          </div>
        </div>
      </div>
    </div>

	    
     <table align="center" border="0" cellpadding="20" cellspacing="0" width="100">
	</table>

    <section class="ftco-section bg-light ftco-no-pb">
    	<div class="container-fluid px-0">
    		<div class="row no-gutters justify-content-center mb-5 pb-3">
         		 <div class="col-md-7 heading-section text-center ftco-animate">
          			<span class="subheading">FIND ID/PW</span>
            		<h2 class="mb-4">아이디 찾기</h2>
          		</div>
        	</div>  
        </div>
    
        
        <div class="container">
			<div class="row justify-content-center mb-5 pb-3">
          		<div class="col-md-7 heading-section text-center ftco-animate">
 	
	<form name="form" id="form" action="/MAL_A/roxandrea/member.do"  method="post" >
	    <input type="hidden" name="workDiv" value="" id="workDiv" />
	    <div id="list"></div>
	    <div id="callBackDiv">
			<table border="1" cellpadding="5" cellspacing="0" width="600">
				<tr>
					<td bgcolor="#99ccff">이메일</td>
					<td><input type="text" name="email" id="email" size="20" /></td>
				<tr/>	
			</table>
		</div>
	</form>	
	<table border="0" cellpadding="5" cellspacing="0" width="600">
		<tr>
			<td colspan="2" align="right">
				<div>					
					<input class="btn btn-primary py-2 px-3" type="button" onclick="location.href='javascript:findId();'"  value="Id찾기" id="cancel" />
				</div>
			</td>
		</tr>
	</table>
		</div>
			</div>
				</div>
	</section>
	
	
	<section class="ftco-section bg-light ftco-no-pb">
    	<div class="container-fluid px-0">
    		<div class="row no-gutters justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
          	<span class="subheading">FIND ID/PW</span>
            <h2 class="mb-4">비밀번호 찾기</h2>
          </div>
        </div>  
        </div>
        <div class="container">
			<div class="row justify-content-center mb-5 pb-3">
          		<div class="col-md-7 heading-section text-center ftco-animate">
 	
	<form name="form2" id="form2" action="/MAL_A/roxandrea/member.do"  method="post" >
	    <input type="hidden" name="workDiv" value="" id="workDiv" />
	    <div id="list"></div>
	    <div id="callBackDiv">
			<table border="1" cellpadding="5" cellspacing="0" width="600">
				<tr>
					<td bgcolor="#99ccff">아이디</td>
					<td><input type="text" name="mid" id="mid" size="20" /></td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">이름</td>
					<td><input type="text" name="name" id="name" size="20" /></td>
				<tr/>	
				<tr>
					<td bgcolor="#99ccff">이메일</td>
					<td><input type="text" name="email2" id="email2" size="20" /></td>
				<tr/>
			</table>
		</div>
	
	</form>	
	<table border="0" cellpadding="5" cellspacing="0" width="600">
		<tr>
			<td colspan="2" align="right">
				<div>					
					<input class="btn btn-primary py-2 px-3" type="button" onclick="location.href='javascript:findPw();'"  value="Pw찾기" id="cancel" />
				</div>
			</td>
		</tr>
	</table>
		</div>
			</div>
				</div>
	</section>

  <%@ include file="/cmn/footer.jsp" %>
  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

<script type="text/javascript">
	//위에서 아래로 해석(인터프리터 방식)
	
	function findId(){
		
		var frm = document.form;
		var email = $("#email").val(); 
		console.log('email='+email);
		
		if(null ==email || email.trim().length ==0 ){
			$("#email").focus();
			alert("email을 입력 하세요.");
			return;
		}
		
  		//ajax
		$.ajax({
			 type:"POST",
			 url:"/MAL_A/roxandrea/member.do",
			 dataType:"html", 
			 data:{"workDiv":"doSelectOneId",
			       "email":email
			 },
			 success:function(data){ //성공
				 //json String --> json object
				   
			      //console.log("data="+data);
				  var jsonObj = JSON.parse(data);
				  //console.log("msgId="+jsonObj.msgId);
				  //console.log("msgContents="+jsonObj.msgContents);
			 	  //alert("data:"+data);
			 	  if(null != jsonObj && jsonObj.msgId=="1"){
			 		  alert(jsonObj.msgContents);
			 		  history.go(0);
			 	  }else{
			 		 alert(jsonObj.msgId+"|"+jsonObj.msgContents);
			 	  }
			 },
			 error:function(xhr,status,error){
			  alert("error:"+error);
			 },
			 complete:function(data){
			 
			 }   
		
		});//--ajax
	
	}
	
	function findPw(){
		
		var frm = document.form2;
		var mid = $("#mid").val(); 
		var name = $("#name").val();
		var email = $("#email2").val();
		
		if(null ==mid || mid.trim().length ==0 ){
			$("#mid").focus();
			alert("아이디를 입력 하세요.");
			return;
		}
		
		if(null ==name || name.trim().length ==0 ){
			$("#name").focus();
			alert("이름을 입력 하세요.");
			return;
		}
		
		if(null ==email || email.trim().length ==0 ){
			$("#email").focus();
			alert("email을 입력 하세요.");
			return;
		}
  		//ajax
		$.ajax({
			 type:"POST",
			 url:"/MAL_A/roxandrea/member.do",
			 dataType:"html", 
			 data:{"workDiv":"doSelectOnePw",
			       "mid":mid,
			       "name":name,
			       "email":email
			 },
			 success:function(data){ //성공
				 //json String --> json object
				   
			      //console.log("data="+data);
				  var jsonObj = JSON.parse(data);
				  //console.log("msgId="+jsonObj.msgId);
				  //console.log("msgContents="+jsonObj.msgContents);
			 	  //alert("data:"+data);
			 	  if(null != jsonObj && jsonObj.msgId=="1"){
			 		  alert(jsonObj.msgContents);
			 		  history.go(0);
			 	  }else{
			 		 alert(jsonObj.msgId+"|"+jsonObj.msgContents);
			 	  }
			 },
			 error:function(xhr,status,error){
			  alert("error:"+error);
			 },
			 complete:function(data){
			 
			 }   
		
		});//--ajax
	}
	
	
</script>	
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
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>