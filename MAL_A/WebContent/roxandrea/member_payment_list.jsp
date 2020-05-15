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
<%@page import="com.mal_a.cmn.SearchVO"%>
<%@page import="com.mal_a.cmn.StringUtil"%>
<%@page import="com.mal_a.payment.PaymentVO"%>
<%@page import="java.util.List"%>
<%@page session="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:url value="/roxandrea/member.do" var="logOut">
 <c:param name="workDiv" value="doLogout"></c:param>	
</c:url>
<c:url value="/roxandrea/board.do" var="hrUrl">
 <c:param name="workDiv" value="doRetrieve"></c:param>
</c:url>
<%
	
	PaymentVO paymentVO = (PaymentVO)request.getAttribute("reviewVO");

	List<PaymentVO> list = (List<PaymentVO>)request.getAttribute("list");
	for(PaymentVO vo :list) {
		//out.print(vo+"<br>");
	}

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
	
	//paging
	int maxNum			= 0;//총글수
	int currPageNo		= 1;//현재 페이지
	int rowsPerPage		= 10;//page
	
	int bottomCount		= 10;//바닥 page_cnt
	
	String url			= HR_PATH+"/roxandrea/payment.do";//호출 URL
	String scriptName 	= "doSearchPage";//JavaScript 함수: doSearchPage(url, no)
	
	if(inVO!=null){
		maxNum = (Integer)request.getAttribute("totalCnt");
		currPageNo 	  = inVO.getPageNum();
		rowsPerPage   = inVO.getPageSize();
		
		LOG.debug("===============");
		LOG.debug("=url="+url);
		LOG.debug("=scriptName="+scriptName);
		LOG.debug("=maxNum="+maxNum);
		LOG.debug("=currPageNo="+currPageNo);
		LOG.debug("=rowsPerPage="+rowsPerPage);
		LOG.debug("===============");
	}
	//--paging
	
%>
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
	            <p class="breadcrumbs mb-2"> <span>My page</span></p>
	            <h1 class="mb-4 bread">PAYMENT LIST</h1>
            </div>
          </div>
        </div>
      </div>
    </div>

	    
     <table align="center" border="0" cellpadding="20" cellspacing="0" width="100">
		<tr>
			<td colspan="0" align="center">					
					<input class="btn btn-primary py-3 px-5" type="button" onclick="location.href='javascript:goMemberMypage();'"  value="내 정보" id="cancel" />
			</td>	
			<td colspan="0" align="center">		
					<input class="btn btn-primary py-3 px-5" type="button" onclick="location.href='#'"  value="예약확인" id="cancel" />
			</td>	
			<td colspan="0" align="center">		
					<input class="btn btn-primary py-3 px-5" type="button" onclick="location.href='javascript:doMemberReview();'"  value="내가 쓴 리뷰" id="cancel" />
			</td>
			<td colspan="0" align="center">		
					<input class="btn btn-primary py-3 px-5" type="button" onclick="location.href='javascript:doMemberHeart();'"  value="좋아요" id="cancel" />
			</td>
		</tr>
	</table>

    <section class="ftco-section bg-light ftco-no-pb">
    
	
	<!-- Button -->
	<table border="0" cellpadding="5" cellspacing="0" width="600">
		<tr>
			<td colspan="2" align="right">
				<div>
						<c:forEach var="code" items="${pageSizeList}" >
							<option value="<c:out value="${code.dtlId }" />" 
								<c:if test="${paramVO.pageSize == code.dtlId }">selected="selected"</c:if>>
								<c:out value="${code.dtlNm }" />
							</option>
						</c:forEach>
					<input class="form-control input-sm" type="hidden" name="search_word" id="search_word"  value="<%=searchWord%>">
					<input  type="button"  value="환불요청" onclick="javascript:updateCanc('doUpdateCanc');"/>
					<input  type="button"  value="환불요청취소" onclick="javascript:updateCanc('doUpdateCancCanc');"/>
				</div>
			</td>
		</tr>
	</table>
	<!-- //Button -->

	 
	<form action="/MAL_A/roxandrea/payment.do" name="searchFrm" id="searchFrm" method="post">
		<input type="hidden" name="workDiv" />
		<input type="hidden" name="searchDiv" value="1"/>
		<input type="hidden" name="searchWord" />
		<input type="hidden" name="pageNum" />
		<input type="hidden" name="pno" />
		<div class="row justify-content-center mb-5 pb-3">
         	<div class="col-md-10 heading-section text-center ftco-animate"> 
				<table class="table table-hover" width="1200" height="200">
					<thead>
						<tr>
							<th>체크</th>
							<th>예약번호</th>
							<th>업체명</th>
							<th>방이름</th>
							<th>시작일</th>
							<th>종료일</th>
							<th>결제금액</th>
							<th>사용포인트</th>
							<th>적립포인트</th>
							<th>예약상태</th>
							<th>결제일</th>
							<th>구매확정일</th>
							<th>예약취소요청일</th>
							<th>예약취소완료일</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${null!=list && list.size()>0 }">
								<c:forEach var="vo" items="${list}" >
									<tr>
										<td><input type="radio" value="${vo.pno}" name="radioPno"/></td>
										<td><c:out value="${vo.pno}"/></td>
										<td><c:out value="${vo.sno}"/></td>
										<td><c:out value="${vo.rno}"/></td>
										<td><c:out value="${vo.startDt}"/></td>
										<td><c:out value="${vo.endDt}"/></td>
										<td><fmt:formatNumber value="${vo.pay}" pattern="#,###" />원</td>
										<td><fmt:formatNumber value="${vo.usePoint }" pattern="#,###" />P</td>
										<td><fmt:formatNumber value="${vo.savePoint }" pattern="#,###" />P</td>
										<td><c:out value="${vo.rs}"/></td>
										<td><c:out value="${vo.payDt}"/></td>
										<td><c:out value="${vo.payCmpDt}"/></td>
										<td><c:out value="${vo.cancDt}"/></td>
										<td><c:out value="${vo.cancCmpDt}"/></td>
										<td>
											<c:if test="${vo.rs eq '구매확정' && vo.reviewCheck eq '0'}">
												<input type="button" name="" id="" value="리뷰 작성" onclick="javascript:goReviewInsert($(this).parent().parent().children());"/>
											</c:if>
										</td>
									</tr>
								</c:forEach>
							</c:when>
								<c:otherwise>
									<tr>
										<td colspan="99">No data found</td>
									</tr>
								</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	<!-- 페이징 -->	
		<div>
			<%=StringUtil.renderPaging(maxNum, currPageNo, rowsPerPage, bottomCount, url, scriptName) %>
		</div>
	<!-- //페이징 -->	
	</form>
	
			
	</section>

	<form name="searchFrm2" action="/MAL_A/roxandrea/member.do" method="post">
    				<input type="hidden" name="workDiv" />
					<input type="hidden" name="pageNum" />
					<input type="hidden" name="regId" />
					<input type="hidden" name="searchDiv" />
					<input type="hidden" name="searchWord" />
	</form>
	
	<form name="searchFrm3" action="/MAL_A/roxandrea/heart.do" method="post">
    				<input type="hidden" name="workDiv" />
					<input type="hidden" name="pageNum" />
					<input type="hidden" name="regId" />
					<input type="hidden" name="searchDiv" />
					<input type="hidden" name="searchWord" />
	</form>
	
	<form name="form" id="form" action="/MAL_A/roxandrea/member.do"  method="post" >
	    <input type="hidden" name="workDiv" value="doInsert" id="workDiv" />
	    <input type="hidden" name="mid"  id="mid"/>
	</form>
	

	<%@ include file="/cmn/footer.jsp" %>  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

<script type="text/javascript">
	//위에서 아래로 해석(인터프리터 방식)
	
	//리뷰 작성
	function goReviewInsert(thisTd){
		var frm = document.searchFrm;
		frm.workDiv.value = "doSelectOnePno";
		frm.pno.value = thisTd.eq(1).text();
		frm.action = '/MAL_A/roxandrea/payment.do';
		frm.submit();
	}
	//--리뷰 작성
	
	//취소요청
	function updateCanc(param){
		var radPno = document.querySelector('input[name="radioPno"]:checked').value;
		//console.log(radPno);
		
		
		if(false==confirm('예약번호: '+radPno+' 을(를)\n취소요청 하시겠습니까?'))return;
		
		//ajax
		$.ajax({
		    type:"POST",
		    url:"/MAL_A/roxandrea/payment.do",
		    dataType:"html", 
		    data:{"workDiv":param,
		    	  "pno":document.querySelector('input[name="radioPno"]:checked').value
		    },
		    success:function(data){ //성공
				console.log("data="+data);
				//alert("data:"+data);
				var jData = JSON.parse(data);
				//성공
				if(jData!=null && jData.msgId=="1"){
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
	}
	
		function doRetrieve(){
			//alert('doRetrieve');
			var frm = document.searchFrm;
			frm.workDiv.value = "doRetrieve";
			frm.searchDiv.value = "1";
			frm.pageNum.value = "1";
			frm.action = '/MAL_A/payment/payment.do';
			frm.submit();
		}
	
	
	function doMemberReview(){
  		var regId = "park01";
  		
		var frm = document.searchFrm2;
		frm.workDiv.value = "doRetrieveReview";
		frm.regId.value = regId;
		frm.searchDiv.value = "3";
		frm.searchWord.value = regId;
		frm.action = '/MAL_A/roxandrea/member.do';
		frm.submit();
	}
	
	function doMemberHeart(){
  		var regId = "park01";
  		
		var frm = document.searchFrm3;
		frm.workDiv.value = "doRetrieveHeart";
		frm.regId.value = regId;
		frm.action = '/MAL_A/roxandrea/heart.do';
		frm.submit();
	}
	
	function doSearchPage(url, no){
		console.log("url:"+url);
		console.log("no:"+no);
		
		var frm = document.searchFrm;
		frm.workDiv.value = "doRetrieve";
		frm.pageNum.value = no;
		frm.action = url;
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