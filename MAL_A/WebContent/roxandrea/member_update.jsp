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
<c:url value="/roxandrea/member.do" var="logOut">
 <c:param name="workDiv" value="doLogout"></c:param>	
</c:url>
<c:url value="/roxandrea/board.do" var="hrUrl">
 <c:param name="workDiv" value="doRetrieve"></c:param>
</c:url>
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
	      <a class="navbar-brand" href="member_main.jsp">숙박의민족</a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> 메뉴
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item"><a href="/MAL_A/roxandrea/store_search.jsp" class="nav-link">업체검색</a></li>
	          <li class="nav-item"><a href="${hrUrl}" class="nav-link">자유게시판</a></li>
	          <li class="nav-item"><a href="#" class="nav-link">마이페이지</a></li>
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
	            <p class="breadcrumbs mb-2"><span>My page</span></p>
	            <h1 class="mb-4 bread">UPDATE USER INFO</h1>
            </div>
          </div>
        </div>
      </div>
    </div>

	    
     <table align="center" border="0" cellpadding="20" cellspacing="0" width="100">
		<tr>
			<td colspan="0" align="center">					
					<input class="btn btn-primary py-3 px-5" type="button" onclick="location.href='#'"  value="내 정보" id="cancel" />
			</td>	
			<td colspan="0" align="center">		
					<input class="btn btn-primary py-3 px-5" type="button" onclick="location.href='javascript:doMemberPaySelectOne()'"  value="예약확인" id="cancel" />
			</td>	
			<td colspan="0" align="center">		
					<input class="btn btn-primary py-3 px-5" type="button" onclick="location.href='javascript:doMemberReview()'"  value="내가 쓴 리뷰" id="cancel" />
			</td>
			<td colspan="0" align="center">		
					<input class="btn btn-primary py-3 px-5" type="button" onclick="location.href='javascript:doMemberHeart();'"  value="좋아요" id="cancel" />
			</td>
		</tr>
	</table>

    <section class="ftco-section bg-light ftco-no-pb">
    
        
        <div class="container">
			<div class="row justify-content-center mb-5 pb-3">
          		<div class="col-md-7 heading-section text-center ftco-animate">
 	
	<form name="form" id="form" action="/MAL_A/roxandrea/member.do"  method="get" >
	    <input type="hidden" name="workDiv" value="doInsert" id="workDiv" />
	    <input type="hidden" name="idsession"  id="idsession"/>
	    <div id="list"></div>
	    <div id="callBackDiv">
			<table class="table table-bordered" border="1" cellpadding="5" cellspacing="0" width="600">
				<tr>
					<td bgcolor="#99ccff">아이디</td>
					<td><input type="text" value="${vo.mid}" name="mid" id="mid" size="20" readonly="readonly"/></td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">비밀번호</td>
					<td><input type="text" value="${vo.pw}" name="pw" id="pw" size="20" /></td>
					<td><input type="button"  value="수정" id="pwUpdateBtn" /></td>
				<tr/>	
				<tr>
					<td bgcolor="#99ccff">이름</td>
					<td><input type="text" value="${vo.name}" name="name" id="name" size="20" readonly="readonly"/></td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">이메일</td>
					<td><input type="text" value="${vo.email}" name="email" id="email" size="20" /></td>
					<td><input  type="button"  value="수정" id="emailUpdateBtn" /></td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">생일</td>
					<td><input type="text" value="${vo.birth}" name="birth" id="birth" size="20" readonly="readonly"/></td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">성별</td>
					<td><input type="text" value="${vo.gender}" name="gender" id="gender" size="20" readonly="readonly"/></td>	
				<tr/>
				<tr>
					<td bgcolor="#99ccff">전화번호</td>
					<td><input type="text" value="${vo.tel}" name="tel" id="tel" size="20" /></td>
					<td><input  type="button"  value="수정" id="telUpdateBtn" /></td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">사용자 선택</td>					
					<td><input type="text" value="${vo.autho}" name="autho" id="autho" size="20" readonly="readonly"/></td>					
				<tr/>
				<tr>
					<td bgcolor="#99ccff">주소</td>		
					<td><input type="text" value="${vo.addr}" name="roadFullAddr" id="roadFullAddr" readonly="readonly"/></td>
					<td><input type="button" onClick="goPopup();" value="주소수정"/></td>
				</tr>
				<tr>
					<td bgcolor="#99ccff">우편번호</td>
					<td><input type="text" value="${vo.addrNo}" name="zipNo" id="zipNo" readonly="readonly"/></td>
					<td><input  type="button"  value="확인" id="addrUpdateBtn" /></td>
				</tr>
			</table>
		</div>
	
	</form>	
	<table border="0" cellpadding="5" cellspacing="0" width="600">
		<tr>
			<td colspan="2" align="right">
				<div>					
					<input type="button" onclick="location.href='javascript:goMemberMypage();'"  value="돌아가기" id="cancel" />
				</div>
			</td>
		</tr>
	</table>
		<input class="btn btn-danger py-2 px-3" type="button" value="계정 삭제" id="delete_btn" />
		</div>
			</div>
				</div>
	</section>
	

<%@ include file="/cmn/footer.jsp" %>
    
  <form name="searchFrm2" action="/MAL_A/roxandrea/payment.do" method="get">
    				<input type="hidden" name="workDiv" />
					<input type="hidden" name="pageNum" />
					<input type="hidden" name="regId" />
					<input type="hidden" name="searchDiv" />
					<input type="hidden" name="searchWord" />
	</form>
	
	<form name="searchFrm3" action="/MAL_A/roxandrea/member.do" method="get">
    				<input type="hidden" name="workDiv" />
					<input type="hidden" name="pageNum" />
					<input type="hidden" name="regId" />
					<input type="hidden" name="searchDiv" />
					<input type="hidden" name="searchWord" />
	</form>
  	
  	<form name="searchFrm4" action="/MAL_A/roxandrea/heart.do" method="get">
    				<input type="hidden" name="workDiv" />
					<input type="hidden" name="pageNum" />
					<input type="hidden" name="regId" />
					<input type="hidden" name="searchDiv" />
					<input type="hidden" name="searchWord" />
	</form>

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

<script type="text/javascript">
	//위에서 아래로 해석(인터프리터 방식)
	
		// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
	//document.domain = "abc.go.kr";
	function goPopup(){
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("juso_api_pop_up.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
		
		// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
	    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}

	function jusoCallBack(roadFullAddr,zipNo){
			// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
			document.form.roadFullAddr.value = roadFullAddr;
			document.form.zipNo.value = zipNo;
	}
	
	//비밀번호수정
	$("#pwUpdateBtn").on("click",function(){
		console.log("#pwUpdateBtn");
		
		//mid
		var mid = $("#mid").val();
		if(null == mid || mid.trim().length ==0){
			alert("아이디를 확인하세요.");
			return;
		}
		//pw
		var pw = $("#pw").val();
		if(null == pw || pw.trim().length ==0){
			$("#pw").focus();
			alert("비밀번호를 확인하세요.");
			return;
		}
		if(false==confirm(pw+'비밀번호을(를)\n수정하시겠습니까?'))return;
		
		 //ajax
		$.ajax({
			type:"POST",
			url:"/MAL_A/roxandrea/member.do",
			dataType:"html", 
			data:{"workDiv":"doUpdatePw",
				"mid":$("#mid").val(),
				"pw":$("#pw").val(),
				"modid":$("#mid").val()
			},
			success:function(data){ //성공
				console.log("data="+data);
				//alert("data:"+data);
				var jData = JSON.parse(data);
				if(null != jData && jData.msgId=="1"){
					alert(jData.msgContents);
					window.location.reload();
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

	//이메일수정
	$("#emailUpdateBtn").on("click",function(){
		console.log("#emailUpdateBtn");
		
		//mid
		var mid = $("#mid").val();
		if(null == mid || mid.trim().length ==0){
			alert("아이디를 확인하세요.");
			return;
		}
		//title
		var email = $("#email").val();
		if(null == email || email.trim().length ==0){
			$("#email").focus();
			alert("이메일을 확인하세요.");
			return;
		}
		if(false==confirm(email+'이메일을(를)\n수정하시겠습니까?'))return;
		
		 //ajax
		$.ajax({
			type:"POST",
			url:"/MAL_A/roxandrea/member.do",
			dataType:"html", 
			data:{"workDiv":"doUpdateEmail",
				"mid":$("#mid").val(),
				"email":$("#email").val(),
				"modid":$("#mid").val()
			},
			success:function(data){ //성공
				console.log("data="+data);
				//alert("data:"+data);
				var jData = JSON.parse(data);
				if(null != jData && jData.msgId=="1"){
					alert(jData.msgContents);
					window.location.reload();
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
	
	//전화번호수정
	$("#telUpdateBtn").on("click",function(){
		console.log("#telUpdateBtn");
		
		//mid
		var mid = $("#mid").val();
		if(null == mid || mid.trim().length ==0){
			alert("아이디를 확인하세요.");
			return;
		}
		//tel
		var tel = $("#tel").val();
		if(null == tel || tel.trim().length ==0){
			$("#tel").focus();
			alert("전화번호를 확인하세요.");
			return;
		}
		if(false==confirm(tel+'전화번호을(를)\n수정하시겠습니까?'))return;
		
		 //ajax
		$.ajax({
			type:"POST",
			url:"/MAL_A/roxandrea/member.do",
			dataType:"html", 
			data:{"workDiv":"doUpdateTel",
				"mid":$("#mid").val(),
				"tel":$("#tel").val(),
				"modId":$("#mid").val()
			},
			success:function(data){ //성공
				console.log("data="+data);
				//alert("data:"+data);
				var jData = JSON.parse(data);
				if(null != jData && jData.msgId=="1"){
					alert(jData.msgContents);
					window.location.reload();
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

	//주소, 우편번호 수정
	$("#addrUpdateBtn").on("click",function(){
		console.log("#addrUpdateBtn");
		
		//mid
		var mid = $("#mid").val();
		if(null == mid || mid.trim().length ==0){
			alert("아이디를 확인하세요.");
			return;
		}
		//addr
		var roadFullAddr = $("#roadFullAddr").val();
		if(null == roadFullAddr || roadFullAddr.trim().length ==0){
			$("#roadFullAddr").focus();
			alert("주소를 확인하세요.");
			return;
		}
		
		//addrNo
		var zipNo = $("#zipNo").val();
		if(null == zipNo || zipNo.trim().length ==0){
			$("#zipNo").focus();
			alert("우편번호를 확인하세요.");
			return;
		}
		
		if(false==confirm(roadFullAddr+'주소을(를)\n수정하시겠습니까?'))return;
		
		 //ajax
		$.ajax({
			type:"POST",
			url:"/MAL_A/roxandrea/member.do",
			dataType:"html", 
			data:{"workDiv":"doUpdateAddr",
				"mid":$("#mid").val(),
				"addr":$("#roadFullAddr").val(),
				"addrno":$("#zipNo").val(),
				"modid":$("#mid").val()
			},
			success:function(data){ //성공
				console.log("data="+data);
				//alert("data:"+data);
				var jData = JSON.parse(data);
				if(null != jData && jData.msgId=="1"){
					alert(jData.msgContents);
					window.location.reload();
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
	
	//삭제
	$("#delete_btn").on("click",function(){
		console.log("#delete_btn");
		
		if(mid == null){
			alert("아이디를 확인하세요.");
			return;
		}
		
		if(false==confirm('정말 삭제하시겠습니까? (삭제하시면 관련 정보가 모두 삭제됩니다.)'))return;
		
		 //ajax
		$.ajax({
			type:"POST",
			url:"/MAL_A/roxandrea/member.do",
			dataType:"html",
			data:{"workDiv":"doDelete",
			},
			success:function(data){ //성공
				console.log("data="+data);
				//alert("data:"+data);
				var jData = JSON.parse(data);
				if(null != jData && jData.msgId=="1"){
					alert(jData.msgContents);
					window.location.href='start.jsp';
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
	
	
	function doMemberPaySelectOne(){
  		var regId = "park01";
  		
		var frm = document.searchFrm2;
		frm.workDiv.value = "doRetrieve";
		frm.regId.value = regId;
		frm.searchDiv.value = "1";
		frm.searchWord.value = regId;
		frm.action = '/MAL_A/roxandrea/payment.do';
		frm.submit();
	}
	
	
	function doMemberReview(){
			var regId = "park01";
			
		var frm = document.searchFrm3;
		frm.workDiv.value = "doRetrieveReview";
		frm.regId.value = regId;
		frm.searchDiv.value = "3";
		frm.searchWord.value = regId;
		frm.action = '/MAL_A/roxandrea/member.do';
		frm.submit();
	}
	
	function doMemberHeart(){
  		var regId = "park01";
  		
		var frm = document.searchFrm4;
		frm.workDiv.value = "doRetrieveHeart";
		frm.regId.value = regId;
		frm.action = '/MAL_A/roxandrea/heart.do';
		frm.submit();
	}
	
	function goMemberMypage(){
		
		var frm = document.form;
		
		frm.workDiv.value = "doSelectOne";
		frm.action = '/MAL_A/roxandrea/member.do'; 
		
		
		frm.submit();
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