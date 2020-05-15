<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                                         수정자                      수정내용
  *  -------                  --------    ---------------------------
  *  2020. 3. 9. 오후 3:04:50   sist         최초 생성
  *
  * author 쌍용교육센터 E반
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.mal_a.room.RoomVO"%>
<%@page import="com.mal_a.room.RoomCont"%>
<%@page import="com.mal_a.roomoption.RoomOptionVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/roxandrea/member.do" var="logOut">
 <c:param name="workDiv" value="doLogout"></c:param>	
</c:url>
<%
	List<RoomVO> list = (List<RoomVO>)request.getAttribute("list");
	
	/*
	RoomCont roomCont = new RoomCont();
	List<RoomOptionVO> roomOptList = (List<RoomOptionVO>)roomCont.doSelectOnePossibleRoomOpt("02_1_1");
	
	for(RoomOptionVO vo :roomOptList) {
		//out.print(vo+"<br>");
		String roomOpt;
		roomOpt += vo.getOpt().toString()+", ";
	}
	*/
%>
<!DOCTYPE html>
<html>
<!-- 1개의 Store -->
<head>
<script src="https://code.jquery.com/jquery-2.2.4.js"></script>
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
	<!-- nav -->
	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="bis_main.jsp">숙박의민족</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        	<span class="oi oi-menu"></span> 메뉴
	      	</button>
			<div class="collapse navbar-collapse" id="ftco-nav">
	        	<ul class="navbar-nav ml-auto">
	        		<li class="nav-item"><a href="javascript:goStoreSelectOne();" class="nav-link">내가게</a></li>
					<li class="nav-item"><a href="javascript:goBisPaymentList();" class="nav-link">예약내역</a></li>
			        <li class="nav-item"><a href="javascript:goMemberMypage();" class="nav-link">마이페이지</a></li>
	          		<li class="nav-item"><a href="${logOut}" class="nav-link" onclick="if(false == confirm('로그아웃 하시겠습니까?')){return false;}">로그아웃</a></li>
	        	</ul>
	      	</div>
		</div>
	</nav>
    <!-- //nav -->
    
    <!-- 머릿말 -->
	<div class="hero-wrap" style="background-image: url('images/bg_1.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
				<div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
					<div class="text">
						<p class="breadcrumbs mb-2"><span>STORE</span></p>
	            		<h1 class="mb-4 bread">ROOMS</h1>
            		</div>
          		</div>
        	</div>
      	</div>
    </div>
    <!-- //머릿말 -->

	<!-- section -->
	<section class="ftco-section">
		<div class="container">
        	<div class="row">
        	
        		
    			
        		
        	
        		<!-- col-md-8 -->
          		<div class="col-lg-8">
          			<div class="row">
          				<form action="/<%=HR_PATH %>/roxandrea/room.do" name="roomFrm" id="roomFrm" method="post">
          					<input type="hidden" name="workDiv"/>
          					<input type="hidden" name="autho" />
          					<input type="hidden" name="rno" />
          					<input type="hidden" name="fileId"/>
          					<input type="hidden" name="searchDiv"/>
          					<input type="hidden" name="searchWord"/>
	         				<input type="button" value="추가" onclick="javascript:goRoomInsert();"/>
	         				<input type="button" value="수정" onclick="javascript:goRoomUpdate();"/>
	         				<input type="button" value="삭제" onclick="javascript:doDelete();"/>
	          			</form>
	          				<!-- 방리스트 -->
	          				<c:choose>
								<c:when test="${null!=list && list.size()>0 }">
									<c:forEach var="list" items="${list }" >
										<c:set var="vo" value="${list.get(0).get(0) }" ></c:set>
										<div class="room-wrap d-md-flex">
											<input type="radio" value="${vo.rno }" name="radioBtn"/>
											<div class="col-md-5 ftco-animate">
          										<div class="single-slider owl-carousel">
													<c:forEach var="fileMngVO" items="${list.get(1) }" >
								          				<div class="item">
							          						<div class="img" style="background-image:url(<%=HR_PATH%>${fileMngVO.savePath}${fileMngVO.saveNm});"></div>
								          				</div>
							          				</c:forEach>
							          			</div>
							          		</div>
				   							<div class="half left-arrow d-flex align-items-center">
				   								<div class="text p-4 p-xl-5 text-center">
				   									<h3 class="mb-0"><strong><c:out value="${vo.name }" /></strong></h3>
				   									<p class="mb-0"><span class="price mr-1">주중가&nbsp;:&nbsp;<fmt:formatNumber value="${vo.price1 }" pattern="#,###" />원</span></p>
													<p class="mb-0"><span class="price mr-1">주말가&nbsp;:&nbsp;<fmt:formatNumber value="${vo.price2 }" pattern="#,###" />원</span></p>
				    								<p class="mb-0"><span class="per">적정 인원: <c:out value="${vo.capacity }" /></span></p>
				    								<input type="hidden" id="forFileId" value="${vo.fileId }"/>
				    								<c:set var="rno" value="${vo.rno }" />
				    								<p class="mb-0"><span class="per">옵션&nbsp;:&nbsp;<%=RoomCont.doRetrievePossibleRoomOpt(pageContext.getAttribute("rno").toString()) %></span></p>
				    								<p class="mb-0"><span class="per">소개: <c:out value="${vo.cont }" /></span></p>
				   								</div>
				   							</div>
				    					</div>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="99">No data found</td>
									</tr>
								</c:otherwise>
							</c:choose>
	          				<!-- //방리스트 -->

    
          				
          			
          				

          			</div>
          		</div>
          		<!-- //col-md-8 -->
          		
          		<!-- 사이드라인 -->
          		<div class="col-lg-4 sidebar ftco-animate">
          			<!-- 사이드바 -->
            		<div class="sidebar-box ftco-animate">
              			<div class="categories">
                			<h3>Categories</h3>
                			<li><a href="javascript:goStoreSelectOne();">업체 <span>(14)</span></a></li>
			                <li><a href="javascript:goRoomList();">방 <span>(6)</span></a></li>
              			</div>
            		</div>
          		</div>
          		<!-- //사이드라인 -->
          		
			</div>
		</div>
	</section>
	<!-- //section -->
	
	
	
	
	<!-- 푸터 -->
<%@ include file="/cmn/footer.jsp" %>
	<!-- //푸터 -->
    
  

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
  	
  	<script type="text/javascript">
		//예약 내역으로 이동
		function goBisPaymentList(){
			var frm = document.roomFrm;
			frm.workDiv.value = "doRetrieve";
			frm.searchDiv.value = "2";
			frm.action = '/MAL_A/roxandrea/payment.do';
			frm.submit();
		}
		//--예약 내역으로 이동
	
		//마이페이지
		function goMemberMypage(){
		
			var frm = document.roomFrm;
			
			frm.workDiv.value = "doSelectOne";
			frm.autho.value= "2";
			frm.action = '/MAL_A/roxandrea/member.do'; 
			frm.submit();
		}
		//--마이페이지
	
		//업체페이지 이동
	  	function goStoreSelectOne(){
			var frm = document.roomFrm;
			
			frm.workDiv.value = "doSelectOne";
			frm.autho.value = "2";
			frm.searchDiv.value = "1";
			frm.action = '/MAL_A/roxandrea/store.do';
			frm.submit();
		}
  	
  		//새로고침
	  	function goRoomList(){
			history.go(0);
		}
  	
  		//방 삭제
  		function doDelete(){
  			//체크된 라디오 버튼
  			var radio = $("input[name=radioBtn]:checked");
  			
  			//체크된 행의 rno
  			var rno = radio.val();
  			//alert(rno);
  			
  			//체크된 행의 fileId
  			var fileId = radio.parent().children().eq(2).children().children().eq(4).val();
  			//alert(fileId);
  			
  			//체크값이 없는 경우
  			if(radio.length==0){
  				alert('선택된 방이 없습니다.')
  				return;
  			};
  			
  			if(false==confirm('삭제 하시겠습니까?'))return;
  			
  			//ajax
  			$.ajax({
  			    type:"POST",
  			    url:"/MAL_A/roxandrea/room.do",
  			    dataType:"html", 
  			    data:{"workDiv": "doDelete",
  			          "rno": rno,
  			          "fileId": fileId
  			    },
  			    success:function(data){ //성공
  					//console.log("data="+data);
  					//alert("data:"+data);
  					var jData = JSON.parse(data);
  					alert(jData.msgContents);
  					goRoomList();
  			    },
  			    error:function(xhr,status,error){
  					alert("error:"+error);
  			    },
  			    complete:function(data){
  			    
  			    }   
  		  	});//--ajax
  		}
  		//--방 삭제
  	
  		//방 추가
  		function goRoomInsert(){
			var frm = document.roomFrm;
			frm.workDiv.value = "doSelectOne";
			frm.autho.value = "1";
			frm.action = "/MAL_A/roxandrea/room.do";
			frm.submit();
  		}
  		//--방 추가
  		
  		//방 수정
  		function goRoomUpdate(){
  			//체크된 라디오 버튼
  			var radio = $("input[name=radioBtn]:checked");
  			
  			//체크된 행의 rno
  			var rno = radio.val();
  			//alert(rno);
  			
  			//체크된 행의 fileId
  			var fileId = radio.parent().children().eq(2).children().children().eq(4).val();
  			//alert(fileId);
  			
  			//체크값이 없는 경우
  			if(radio.length==0){
  				alert('선택된 방이 없습니다.')
  				return;
  			};
  			
  			//if(false==confirm('방: '+name+' 을(를)\n수정 하시겠습니까?'))return;
			
			var frm = document.roomFrm;
			frm.workDiv.value = "doSelectOne";
			frm.rno.value = rno;
			frm.fileId.value = fileId;
			frm.autho.value = "2";
			frm.action = "/MAL_A/roxandrea/room.do";
			frm.submit();
  		}
  		//--방 수정
  	
  	
  	</script>
  	
</body>
</html>