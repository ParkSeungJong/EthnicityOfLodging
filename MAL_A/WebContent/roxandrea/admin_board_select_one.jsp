<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ------------------
  *  2020. 3. 9.       WH           최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"    
    errorPage="/cmn/error.jsp"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   

<%@page import="com.mal_a.board.BoardVO"%>
<%@page import="com.mal_a.cmn.StringUtil"%>
<%@page import="com.mal_a.code.CodeVO"%>
<%@page import="com.mal_a.cmn.SearchVO"%>
<%@page import="com.mal_a.comments.CommentsVO"%>
<%@page import="com.mal_a.comments.CommentsCont"%>
<%@page import="java.util.List"%>  
<%
    //param
    String pageNum    ="1";//페이지 넘버
    String searchDiv  = "";//검색구분
    String searchWord ="";//검색어
    String pageSize   ="10";//페이지 사이즈

    SearchVO inVO= (SearchVO)request.getAttribute("paramVO");
    if(null !=inVO){
        LOG.debug("===========");
        LOG.debug("=inVO="+inVO);
        LOG.debug("===========");
        pageNum    = String.valueOf(inVO.getPageNum());
        searchDiv  = inVO.getSearchDiv();
        searchWord = inVO.getSearchWord();
        pageSize   = String.valueOf(inVO.getPageSize());
    }
    
    //code
    List<CodeVO> searchList =  (List<CodeVO>)request.getAttribute("searchList");
    
    List<CodeVO> pageSizeList = (List<CodeVO>)request.getAttribute("pageSizeList");
    
    List<CommentsVO> commentList = (List<CommentsVO>)request.getAttribute("commentList");
    
    String check = (String) request.getAttribute("check");
    
    String viewsCheck = (String) request.getAttribute("viewsCheck");
    
    String commentsViewsCheck = (String) request.getAttribute("commentsViewsCheck");
    
    String ri = (String) request.getAttribute("ri");
    
    String SesId = (String) request.getAttribute("SesId");
    
    //paging
    int maxNum     = 0;//총글수 
    int currPageNo = 1;//현재 페이지 
    int rowsPerPage= 10;// pageSize 
    
    int bottomCount= 10;// 바닥 page_cnt
    
    String url = HR_PATH+"/roxandrea/comments.do";//호출 URL 
    String scriptName = "doSearchPage";//JavaScript함수: doSearchPage(url,no)
    if(null !=inVO){
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
<c:url value="/roxandrea/member.do" var="myPage">
 <c:param name="workDiv" value="doSelectOne"></c:param>
</c:url>

<c:url value="/roxandrea/board.do" var="hrUrl">
 <c:param name="workDiv" value="doAdminRetrieve"></c:param>
</c:url>

<c:url value="/roxandrea/member.do" var="logOut">
 <c:param name="workDiv" value="doLogout"></c:param>    
</c:url>
   
<!DOCTYPE html>
<html lang="en">
  <head>
  <script  src="https://code.jquery.com/jquery-2.2.4.js"></script>
    <title>숙박의 민족 - MAL_A</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
          <a class="navbar-brand" href="admin_main.jsp">숙박의민족</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
          </button>

          <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a href="/MAL_A/roxandrea/admin_store_search.jsp" class="nav-link">업체검색</a></li>
            <li class="nav-item"><a href="javascript:goStoreListAll();" class="nav-link">업체관리</a></li>
             <li class="nav-item"><a href="javascript:goLandmarkListAll()" class="nav-link">관광명소관리</a></li>
            <li class="nav-item"><a href="${hrUrl}" class="nav-link">자유게시판관리</a></li>
            <li class="nav-item"><a href="javascript:goMemberListAll();" class="nav-link">회원관리</a></li>
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
                 <p class="breadcrumbs mb-2"> <span>BOARD</span></p>
                <h1 class="mb-4 bread">BOARD </h1>
            </div>
          </div>
        </div>
      </div>
    </div>

<section class="ftco-section ftco-menu" >
   <div class="container">
       <div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <h2></h2>
          </div>
        </div>
        
        <div class="col-md-17">
         
            <div class="container">  
                <!-- div title --> 
                <div class="page-header">
                </div> 
                <div class="row text-right">
                    <label for="title" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label"></label>
                    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
                        <input  type="button"  class="btn btn-default btn-sm"  value="목록" id="toListBtn" />
                        
                           <c:if test="${check eq '1'}"> 
                            <input  type="button"  class="btn btn-default btn-sm"  value="수정" id="updateBtn" />
                           </c:if> 
                         
                          <c:if test="${viewsCheck eq '1'}">
                            <input  type="button"  class="btn btn-default btn-sm"  value="정지" id="stopBtn" />
                          </c:if>
                          <c:if test="${viewsCheck eq '2'}">
                            <input  type="button"  class="btn btn-default btn-sm"  value="비정지" id="noStopBtn" />
                          </c:if>  
                    </div>
                </div>  
                
                
                <form name="insert_frm"  class="form-horizontal"  action='<%=HR_PATH %>/roxandrea/board.do'  method="post">
                    <input type="hidden" name="workDiv"  id="workDiv" />
                    <input type="hidden" name="seq"  id="seq" value="${vo.bno}" />
                    <div class="form-group">
                        <label for="title" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">제목</label>
                        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
                            <input type="text" placeholder="제목" class="form-control" value="${vo.title}" name="title" id="title" size="20"  readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="title" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">작성자</label>
                        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
                            <input type="text" placeholder="작성자" class="form-control" value="${vo.regId }" name="regId" id="regId" size="20"  readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="title" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">조회수</label>
                        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
                            <input type="text"  class="form-control"  placeholder="조회수" value="${vo.cnt }" name="read_cnt" id="read_cnt" size="20" readonly/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="title" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">내용</label>
                        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
                            <textarea rows="5"  class="form-control"  name="contents" id="contents" cols="40" readonly>${vo.cont }</textarea>
                        </div>
                    </div>
                </form>
            </div>    
            
            <h2>댓글</h2>
         
            
    <div >     
         <form action="/MAL_A/roxandrea/comments.do" name="searchFrm" id="searchFrm" method="post">
                <input type="hidden" name="workDiv"  id="workDiv" />
                <input type="hidden" name="page_num"   />  
                <input type="hidden" name="regId"   />  
                <input type="hidden" name="cont"   />  
                <input type="hidden" name="seq1" id="seq1" value="${vo.bno}" />
                <input type="hidden" name="cno" id="cno"  />
                <input type="hidden" name="workDiv1"  id="workDiv1" />
                <input type="hidden" name="seq1"  id="seq1" value="${vo.bno}" />
        
                <div class="table-responsive">          
                    <table  id="listTable1" class="table table-condensed"   >
                        <thead>
                            <tr>
                                <th  class="text-center  ">NO</th>
                                <th  class="text-center ">등록자ID</th>
                                <th  class="text-center  ">등록일</th>
                                <th style="display:none;">BNO</th>
                                <th style="display:none;">CNO</th>
                                <th  class="text-center  ">내용</th>
                                <th class="text-center  ">버튼</th>
                                <th class="text-center  ">정지여부</th>
                                <th class="text-center  ">정지버튼</th>
                            </tr>
                        </thead>
                        <tbody>
                             <c:choose>
                                   <c:when test="${commentList.size()>0}">
                                        <c:forEach var="commentVO"   items="${commentList}" >
                                        
                                            <tr>
                                                <!-- <td><input type="radio" value="${vo.num }" name="radioBtn"/></td>--> 
                                                <td  class="text-center   "><c:out value="${commentVO.num }"></c:out></td>
                                                <td  class="text-center    "><c:out value="${commentVO.regId }"></c:out></td>
                                                <td  class="text-center  "><c:out value="${commentVO.regDt }"></c:out></td>
                                                <td style="display:none;"><c:out value="${commentVO.bno }"></c:out></td>
                                                <td style="display:none;"><c:out value="${commentVO.cno }"></c:out></td>
                                                <td  class="text-center " >
                                                    <c:out value="${commentVO.cont }"></c:out>
                                                </td>
                                                <td class="td3" style="text-align:center;">
                                                  <c:if test="${SesId eq commentVO.regId}">
                                                        <div id="comment_btn" style="display:block; ">
                                                             <button class="modbtn" style="  padding:2px" OnClick="change($(this).parent().parent().parent());">수정</button>
                                                             <button class="delbtn" style="  padding:2px">삭제</button>
                                                        </div>
                                                   </c:if>  
                                                </td>
                                                <td  class="text-center  "><c:out value="${commentVO.views }"></c:out></td>
                                                <td class="td3" style="text-align:center;">
                                                    <c:if test="${commentVO.views eq '비정지'}">
	                                                    <button class="commentsStop" style=" padding:2px;"  >정지</button>
	                                                 </c:if>
	                                                 <c:if test="${commentVO.views eq '정지'}">
	                                                    <button class="commentsNoStop" style=" padding:2px"  >비정지</button>
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
	         <div class="container">  
	                <!-- div title --> 
	                <div class="page-header">
	                   
	                </div> 
	                <div class="row text-right">
	                    <label for="title" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label"></label>
	                    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
	                        <input  type="button"  class="btn btn-default btn-sm"  value="등록" id="commentsinsertBtn" />
	                    </div>
	                </div>  
	                

	
	                <div class="form-group">
	                        <label for="title" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">내용</label>
	                        <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
	                            <textarea rows="5"  class="form-control"  name="contents" id="contents1" cols="40"></textarea>
	                        </div>
	               </div>
              </div>
          
          
         </form>        
     </div>
     
   </div>
</div>
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
  
  <script type="text/javascript">
  
  
  
  //회원관리
  function goMemberListAll(){
      window.location.href='/MAL_A/roxandrea/member.do?workDiv=doRetrieveAdmin';
  }
  
  //업체관리
  function goStoreListAll(){
      window.location.href='/MAL_A/roxandrea/store.do?workDiv=doRetrieveAdmin';
  }
  
 //관광명소 관리
 function goLandmarkListAll(){
    window.location.href='/MAL_A/roxandrea/landmark.do?workDiv=doRetrieveAdmin';
 }
  
  


  $("#stopBtn").on("click",function(){//게시글 비정지 ->정지 버튼
      
      //seq
      var seq = $("#seq").val();
      var views = "2";
      var modId = "${SesId}";

      if(false==confirm(seq+'번 게시글을 수정하시겠습니까?'))return;
       //ajax
      $.ajax({
        type:"POST",
        url:"/MAL_A/roxandrea/board.do",
        dataType:"html", 
        data:{"workDiv":"doViewsUpdate",
              "views":views,
              "modId":modId,
              "seq":seq
        },
        success:function(data){ //성공
             console.log("data="+data);
             var jData = JSON.parse(data);
             //성공
             if(null !=jData && jData.msgId=="1"){
                 alert(jData.msgContents);
                 goRetrieve();
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
  
  
  
  $("#noStopBtn").on("click",function(){//게시글 정지 ->비정지 버튼
      
      //seq
      var seq = $("#seq").val();
      var views = "1";
      var modId = "${SesId}";


      if(false==confirm(seq+'번 게시글을 수정하시겠습니까?'))return;
      
       //ajax
      $.ajax({
        type:"POST",
        url:"/MAL_A/roxandrea/board.do",
        dataType:"html", 
        data:{"workDiv":"doViewsUpdate",
              "views":views,
              "modId":modId,
              "seq":seq
        },
        success:function(data){ //성공
             console.log("data="+data);
             var jData = JSON.parse(data);
             //성공
             if(null !=jData && jData.msgId=="1"){
                 alert(jData.msgContents);
                 goRetrieve();
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
  
  
  
   $(".commentsStop").on("click",function(){//댓글 정지 ->비정지 버튼
      
      //cno
      var cno = ($(this).parent().parent()).children().eq(4).text();
      console.log("cno"+cno);
      var views = "2";
      console.log("views"+views);
      var modId = "${SesId}";
      console.log("modId=="+modId);
      event.preventDefault();


       if(false==confirm(cno+'번 게시글을 수정하시겠습니까?'))return;
      
       //ajax
       $.ajax({
        type:"POST",
        url:"/MAL_A/roxandrea/comments.do",
        dataType:"html", 
        data:{"workDiv":"doViewsUpdate",
              "views":views,
              "modId":modId,
              "cno":cno
        },
        success:function(data){ //성공
             console.log("data="+data);
             var jData = JSON.parse(data);
             //성공
             if(null !=jData && jData.msgId=="1"){
                 alert(jData.msgContents);
                 goRetrieve1();
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
   
   
   
   
   $(".commentsNoStop").on("click",function(){//댓글 정지 ->비정지 버튼
	      
	      //cno
	      var cno = ($(this).parent().parent()).children().eq(4).text();
	      console.log("cno"+cno);
	      var views = "1";
	      console.log("views"+views);
	      var modId = "${SesId}";
	      console.log("modId=="+modId);
	      event.preventDefault();


	       if(false==confirm(cno+'번 게시글을 수정하시겠습니까?'))return;
	      
	       //ajax
	       $.ajax({
	        type:"POST",
	        url:"/MAL_A/roxandrea/comments.do",
	        dataType:"html", 
	        data:{"workDiv":"doViewsUpdate",
	              "views":views,
	              "modId":modId,
	              "cno":cno
	        },
	        success:function(data){ //성공
	             console.log("data="+data);
	             var jData = JSON.parse(data);
	             //성공
	             if(null !=jData && jData.msgId=="1"){
	                 alert(jData.msgContents);
	                 goRetrieve1();
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
  
  
  
  
  
  
  
    
    function change(param){//수정버튼클릭시 텍스트필드로변환
        var removeTd01 =param.children().eq(5);
        var removeTd02 =param.children().eq(6);
        var removeTd03 =param.children().eq(7);
        var removeTd04 =param.children().eq(8);
        event.preventDefault();
        removeTd01.remove();
        removeTd02.remove();
        removeTd03.remove();
        removeTd04.remove();
        param.append("<td><textarea name='message' id='message' placeholder='Message' value = ''></textarea></td><td><div id='comment_btn' style='display:block; '><button class='modcom' style='padding:2px' OnClick='mod1($(this).parent().parent().parent());'>수정완료</button><button class='noUpdate' style='padding:2px'>수정취소</button></div></td><td><c:out value='${commentVO.views}'></c:out></td><td></td>");
        
    }
 
    
    $(document).on("click",".noUpdate",function(){//수정취소버튼
    	var bno = $("#seq1").val();
    	event.preventDefault();
    	goRetrieve1();
    });
    
    
    
    $(document).on("click",".modcom",function(){//댓글수정완료버튼
        //seq
       
        event.preventDefault();
        var cno = ($(this).parent().parent().parent()).children().eq(4).text();
        var regId = ($(this).parent().parent().parent()).children().eq(1).text();
        var regDt = ($(this).parent().parent().parent()).children().eq(2).text();
        var contents = $("#message").val();
        var bno = $("#seq1").val();
       
        //ajax
        
        $.ajax({
          type:"POST",
          url:"/MAL_A/roxandrea/comments.do",
          dataType:"html",
          data:{"workDiv":"doUpdate",
                "cno1":cno,
                "regId1":regId,
                "contents1":contents,
                "seq1":bno
          },
          success:function(data){ //성공
                   goRetrieve1();
            
          },
          error:function(xhr,status,error){
           alert("error:"+error);
          },
          complete:function(data){
          
          }   
        
        });//--ajax   
        
    });  
    
    $(".delbtn").on("click",function(){//댓글삭제버튼
       
        
        var cno = ($(this).parent().parent().parent()).children().eq(4).text() ;
        var bno = $("#seq1").val();
        var workDiv = "doDelete";
        if(cno == null){
            alert("순번을 확인 하세요.");
            return;
        }
        if(false==confirm('삭제하시겠습니까?'))return;
        event.preventDefault();
        //ajax
        $.ajax({
            type:"POST",
            url:"/MAL_A/roxandrea/comments.do",
            dataType:"html",
            data:{"workDiv":"doDelete",
                  "cno":cno               
            },
            success:function(data){ //성공
               var jData = JSON.parse(data);
               //성공
               if(null !=jData && jData.msgId=="1"){
                   goRetrieve1();
               }else{
                   goRetrieve1();
               }

            },
            error:function(xhr,status,error){
             alert("error:"+error);
            },
            complete:function(data){

            }   
        });//--ajax     
    });   


 
    
    
    
    //수정
    $("#updateBtn").on("click",function(){//수정페이지로이동버튼
      goUpdate();
      
      
    }); 
    
    

    


    //위에서 아래로 해석(인터프리터 방식)
    $("#toListBtn").on('click',function(){//게시판 목록페이지로이동
        goRetrieve();
    });
    
    
    
    function goRetrieve(){//게시판 목록페이지로이동함수
        window.location.href='/MAL_A/roxandrea/board.do?workDiv=doAdminRetrieve';
    }
    
    function goRetrieve1(){//게시글페이지로이동 함수
        /* window.location.href='/MAL_A/roxandrea/board.do?workDiv=doAdminSelectOne&page_num=&seq='+sq+'&searchDiv=&searchWord=&pageSize=10'; */
    	 history.go(0);
    }
    
    function goUpdate(){//게시글수정페이지로 데이터전달함수
         var frm = document.searchFrm;
         frm.workDiv.value = "doSelectOne2";
         frm.seq1.value = seq1;
         frm.regId.value = regId;
         frm.action = '/MAL_A/roxandrea/board.do';
         frm.submit();
    }
    
    
 



    $("#commentsinsertBtn").on('click',function(){//댓글 등록버튼
        var workDiv = "doInsert";
        if(null == workDiv || workDiv.trim().length==0){
                alert("작업구분을 확인 하세요.");
                return;
        }
        var regId    = "${SesId}";
        console.log("regId=="+regId);
        var contents = $("#contents1").val();
        if(null == contents || contents.trim().length==0){
            $("#contents1").focus();//focus
            alert("내용을 입력 하세요.");
            return;
        }
        if(false == confirm(contents+"을(를)\n등록 하시겠습니까?"))return;
        //ajax
        $.ajax({
             type:"POST",
             url:"/MAL_A/roxandrea/comments.do",
             dataType:"html", 
             data:{"workDiv":workDiv,
                   "regId1":regId,
                   "contents1":$("#contents1").val(),
                   "seq1":$("#seq1").val()
             },
             success:function(data){ //성공
                 //json String --> json object
                  var jsonObj = JSON.parse(data);
                  if(null != jsonObj && jsonObj.msgId=="1"){
                      alert(jsonObj.msgContents);
                      goRetrieve1();
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
        

        
    });//--#comments_btn  
    
    
    
    
    
   
    
    
    $(document).ready(function(){
        

    
    });
    



  </script>   
  
  
    
  </body>
</html>