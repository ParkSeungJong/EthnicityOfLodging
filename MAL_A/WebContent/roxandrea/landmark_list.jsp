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

<%@page import="com.mal_a.store.StoreVO"%>
<%@page import="com.mal_a.cmn.StringUtil"%>
<%@page import="com.mal_a.code.CodeVO"%>
<%@page import="com.mal_a.landmark.LandmarkDao"%>
<%@page import="com.mal_a.landmark.LandmarkCont"%>
<%@page import="com.mal_a.cmn.SearchVO"%>
<%@page import="com.mal_a.landmark.LandmarkVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/cmn/common.jsp" %>
<%
   //param
   String searchDiv ="1";   //검색구분
   String pageSize ="10";   //페이지 사이즈
   String pageNum = "1";   //페이지 넘버
   String searchWord ="";//검색어
   String searchWord02 ="";//검색어
   String workDiv ="doRetrievMember";
   String sno="";
   
 	//paging
   int maxNum     = 0;//총글수 
   int currPageNo = 1;//현재 페이지 
   int rowsPerPage= 10;// pageSize 
   
   int bottomCount= 10;// 바닥 page_cnt
   
   String url = HR_PATH+"/roxandrea/landmark.do";//호출 URL 
   String scriptName = "doSearchPage";//JavaScript함수: doSearchPage(url,no)
   
  	StoreVO stoVO = (StoreVO)request.getAttribute("stoVO");
    SearchVO inVO = (SearchVO)request.getAttribute("paramVO");
    
    List<CodeVO> pageSizeList = (List<CodeVO>)request.getAttribute("pageSizeList");
    List<CodeVO> searchList = (List<CodeVO>)request.getAttribute("searchList");
    List<CodeVO> locList = (List<CodeVO>)request.getAttribute("locList");
    List<CodeVO> categoryList = (List<CodeVO>)request.getAttribute("categoryList");
    List<CodeVO> search = (List<CodeVO>)request.getAttribute("searchDIV");
    
    if(inVO!=null){
       LOG.debug("===============");
       LOG.debug("inVO="+inVO);
       LOG.debug("===============");
       searchDiv = inVO.getSearchDiv();
       pageNum = String.valueOf(inVO.getPageNum());
       pageSize = String.valueOf(inVO.getPageSize());
       searchWord = inVO.getSearchWord();
       searchWord02 = inVO.getSearchWord02();
       
       maxNum     = (Integer)request.getAttribute("totalCnt");
       currPageNo = inVO.getPageNum();
       rowsPerPage= inVO.getPageSize();
       
       LOG.debug("=======================");
       LOG.debug("url="+url);
       LOG.debug("scriptName="+scriptName);
       LOG.debug("maxNum="+maxNum);
       LOG.debug("currPageNo="+currPageNo);
       LOG.debug("rowsPerPage="+rowsPerPage);
       LOG.debug("=======================");
    }
   
  
   
   
   //--paging

   
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
<html>
  <head>
  	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7c798e37b13fac506a55eb2eebfd5a18&libraries=services"></script>
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
				    <span class="oi oi-menu"></span> 메뉴
				</button>
				
				<div class="collapse navbar-collapse" id="ftco-nav">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a href="/MAL_A/roxandrea/admin_store_search.jsp" class="nav-link">업체검색</a></li>
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
			             <p class="breadcrumbs mb-2">LANDMARK</p>
			             <h1 class="mb-4 bread">LANDMARK</h1>
			          </div>
				</div>
			</div>
		</div>
	</div>
		
	<section class="ftco-section">
		<div class="container">
		<div class="row">
			<div class="col-lg-8">
				<div class="row">
					<div class="col-md-12 room-single mt-4 mb-5 ftco-animate" name="landmarkList" id="landmarkList">
					<!-- 관광명소 리스트 -->
						<form action="/MAL_A/roxandrea/landmark.do" name="updateFrm" id="updateFrm"  method="post">
							<input type="hidden" name="workDiv"/>
							<input type="hidden" name="autho"/>
							<input type="hidden" name="pageNum"/>
							<input type="hidden" name="searchDiv"/>
							<input type="hidden" name="searchWord"/>
							<input type="hidden" name="searchWord02" />
							  
							<div class="select-wrap" align="left" name="selectList" id="selectList">
								<select class="form-control-lg input-md" name="searchWd" id="sno"  value="${searchWord}" style="display: none;">
								</select>
								
								<select class="form-control-lg input-md" name="searchWd02" id="category" value="${searchWord02}">
									<option value="">카테고리 선택</option>
									<c:forEach var="code" items="${categoryList}" >
									<option value="<c:out value="${code.dtlId }" />" >
										<c:if test="${paramVO.pageSize == code.dtlId }"></c:if>
										<c:out value="${code.dtlNm }" />
									</option>
									</c:forEach>
								</select>
								
								<select class=" form-control-lg input-md" name="pageSize" id="pageSize" >
									<c:forEach var="code" items="${pageSizeList}" >
									<option value="<c:out value="${code.dtlId }" />" 
										<c:if test="${paramVO.pageSize == code.dtlId }">selected="selected"</c:if>>
										<c:out value="${code.dtlNm }" />
									</option>
									</c:forEach>
								</select>	
								<input  type="button" class="btn btn-default btn-lg" value="조회" id="catBtn" onclick="javascript:doRetrieve();" />
							</div>
							<div>
								<c:choose>
									<c:when test="${list !=null && list.size()>0 }">
										<c:forEach var="list" items="${list}" >
											<c:set var="vo" value="${list.get(0).get(0) }" ></c:set>
											<div class="col-md-12 ftco-animate">
												<div class="single-slider owl-carousel">
													<c:forEach var="fileMngVO" items="${list.get(1) }" >
								          				<div class="item">
							          						<div class="room-img" style="background-image:url(<%=HR_PATH%>${fileMngVO.savePath}${fileMngVO.saveNm});"></div>
								          				</div>
						          					</c:forEach>
												</div>
											</div>
											<h2 class="mb-4" id="mecca1"><strong><c:out value="${vo.name }" /></strong></h2>
											<p align="right">최종 수정일:
												<c:out value="${vo.modDt }" default="${vo.regDt }"/>
											</p>
											<div class="d-md-flex mt-5 mb-5">
												<table >
													<tr>
														<td>
															<input  type="radio"     name ="radio"  value="${vo.lno}"/>
														</td>
													</tr>
													<tr style="display: none">
														<td colspan="5"><b>lno</b></td>
														<td name="lno" id="lno"  value="${vo.lno}">&nbsp;&nbsp;<c:out value="${vo.lno}" /></td>
												    </tr>
													<tr align="left">
													      <td colspan="5"><b>이름</b></td>
													      <td name="name">&nbsp;&nbsp;<c:out value="${vo.name}" /></td>
													</tr>
													<tr align="left">
													   <td colspan="5"><b>번호</b></td>
													   <td name="tel">&nbsp;&nbsp;<c:out value="${vo.tel}" /></td>
													</tr>
													<tr align="left">
													   <td colspan="5"><b>위치</b></td>
													   <td name="addr">&nbsp;&nbsp;<c:out value="${vo.addr}" /></td>
													</tr>
													<tr align="left" valign="top">
													   <td colspan="5"><b>내용</b></td>
													   <td name="cont">&nbsp;&nbsp;<c:out value="${vo.cont}" /></td>
													</tr>
													<tr style="display: none">
														<td colspan="5"><b>카테고리</b></td>
														<td name="category">&nbsp;&nbsp;<c:out value="${vo.category}" /></td>
													</tr>
												    <tr style="display: none">
														<td colspan="5"><b>우편번호</b></td>
														<td name="zipNo">&nbsp;&nbsp;<c:out value="${vo.addrNo}" /></td>
													</tr>
													<tr style="display: none">
														<td colspan="5"><b>수정자</b></td>
														<td name="modId">&nbsp;&nbsp;<c:out value="${vo.regId}" /></td>
													</tr>
												    <tr style="display: none">
														<td colspan="5"><b>파일ID</b></td>
														<td name="fileId">&nbsp;&nbsp;<c:out value="${vo.fileId}" /></td>
												    </tr>
												</table>   
											</div>
										</c:forEach>
									</c:when>
								</c:choose>
							</div>
						</form>   
					<!-- 관광명소 리스트 -->
					</div>
						<div class="col-md-12 room-single mt-4 mb-5 ftco-animate">
							<div  class="tagcloud" align="right">
							    <a class="tag-cloud-link" onclick="javascript:landmarkLocation();">위치보기</a>
							</div>
						</div>
						<div id="kakaoMap" style="width:100%;height:350px;"></div>
				</div>
			</div> <!-- .col-md-8 -->
			
			
			<div class="col-lg-4 sidebar ftco-animate">
             <!-- 카테고리 -->
	            <div class="sidebar-box ftco-animate">
				<form action="/MAL_A/roxandrea/landnmark.do" name="moveFrm" id="moveFrm" method="post">
	            	<input type="hidden" name="workDiv" />
	            	<input type="hidden" name="autho" />
	            	<input type="hidden" name="searchDiv" />
	            	<input type="hidden" name="searchWord" />
	            	<input type="hidden" name="searchWord02" />
	            	<input type="hidden" name="sno" id="sno"/>
	            	<input type="hidden" name="regId" />
		            <div class="sidebar-box ftco-animate">
		            	<div class="categories">
			                <h3>Categories</h3>
			                <li><a href="javascript:goStoreSelectOne();">업체 </a></li>
			                <li><a href="javascript:goRoomList();">방</a></li>
			                <li><a href="javascript:goLandmark();">관광명소 </a></li>
			                <li><a href="javascript:goPaymentInsert();">실시간예약</a></li>
		           	    </div>
		            </div>
	        	</form>
                <!-- //카테고리 -->
		</div>
	  </div>
				<!-- paging -->
				<div>
					<%=StringUtil.renderPaging(maxNum, currPageNo, rowsPerPage, bottomCount, url, scriptName)%>
				</div>
				<!--// paging -->     
	</section> <!-- .section -->
  
<%@ include file="/cmn/footer.jsp" %>
   
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/jquery.mb.YTPlayer.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/scrollax.min.js"></script>
  <!-- // <script src="js/jquery.timepicker.min.js"></script> -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script type="text/javascript">

  		//조회
         function doRetrieve(){
		   //var searchWord="02_1";
	  	   var searchWord = "${paramVO.searchWord}";
	  	  // alert(searchWord);
           var searchWord02 = $("select[name=searchWd02]").val();
           var pageSize = $("select[name=pageSize]").val();
           
        	   if(searchWord02!=null&& searchWord02!="" &&searchWord02!="카테고리 선택"){
                   console.log('searchWord=='+searchWord+"==");
                   console.log('searchWord02=='+searchWord02+"==");
                   
                   var frm = document.updateFrm;
                   frm.workDiv.value = "doRetrieveMember";
                   frm.searchDiv.value = "1";
                   frm.searchWord.value = searchWord;
                   frm.searchWord02.value = searchWord02;
                   frm.pageSize.value = pageSize;
                   frm.action = "/MAL_A/roxandrea/landmark.do";
                   frm.submit();
                   
        	   }else{
        		 alert("카테고리를 선택하세요");
        	   }
        	
           }
        
      
        function landmarkLocation(){
        	 var rowData = new Array();
             var tdArr = new Array();
             var radio = $("input[name=radio]:checked");
             if(radio.is(":checked")){
	              radio.each(function(i){
	        	       var tr = radio.parent().parent().parent().eq(i);
	        	       var td = tr.children().children();
	        	       rowData.push(tr.text());
	        	   
	        	       var roadFullAddr= td.eq(8).text();
	               	   var name = td.eq(4).text();
	               	   
	        	       tdArr.push(roadFullAddr);
	        	       tdArr.push(name);
	              });
	              var roadFullAddr= tdArr[0];
	              var name = tdArr[1];
	              	if(roadFullAddr!=null && roadFullAddr!="" &&roadFullAddr!="undefined"){
		              	var mapContainer = document.getElementById('kakaoMap'), // 지도를 표시할 div 
				        	  mapOption = {
				        	      center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				        	      level: 3 // 지도의 확대 레벨
				        	  };  
			        	
			        	//지도를 생성합니다    
			        	var map = new kakao.maps.Map(mapContainer, mapOption); 
			        	
			        	//주소-좌표 변환 객체를 생성합니다
			        	var geocoder = new kakao.maps.services.Geocoder();
			        	
			        	//주소로 좌표를 검색합니다
			        	geocoder.addressSearch(roadFullAddr, function(result, status) {
		        	
		        	  // 정상적으로 검색이 완료됐으면 
		        	    if (status === kakao.maps.services.Status.OK) {
		        	
		        	      var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		        	
		        	      // 결과값으로 받은 위치를 마커로 표시합니다
		        	      var marker = new kakao.maps.Marker({
		        	          map: map,
		        	          position: coords
		        	      });
		        	
		        	      // 인포윈도우로 장소에 대한 설명을 표시합니다
		        	      var infowindow = new kakao.maps.InfoWindow({
		        	          content: '<div style="width:150px;text-align:center;padding:6px 0;">'+name+'</div>'
		        	      });
		        	      infowindow.open(map, marker);
		        	
		        	      // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        	      map.setCenter(coords);
		        	  } 
		        	}); 
	              }
             }
        	
        }
        
        function doSearchPage(url,no){
            //console.log("url:"+url);
            //console.log("no:"+no);
              var frm = document.updateFrm;
              frm.workDiv.value = "doRetrievMember";
              frm.pageNum.value = no;
              frm.action =url;
              frm.submit();
            
        }
      
      	//방목록 이동
    	function goRoomList(){
    		//alert('doRetrieve');
    		var frm = document.moveFrm;
    		var sno = "${param.sno}";
    		frm.workDiv.value = "doRetrieve";
    		frm.autho.value = "1";
    		frm.searchDiv.value = "1";
    		frm.searchWord.value =sno;
    		//alert("sno="+sno);
    		frm.action = '/MAL_A/roxandrea/room.do';
    		frm.submit();
    	}
    	
        //관광명소 이동
        function goLandmark(){
        	history.go(0); 
      }    
        
		//결제페이지 이동
	  	function goPaymentInsert(){
	  		var frm = document.moveFrm;
			frm.sno.value = "${param.sno}";
			frm.workDiv.value = "goPaymentInsert";
			frm.action = '/MAL_A/roxandrea/payment.do';
			frm.submit();
	  	}
      
		//업체페이지 이동
	  	function goStoreSelectOne(){
	  		var sno = "${param.sno}";
			var frm = document.moveFrm;
			frm.workDiv.value = "doSelectOne";
			frm.autho.value = "1";
			frm.searchDiv.value = "1";
			frm.searchWord.value = sno;
			frm.sno.value=sno;
			frm.action = '/MAL_A/roxandrea/store.do';
			frm.submit();
		}
   </script>
    
  </body>
</html>