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
<%@page import="com.mal_a.stooption.StoOptionVO"%>
<%@page import="com.mal_a.code.CodeVO"%>
<%@page import="com.mal_a.filemng.FileMngVO"%>
<%@page import="com.mal_a.store.StoreVO"%>
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
<c:url value="/roxandrea/member.do" var="logOut">
 <c:param name="workDiv" value="doLogout"></c:param>	
</c:url>
<%
	StoreVO storeVO = (StoreVO)request.getAttribute("storeVO");
	List<FileMngVO> outListFileMng = (List<FileMngVO>)request.getAttribute("outListFileMng");
	List<StoOptionVO> outListStoOption = (List<StoOptionVO>)request.getAttribute("outListStoOption");
%>
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
			<a class="navbar-brand" href="bis_main.jsp">숙박의민족</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
	      	</button>
			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
	          		<li class="nav-item"><a href="javascript:goBack();" class="nav-link">내가게</a></li>
					<li class="nav-item"><a href="javascript:goMemberMypage();" class="nav-link">마이페이지</a></li>
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
	            		<p class="breadcrumbs mb-2"><span class="mr-2"><a href="index.html">Home</a></span> <span>Blog</span></p>
	            		<h1 class="mb-4 bread">업체 수정</h1>
            		</div>
          		</div>
        	</div>
		</div>
	</div>
	
	<section class="ftco-section">
		
			<div class="container">
				<div class="row justify-content-center mb-5 pb-3">
	          		<div class="col-md-7 heading-section text-center ftco-animate">
	          			<span class="subheading">store_update</span>
	            		<h2>업체 수정</h2>
	            	</div>
	            </div>
			</div>
			
			<!-- 정보 입력란 -->
			<div class="container">
				<form name="form" id="form" action="<%=HR_PATH %>/roxandrea/store.do" method="post">
		    		<input type="hidden" name="workDiv" id="workDiv" value="doInsert" />
		    		<input type="hidden" name="autho"/>
		    		<input type="hidden" name="sno"/>
		    		<input type="hidden" name="searchDiv"/>
		    		<input type="hidden" name="searchWord"/>       			
					<div class="row justify-content-center mb-5 pb-3">			
						<div class="wrap bg-white align-self-stretch py-3 px-4">			
							<div class="col-md-12 room-single mt-4 mb-5 ftco-animate" align="center">
								<div class="d-md-flex mt-10 mb-10 py-5">
									<table border="1" cellpadding="5" cellspacing="0" width="600">
										<thead>
										</thead>
										<tbody>
											<tr>
												<td bgcolor="#E6FFFF">업체명</td>	
												<td><input type="text" name="name" id="name" value="${storeVO.name}" size="40" placeholder="최대 30자로 입력하세요." maxlength="30" translate="no"/></td>
											</tr>
											
											<tr>
												<td bgcolor="#E6FFFF">전화번호</td>	
												<td>
													<input class="phoneNumber" type="text" name="tel" value="${storeVO.tel}" id="tel" size="40" placeholder="'-'를 빼고 입력하세요." maxlength="13" translate="no"/>
												</td>
											</tr>
											
											<tr>
												<td bgcolor="#E6FFFF">업소 분류</td>
												<td>
													<c:choose>
														<c:when test="${storeVO.stoPart eq '펜션'}">
															<input type="radio" value="1" name="radioBtn" checked/>&nbsp;펜션&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="radio" value="2" name="radioBtn"/>&nbsp;모텔&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="radio" value="3" name="radioBtn"/>&nbsp;호텔&nbsp;&nbsp;&nbsp;&nbsp;
														</c:when>
														<c:when test="${storeVO.stoPart eq '모텔'}">
															<input type="radio" value="1" name="radioBtn"/>&nbsp;펜션&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="radio" value="2" name="radioBtn" checked/>&nbsp;모텔&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="radio" value="3" name="radioBtn"/>&nbsp;호텔&nbsp;&nbsp;&nbsp;&nbsp;
														</c:when>
														<c:when test="${storeVO.stoPart eq '호텔'}">
															<input type="radio" value="1" name="radioBtn"/>&nbsp;펜션&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="radio" value="2" name="radioBtn"/>&nbsp;모텔&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="radio" value="3" name="radioBtn" checked/>&nbsp;호텔&nbsp;&nbsp;&nbsp;&nbsp;
														</c:when>
														<c:otherwise>
															<input type="radio" value="1" name="radioBtn"/>&nbsp;펜션&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="radio" value="2" name="radioBtn"/>&nbsp;모텔&nbsp;&nbsp;&nbsp;&nbsp;
															<input type="radio" value="3" name="radioBtn"/>&nbsp;호텔&nbsp;&nbsp;&nbsp;&nbsp;
														</c:otherwise>
													</c:choose>
												</td>
											</tr>	
											
											<tr>
												<td bgcolor="#E6FFFF">우편번호</td>	
												<td><input type="text"  size="40" id="zipNo"  name="zipNo" value="${storeVO.addrNo}" readonly/>
													<input type="button" value="우편번호 찾기" onclick="goPopup();"/></td>
											</tr>
											<tr>
												<td bgcolor="#E6FFFF">주소</td>	
												<td><input type="text"  size="40" id="roadFullAddr"  name="roadFullAddr" value="${storeVO.addr}" readonly/></td>
											</tr>
											
											<tr>
												<td bgcolor="#E6FFFF">업체 소개</td>
												<td><textarea name="cont" id="cont" rows="10" cols="60" placeholder="최대 1000자로 입력해주세요." maxlength="1000" translate="no">${storeVO.cont}</textarea></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
			<!-- //정보 입력란 -->
			
			<!-- 옵션 선택란 -->
			<div class="container">
				<div class="row justify-content-center mb-5 pb-3">			
					<div class="wrap bg-white align-self-stretch py-3 px-4">			
						<div class="col-md-12 room-single mt-4 mb-5 ftco-animate" align="center">
							<div class="d-md-flex mt-10 mb-10 py-5">
								<div class="d-md-flex mt-5 mb-5" align="center">
									<table border="1" cellpadding="5" cellspacing="0" width="600">
										<thead>
											<tr>
												<th>Keywords</th>
											</tr>
										</thead>
										<tbody>
											<c:choose>
												<c:when test="${null!=outListStoOption && outListStoOption.size()>0 }">
													<c:forEach var="stoOptionVO" items="${outListStoOption }" >
														<tr>
															<td>
																<c:if test="${stoOptionVO.yn eq '1'}">
																	&nbsp;<input type="checkbox" id="stoOption" name="stoOption" value="${stoOptionVO.opt }" checked/>&nbsp;${stoOptionVO.optName }
																</c:if>
																<c:if test="${stoOptionVO.yn eq '0'}">
																	&nbsp;<input type="checkbox" id="stoOption" name="stoOption" value="${stoOptionVO.opt }" />&nbsp;${stoOptionVO.optName }
																</c:if>
																
															</td>
														</tr>
													</c:forEach>
												</c:when>
											</c:choose>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- 옵션 선택란 -->
			
			<!-- 파일 첨부 -->
			<div class="container">
				<div class="row justify-content-center mb-5 pb-3">			
					<div class="wrap bg-white align-self-stretch py-3 px-4">			
						<div class="col-md-12 room-single mt-4 mb-5 ftco-animate" align="center">
							<div class="d-md-flex mt-10 mb-10 py-5">
								<div class="d-md-flex mt-5 mb-5" align="center">
									<form action="<%=HR_PATH %>/roxandrea/store.do" method="post" name="fileFrm" id="fileFrm">
										<input type="hidden" name="fileId" id="fileId" value="${storeVO.fileId }">
										<table>
											<tbody>
												<tr>
													<td><h1>사진 첨부</h1></td>
													<td><input type="button" onclick="javascript:centerPopup(document.fileFrm);" value="파일첨부" ></td>
													<td><input type="button" onclick="javascript:doUploadCancle(document.fileFrm);" value="파일삭제" ></td>
												</tr>
											</tbody>
										</table>
										<table border="1" cellpadding="5" cellspacing="0" width="600">
											<thead>
												<tr>
													<th>체크</th>
													<th>파일명</th>
												</tr>
											</thead>
											<tbody id="uploadTbody">
											<c:choose>
												<c:when test="${null!=outListFileMng && outListFileMng.size()>0 }">
													<c:forEach var="fileMngVO" items="${outListFileMng }" >
														<tr>
															<td><input type="checkbox" name="fileCheck"></td>
															<td><input type="text" name="orgNm" id="orgNm" value="${fileMngVO.orgNm }"><br/></td>
															<td style="display:none;"><input type="hidden" name="saveNm" id="saveNm" value="${fileMngVO.saveNm }"><br/></td>
															<td style="display:none;"><input type="hidden" name="savePath" id="savePath" value="${fileMngVO.savePath }"><br/></td>
															<td style="display:none;"><input type="hidden" name="fileSize" id="fileSize" value="${fileMngVO.fileSize }"><br/></td>
															<td style="display:none;"><input type="hidden" name="ext" id="ext" value="${fileMngVO.ext }"><br/></td>
														</tr>
													</c:forEach>
												</c:when>
											</c:choose>
										</tbody>
										</table>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //파일 첨부 -->
			
			<!-- 버튼 -->
			<div class="container">    			
				<div class="row justify-content-center mb-5 pb-3">			
					<div class="wrap bg-white align-self-stretch py-3 px-4">			
						<div class="col-md-30 room-single mt-30 mb-30 ftco-animate">
							<div class="d-md-flex mt-10 mb-10 py-5">
								<input type="button" value="수정완료" onclick="javascript:doUpdate();"/>
								<input type="button" value="취소" onclick="javascript:goBack();"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //버튼 -->
			
			<form name="memberFrm" id="memberFrm" action="/MAL_A/roxandrea/member.do" method="post" >
			    <input type="hidden" name="workDiv" id="workDiv" value="doInsert" />
			    <input type="hidden" name="autho" id="autho"/>
			    <input type="hidden" name="searchDiv" id="searchDiv"/>
				<input type="hidden" name="searchWord" />
				<input type="hidden" name="pageNum" />
			</form>
			
        
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
  	//업체 셀렉트원으로 이동
  	function goStoreSelectOne(){
  		var sno = "${storeVO.sno}";
  		
		var frm = document.form;
		frm.workDiv.value = "doSelectOne";
		frm.autho.value = "2";
		frm.sno.value = sno;
		frm.searchDiv.value = "1";
		frm.searchWord.value = sno;
		frm.action = '/MAL_A/roxandrea/store.do';
		frm.submit();
  	}
  	//--업체 셀렉트원으로 이동
  
  	//전화번호 입력란 숫자만 셋팅
  	$(document).on("keyup", ".phoneNumber", function() {
  		$(this).val(
  			$(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})/,"$1-$2-$3").replace("--", "-")
  		);
  	});
  	//--전화번호 입력란 숫자만 셋팅
  
	//업체 수정
	function doUpdate(){
		//스토어 파람 생성
		var sno = "${storeVO.sno}";
		var name = $("#name").val();//업체명
		var tel = $("#tel").val();//전화번호
		var stoPart = $("input[name=radioBtn]:checked").val();//업체 분류
		var addrNo = $("#zipNo").val();//우편번호
		var addr = $("#roadFullAddr").val();//주소
		var cont = $("#cont").val();//업체분류
		var fileId = $("#fileId").val();//설명
		
		//유효성 검사
		if(name==""){
			alert('업체명을 입력해주세요.');
			return;
		}else if(tel==""){
			alert('전화번호를 입력해주세요.');
			return;
		}else if(stoPart==undefined){
			alert('업소 분류를 체크해주세요.');
			return;
		}else if(addrNo=="" || addr==""){
			alert('우편번호 및 주소를 입력해주세요.');
			return;
		}else if(cont==""){
			alert('업체 소개를 입력해주세요.');
			return;
		}
		
		/*
		if(isNaN(capacity) || isNaN(price1) || isNaN(price2)){
			alert('수용인원 및 가격은 숫자로만 입력해주세요.');
			return;
		}else if(capacity<0 || price1<0 || price2<0){
			alert('수용인원 및 가격에 음수는 입력 할 수 없습니다.');
			return;
		}else if(!checkDecimal.test(capacity) || !checkDecimal.test(price1) || !checkDecimal.test(price2)){
			alert('수용인원 및 가격에 소수는 입력 할 수 없습니다.');
			return;
		}
		*/
		
		//첨부파일 파람 생성
		var filePart = "1";//첨부파일 페이지 분류
		
		//첨부파일 배열 객체 생성
		var orgNm = [];//첨부파일 원본명
		var saveNm = [];//첨부파일 저장명
		var savePath = [];//첨부파일 저장경로
		var fileSize = [];//첨부파일 사이즈
		var ext = [];//첨부파일 확장자
		
		//첨부파일 배열 수 만큼 for문 돌려서 배열에 담기
		var size = $("input[name='orgNm']").length;
		for(i=0;i<size;i++){
			orgNm.push($("input[name='orgNm']").eq(i).val());
			saveNm.push($("input[name='saveNm']").eq(i).val());
			savePath.push($("input[name='savePath']").eq(i).val());
			fileSize.push($("input[name='fileSize']").eq(i).val());
			ext.push($("input[name='ext']").eq(i).val());
		}
		
		//업체 옵션 수 만큼 for문 돌려서 배열에 담기
		var stoOptionCheck = $("input:checkbox[name='stoOption']");
		var stoOption = [];
		for(var i=0;i<stoOptionCheck.length;i++){
			//console.log(stoOptionCheck);
			if(stoOptionCheck[i].checked==true){
				stoOption.push("1");
			}else{
				stoOption.push("0");
			}
			//console.log(i+1+"번째 옵션 값: "+stoOption[i]);
		}
		
		if(false==confirm('수정 하시겠습니까?'))return;
		
		//비동기통신
		$.ajax({
			type: "POST",//데이터 전송방식(POST/GET),
			url: "/MAL_A/roxandrea/store.do",//요청URL,
			dataType: "json",//서버에서 받아올 데이터 타입,
			traditional: true,
			data: {"workDiv": "doUpdate",
					"name": name,
					"tel": tel,
					"stoPart": stoPart,
					"sno": sno,
					"addrNo": addrNo,
					"addr": addr,
					"cont": cont,
					"fileId": fileId,
					"orgNm": orgNm,
					"saveNm": saveNm,
					"savePath": savePath,
					"fileSize": fileSize,
					"ext": ext,
					"filePart": filePart,
					"stoOption": stoOption
			},
			success:function(data){//성공
				alert('수정 성공했습니다.');
				goStoreSelectOne();
				var jData = JSON.parse(data);
				if(null != jData && jData.msgId=="1"){
					alert(jData.msgContents);
				}else{
					alert(jData.msgId+"|"+jData.msgContents);
				}
			},
			error: function(xhr,status,error){
				alert("error:"+error);
			},
			complete:function(data){
				
			}
		});//--ajax
	}
	//--업체 수정
  
  	//주소 검색 API 팝업 콜백
  	function jusoCallBack(roadFullAddr,zipNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.form.roadFullAddr.value = roadFullAddr;
		document.form.zipNo.value = zipNo;
	}
 	//--주소 검색 API 팝업 콜백
  	
 	//주소 검색 API 팝업 호출
  	function goPopup(){
  		var pop = window.open("juso_api_pop_up.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
  	}
  	//주소 검색 API 팝업 호출
  
  	//뒤로가기
  	function goBack(){
  		history.go(-1);
  	}
  	
  	//첨부파일 선택 취소
	function doUploadCancle(frm){
		//alert('asd');
		
		//name을 가지는 checkbox 항목의 전체 개수
		var checkCnt = $("input:checkbox[name='fileCheck']").length;
		//alert(checkCnt);

		//name을 가지는 checkbox 중 체크표시된 항목의 전체 개수
		var checkOnCnt = $("input:checkbox[name='fileCheck']:checked").length;
		//alert(checkOnCnt);
		
		if(checkOnCnt==0){
			alert("삭제할 첨부파일이 없습니다.");
			return;
		}
	 
		//현재 체크된 체크박스의 tr삭제
		$("input:checkbox[name='fileCheck']").each(function() {
			if(this.checked){
				var tr = $(this).parent().parent();
				tr.remove(); // 삭제하기
			}
		}); 
		
		//모든 첨부파일 삭제시 tr 삭제
		var removeCheckCnt = $("input:checkbox[name='fileCheck']").length;
		//alert(removeCheckCnt);
		if(removeCheckCnt==0){
			var tBody = $("#uploadTbody");
			tBody.find("tr").remove().end(); // 삭제하기
		}
	}
	//--파일 선택 취소

	//첨부파일 팝업 콜백
	function setChildValue(fileId, orgNm, saveNm, savePath, fileSize, ext){
	  	//alert("child:"+name);
	  	var frm = document.fileFrm;
	  	
	  	//name을 가지는 checkbox 항목의 전체 개수
		var checkCnt = $("input:checkbox[name='fileCheck']").length;
		//alert(checkCnt);
		
		var txtFileId = $("#fileId").val();
		//alert(txtFileId);
		
		if(txtFileId.length==0 || txtFileId==""){
			$("#fileId").val(fileId);
		  	$("#uploadTbody").append(
				"<tr>"
				+ "<td><input type='checkbox' name='fileCheck'></td>"
				+ "<td><input type='text' name='orgNm' id='orgNm' value="+orgNm+"></br></td>"
				+ "<input type='hidden' name='saveNm' id='saveNm' value="+saveNm+"></br>"
				+ "<input type='hidden' name='savePath' id='savePath' value="+savePath+"><br/>"
				+ "<input type='hidden' name='fileSize' id='fileSize' value="+fileSize+"></br>"
				+ "<input type='hidden' name='ext' id='ext' value="+ext+"></br></td>"
				+ "</tr>"
			);
	  	}else{
	  		//alert('asd');
	  		$("#uploadTbody").append(
				"<tr>"
				+ "<td><input type='checkbox' name='fileCheck'></td>"
				+ "<td><input type='text' name='orgNm' id='orgNm' value="+orgNm+"></br></td>"
				+ "<input type='hidden' name='saveNm' id='saveNm' value="+saveNm+"></br>"
				+ "<input type='hidden' name='savePath' id='savePath' value="+savePath+"><br/>"
				+ "<input type='hidden' name='fileSize' id='fileSize' value="+fileSize+"></br>"
				+ "<input type='hidden' name='ext' id='ext' value="+ext+"></br>"
				+ "</tr>"
			);
	  	}
	}
	//--첨부파일 팝업 콜백

	//첨부파일 팝업 출력
	function centerPopup(frm){
		console.log('openPopup');
		/*
		window.open 옵션
		no:0
		yes:1
		width : 팝업창 가로길이
		height : 팝업창 세로길이
		toolbar=no : 단축도구창(툴바) 표시안함
		menubar=no : 메뉴창(메뉴바) 표시안함
		location=no : 주소창 표시안함
		scrollbars=no : 스크롤바 표시안함
		status=no : 아래 상태바창 표시안함
		resizable=no : 창변형 하지않음
		fullscreen=no : 전체화면 하지않음
		channelmode=yes : F11 키 기능이랑 같음
		left=0 : 왼쪽에 창을 고정(ex. left=30 이런식으로 조절)
		top=0 : 위쪽에 창을 고정(ex. top=100 이런식으로 조절)
		*/
		var title ="팝업(제목)";
		var xWidth =window.screen.width/2;
		var xHeight =window.screen.height/2;
		console.log('xWidth:'+xWidth);
		console.log('xHeight:'+xHeight);
		
		var pX =xWidth - 240/2;
		var pY =xHeight - 240/2;
		console.log('pX:'+pX);
		console.log('pY:'+pY);			
		
		var status  ="toolbar=0,scrollbars=no,resizable=0,status=yes,width=240,height=200,left="+pX+',top='+pY;
		window.open("",title,status);
		
		frm.target = title;
		frm.method = "get";
		frm.action = "<c:url value='/roxandrea/file_mng_pop_up.jsp'/>";
		frm.submit();
	}//--첨부파일 팝업 출력
	
	//마이페이지
	function goMemberMypage(){
	
		var frm = document.memberFrm;
		
		frm.workDiv.value = "doSelectOne";
		frm.action = '/MAL_A/roxandrea/member.do'; 
		frm.autho.value = "2";
		frm.submit();
	}
	//--마이페이지
	
  </script>
  
</html>