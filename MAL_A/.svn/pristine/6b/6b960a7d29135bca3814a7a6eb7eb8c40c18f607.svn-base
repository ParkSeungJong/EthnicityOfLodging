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
 
package com.mal_a.comments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mal_a.board.BoardVO;
import com.mal_a.cmn.ConnectionMaker;
import com.mal_a.cmn.DTO;
import com.mal_a.cmn.JDBCResClose;
import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.WorkDiv;

/**
 * @author sist
 *
 */
public class CommentsDao extends WorkDiv {
   private final Logger LOG = 
         Logger.getLogger(CommentsDao.class);
   private ConnectionMaker connectionMaker;
   
   public CommentsDao() {
      connectionMaker = new ConnectionMaker();
   }

   /**
   * 
   *@Method Name:doInsert
   *@작성일: 2020. 2. 3.
   *@작성자: sist
   *@설명:댓글  등록. 등록성공(1),실패(0)
   *@param dto
   *@return int
   */
   @Override
   public int doInsert(DTO dto) {
      int flag = 0;
          
      Connection connection = connectionMaker.getConnection();
         
      //3. query수행을 위한 PreparedStatement
      StringBuilder sb=new StringBuilder();
      sb.append(" INSERT INTO comments (     \n");
      sb.append("     cno,                	 \n");
      sb.append("     cont,              	 \n");
      sb.append("     regid,                 \n");
      sb.append("     bno                	 \n");
      sb.append(" ) VALUES (              	 \n");
      sb.append("     COMMENTS_CNO.NEXTVAL,  \n");//cno
      sb.append("     ?,                 	 \n");//내용
      sb.append("     ?,                 	 \n");//등록자아이디
      sb.append("     ?  	 				 \n");//게시글번호
      sb.append(" )                      	 \n");   
      
      PreparedStatement pstmt = null;
      CommentsVO inVO = (CommentsVO) dto;
      
      try {
         LOG.debug("2.sql=\n"+sb.toString());
         LOG.debug("2.1 param=\n"+inVO);
         pstmt = connection.prepareStatement(sb.toString()); 
         LOG.debug("3.pstmt="+pstmt);
         // * 4. query실행
         //   4.1. Bind변수에 값 설정

         pstmt.setString(1, inVO.getCont());//제목
         pstmt.setString(2, inVO.getRegId());//내용
         pstmt.setString(3, inVO.getBno());//게시글번호

         
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
   *@Method Name:doRetrieve
   *@작성일: 2020. 2. 3.
   *@작성자: sist
   *@설명:사용자 댓글 다건조회
   *@param dto
   *@return int
   */
   public List<?> doRetrieveList(DTO dto) {
   //검색조건 : 검색조건
   //제목
   //내용
   SearchVO inVO = (SearchVO) dto;
   LOG.debug("dto**************"+dto);
   List<CommentsVO> outList = new ArrayList<CommentsVO>();
   
   Connection connection = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   
   StringBuilder sbWhere = new StringBuilder();//검색조건
   StringBuilder sb = new StringBuilder();//검색query
   LOG.debug("work_div**********************="+inVO.getSearchDiv());
   //검색구분 : 1:회원(게시글번호), 2:관리자(게시글번호)
   if(null !=inVO.getSearchDiv()|| !inVO.getSearchDiv().equals("")) {
      if("1".equals(inVO.getSearchDiv()) ) {
         //회원(게시글번호)
         sbWhere.append(" WHERE t1.bno = ? \n");
         sbWhere.append(" AND t1.views = 1 \n");
      }else if("2".equals(inVO.getSearchDiv())) {
    	//관리자(게시글번호)
         sbWhere.append(" WHERE t1.bno = ? \n");
      }
   }
   
   //main query
   
   sb.append("   SELECT *                                         					\n");
   sb.append("   FROM(                                            		            \n");
   sb.append("       SELECT  RNUM num,                            		            \n");
   sb.append("                b.cno cno,                                 		        \n");
   sb.append("                b.cont cont,                            		        \n");
   sb.append("         		  get_code('VIEWS',b.views) views,                    	\n");
   sb.append("                b.regid regid,                          		        \n");
   sb.append("                TO_CHAR(b.regdt,'YYYY/MM/DD') regdt,                  \n");
   sb.append("                b.modid modid,                         		        \n");
   sb.append("                TO_CHAR(b.moddt,'YYYY/MM/DD') moddt,                  \n");
   sb.append("                b.bno bno                              		        \n");
   sb.append("       FROM (                                       		            \n");
   sb.append("           SELECT ROWNUM as rnum,A.*                 		            \n");
   sb.append("           FROM(                                    		            \n");
   sb.append("               SELECT t1.*                          		            \n");
   sb.append("               FROM comments t1                      		            \n");
   //---------------------------------where-------------------------------------
   if(inVO.getSearchDiv()!=null||!inVO.getSearchDiv().equals("")) {
       if(inVO.getSearchWord()!=null) {
          sb.append(sbWhere.toString());//물음표 1번
       }
    }
   //---------------------------------where-------------------------------------
   sb.append("               ORDER BY t1.regdt ASC                                 \n");
   sb.append("        )A                                                           \n");
   sb.append("          WHERE rownum <=(?*(?-1)+?)  							   \n");			
   sb.append("    )B                                                               \n");
   sb.append("   	 WHERE rnum >=?*(?-1)+1                						   \n");	
   sb.append("   	)                                                              \n");
   sb.append("   CROSS JOIN                                                        \n");
   sb.append("   (                                                                 \n");
   sb.append("    SELECT COUNT(*) TOTAL                                            \n");
   sb.append("    FROM comments t1                                                 \n");
   //---------------------------------where-------------------------------------
   if(inVO.getSearchDiv()!=null||!inVO.getSearchDiv().equals("")) {
       if(inVO.getSearchWord()!=null) {
          sb.append(sbWhere.toString());//물음표 1번
       }
    }
   //---------------------------------where-------------------------------------
   sb.append("         )                                                           \n");
   
   
   
   try {
      //1.
      connection = this.connectionMaker.getConnection();
      LOG.debug("1.connection="+connection);
      
      //2.pstmt
      //2.1
      LOG.debug("2.query=\n"+sb.toString());
      pstmt = connection.prepareStatement(sb.toString());
      LOG.debug("3.pstmt="+pstmt);
      LOG.debug("4. param="+inVO);
      //검색어 있는 경우
      if(null !=inVO.getSearchDiv() && null !=inVO.getSearchWord()) {
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
      }
    	  
      
      //4.query수행
      rs = pstmt.executeQuery();
      while(rs.next()) {
         //Data 1건을 outVO담기.
    	  CommentsVO outVO = new CommentsVO();
         
         outVO.setCno(rs.getString("cno"));
         outVO.setCont(rs.getString("cont")); 
         outVO.setViews(rs.getString("views"));
         outVO.setRegId(rs.getString("regid"));
         outVO.setRegDt(rs.getString("regdt")); 
         outVO.setModId(rs.getString("modid"));
         outVO.setModDt(rs.getString("moddt"));
         outVO.setBno(rs.getString("bno"));
         outVO.setNum(rs.getInt("num"));
         outVO.setTotal(rs.getInt("total"));
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
	 *메서드명 : doAdminRetrieveList
	 *작성일 : 2020. 3. 18.
	 *작성자 : sist133
	 *설명 : 관리자 댓글 다건조회
	 *@param dto
	 *@return DTO
	 */
   public List<?> doAdminRetrieveList(DTO dto) {
   //검색조건 : 검색조건
   //제목
   //내용
   SearchVO inVO = (SearchVO) dto;
   LOG.debug("dto**************"+dto);
   List<CommentsVO> outList = new ArrayList<CommentsVO>();
   
   Connection connection = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   
   StringBuilder sbWhere = new StringBuilder();//검색조건
   StringBuilder sb = new StringBuilder();//검색query
   LOG.debug("work_div**********************="+inVO.getSearchDiv());
   //검색구분 : 1:회원(게시글번호), 2:관리자(게시글번호)
   if(null !=inVO.getSearchDiv()|| !inVO.getSearchDiv().equals("")) {
      if("1".equals(inVO.getSearchDiv()) ) {
         //회원(게시글번호)
         sbWhere.append(" WHERE t1.bno = ? \n");
      }else if("2".equals(inVO.getSearchDiv())) {
    	//관리자(게시글번호)
         sbWhere.append(" WHERE t1.bno = ? \n");
      }else {
    	  sbWhere.append(" WHERE t1.bno = ? \n");
      }
   }
   
   //main query
   
   sb.append("   SELECT *                                         					\n");
   sb.append("   FROM(                                            		            \n");
   sb.append("       SELECT  RNUM num,                            		            \n");
   sb.append("                b.cno cno,                                 		        \n");
   sb.append("                b.cont cont,                            		        \n");
   sb.append("         		  get_code('VIEWS',b.views) views,                    	\n");
   sb.append("                b.regid regid,                          		        \n");
   sb.append("                TO_CHAR(b.regdt,'YYYY/MM/DD') regdt,                  \n");
   sb.append("                b.modid modid,                         		        \n");
   sb.append("                TO_CHAR(b.moddt,'YYYY/MM/DD') moddt,                  \n");
   sb.append("                b.bno bno                              		        \n");
   sb.append("       FROM (                                       		            \n");
   sb.append("           SELECT ROWNUM as rnum,A.*                 		            \n");
   sb.append("           FROM(                                    		            \n");
   sb.append("               SELECT t1.*                          		            \n");
   sb.append("               FROM comments t1                      		            \n");
   //---------------------------------where-------------------------------------
   if(inVO.getSearchDiv()!=null||!inVO.getSearchDiv().equals("")) {
       if(inVO.getSearchWord()!=null) {
          sb.append(sbWhere.toString());//물음표 1번
       }
    }
   //---------------------------------where-------------------------------------
   sb.append("               ORDER BY t1.regdt ASC                                 \n");
   sb.append("        )A                                                           \n");
   sb.append("          WHERE rownum <=(?*(?-1)+?)  							   \n");			
   sb.append("    )B                                                               \n");
   sb.append("   	 WHERE rnum >=?*(?-1)+1                						   \n");	
   sb.append("   	)                                                              \n");
   sb.append("   CROSS JOIN                                                        \n");
   sb.append("   (                                                                 \n");
   sb.append("    SELECT COUNT(*) TOTAL                                            \n");
   sb.append("    FROM comments t1                                                 \n");
   //---------------------------------where-------------------------------------
   if(inVO.getSearchDiv()!=null||!inVO.getSearchDiv().equals("")) {
       if(inVO.getSearchWord()!=null) {
          sb.append(sbWhere.toString());//물음표 1번
       }
    }
   //---------------------------------where-------------------------------------
   sb.append("         )                                                           \n");
   
   
   
   try {
      //1.
      connection = this.connectionMaker.getConnection();
      LOG.debug("1.connection="+connection);
      
      //2.pstmt
      //2.1
      LOG.debug("2.query=\n"+sb.toString());
      pstmt = connection.prepareStatement(sb.toString());
      LOG.debug("3.pstmt="+pstmt);
      LOG.debug("4. param="+inVO);
      //검색어 있는 경우
      if(null !=inVO.getSearchDiv() && null !=inVO.getSearchWord()) {
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
      }
    	  
      
      //4.query수행
      rs = pstmt.executeQuery();
      while(rs.next()) {
         //Data 1건을 outVO담기.
    	  CommentsVO outVO = new CommentsVO();
         
         outVO.setCno(rs.getString("cno"));
         outVO.setCont(rs.getString("cont")); 
         outVO.setViews(rs.getString("views"));
         outVO.setRegId(rs.getString("regid"));
         outVO.setRegDt(rs.getString("regdt")); 
         outVO.setModId(rs.getString("modid"));
         outVO.setModDt(rs.getString("moddt"));
         outVO.setBno(rs.getString("bno"));
         outVO.setNum(rs.getInt("num"));
         outVO.setTotal(rs.getInt("total"));
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
   *@작성일: 2020. 2. 3.
   *@작성자: sist
   *@설명:사용자 댓글업데이트
   *@param dto
   *@return int
   */
   @Override
   public int doUpdate(DTO dto) {
      int flag = 0;//쿼리수행여부확인하는변수 0이면실행안함 1이면실행함.
      CommentsVO inVO = (CommentsVO) dto;//param
      
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
         
         sb.append(" UPDATE comments           	 \n");
         sb.append(" SET  cont    = ?      		 \n");
         sb.append("     ,moddt   = SYSDATE 	 \n");
         sb.append(" WHERE cno     = ?       	 \n");
         LOG.debug("2.1. query=\n"+sb.toString());
         
         pstmt = connection.prepareStatement(sb.toString());
         LOG.debug("2. PreparedStatement=\n"+pstmt);
         LOG.debug("2.1. query=\n"+sb.toString());
         //3. param
         LOG.debug("3. param="+inVO);
         //3.1 param binding
         
         pstmt.setString(1, inVO.getCont());          //title
         pstmt.setString(2, inVO.getCno());           //seq
         
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
   *@작성일: 2020. 2. 3.
   *@작성자: sist
   *@설명:사용자 뷰업데이트
   *@param dto
   *@return int
   */
   public int doViewsUpdate(DTO dto) {
	      int flag = 0;//쿼리수행여부확인하는변수 0이면실행안함 1이면실행함.
	      CommentsVO inVO = (CommentsVO) dto;//param
	      
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
	         
	         sb.append(" UPDATE comments         	 \n");
	         sb.append(" SET  views    = ?           \n");
	         sb.append("     ,modid    = ? 	 		 \n");
	         sb.append("     ,moddt    = SYSDATE 	 \n");
	         sb.append(" WHERE cno     = ?           \n");
	         LOG.debug("2.1. query=\n"+sb.toString());
	         
	         pstmt = connection.prepareStatement(sb.toString());
	         LOG.debug("2. PreparedStatement=\n"+pstmt);
	         LOG.debug("2.1. query=\n"+sb.toString());
	         //3. param
	         LOG.debug("3. param="+inVO);
	         //3.1 param binding
	         
	               
	         pstmt.setString(1, inVO.getViews());
	         pstmt.setString(2, inVO.getModId());   
	         pstmt.setString(3, inVO.getCno());
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
   *@작성일: 2020. 2. 3.
   *@작성자: sist
   *@설명:사용자 댓글 삭제
   *@param dto
   *@return int
   */
   @Override
   public int doDelete(DTO dto) {
      
      int flag = 0;
        
      Connection connection = connectionMaker.getConnection();
         
      //3. query수행을 위한 PreparedStatement
      StringBuilder sb=new StringBuilder();
      sb.append(" DELETE FROM comments \n");
      sb.append(" WHERE cno = ? \n");
         
      PreparedStatement pstmt = null;
      CommentsVO inVO = (CommentsVO) dto;
         
      try {
    	  LOG.debug("2.sql=\n"+sb.toString());
    	  LOG.debug("2.1 param=\n"+inVO);
    	  pstmt = connection.prepareStatement(sb.toString()); 
    	  LOG.debug("3.pstmt="+pstmt);
    	  // * 4. query실행
    	  //   4.1. Bind변수에 값 설정
    	  pstmt.setString(1, inVO.getCno());//게시순번
            
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
   *@작성일: 2020. 2. 3.
   *@작성자: sist
   *@설명:사용안할예정
   *@param dto
   *@return int
   */
	@Override
	public DTO doSelectOne(DTO dto) {
		return null;
	}
	//사용 안함
	@Override
	public List<?> doRetrieve(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}





	/**
	 * 
	 *메서드명 : doAdminSelectOne1
	 *작성일 : 2020. 3. 18.
	 *작성자 : sist133
	 *설명 : 관리자 다건조회
	 *@param dto
	 *@return DTO
	 */
	public DTO doAdminSelectOne1(DTO dto) {
	    CommentsVO inVO = (CommentsVO) dto;//param
	    CommentsVO outVO = null;//return
	    
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
	       sb.append("SELECT cno,          \n");                                      
	       sb.append("      cont,          \n");                                     
	       sb.append("      views,         \n");                                       
	       sb.append("      regId,         \n");                                        
	       sb.append("      regDt,         \n");              
	       sb.append("      modId,         \n");                                      
	       sb.append("      modDt,         \n");
	       sb.append("      bno            \n");                                                                         
	       sb.append("FROM Comments        \n");                                         
	       sb.append("WHERE cno = ?        \n");  
	       
	       
	       pstmt = connection.prepareStatement(sb.toString());
	       LOG.debug("2. PreparedStatement="+pstmt);
	       LOG.debug("2.1 sql \n="+sb.toString());
	       
	       //3.param
	       LOG.debug("3. Param ="+inVO);
	       pstmt.setString(1, inVO.getCno());
	       
	       //4.query수행
	       rs = pstmt.executeQuery();
	       if(rs.next()) {//Moves the cursor forward one fow from its current position. 
	          //Data 1건을 outVO담기.
	    	   
	          outVO = new CommentsVO();
	          outVO.setCno(rs.getString("cno"));
	          outVO.setCont(rs.getString("cont"));
	          outVO.setViews(rs.getString("views"));
	          outVO.setRegId(rs.getString("refId"));
	          outVO.setRegDt(rs.getString("regDt"));
	          outVO.setModId(rs.getString("modId"));
	          outVO.setModDt(rs.getString("modDt"));
	          outVO.setBno(rs.getString("bno"));
	          
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





}
