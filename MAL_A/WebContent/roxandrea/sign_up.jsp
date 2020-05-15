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
<%@page import="java.util.List"%>
<%@page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
             <li class="nav-item"><a href="#" class="nav-link">회원가입</a></li>
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
               <p class="breadcrumbs mb-2"> <span>sign up</span></p>
               <h1 class="mb-4 bread">SIGN UP</h1>
            </div>
          </div>
        </div>
      </div>
    </div>



    <section class="ftco-section bg-light ftco-no-pb">
        
        <div class="container">
         <div class="row justify-content-center mb-5 pb-3">
                <div class="col-md-7 heading-section text-center ftco-animate">
    
         <form action="" name="loginFrm" id="loginFrm" method="get">
            <input type="hidden" name="workDiv" value="doLogin">
              
               <div class="p-t-15">
                  <label><h3>회원가입할 사용자를 선택해주세요.</h3></label><br/>
                   <button class="btn btn-primary py-3 px-5"  type="button" onclick="location.href='member_insert.jsp'">일반사용자 회원가입</button>
                   <button class="btn btn-primary py-3 px-5"  type="button" onclick="location.href='bis_member_insert.jsp'">업체사장님 회원가입</button>
               </div>
              
           </form>
   
   
   
   <table border="0" cellpadding="5" cellspacing="0" width="600">
      <tr>
         <td colspan="2" align="right">
            <div>
               
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

 <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="<c:url  value='/js/bootstrap.min.js' />"> </script>


<script type="text/javascript">
   //위에서 아래로 해석(인터프리터 방식)
   
   // opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
   //document.domain = "abc.go.kr";
   function goPopup(){
      // 주소검색을 수행할 팝업 페이지를 호출합니다.
      // 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
      var pop = window.open("JusoPopupAPI.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
      
      // 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
       //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
   }

   function jusoCallBack(roadFullAddr,zipNo){
         // 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
         document.form.roadFullAddr.value = roadFullAddr;
         document.form.zipNo.value = zipNo;
   }
   

   /*로그인세션*/
   $("#doLogin").on("click",function(){
      
      console.log("doLogin");
      //id입력 체크
      var memberId = $("#memberId").val();
      if(null == memberId || memberId.trim().length ==0){
         $("#memberId").focus();
         alert("ID를 입력 하세요.");
         return;
      }
      //비번 체크
      var password = $("#password").val();
      if(null == password || password.trim().length ==0){
         $("#password").focus();
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
           "password":password
          }, 
        success: function(data){
          //var jData = JSON.parse(data);
          if(null != data && data=="1"){
            alert(data);
            goMemberStart();
          }else if(null != data && data=="2"){
             alert(data);
              goBisStart();
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
         window.location.href='/MAL_A/roxandrea/store_search.jsp';
       }
      
      function goBisStart(){
         window.location.href='/MAL_A/roxandrea/payment.jsp';
       }
      
   });

   
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