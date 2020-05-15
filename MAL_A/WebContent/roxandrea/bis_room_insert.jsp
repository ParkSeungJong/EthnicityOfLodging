<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                                         수정자                      수정내용
  *  -------                  --------    ---------------------------
  *  2020. 3. 12. 오후 6:47:30   sist         최초 생성
  *
  * author 쌍용교육센터 E반
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.mal_a.code.CodeVO"%>
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
	request.setCharacterEncoding("utf-8");
	List<CodeVO> outListCodeRoomOption = (List<CodeVO>)request.getAttribute("outListCodeRoomOption");
%>
<!DOCTYPE html>
<html>
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
    <!-- END nav -->
    
		<div class="hero-wrap" style="background-image: url('images/bg_1.jpg');">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text d-flex align-itemd-end justify-content-center">
          <div class="col-md-9 ftco-animate text-center d-flex align-items-end justify-content-center">
          	<div class="text">
	            <p class="breadcrumbs mb-2"><span class="mr-2"><a href="landmark.jsp">STORE</a></span></p>
	            <h2 class="mb-4 bread">ROOM INSERT</h2>
            </div>
          </div>
        </div>
      </div>
    </div>
	
	<section class="ftco-section">
		
		<!-- container -->
		<div class="container">
			<div class="row">
			
				<!-- col-lg-8 -->
				<div class="col-lg-8">
					<div class="row">
						<div class="col-md-12 room-single mt-4 mb-5 ftco-animate" align="center">
							
							<!-- 정보입력란 -->
							<div class="d-md-flex mt-5 mb-5" align="center">
								<form name="roomFrm" id="roomFrm" action="<%=HR_PATH %>/roxandrea/room.do" method="post">
									<input type="hidden" name="workDiv" id="workDiv" value="doInsert"/>
									<input type="hidden" name="autho"/>
									<input type="hidden" name="searchDiv"/>
									<input type="hidden" name="searchWord"/>
									<div id="list"></div>
   									<div id="callBackDiv">
										<table border="1" cellpadding="5" cellspacing="0" width="600">
											<tr>
												<td bgcolor="#E6FFFF">방 이름</td>	
												<td><input type="text" name="name" id="name" size="40" placeholder="최대 30자로 입력하세요." maxlength="30" translate="no"/></td>
											</tr>
											
											<tr>
												<td bgcolor="#E6FFFF">수용 인원</td>
												<td><input type="text" name="capacity"  id="capacity" size="40" placeholder="숫자로만 입력해주세요. ex) 2 or 14..." maxlength="4" translate="no"/></td>
											</tr>	
											
											<tr>
												<td bgcolor="#E6FFFF">설명</td>
												<td><textarea name="cont"  id="cont" rows="10" cols="40" placeholder="최대 100자로 입력해주세요." maxlength="100" translate="no"></textarea></td>
											</tr>
											
											<tr>
												<td bgcolor="#E6FFFF">주중가</td>
												<td><input type="text" name="price1" id="price1" size="40" placeholder="숫자로만 입력해주세요. ex) 2 or 14..." maxlength="10" translate="no"/></td>
											</tr>
											
											<tr>
												<td bgcolor="#E6FFFF">주말가</td>
												<td><input type="text" name="price2" id="price2" size="40" placeholder="숫자로만 입력해주세요. ex) 2 or 14..." maxlength="10" translate="no"/></td>
											</tr>
											
										</table>
									</div>
								</form>
   	   	   					</div>
   	   	   					<!-- //정보입력란 -->
   	   	   					
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
																<c:when test="${null!=outListCodeRoomOption && outListCodeRoomOption.size()>0 }">
																	<c:forEach var="roomOptionVO" items="${outListCodeRoomOption }" >
																		<tr>
																			<td>
																				&nbsp;<input type="checkbox" id="roomOption" name="roomOption" value="${roomOptionVO.dtlId }" />&nbsp;${roomOptionVO.dtlNm }
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
							<div class="d-md-flex mt-5 mb-5" align="center">
								<form action="<%=HR_PATH %>/roxandrea/room.do" method="post" name="fileFrm" id="fileFrm">
									<input type="hidden" name="fileId" id="fileId" value="">
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
										</tbody>
									</table>
								</form>
							</div>
							<!-- //파일 첨부 -->
    	   	   					
   	   	   					<!-- 등록버튼 -->
							<div  class="tagcloud" align="center">
               					<div align="right">
               						<a class="tag-cloud-link" onclick="javascript:doInsert();">등록</a>
               						<a class="tag-cloud-link" onclick="javascript:goRoomList();">취소</a>
              					</div>
           					</div>
           					<!-- //등록버튼 -->
             					
           				</div>
         			</div>
         		</div>
         		<!-- //col-lg-8 -->
         
         		<!-- 카테고리 -->
          		<div class="col-lg-4 sidebar ftco-animate">
            		<div class="sidebar-box ftco-animate">
              			<div class="categories">
                			<h3>Categories</h3>
			                <li><a href="javascript:goStoreSelectOne();">업체 <span>(6)</span></a></li>
			                <li><a href="javascript:goRoomList();">방<span>(3)</span></a></li>
              			</div>
            		</div>
          		</div>
          		<!-- //카테고리 -->
          		
        	</div>
      	</div>
      	<!-- //container -->
      
	</section>
	
	
	
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
		frm.action = '/MAL_A/roxandrea/member.do'; 
		frm.submit();
	}

	//업체페이지 이동
	function goStoreSelectOne(){
		var frm = document.roomFrm;
		
		frm.workDiv.value = "doSelectOne";
		frm.autho.value = "2";
		frm.searchDiv.value = "1";
		frm.action = '/MAL_A/roxandrea/store.do';
		frm.submit();
	}

  	//룸 목록으로 복귀
  	function goRoomList(){
		var frm = document.roomFrm;
		frm.workDiv.value = "doRetrieve";
		frm.autho.value = "2";
		frm.searchDiv.value = "1";
		frm.action = '/MAL_A/roxandrea/room.do';
		frm.submit();
	}
  
	//업체 저장
	function doInsert(){
		//룸 객체 생성
		var name = $("#name").val();//방 이름
		var capacity = $("#capacity").val();//수용 인원
		var cont = $("#cont").val();//내용
		var price1 = $("#price1").val();//주중가
		var price2 = $("#price2").val();//주말가
		var fileId = $("#fileId").val();//첨부파일 ID
		
		//유효성 검사
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
		
		//첨부파일 객체 생성
		var filePart = "2";//첨부파일 페이지 분류
		
		//첨부파일 배열 객체 생성
		var orgNm = [];//첨부파일 원본명
		var saveNm = [];//첨부파일 저장명
		var savePath = [];//첨부파일 저장 경로
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
		var roomOptionCheck = $("input:checkbox[name='roomOption']");
		var roomOption = [];
		for(var i=0;i<roomOptionCheck.length;i++){
			//console.log(roomOptionCheck);
			if(roomOptionCheck[i].checked==true){
				roomOption.push("1");
			}else{
				roomOption.push("0");
			}
			//console.log(i+1+"번째 옵션 값: "+roomOption[i]);
		}
		
		if(false==confirm('등록 하시겠습니까?'))return;
		
		//비동기통신
		$.ajax({
			type: "POST",//데이터 전송방식(POST/GET),
			url: "/MAL_A/roxandrea/room.do",//요청URL,
			dataType: "json",//서버에서 받아올 데이터 타입,
			traditional: true,
			data: {"workDiv": "doInsert",
					"name": name,
					"capacity": capacity,
					"cont": cont,
					"price1": price1,
					"price2": price2,
					"fileId": fileId,
					"orgNm": orgNm,
					"saveNm": saveNm,
					"savePath": savePath,
					"fileSize": fileSize,
					"ext": ext,
					"filePart": filePart,
					"roomOption": roomOption
			},
			success:function(data){//성공
				alert('등록 성공했습니다.');
				goRoomList();
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
	//--업체 저장
  
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
		
		//모든 첨부파일 삭제시 파일ID, 저장경로 삭제
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
	}
	//--첨부파일 팝업 출력
  
  </script>	
 
  </body>
</html>