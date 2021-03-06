/**
 *<pre>
 * com.hr.board
 * Class Name : BoardDao.java
 * Description : Board CRUD
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-02-03           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-02-03 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
 
package com.mal_a.board;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.cmn.ConnectionMaker;
import com.mal_a.cmn.DTO;
import com.mal_a.cmn.JDBCResClose;
import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.WorkDiv;

/**
 * @author sist
 *
 */
public class BoardDao extends WorkDiv {
   private final Logger LOG = 
         Logger.getLogger(BoardDao.class);
   private ConnectionMaker connectionMaker;
   public BoardDao() {
      connectionMaker = new ConnectionMaker();
   }
   
   
   /**
   * 
   *@Method Name:doInsert
   *@작성일: 2020. 2. 3.
   *@작성자: sist
   *@설명:사용자 게시판 글 등록. 등록성공(1),실패(0)
   *@param dto
   *@return int
   */
   @Override
   public int doInsert(DTO dto) {
      int flag = 0;
          
      Connection connection = connectionMaker.getConnection();
         
      //3. query수행을 위한 PreparedStatement
      StringBuilder sb=new StringBuilder();
      sb.append(" INSERT INTO board (    	 \n");
      sb.append("     bno,                	 \n");
      sb.append("     title,              	 \n");
      sb.append("     cont,               	 \n");
      sb.append("     regid,              	 \n");
      sb.append("     cnt,              	 \n");
      sb.append("     fileid              	 \n");
      sb.append(" ) VALUES (              	 \n");
      sb.append("     BOARD_BNO.NEXTVAL,  	 \n");//bno
      sb.append("     ?,                  	 \n");//title
      sb.append("     ?,                  	 \n");//cont
      sb.append("     ?,                  	 \n");//regid
      sb.append("     0,                  	 \n");//cnt
      sb.append("     ?						 \n");//fileId
      sb.append(" )                       	 \n");   
      
      PreparedStatement pstmt = null;
      BoardVO inVO = (BoardVO) dto;
      
      try {
         LOG.debug("2.sql=\n"+sb.toString());
         LOG.debug("2.1 param=\n"+inVO);
         pstmt = connection.prepareStatement(sb.toString()); 
         LOG.debug("3.pstmt="+pstmt);
         // * 4. query실행
         //   4.1. Bind변수에 값 설정
         pstmt.setString(1, inVO.getTitle());//제목
         pstmt.setString(2, inVO.getCont());//내용
         pstmt.setString(3, inVO.getRegId());//등록자ID
         pstmt.setString(4, inVO.getFileId());//fileId
         
         //   4.2. query수행: 
         flag = pstmt.executeUpdate();
         LOG.debug("4.flag="+flag);
         
      } catch (SQLException e) {
         LOG.debug("===================");
         LOG.debug("SQLException="+e.getMessage());
         LOG.debug("===================");
         e.printStackTrace();
      // * 6. PreparedStatement,ResultSet
      // * 7. Connection종료 
      } finally {
       //사용 역순으로 자원반납 close
         JDBCResClose.close(pstmt);
         JDBCResClose.close(connection);    
      }
      return flag;
   }
   
   /**
    * 
    *@Method Name:doSelectOne
    *@작성일: 2020. 2. 4.
    *@작성자: sist
    *@설명: 사용자단건조회
    *@param dto
    *@return BoardVO
    */
   @Override
   public DTO doSelectOne(DTO dto) {
      BoardVO inVO = (BoardVO) dto;//param
      BoardVO outVO = null;//return
      
      Connection connection = null;//DB Connection
      PreparedStatement pstmt = null;// vs Statement(해킹에 취약해서 쓰이지않음)
      ResultSet rs = null;//결과값 처리 class
      
      try {
         //1. Connection
         connection = this.connectionMaker.getConnection();
         LOG.debug("1. connection ="+connection);
         
         //2. PreparedStatement
         //2.1 SQL
         StringBuilder sb = new StringBuilder();
         sb.append(" SELECT bno,                                             \n");
         sb.append("       title,                                            \n");
         sb.append("       cont,                                             \n");
         sb.append("       cnt,                                              \n");
         sb.append("       get_code('VIEWS',views) views,                    \n");
         sb.append("       regid,                                            \n");
         sb.append("       TO_CHAR(regdt,'YYYY/MM/DD HH24:MI:SS') regdt,     \n");
         sb.append("       modId,                                            \n");
         sb.append("       TO_CHAR(moddt,'YYYY/MM/DD HH24:MI:SS') moddt,     \n");
         sb.append("       fileid                                            \n");
         sb.append(" FROM board                                              \n");
         sb.append(" WHERE bno = ?                                           \n");
         sb.append(" and views = '1'                                         \n");
         pstmt = connection.prepareStatement(sb.toString());
         LOG.debug("2. PreparedStatement="+pstmt);
         LOG.debug("2.1 sql \n="+sb.toString());
         
         //3.param
         LOG.debug("3. Param ="+inVO);
         pstmt.setString(1, inVO.getBno());
         
         //4.query수행
         rs = pstmt.executeQuery();
         if(rs.next()) {//Moves the cursor forward one fow from its current position. 
            //Data 1건을 outVO담기.
            outVO = new BoardVO();
            outVO.setBno(rs.getString("bno"));
            outVO.setTitle(rs.getString("title"));
            outVO.setCont(rs.getString("cont"));
            outVO.setCnt(rs.getString("cnt"));
            outVO.setViews(rs.getString("views"));
            outVO.setRegId(rs.getString("regId"));
            outVO.setRegDt(rs.getString("regDt"));
            outVO.setModId(rs.getString("modId"));
            outVO.setModDt(rs.getString("modDt"));
            outVO.setFileId(rs.getString("fileId"));
            LOG.debug("4. return="+outVO);
         }
         
      }catch(SQLException e) {
         LOG.debug("=============================");
         LOG.debug("SQLException="+e.getMessage());
         LOG.debug("=============================");
         e.printStackTrace();
      }finally {
          //사용 역순으로 자원반납 close
            JDBCResClose.close(rs);
            JDBCResClose.close(pstmt);
            JDBCResClose.close(connection); 
      }
      
      return outVO;
   }
   
   
   /**
    * 
    *메서드명 : doAdminSelectOne
    *작성일 : 2020. 3. 18.
    *작성자 : sist133
    *설명 : 관리자 단건조회
    *@param dto
    *@return DTO
    */
   public DTO doAdminSelectOne(DTO dto) {
	      BoardVO inVO = (BoardVO) dto;//param
	      BoardVO outVO = null;//return
	      
	      Connection connection = null;//DB Connection
	      PreparedStatement pstmt = null;// vs Statement(해킹에 취약해서 쓰이지않음)
	      ResultSet rs = null;//결과값 처리 class
	      
	      try {
	         //1. Connection
	         connection = this.connectionMaker.getConnection();
	         LOG.debug("1. connection ="+connection);
	         
	         //2. PreparedStatement
	         //2.1 SQL
	         StringBuilder sb = new StringBuilder();
	         sb.append(" SELECT bno,                                             \n");
	         sb.append("       title,                                            \n");
	         sb.append("       cont,                                             \n");
	         sb.append("       cnt,                                              \n");
	         sb.append("       get_code('VIEWS',views) views,                    \n");
	         sb.append("       regid,                                            \n");
	         sb.append("       TO_CHAR(regdt,'YYYY/MM/DD HH24:MI:SS') regdt,     \n");
	         sb.append("       modId,                                            \n");
	         sb.append("       TO_CHAR(moddt,'YYYY/MM/DD HH24:MI:SS') moddt,     \n");
	         sb.append("       fileid                                            \n");
	         sb.append(" FROM board                                              \n");
	         sb.append(" WHERE bno = ?                                           \n");
	         pstmt = connection.prepareStatement(sb.toString());
	         LOG.debug("2. PreparedStatement="+pstmt);
	         LOG.debug("2.1 sql \n="+sb.toString());
	         
	         //3.param
	         LOG.debug("3. Param ="+inVO);
	         pstmt.setString(1, inVO.getBno());
	         
	         //4.query수행
	         rs = pstmt.executeQuery();
	         if(rs.next()) {//Moves the cursor forward one fow from its current position. 
	            //Data 1건을 outVO담기.
	            outVO = new BoardVO();
	            outVO.setBno(rs.getString("bno"));
	            outVO.setTitle(rs.getString("title"));
	            outVO.setCont(rs.getString("cont"));
	            outVO.setCnt(rs.getString("cnt"));
	            outVO.setViews(rs.getString("views"));
	            outVO.setRegId(rs.getString("regId"));
	            outVO.setRegDt(rs.getString("regDt"));
	            outVO.setModId(rs.getString("modId"));
	            outVO.setModDt(rs.getString("modDt"));
	            outVO.setFileId(rs.getString("fileId"));
	            LOG.debug("4. return="+outVO);
	         }
	         
	      }catch(SQLException e) {
	         LOG.debug("=============================");
	         LOG.debug("SQLException="+e.getMessage());
	         LOG.debug("=============================");
	         e.printStackTrace();
	      }finally {
	          //사용 역순으로 자원반납 close
	            JDBCResClose.close(rs);
	            JDBCResClose.close(pstmt);
	            JDBCResClose.close(connection); 
	      }
	      
	      return outVO;
	   }
   
   
   
   
   
   
   /**
    * 
    *메서드명 : doAdminRetrieve
    *작성일 : 2020. 3. 18.
    *작성자 : sist133
    *설명 : 관리자 다건조회
    *@param dto
    *@return List<?>
    */
   public List<?> doAdminRetrieve(DTO dto) {

   SearchVO inVO = (SearchVO) dto;
   List<BoardVO> outList = new ArrayList<BoardVO>();
   
   Connection connection = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   
   StringBuilder sbWhere = new StringBuilder();//검색조건
   StringBuilder sb = new StringBuilder();//검색query
   
   //검색구분 :  1:관리자(제목), 2:관리자(내용), 3:관리자(등록자ID)
   if(null !=inVO.getSearchDiv()) {
      if("1".equals(inVO.getSearchDiv())) {
         //관리자(제목)
         sbWhere.append(" WHERE t1.title like '%'||?||'%'   \n");
      }else if("2".equals(inVO.getSearchDiv()) ) {
         //관리자(내용)
         sbWhere.append(" WHERE t1.cont like '%'||?||'%' 	  \n");
      }else if("3".equals(inVO.getSearchDiv())) {
         //관리자(등록자아이디)
         sbWhere.append(" WHERE t1.regId like '%'||?||'%' 		  \n");
      }else {
    	 sbWhere.append("  		  \n");
      }

   }
   
  
   
   
   
   
   //main query
   
   sb.append("SELECT *                                                     \n");
   sb.append("FROM(                                                        \n");
   sb.append("    SELECT  rnum num,                                        \n");
   sb.append("         b.bno,                                              \n");
   sb.append("         b.title,                                            \n");
   sb.append("         b.cnt,                                              \n");
   sb.append("         b.cont,                                             \n");
   sb.append("         get_code('VIEWS',b.views) views,                    \n");
   sb.append("         b.regid,                                            \n");
   sb.append("         DECODE( TO_CHAR(b.regdt,'YYYY/MM/DD')               \n");
   sb.append("                 ,TO_CHAR(SYSDATE,'YYYY/MM/DD')              \n");
   sb.append("                 ,TO_CHAR(b.regdt,'HH24:MI')                 \n");
   sb.append("                 ,TO_CHAR(b.regdt,'YYYY/MM/DD')              \n");
   sb.append("         ) regdt,                                            \n");
   sb.append("         b.modid,                                            \n");
   sb.append("         DECODE( TO_CHAR(b.moddt,'YYYY/MM/DD')               \n");
   sb.append("                 ,TO_CHAR(SYSDATE,'YYYY/MM/DD')              \n");
   sb.append("                 ,TO_CHAR(b.moddt,'HH24:MI')                 \n");
   sb.append("                 ,TO_CHAR(b.moddt,'YYYY/MM/DD')              \n");
   sb.append("         ) moddt,                                            \n");
   sb.append("         b.fileid                                            \n");
   sb.append("    FROM (                                                   \n");
   sb.append("        SELECT ROWNUM as rnum,A.*                            \n");
   sb.append("        FROM(                                                \n");
   sb.append("            SELECT t1.*                                      \n");
   sb.append("            FROM board t1                                    \n");
   sb.append("            --검색어                                                                 	   \n");
   //---------------------------------where-------------------------------------
   if(inVO.getSearchDiv()!=null||!inVO.getSearchDiv().equals("")) {
       if(inVO.getSearchWord()!=null) {
          sb.append(sbWhere.toString());//물음표 1번
       }
    }
   //---------------------------------where-------------------------------------
   sb.append("            ORDER BY t1.regdt DESC                           \n");
   sb.append("        )A                                                   \n");
   sb.append("        WHERE rownum <=(?*(?-1)+?) 						   \n");
   sb.append("    )B                                                       \n");
   sb.append("    WHERE rnum >=(?*(?-1)+1)               				   \n");
   sb.append("    )							               				   \n");
   sb.append("CROSS JOIN                                                   \n");
   sb.append("(                                                            \n");
   sb.append("    SELECT COUNT(*) TOTAL                                    \n");
   sb.append("    FROM board t1                                            \n");
   //---------------------------------where-------------------------------------
   if(inVO.getSearchDiv()!=null|| !inVO.getSearchDiv().equals("")) {
       if(inVO.getSearchWord()!=null) {
          sb.append(sbWhere.toString()); //물음표 7번
       }
    }
   //---------------------------------where-------------------------------------
   sb.append(")                                                            \n");
   
   
   
   try {

      connection = this.connectionMaker.getConnection();
      LOG.debug("1.connection="+connection);
      

      LOG.debug("2.query=\n"+sb.toString());
      pstmt = connection.prepareStatement(sb.toString());
      LOG.debug("3.pstmt="+pstmt);
      LOG.debug("4. param="+inVO);
      //검색어 있는 경우
      if(null !=inVO.getSearchDiv()&&!inVO.getSearchDiv().equals("")) {
         //검색어
         //&PAGE_SIZE*(&PAGE_NUM-1)+&PAGE_SIZE
         //&PAGE_SIZE*(&PAGE_NUM-1)+1
         
         //1.검색어
         //2.PAGE_SIZE
         //3.PAGE_NUM
         //4.PAGE_SIZE
         //5.PAGE_SIZE
         //6.PAGE_NUM
         //7.검색어
         pstmt.setString(1, inVO.getSearchWord());
         pstmt.setInt(2, inVO.getPageSize());
         pstmt.setInt(3, inVO.getPageNum());
         pstmt.setInt(4, inVO.getPageSize());
         pstmt.setInt(5, inVO.getPageSize());
         pstmt.setInt(6, inVO.getPageNum());
         pstmt.setString(7, inVO.getSearchWord());
         
//         pstmt.setString(8, inVO01.getCont());
//         pstmt.setString(9, inVO01.getViews());
//         pstmt.setString(10, inVO01.getModId());
//         pstmt.setString(11, inVO01.getModDt());
//         pstmt.setString(12, inVO01.getFileId());
         
      //검색어 없을때   
      }else {
          //1.PAGE_SIZE
          //2.PAGE_NUM
          //3.PAGE_SIZE
          //4.PAGE_SIZE
          //5.PAGE_NUM
    	  pstmt.setInt(1, inVO.getPageSize());
          pstmt.setInt(2, inVO.getPageNum());
          pstmt.setInt(3, inVO.getPageSize());
          pstmt.setInt(4, inVO.getPageSize());
          pstmt.setInt(5, inVO.getPageNum());
      }
      //4.query수행
      rs = pstmt.executeQuery();
      while(rs.next()) {
         //Data 1건을 outVO담기.
         BoardVO outVO = new BoardVO();
         
         outVO.setBno(rs.getString("bno"));
         outVO.setTitle(rs.getString("title"));
         outVO.setCnt(rs.getString("cnt"));
         outVO.setCont(rs.getString("cont"));
         outVO.setViews(rs.getString("views"));
         outVO.setRegId(rs.getString("regid"));
         outVO.setRegDt(rs.getString("regdt"));
         outVO.setModId(rs.getString("modid"));
         outVO.setModDt(rs.getString("moddt"));
         outVO.setFileId(rs.getString("fileid"));
         
         outVO.setTotal(rs.getInt("total"));
         outVO.setNum(rs.getInt("num"));
         outList.add(outVO);
      }
      LOG.debug("4. return="+outList);
      
   }catch(SQLException e) {
        LOG.debug("===================");
        LOG.debug("SQLException="+e.getMessage());
        LOG.debug("===================");
        e.printStackTrace();
        
   }finally {
      JDBCResClose.close(rs);
      JDBCResClose.close(pstmt);
      JDBCResClose.close(connection);
   }
   
   return outList;
}
   

   
   
   /**
    * 
    *@Method Name:doRetrieve
    *@작성일: 2020. 2. 4.
    *@작성자: sist
    *@설명: 사용자다건조회
    *@param dto
    *@return BoardVO
    */
   @Override
   public List<?> doRetrieve(DTO dto) {

   SearchVO inVO = (SearchVO) dto;
   List<BoardVO> outList = new ArrayList<BoardVO>();
   
   Connection connection = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   
   StringBuilder sbWhere = new StringBuilder();//검색조건
   StringBuilder sb = new StringBuilder();//검색query
   
   //검색구분 : 1:회원(제목), 2:회원(내용), 3:회원(등록자ID), 4:관리자(제목), 5:관리자(내용), 6:관리자(등록자ID)
   if(null !=inVO.getSearchDiv()|| !inVO.getSearchDiv().equals("")) {
      if("1".equals(inVO.getSearchDiv())) {
         //회원(제목)
         sbWhere.append(" WHERE 	t1.views = 1 		  \n");
         sbWhere.append(" AND t1.title like '%'||?||'%'   \n");
      }else if("2".equals(inVO.getSearchDiv())) {
         //회원(내용)
    	  sbWhere.append(" WHERE 	t1.views = 1  		  \n");
         sbWhere.append(" AND t1.cont like '%'||?||'%' 	  \n");
      }else if("3".equals(inVO.getSearchDiv())) {
         //회원(등록자아이디)
    	  sbWhere.append(" WHERE 	t1.views = 1 		  \n");
         sbWhere.append(" AND t1.regId like ?||'%' 		  \n");
      }else {
       	  sbWhere.append(" WHERE 	t1.views = 1 		  \n");
      }
//      else if("4".equals(inVO.getSearchDiv())) {
//          //관리자(제목)
//          sbWhere.append(" WHERE t1.title like '%'||?||'%' 	  \n");
//       }else if("5".equals(inVO.getSearchDiv())) {
//          //관리자(내용)
//          sbWhere.append(" WHERE t1.cont like '%'||?||'%' 		  \n");
//       }else if("6".equals(inVO.getSearchDiv())) {
//          //관리자(등록자아이디)
//          sbWhere.append(" WHERE t1.regId like ?||'%' 		      \n");
//       }
   }
   
   //main query
   
   sb.append("SELECT *                                                     \n");
   sb.append("FROM(                                                        \n");
   sb.append("    SELECT  rnum num,                                        \n");
   sb.append("         b.bno,                                              \n");
   sb.append("         b.title,                                            \n");
   sb.append("         b.cnt,                                              \n");
   sb.append("         b.cont,                                             \n");
   sb.append("         get_code('VIEWS',b.views) views,                    \n");
   sb.append("         b.regid,                                            \n");
   sb.append("         DECODE( TO_CHAR(b.regdt,'YYYY/MM/DD')               \n");
   sb.append("                 ,TO_CHAR(SYSDATE,'YYYY/MM/DD')              \n");
   sb.append("                 ,TO_CHAR(b.regdt,'HH24:MI')                 \n");
   sb.append("                 ,TO_CHAR(b.regdt,'YYYY/MM/DD')              \n");
   sb.append("         ) regdt,                                            \n");
   sb.append("         b.modid,                                            \n");
   sb.append("         DECODE( TO_CHAR(b.moddt,'YYYY/MM/DD')               \n");
   sb.append("                 ,TO_CHAR(SYSDATE,'YYYY/MM/DD')              \n");
   sb.append("                 ,TO_CHAR(b.moddt,'HH24:MI')                 \n");
   sb.append("                 ,TO_CHAR(b.moddt,'YYYY/MM/DD')              \n");
   sb.append("         ) moddt,                                            \n");
   sb.append("         b.fileid                                            \n");
   sb.append("    FROM (                                                   \n");
   sb.append("        SELECT ROWNUM as rnum,A.*                            \n");
   sb.append("        FROM(                                                \n");
   sb.append("            SELECT t1.*                                      \n");
   sb.append("            FROM board t1                                    \n");
   sb.append("            --검색어                                                                 	   \n");
   //---------------------------------where-------------------------------------
   if(inVO.getSearchDiv()!=null||!inVO.getSearchDiv().equals("")) {
       if(inVO.getSearchWord()!=null) {
          sb.append(sbWhere.toString());//물음표 1번
       }
    }
   //---------------------------------where-------------------------------------
   sb.append("            ORDER BY t1.regdt DESC                           \n");
   sb.append("        )A                                                   \n");
   sb.append("        WHERE rownum <=(?*(?-1)+?) 						   \n");
   sb.append("    )B                                                       \n");
   sb.append("    WHERE rnum >=(?*(?-1)+1)               				   \n");
   sb.append("    )							               				   \n");
   sb.append("CROSS JOIN                                                   \n");
   sb.append("(                                                            \n");
   sb.append("    SELECT COUNT(*) TOTAL                                    \n");
   sb.append("    FROM board t1                                            \n");
   //---------------------------------where-------------------------------------
   if(inVO.getSearchDiv()!=null|| !inVO.getSearchDiv().equals("")) {
       if(inVO.getSearchWord()!=null) {
          sb.append(sbWhere.toString()); //물음표 7번
       }
    }
   //---------------------------------where-------------------------------------
   sb.append(")                                                            \n");
   
   
   
   try {

      connection = this.connectionMaker.getConnection();
      LOG.debug("1.connection="+connection);
      

      LOG.debug("2.query=\n"+sb.toString());
      pstmt = connection.prepareStatement(sb.toString());
      LOG.debug("3.pstmt="+pstmt);
      LOG.debug("4. param="+inVO);
      //검색어 있는 경우
      if(null !=inVO.getSearchDiv()&&!inVO.getSearchDiv().equals("")) {
         //검색어
         //&PAGE_SIZE*(&PAGE_NUM-1)+&PAGE_SIZE
         //&PAGE_SIZE*(&PAGE_NUM-1)+1
         
         //1.검색어
         //2.PAGE_SIZE
         //3.PAGE_NUM
         //4.PAGE_SIZE
         //5.PAGE_SIZE
         //6.PAGE_NUM
         //7.검색어
         pstmt.setString(1, inVO.getSearchWord());
         pstmt.setInt(2, inVO.getPageSize());
         pstmt.setInt(3, inVO.getPageNum());
         pstmt.setInt(4, inVO.getPageSize());
         pstmt.setInt(5, inVO.getPageSize());
         pstmt.setInt(6, inVO.getPageNum());
         pstmt.setString(7, inVO.getSearchWord());
         
//         pstmt.setString(8, inVO01.getCont());
//         pstmt.setString(9, inVO01.getViews());
//         pstmt.setString(10, inVO01.getModId());
//         pstmt.setString(11, inVO01.getModDt());
//         pstmt.setString(12, inVO01.getFileId());
         
      //검색어 없을때   
      }else {
          //1.PAGE_SIZE
          //2.PAGE_NUM
          //3.PAGE_SIZE
          //4.PAGE_SIZE
          //5.PAGE_NUM
    	  pstmt.setInt(1, inVO.getPageSize());
          pstmt.setInt(2, inVO.getPageNum());
          pstmt.setInt(3, inVO.getPageSize());
          pstmt.setInt(4, inVO.getPageSize());
          pstmt.setInt(5, inVO.getPageNum());
      }
      //4.query수행
      rs = pstmt.executeQuery();
      while(rs.next()) {
         //Data 1건을 outVO담기.
         BoardVO outVO = new BoardVO();
         
         outVO.setBno(rs.getString("bno"));
         outVO.setTitle(rs.getString("title"));
         outVO.setCnt(rs.getString("cnt"));
         outVO.setCont(rs.getString("cont"));
         outVO.setViews(rs.getString("views"));
         outVO.setRegId(rs.getString("regid"));
         outVO.setRegDt(rs.getString("regdt"));
         outVO.setModId(rs.getString("modid"));
         outVO.setModDt(rs.getString("moddt"));
         outVO.setFileId(rs.getString("fileid"));
         
         outVO.setTotal(rs.getInt("total"));
         outVO.setNum(rs.getInt("num"));
         outList.add(outVO);
      }
      LOG.debug("4. return="+outList);
      
   }catch(SQLException e) {
        LOG.debug("===================");
        LOG.debug("SQLException="+e.getMessage());
        LOG.debug("===================");
        e.printStackTrace();
        
   }finally {
      JDBCResClose.close(rs);
      JDBCResClose.close(pstmt);
      JDBCResClose.close(connection);
   }
   
   return outList;
}
   
   /**
    * 
    *@Method Name:doUpdate
    *@작성일: 2020. 2. 4.
    *@작성자: sist
    *@설명: 사용자업데이트
    *@param dto
    *@return BoardVO
    */
   @Override
   public int doUpdate(DTO dto) {
      int flag = 0;//쿼리수행여부확인하는변수 0이면실행안함 1이면실행함.
      BoardVO inVO = (BoardVO) dto;//param
      
      Connection connection = null;//DB Connection
      PreparedStatement pstmt = null;// vs Statement(해킹에 취약해서 쓰이지않음)
      try {
         //1.Connection 생성
         connection = connectionMaker.getConnection();
         connection.setAutoCommit(false);//transaction 개발자가 관리 -오토커밋 못하게막음.
         
         LOG.debug("1 connection=\n"+connection);
         //2.PreparedStatement
         //2.1 SQL
         StringBuilder sb = new StringBuilder();//속도의 차이가 있기에 이걸씀
         
         sb.append(" UPDATE board            \n");
         sb.append(" SET  title = ?          \n");
         sb.append("     ,cont = ?           \n");
         sb.append("     ,modid   = ?        \n");
         sb.append("     ,moddt   = SYSDATE  \n");
         sb.append(" WHERE bno    = ?        \n");
         LOG.debug("2.1. query=\n"+sb.toString());
         
         pstmt = connection.prepareStatement(sb.toString());
         LOG.debug("2. PreparedStatement=\n"+pstmt);
         LOG.debug("2.1. query=\n"+sb.toString());
         //3. param
         LOG.debug("3. param="+inVO);
         //3.1 param binding
         
         pstmt.setString(1, inVO.getTitle());      //title
         pstmt.setString(2, inVO.getCont());   //contents
         pstmt.setString(3, inVO.getModId());      //mod_id
         pstmt.setString(4, inVO.getBno());           //seq
         
         //4.query 수행
         flag = pstmt.executeUpdate();//DML발생에 사용.쿼리문실행시 flag값 1로전환
         
         LOG.debug("4. flag="+flag);
      }catch(SQLException e) {
         LOG.debug("=============================");
         LOG.debug("SQLException="+e.getMessage());
         LOG.debug("=============================");
         e.printStackTrace();
         
         //RollBack
         JDBCResClose.rollBack(connection);
         
      }finally { //자원반납
         //사용 역순으로 자원반납 close
         JDBCResClose.close(pstmt);
         JDBCResClose.close(connection);
         
      }
      
      return flag;
   }
   
   /**
    * 
    *@Method Name:doViewsUpdate
    *@작성일: 2020. 2. 4.
    *@작성자: sist
    *@설명: 뷰업데이트(정지,비정지)
    *@param dto
    *@return BoardVO
    */
   public int doViewsUpdate(DTO dto) {
	      int flag = 0;//쿼리수행여부확인하는변수 0이면실행안함 1이면실행함.
	      BoardVO inVO = (BoardVO) dto;//param
	      
	      Connection connection = null;//DB Connection
	      PreparedStatement pstmt = null;// vs Statement(해킹에 취약해서 쓰이지않음)
	      try {
	         //1.Connection 생성
	         connection = connectionMaker.getConnection();
	         connection.setAutoCommit(false);//transaction 개발자가 관리 -오토커밋 못하게막음.
	         
	         LOG.debug("1 connection=\n"+connection);
	         //2.PreparedStatement
	         //2.1 SQL
	         StringBuilder sb = new StringBuilder();//속도의 차이가 있기에 이걸씀
	         
	         sb.append(" UPDATE board            \n");
	         sb.append(" SET  views    = ?       \n");
	         sb.append("     ,modid    = ? 	 	 \n");
	         sb.append("     ,moddt    = SYSDATE \n");
	         sb.append(" WHERE bno     = ?       \n");
	         LOG.debug("2.1. query=\n"+sb.toString());
	         
	         pstmt = connection.prepareStatement(sb.toString());
	         LOG.debug("2. PreparedStatement=\n"+pstmt);
	         LOG.debug("2.1. query=\n"+sb.toString());
	         //3. param
	         LOG.debug("3. param="+inVO);
	         //3.1 param binding
	         
	         pstmt.setString(1, inVO.getViews()); //정지권한
	         pstmt.setString(2, inVO.getModId()); //수정자아이디
	         pstmt.setString(3, inVO.getBno());  //게시판번호
	         //4.query 수행
	         flag = pstmt.executeUpdate();//DML발생에 사용.쿼리문실행시 flag값 1로전환
	         
	         LOG.debug("4. flag="+flag);
	      }catch(SQLException e) {
	         LOG.debug("=============================");
	         LOG.debug("SQLException="+e.getMessage());
	         LOG.debug("=============================");
	         e.printStackTrace();
	         
	         //RollBack
	         JDBCResClose.rollBack(connection);
	         
	      }finally { //자원반납
	         //사용 역순으로 자원반납 close
	         JDBCResClose.close(pstmt);
	         JDBCResClose.close(connection);
	         
	      }
	      
	      return flag;
	   }
   
   
   /**
    * 
    *@Method Name:doDelete
    *@작성일: 2020. 2. 4.
    *@작성자: sist
    *@설명: 사용자글삭제
    *@param dto
    *@return BoardVO
    */
   @Override
   public int doDelete(DTO dto) {
      
      int flag = 0;
        
         Connection connection = connectionMaker.getConnection();
         
         //3. query수행을 위한 PreparedStatement
         StringBuilder sb=new StringBuilder();
         sb.append(" DELETE FROM board \n");
         sb.append(" WHERE bno = ? \n");
         
         PreparedStatement pstmt = null;
         BoardVO inVO = (BoardVO) dto;
         
         try {
            LOG.debug("2.sql=\n"+sb.toString());
            LOG.debug("2.1 param=\n"+inVO);
            pstmt = connection.prepareStatement(sb.toString()); 
            LOG.debug("3.pstmt="+pstmt);
            // * 4. query실행
            //   4.1. Bind변수에 값 설정
            pstmt.setString(1, inVO.getBno());//게시순번
            
            //   4.2. query수행: 
            flag = pstmt.executeUpdate();
            LOG.debug("4.flag="+flag);
            
         } catch (SQLException e) {
            LOG.debug("===================");
            LOG.debug("SQLException="+e.getMessage());
            LOG.debug("===================");
            e.printStackTrace();
         // * 6. PreparedStatement,ResultSet
         // * 7. Connection종료 
         } finally {
            //사용 역순으로 자원반납 close
            JDBCResClose.close(pstmt);
            JDBCResClose.close(connection);         
         }
         return flag;
     
   }
   
   
   
   public int doAdminDelete(DTO dto) {
	      
	      int flag = 0;
	        
	         Connection connection = connectionMaker.getConnection();
	         
	         //3. query수행을 위한 PreparedStatement
	         StringBuilder sb=new StringBuilder();
	         sb.append(" DELETE FROM board \n");
	         sb.append(" WHERE bno = ? \n");
	         
	         PreparedStatement pstmt = null;
	         BoardVO inVO = (BoardVO) dto;
	         
	         try {
	            LOG.debug("2.sql=\n"+sb.toString());
	            LOG.debug("2.1 param=\n"+inVO);
	            pstmt = connection.prepareStatement(sb.toString()); 
	            LOG.debug("3.pstmt="+pstmt);
	            // * 4. query실행
	            //   4.1. Bind변수에 값 설정
	            pstmt.setString(1, inVO.getBno());//게시순번
	            
	            //   4.2. query수행: 
	            flag = pstmt.executeUpdate();
	            LOG.debug("4.flag="+flag);
	            
	         } catch (SQLException e) {
	            LOG.debug("===================");
	            LOG.debug("SQLException="+e.getMessage());
	            LOG.debug("===================");
	            e.printStackTrace();
	         // * 6. PreparedStatement,ResultSet
	         // * 7. Connection종료 
	         } finally {
	            //사용 역순으로 자원반납 close
	            JDBCResClose.close(pstmt);
	            JDBCResClose.close(connection);         
	         }
	         return flag;
	     
	   }
   
   
   
   
   /**
    * 
    *@Method Name:readCount
    *@작성일: 2020. 2. 4.
    *@작성자: sist
    *@설명: 게시글조회수증가
    *@param dto
    *@return BoardVO
    */
   public int readCount(DTO dto) {
	     int flag = 0;
	     BoardVO inVO = (BoardVO) dto;//param
	    
	     Connection connection   = null;//DB Connection
	     PreparedStatement pstmt = null;//VS Statement
	     try {
	      //1.Connection
	    	 connection = connectionMaker.getConnection();
	    	 LOG.debug("1.Connection="+connection);
	    	 
	    	 //2.query
	    	 StringBuilder sb=new StringBuilder();
	    	 sb.append("Update board						\n");
	    	 sb.append("SET cnt = NVL(cnt,0)+1    \n");
	    	 sb.append("WHERE bno =?	                    \n");
	    	 //2.1 pstmt
	    	 pstmt=connection.prepareStatement(sb.toString());
	    	 LOG.debug("2.1.pstmt="+inVO);
	    	 
	    	 
	    	 //3.param
	    	 LOG.debug("3.param="+inVO);
	    	 pstmt.setString(1,inVO.getBno());
	    	 
	    	 //4.query 수행
	    	 flag=pstmt.executeUpdate();
	    	 LOG.debug("4.flag="+flag);
	     
	    	
	     }catch(SQLException e) {
	      LOG.debug("===========================");
	      LOG.debug("=SQLException="+e.getMessage());
	      LOG.debug("===========================");
	      e.printStackTrace();
	      JDBCResClose.rollBack(connection);
	     }finally { //자원반납
	      //사용 역순으로 close
	      JDBCResClose.close(pstmt);//prepareStatement
	      JDBCResClose.close(connection);//connection
	      
	      
	     }
	  return flag;
   }
   

}
