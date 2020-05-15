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
<!DOCTYPE html>
<html>
<head>
<script  src="https://code.jquery.com/jquery-2.2.4.js"></script>

<meta charset="UTF-8">
<title>게시판 등록</title>
</head>
<body>
    <h2>게시판 등록</h2>
    <hr/>
    <table border="0" cellpadding="5" cellspacing="0" width="600">
        <tr>
            <td colspan="2" align="right">
                <div>
                    <input  type="button"  value="목록" id="to_list_btn" />
                    <input  type="button"  value="등록" id="insert_btn" />
                </div>
            </td>
        </tr>
    </table>    
            
    <form name="insert_frm" action='<%=HR_PATH %>/board/board.do'  method="post">
        <input type="hidden" name="work_div" value="do_insert" id="work_div" />
        <table border="1" cellpadding="5" cellspacing="0" width="600">
            <tr>
                <td bgcolor="#99ccff">제목</td>
                <td><input type="text" name="title" id="title" size="20" /></td>
            <tr/>
            <tr>
                <td bgcolor="#99ccff">작성자</td>
                <td><input type="text" name="reg_id" id="reg_id" size="20" /></td>
            <tr/>   
            <tr>
                <td bgcolor="#99ccff">내용</td>
                <td><textarea rows="5" name="contents" id="contents" cols="40"></textarea> </td>
            <tr/>           
        </table>
    </form>
    
<script type="text/javascript">
    //위에서 아래로 해석(인터프리터 방식)
    $("#to_list_btn").on('click',function(){
        //console.log("#to_list_btn");
        goRetrieve();//등록화면에서 목록버튼기능
    });
    
    //목록호출
    function goRetrieve(){
        window.location.href='/MAL_A/board/board.do?work_div=do_retrieve';
    }
    
    
    
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
        
        if(false == confirm(title+"을(를)\n등록 하시겠습니까?"))
        	return;
        
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









