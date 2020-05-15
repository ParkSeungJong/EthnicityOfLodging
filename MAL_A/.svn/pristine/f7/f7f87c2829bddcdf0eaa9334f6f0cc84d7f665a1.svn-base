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
    errorPage="/cmn/error.jsp"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %>  

<%@page import="com.mal_a.cmn.StringUtil"%>
<%@page import="com.mal_a.code.CodeVO"%>
<%@page import="com.mal_a.cmn.SearchVO"%>
<%@page import="com.mal_a.comments.CommentsVO"%>
<%@page import="com.mal_a.comments.CommentsCont"%>
<%@page import="java.util.List"%>





<%
//req.setAttribute("list", list);//목록
//req.setAttribute("paramVO", inVO);//param
//req.setAttribute("totalCnt", totalCnt);
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
    /*
    for(CodeVO vo :searchList) {
        //out.print(vo+"<br>");
    }
    */
    
    List<CodeVO> pageSizeList = (List<CodeVO>)request.getAttribute("pageSizeList");
    /*
    for(CodeVO vo :pageSizeList) {
        out.print(vo+"<br>");
    }
    */
    
    
    
    List<CommentsVO> commentList = (List<CommentsVO>)request.getAttribute("commentList");
    /*
    for(BoardVO vo :list) {
        //out.print(vo+"<br>");
    }
    */
    //paging
    int maxNum     = 0;//총글수 
    int currPageNo = 1;//현재 페이지 
    int rowsPerPage= 10;// page_size 
    
    int bottomCount= 10;// 바닥 page_cnt
    
    String url = HR_PATH+"/comments/board.do";//호출 URL 
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

   
<!DOCTYPE html>
<html>
<head>
<script  src="https://code.jquery.com/jquery-2.2.4.js"></script>

<meta charset="UTF-8">
<title>게시판 등록</title>
</head>
<body>
    <h2>게시판 수정/삭제</h2>
    <hr/>
    <table border="0" cellpadding="5" cellspacing="0" width="600">
        <tr>
            <td colspan="2" align="right">
                <div>
                    <input  type="button"  value="목록" id="to_list_btn" />
                    <input  type="button"  value="수정" id="update_btn" />
                    <input  type="button"  value="삭제" id="delete_btn" />
                </div>
            </td>
        </tr>
    </table>    
    
    <form name="insert_frm" action='<%= HR_PATH %>/board/board.do'  method="post">
        <input type="hidden" name="work_div"  id="work_div" />
        <input type="hidden" name="seq"  id="seq" value="${vo.bno}" />
        <table border="1" cellpadding="5" cellspacing="0" width="600">
            <tr>
                <td bgcolor="#99ccff">제목</td>
                <td><input type="text" value="${vo.title}" name="title" id="title" size="20" /></td>
            <tr/>
            <tr>
                <td bgcolor="#99ccff">작성자</td>
                <td><input type="text" value="${vo.modId}" name="reg_id" id="reg_id" size="20" /></td>
            <tr/>
            <tr>
                <td bgcolor="#99ccff">조회수</td>
                <td><input type="text" value="${vo.cnt}" name="read_cnt" id="read_cnt" size="20" /></td>
            <tr/>               
            <tr>
                <td bgcolor="#99ccff">내용</td>
                <td><textarea rows="5" name="contents" id="contents" cols="40">${vo.cont}</textarea> </td>
            <tr/>           
        </table>
       
    </form>
    
     <form action="/MAL_A/board/board.do" name="searchFrm" id="searchFrm" 
          method="get">
        <input type="hidden" name="work_div"   />
        <input type="hidden" name="page_num"   />  
        <input type="hidden" name="seq"   />
    <!--//Button  -->
     
        <!-- 검색 -->

        
        </form>     
    
    <!-- 
    <form name="insert_frm" action='<%= HR_PATH %>/board/board.do'  method="post">
        <input type="hidden" name="work_div"  id="work_div" />
        <input type="hidden" name="seq"  id="seq" value="${vo.bno}" />
         -->
       <table id="listTable">
            <thead>
                <tr>
                    <th>NO</th>
                    <th>등록자ID</th>
                    <th>등록일</th>
                    <th>내용</th>
                    <th style="display:none;">SEQ</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if(null !=commentList && commentList.size()>0){
                        for(CommentsVO vo:commentList){
                %>      
                        <tr>
                            <td><%=vo.getNum() %></td>
                            <td><%=vo.getModId() %></td>
                            <td class="acenter"><%=vo.getModDt() %></td>
                            <td class="money"><%=vo.getCont() %></td>
                            <td style="display:none;"><%=vo.getBno() %></td>
                        </tr>
                <%
                        }//for
                    }else{  
                %>
                        <tr>
                            <td colspan="99">No data found</td>
                        </tr>
                <%
                    }
                %>
    
            </tbody>
        </table>
        
    <form name="insert_frm" action='<%=HR_PATH %>/comments/board.do'  method="post">
        <input type="text" name="work_div" value="do_insert" id="work_div1" />
        <input type="hidden" name="seq1"  id="seq1" value="${vo.bno}" />
        <table border="1" cellpadding="5" cellspacing="0" width="600">
            <tr>
                <td bgcolor="#99ccff">등록자</td>
                <td><input type="text"  name="reg_id" id="reg_id1" size="20" /></td>
            <tr/>
            <tr>
                <td bgcolor="#99ccff">등록날짜</td>
                <td><input type="text" value="${vo.regDt}" name="reg_Dt" id="reg_Dt1" size="20" /></td>
            <tr/>   
            <tr>
                <td bgcolor="#99ccff">내용</td>
                <td><textarea rows="5"  name="contents" id="contents1" cols="40"></textarea> </td>
            <tr/>  
            <tr>
            <td colspan="2" align="right">
                <div>
                    <input  type="button"  value="등록" id="comments_btn" />
                </div>
            </td>
        </tr>         
        </table>
        
    </form>
        
        <!-- 
      </form>
       -->
    
<script type="text/javascript">

    //수정
    $("#update_btn").on("click",function(){
        console.log("#update_btn");
        
        //seq
        var seq = $("#seq").val();
        if(null ==seq || seq.trim().length ==0){
            alert("순번을 확인 하세요.");
            return;
        }
        //title
        var title = $("#title").val();
        if(null ==title || title.trim().length ==0){
            $("#title").focus();
            alert("제목을 확인 하세요.");
            return;
        }
        //contents
        var contents = $("#contents").val();
        if(null ==contents || contents.trim().length ==0){
            $("#contents").focus();
            alert("내용을 확인 하세요.");
            return;
        }
        if(false==confirm(title+'을(를)\n수정하시겠습니까?'))return;
        
        //ajax
        $.ajax({
          type:"POST",
          url:"/MAL_A/board/board.do",
          dataType:"html", 
          data:{"work_div":"do_update",
                "seq":$("#seq").val(),
                "title":$("#title").val(),
                "reg_id":$("#reg_id").val(),
                "contents":$("#contents").val()
          },
          success:function(data){ //성공
               console.log("data="+data);
            // alert("data:"+data);
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


    //삭제
    $("#delete_btn").on("click",function(){
        //console.log("#delete_btn");
        var seq = $("#seq").val();
        
        console.log("seq="+seq);
        if(seq == null){
            alert("순번을 확인 하세요.");
            return;
        }
        
        if(false==confirm('삭제하시겠습니까?'))return;   
        //ajax
        $.ajax({
            type:"POST",
            url:"/MAL_A/board/board.do",
            dataType:"html", 
            data:{"work_div":"do_delete",
                  "seq":$("#seq").val()
            },
            success:function(data){ //성공
               console.log("data="+data);
               //alert("data:"+data);
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


    //위에서 아래로 해석(인터프리터 방식)
    $("#to_list_btn").on('click',function(){
        //console.log("#to_list_btn");
        goRetrieve();
    });
    
    
    function goRetrieve(){
        window.location.href='/MAL_A/board/board.do?work_div=do_retrieve';
    }
   
    
    $("#comments_btn").on('click',function(){
        //console.log("#insert_btn");
        var work_div = $("#work_div1").val();
        console.log("work_div1==="+work_div1);
        if(null == work_div || work_div.trim().length==0){
                alert("작업구분을 확인 하세요.");
                return;
        }
        
        var reg_id    = $("#reg_id1").val();
        if(null == reg_id || reg_id.trim().length==0){
            $("#reg_id").focus();//focus
            alert("등록자을 확인 하세요.");
            return;
        }       
        
        var reg_Dt   = $("#reg_Dt1").val();
        if(null == reg_Dt || reg_Dt.trim().length==0){
            $("#reg_Dt").focus();//focus
            alert("등록자를 입력 하세요.");
            return;
        }
        
        var contents = $("#contents1").val();
        if(null == contents || contents.trim().length==0){
            $("#contents").focus();//focus
            alert("내용을 입력 하세요.");
            return;
        }
        
        if(false == confirm(contents+"을(를)\n등록 하시겠습니까?"))return;
        
        //동기통신
        //var frm = document.insert_frm;
        //frm.work_div.value = "do_insert";
        //frm.action = "/DaoWEB/board/board.do";
        //frm.submit();
        

        
        
        //비동기통신
        console.log("work_div"+work_div);
        console.log("reg_id"+reg_id);
        console.log("reg_Dt"+reg_Dt);
        console.log("contents"+contents);
        
        //ajax
        $.ajax({
             type:"POST",
             url:"/MAL_A/comments/board.do",
             dataType:"html", 
             data:{"work_div":work_div,
                   "reg_id1":$("#reg_id1").val(),
                   "reg_Dt1":$("#reg_Dt1").val(),
                   "contents1":$("#contents1").val(),
                   "seq1":$("#seq1").val()
                   
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
                      goRetrieve();
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
        
        
        //console.log("work_div="+work_div);
        //console.log("title="+title);
        //console.log("reg_id="+reg_id);
        //console.log("contents="+contents);
        
    });//--#comments_btn  
    
    
    
    
    
    $("#insert_btn").on('click',function(){
        //console.log("#insert_btn");
        var work_div = $("#work_div").val();
        if(null == work_div || work_div.trim().length==0){
                alert("작업구분을 확인 하세요.");
                return;
        }
        
        var title    = $("#title").val();
        if(null == title || title.trim().length==0){
            $("#title").focus();//focus
            alert("제목을 확인 하세요.");
            return;
        }       
        
        var reg_id   = $("#reg_id").val();
        if(null == reg_id || reg_id.trim().length==0){
            $("#reg_id").focus();//focus
            alert("등록자를 입력 하세요.");
            return;
        }
        
        var contents = $("#contents").val();
        if(null == contents || contents.trim().length==0){
            $("#contents").focus();//focus
            alert("내용을 입력 하세요.");
            return;
        }
        
        if(false == confirm(title+"을(를)\n등록 하시겠습니까?"))return;
        
        //동기통신
        //var frm = document.insert_frm;
        //frm.work_div.value = "do_insert";
        //frm.action = "/DaoWEB/board/board.do";
        //frm.submit();
        

        
        
        //비동기통신
        
        //ajax
        $.ajax({
             type:"POST",
             url:"/MAL_A/board/board.do",
             dataType:"html", 
             data:{"work_div":work_div,
                   "title":$("#title").val(),
                   "contents":$("#contents").val(),
                   "reg_id":$("#reg_id").val()
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
                      goRetrieve();
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
        
        
        //console.log("work_div="+work_div);
        //console.log("title="+title);
        //console.log("reg_id="+reg_id);
        //console.log("contents="+contents);
        
    });//--#insert_btn  
    
    
    $(document).ready(function(){
        
        //console.log("document ready");

    
    });
    



</script>   
</body>
</html>









