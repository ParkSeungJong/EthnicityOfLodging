package com.mal_a.cmn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public interface ContHandler {
//    serviceHandler()
//    doUpdate()
//    doInsert()
//    doDelete()
//    doRetrieve()
//    doSelectOne()
   Logger LOG= Logger.getLogger(ContHandler.class);
   /**
    * 
    *@Method Name:serviceHandler
    *@작성일: 2020. 2. 21.
    *@작성자: sist133
    *@설명: doPost()/doGet() 요청을 받는다.-한곳에모은다
    *@param req
    *@param res
    *@throws ServletException
    *@throws IOException
    */
   public void serviceHandler(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException;
   
   
   /**
    * 
    *@Method Name:doRetrieve
    *@작성일: 2020. 2. 21.
    *@작성자: sist133
    *@설명:목록조회
    *@param req
    *@param res
    *@throws ServletException
    *@throws IOException
    */
   public void doRetrieve(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException;
   
   
   /**
    * 
    *@Method Name:doSelectOne
    *@작성일: 2020. 2. 21.
    *@작성자: sist133
    *@설명:단건조회
    *@param req
    *@param res
    *@throws ServletException
    *@throws IOException
    */
   public void doSelectOne(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException;
   
   /**
    * 
    *@Method Name:doDelete
    *@작성일: 2020. 2. 21.
    *@작성자: sist133
    *@설명:삭제
    *@param req
    *@param res
    *@throws ServletException
    *@throws IOException
    */
   public void doDel(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException;
   
   /**
    * 
    *@Method Name:doInsert
    *@작성일: 2020. 2. 21.
    *@작성자: sist133
    *@설명: 등록
    *@param req
    *@param res
    *@throws ServletException
    *@throws IOException
    */
   public void doInsert(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException;
   
   
   /**
    * 
    *@Method Name:doUpdate
    *@작성일: 2020. 2. 21.
    *@작성자: sist133
    *@설명:update처리를 한다.
    *@param req
    *@param res
    *@throws ServletException
    *@throws IOException
    */
   public void doUpdate(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException;
   
}



















