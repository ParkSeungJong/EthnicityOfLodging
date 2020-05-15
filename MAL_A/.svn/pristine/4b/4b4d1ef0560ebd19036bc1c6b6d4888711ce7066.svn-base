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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	      <a class="navbar-brand" href="start.jsp">숙박의민족</a>
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
	            <p class="breadcrumbs mb-2"> <span>Sign up</span></p>
	            <h1 class="mb-4 bread">BUSINESS MEMBER REGISTRATION</h1>
            </div>
          </div>
        </div>
      </div>
    </div>



    <section class="ftco-section bg-light ftco-no-pb">
        
        <div class="container">
			<div class="row justify-content-center mb-5 pb-3">
          		<div class="col-md-7 heading-section text-center ftco-animate">
 	
	<form name="form" id="form" action="MAL_A/roxandrea/member.do"  method="post" >
	    <input type="hidden" name="workDiv" value="doInsert" id="workDiv" />
	    <input type="hidden" name="regid" id="regid"/>
	    <input type="hidden" name="autho" id="autho"/>
	    <div id="list"></div>
	    <div id="callBackDiv">
			<table class="table table-bordered" border="1" cellpadding="5" cellspacing="0" width="600">
				<tr>
					<td bgcolor="#99ccff">아이디</td>
					<td><input type="text" name="mid" id="mid" size="20" /></td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">비밀번호</td>
					<td><input type="text" name="pw" id="pw" size="20" /></td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">비밀번호확인</td>
					<td><input type="text" name="checkpw" id="checkpw" size="20" /></td>
				<tr/>	
				<tr>
					<td bgcolor="#99ccff">이름</td>
					<td><input type="text" name="name" id="name" size="20" /></td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">이메일</td>
					<td><input type="text" placeholder="ex)minjok12@naver.com" name="email" id="email" size="20" /></td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">생일</td>
					<td><input type="text" placeholder="ex)19850101" name="birth" id="birth" size="20" /></td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">성별</td>
						<td>남자
	                   	 	<input type="radio" checked="checked" name="gender" id="Mgender" value="1">
	                		<span class="checkmark"></span>
	  						여자
	                    	<input type="radio" name="gender" id="Wgender" value="2">
	                    	<span class="checkmark"></span>
					</td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">전화번호</td>
					<td><input type="text" placeholder="010-1234-5678" name="tel" id="tel" size="20" /></td>
				<tr/>
				<tr>
					<td bgcolor="#99ccff">주소</td>
					<td>
						<input type="text"  style="width:500px;" id="roadFullAddr"  name="roadFullAddr" readonly/>
						<input type="button" onClick="goPopup();" value="주소검색"/>
					</td>
				</tr>
				<tr>
					<td bgcolor="#99ccff">우편번호</td>
					<td>
						<input type="text"  style="width:500px;" id="zipNo"  name="zipNo" readonly/>
					</td>
				</tr>
			</table>
		</div>
	</form>
	
	<table border="0" cellpadding="5" cellspacing="0" width="600">
		<tr>
			<td colspan="2" align="right">
				<div>
					<input class="btn btn-primary py-3 px-5" type="button"  value="회원가입" id="insertBtn" />
					<input class="btn btn-primary py-3 px-5" type="button" onclick="location.href='log_in.jsp'"  value="취소" id="cancel" />
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
	
	/*로그인세션*/
	function doLogIn(){
		console.log("doLogin");
		//id입력 체크
		var memberId = $("#mid").val();
		if(null == memberId || memberId.trim().length ==0){
			$("#mid").focus();
			alert("ID를 입력 하세요.");
			return;
		}
		//비번 체크
		var password = $("#pw").val();
		if(null == password || password.trim().length ==0){
			$("#pw").focus();
			alert("PW를 입력 하세요.");
			return;
		}
		
		console.log("memberId:"+memberId);
		console.log("password:"+password);
		
		//ajax
        $.ajax({
           type:"POST",
           url:"/MAL_A/roxandrea/member.do",
           dataType:"text",
           data:{
           "workDiv":"doLogin",
           "memberId":memberId,
           "password":password,
           "autho":"4"
          }, 
        success: function(data){
          //var jData = JSON.parse(data);
          if(null != data && data=="1"){
             alert(memberId+"(일반회원)님 로그인되었습니다.");
             goMemberStart();
          }else if(null != data && data=="2"){
       		 alert(memberId+"(업체회원)님 로그인되었습니다.");
             goBisStart();
          }else if(null != data && data=="3"){
        	 alert(memberId+"(웹관리자)님 로그인되었습니다.");
           	 goAdminStart();
          }else if(null != data && data=="4"){
        	  goBisStoreInsert();
          }else{
        	 alert(data.msgId+"|"+data.msgContents);
          }
        },
        complete:function(data){
         
        },
        error:function(xhr,status,error){
            alert("error:"+error);
        }
       }); 
       //--ajax  
		
		function goMemberStart(){
			window.location.href='/MAL_A/roxandrea/member_main.jsp';
       }
		
		function goBisStart(){
			window.location.href='/MAL_A/roxandrea/bis_main.jsp';
       }
		
		function goAdminStart(){
			window.location.href='/MAL_A/roxandrea/admin_main.jsp';
       }
		
		//회원가입 완료시 업체 인서트로 이동
		function goBisStoreInsert(){
			//window.location.href='/MAL_A/roxandrea/bis_store_insert.jsp';
			var frm = document.form;
			frm.workDiv.value = "doSelectOne";
			frm.autho.value = "4";
			frm.action = "/MAL_A/roxandrea/member.do";
			frm.submit();
       	}
		//--회원가입 완료시 업체 인서트로 이동
		
	}
	//--로그인 세션
	
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
	
		
	$("#insertBtn").on('click',function(){
		//console.log("#insert_btn");
		var workDiv = $("#workDiv").val();
		if(null == workDiv || workDiv.trim().length==0){
				alert("작업구분을 확인 하세요.");
				return;
		}
		
		var mid    = $("#mid").val();
		if(null == mid || mid.trim().length==0){
			$("#mid").focus();//focus
			alert("ID를 확인 하세요.");
			return;
		}
		
		//아이디 유효성 검사 (영문소문자, 숫자만 허용)
		for (var i = 0; i < mid.length; i++) {
            ch = mid.charAt(i)
            if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) {
                alert("아이디는 영문 대소문자, 숫자만 입력가능합니다.")
                $("#mid").focus();
                $("#mid").select();
                return false;
            }
        }
		
		 //아이디 길이 체크 (4~12자)
	       if (mid.length<4 || mid.length>12) {
	            alert("아이디를 4~12자까지 입력해주세요.")
	            $("#mid").focus();
	            $("#mid").select();
	            return false;
	        }
		
		var pw   = $("#pw").val();
		if(null == pw || pw.trim().length==0){
			$("#pw").focus();//focus
			alert("비밀번호를 입력 하세요.");
			return;
		}
		
		var checkpw   = $("#checkpw").val();
		if(null == checkpw || checkpw.trim().length==0){
			$("#checkpw").focus();//focus
			alert("비밀번호확인을 입력 하세요.");
			return;
		}
		
		if (mid == pw) {
            alert("아이디와 비밀번호가 같습니다.")
            $("#pw").focus();
            return false;
        }
		
		//비밀번호 길이 체크(6~12자 까지 허용)
        if (pw.length<4 || pw.length>12) {
            alert("비밀번호를 4~12자까지 입력해주세요.")
             $("#pw").focus();
             $("#pw").select();
            return false;
        }
		
        //비밀번호와 비밀번호 확인 일치여부 체크
        if (pw != checkpw) {
            alert("비밀번호확인이 일치하지 않습니다")
            checkpw = "";
            $("#checkpw").focus();
            return false;
        }
		
        var reghan = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
		
		var name = $("#name").val();
		if(null == name || name.trim().length==0){
			$("#name").focus();//focus
			alert("이름을 입력 하세요.");
			return;
		}
		
		if (reghan.test(name) == true) {
            alert("이름은 한글만 입력할 수 있습니다.");
            name=""
            $("#name").focus();//focus
            return false;
        }
		
		if(name.length<2){
            alert("이름을 2자 이상 입력해주십시오.")
            $("#name").focus();//focus
            return false;
        }
		
		
		
		var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		var regex2 = /^[A-z|0-9]([A-z|0-9]*)(@)([A-z]*)(\.)([A-z]*)$/;
	
		var email = $("#email").val();
		if(null == email || email.trim().length==0){
			$("#email").focus();//focus
			alert("이메일을 입력 하세요.");
			return;
		}
		
		if (regex2.test(email) === false) {
            alert("잘못된 이메일 형식입니다.");
            email=""
            $("#email").focus();//focus
            return false;
        }
		
		/*
		for (var i = 0; i < email.length; i++) {
            chm = email.charAt(i)
            if (!(chm >= '0' && chm <= '9') && !(chm >= 'a' && chm <= 'z')&&!(chm >= 'A' && chm <= 'Z')) {
                alert("이메일은 영문 대소문자, 숫자만 입력가능합니다.")
                $("#email").focus();//focus
                return false;
            }
        }
		*/
		
		var birth = $("#birth").val();
		if(null == birth || birth.trim().length==0){
			$("#birth").focus();//focus
			alert("생년월일을 입력 하세요.");
			return;
		}
		
		if (birth.length<8||birth.length>8) {
            alert("생년월일 길이가 맞지 않습니다.");
            birth = "";
            $("#birth").focus();//focus
            return false;
        }
		
		// 숫자가 아닌 것을 입력한 경우
        if (!isNumeric(birth.substr(0,8))) {
            alert("생년월일은 숫자로 입력하세요.");
            $("#birth").focus();//focus
            return false;
        }
		
		var tel = $("#tel").val();
		if(null == tel || tel.trim().length==0){
			$("#tel").focus();//focus
			alert("전화번호를 입력 하세요.");
			return;
		}
		
		var regExp = /^\d{3}-\d{3,4}-\d{4}$/;
		010-1234-5678
		if (tel.length != 13) {
            alert("전화번호 길이가 맞지 않습니다.");
            tel = "";
            $("#tel").focus();//focus
            return false;
        }
		
		if (regExp.test(tel) === false) {
            alert("잘못된 전화번호 형식입니다.");
            tel="";
            $("#tel").focus();//focus
            return false;
        }
		
		
		var roadFullAddr = $("#roadFullAddr").val();
		if(null == roadFullAddr || roadFullAddr.trim().length==0){
			$("#roadFullAddr").focus();//focus
			alert("주소를 입력 하세요.");
			return;
		}
		
		if(false == confirm("회원가입하시겠습니까??"))return;
		
		//비동기통신
		
  		//ajax
		$.ajax({
			 type:"POST",
			 url:"/MAL_A/roxandrea/member.do",
			 dataType:"html", 
			 data:{"workDiv":workDiv,
			       "mid":$("#mid").val(),
			       "pw":$("#pw").val(),
			       "name":$("#name").val(),
			       "email":$("#email").val(),
			       "birth":$("#birth").val(),
			       "gender":$(":input:radio[name=gender]:checked").val(),
			       "tel":$("#tel").val(),
			       "point":"0",
			       "autho":"2",
			       "regid":$("#mid").val(),
			       "addrno":$("#zipNo").val(),
			       "addr":$("#roadFullAddr").val()
			       
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
			 		 doLogIn();
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
		
	});//--#insert_btn	
	
	function isNumeric(s) { 
        for (i=0; i<s.length; i++) { 
          c = s.substr(i, 1); 
          if (c < "0" || c > "9") return false; 
        } 
        return true; 
  	}
	
	
	$(document).ready(function(){
	      
	       $.datepicker.setDefaults({
	           dateFormat: 'yymmdd',
	           prevText: '이전 달',
	           nextText: '다음 달',
	           monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	           monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
	           dayNames: ['일', '월', '화', '수', '목', '금', '토'],
	           dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
	           dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
	           showMonthAfterYear: true,
	           yearSuffix: 'Year'
	       });
	       
	       $("#birth").datepicker();

	   
	   });
	

</script>	
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>    
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
  <!-- <script src="js/jquery.min.js"></script> -->
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
  <!-- <script src="js/bootstrap-datepicker.js"></script> -->
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>