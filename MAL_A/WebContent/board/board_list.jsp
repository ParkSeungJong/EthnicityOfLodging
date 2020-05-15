<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 2. 25.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.mal_a.cmn.StringUtil"%>
<%@page import="com.mal_a.code.CodeVO"%>
<%@page import="com.mal_a.cmn.SearchVO"%>
<%@page import="com.mal_a.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    errorPage="/cmn/error.jsp"
    pageEncoding="UTF-8"%>
<%@ include file="/cmn/common.jsp" %>     
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
    List<CodeVO> searchList = (List<CodeVO>)request.getAttribute("searchList");
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
    
    
    
    List<BoardVO> list = (List<BoardVO>)request.getAttribute("list");
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
    
    String url = HR_PATH+"/roxandrea/board.do";//호출 URL 
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
  <style type="text/css">
   body {
    font-family: Arial, Verdana, sans-serif;
    color: #111111;}
   table {
    width: 90%;}
   th, td {
    padding: 7px 10px 10px 10px;}
   th {
    text-transform: uppercase;
    letter-spacing: 0.1em;
    font-size: 90%;
    border-bottom: 2px solid #111111;
    border-top: 1px solid #999;
    text-align: left;}
   tr.even {
    background-color: #efefef;}
   tr:hover {
    background-color: #c3e6e5;}
    
   .money {
    text-align: right;}
   .acenter {
    text-align: center;}  
    
     select { width: 200px; /* 원하는 너비설정 */
     padding: .5em .3em; /* 여백으로 높이 설정 */ 
     font-family: inherit; /* 폰트 상속 */ 
     border: 1px solid #999; 
     border-radius: 0px; /* iOS 둥근모서리 제거 */  
     appearance: none; }
    
     input[type="text"], input[type="password"] { 
     height: auto; /* 높이 초기화 */ 
     line-height: normal; /* line-height 초기화 */
     padding: .5em .3em; /* 여백 설정 */ }      
  </style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
    <h2>게시판 목록</h2>
    <hr/>
    <!-- Button -->
    <div>
        <input  type="button"  value="조회" onclick="javascript:doRetrieve();" id="to_list_btn" />
        <input  type="button"  value="등록" onclick="javascript:moveToSave();" id="insert_btn" />
    </div>  
    <!--//Button  -->
    
    <form action="/MAL_A/board/board.do" name="searchFrm" id="searchFrm" 
          method="get">
        <input type="text" name="work_div"   />
        <input type="text" name="page_num"   />  
        <input type="text" name="seq"   />
    <!--//Button  -->
     
        <!-- 검색 -->
        <table>
            <tr>
                <td>
                    <div>구분<%=StringUtil.makeSelectBox(searchList, "search_div", searchDiv, true) %>
                        <%-- 
                        <select name="search_div" id="search_div">
                            <option value="">전체</option>
                            <option value="10" <%if(searchDiv.equals("10"))out.print("selected"); %> >제목</option>
                            <option value="20" <%if(searchDiv.equals("20"))out.print("selected"); %> >내용</option>
                            <option value="30" <%if(searchDiv.equals("30"))out.print("selected"); %> >등록자</option>
                        </select>
                        --%>
                        <input type="text" name="search_word" id="search_word"  value="<%=searchWord%>">
                        <%=StringUtil.makeSelectBox(pageSizeList, "page_size", pageSize, false) %>
                        <%--
                        <select name="page_size"  id="page_size">
                            <option value="10"  <%if(pageSize.equals("10"))out.print("selected");  >10</option>
                            <option value="50"  <%if(pageSize.equals("50"))out.print("selected"); %> >50</option>
                            <option value="100" <%if(pageSize.equals("100"))out.print("selected"); %> >100</option>
                            <option value="200" <%if(pageSize.equals("200"))out.print("selected"); %> >200</option>
                        </select>
                        --%>                            
                    </div>
                </td>
            </tr>
        </table>
        
        </form>     
        
        <!--// 검색 -->
        <table id="listTable">
            <thead>
                <tr>
                    <th>NO</th>
                    <th>제목</th>
                    <th>등록자ID</th>
                    <th>등록일</th>
                    <th>조회수</th>
                    <th style="display:none;">SEQ</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if(null !=list && list.size()>0){
                        for(BoardVO vo:list){
                %>      
                        <tr>
                            <td><%=vo.getNum() %></td>
                            <td><%=vo.getTitle()%></td>
                            <td><%=vo.getModId() %></td>
                            <td class="acenter"><%=vo.getModDt() %></td>
                            <td class="money"><%=vo.getCnt() %></td>
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
    <!-- paging -->
        <div>
            <%=StringUtil.renderPaging(maxNum, currPageNo, rowsPerPage, bottomCount, url, scriptName)%>
        </div>
    <!--// paging -->


    
    <script type="text/javascript">
        function doSearchPage(url,no){
            //console.log("url:"+url);
            //console.log("no:"+no);
              var frm = document.searchFrm;
              frm.work_div.value = "do_retrieve";
              frm.page_num.value = no;
              frm.action =url;
              frm.submit();
            
        }
        
    
        //listTable자식:dbclick(double click)
        $("#listTable>tbody").on("dblclick","tr",function(event){
            //console.log("event:"+event);
            //console.log("#listTable>tbody>tr");
            var pTR = $(this);//tr
            var pTR_Children = pTR.children();
            var seq = pTR_Children.eq(5).text();
            console.log("seq:"+seq);
            var frm = document.searchFrm;
            
            frm.work_div.value = "do_selectOne";
            frm.seq.value = seq;
            frm.action = '/MAL_A/roxandrea/board.do';
            frm.submit();
            
        });
    
    
        function doRetrieve(){
            //alert('doRetrieve');
            var frm = document.searchFrm;
            frm.work_div.value = "do_retrieve";
            frm.page_num.value = "1";
            frm.action = '/MAL_A/roxandrea/board.do';
            frm.submit();
        }
    
        function moveToSave(){
            //alert('moveToSave');
            //http://localhost:8080/DaoWEB/board/board.do?work_div=move_to_save&page_num=
            if(false==confirm('등록 화면으로 이동 하시겠습니까?'))return;
            var frm = document.searchFrm;
            frm.work_div.value = "move_to_save";
            frm.action = '/MAL_A/roxandrea/board.do';
            frm.submit();
        }
        
        $("#search_word").keypress(function(e){
            //console.log('#search_word');
            //alert('#search_word');
            //Enter Keycode 13
            if(e.which ==13){
                doRetrieve();
            }
            
        });
        
        
    </script>
</body>
</html>






























