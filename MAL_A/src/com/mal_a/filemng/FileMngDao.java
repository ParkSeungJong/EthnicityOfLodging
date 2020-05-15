/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.filemng
 * 클래스명 : FileMngDao.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-17    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-17 오후 4:27:33
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.filemng;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mal_a.cmn.ConnectionMaker;
import com.mal_a.cmn.DTO;
import com.mal_a.cmn.JDBCResClose;
import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.WorkDiv;
import com.mal_a.payment.PaymentVO;
import com.mal_a.room.RoomVO;

/**
 * @author sist
 *
 */
public class FileMngDao extends WorkDiv {

	private ConnectionMaker connectionMaker;
	
	public FileMngDao() {
		connectionMaker = new ConnectionMaker();
	}
	
	/**
	 * 
	 *메서드명 : doInsert
	 *작성일 : 2020. 2. 17.
	 *작성자 : sist
	 *설명 : 첨부파일 최초 인서트 메서드
	 *@param dto
	 *@return int
	 */
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		Connection connection = connectionMaker.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO FILEMNG(                                               \n");
		sb.append("					fileid                                            \n");
		sb.append("					,seq                                              \n");
		sb.append("					,orgnm                                            \n");
		sb.append("					,savenm                                           \n");
		sb.append("                 ,savepath                                      	  \n");
		sb.append("                 ,filesize                                      	  \n");
		sb.append("                 ,ext                                              \n");
		sb.append("					,filepart                                         \n");
		sb.append("					,regid                                            \n");
		sb.append("			) VALUES (                                                \n");
		sb.append("			 	?      												  \n");
		sb.append("			   ,?                                                     \n");
		sb.append("			   ,?                                                     \n");
		sb.append("			   ,?                                                     \n");
		sb.append("            ,?                                                     \n");
		sb.append("            ,?                                                     \n");
		sb.append("            ,?                                                     \n");
		sb.append("			   ,?                                                     \n");
		sb.append("			   ,?                                                     \n");
		sb.append("            )                                                      \n");
		PreparedStatement pstmt = null;
		FileMngVO inVO = (FileMngVO) dto;
		try {
			LOG.debug("2. sql=\n"+sb.toString());
			LOG.debug("2.1. param=\n"+inVO);
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("3. pstmt="+pstmt);
			pstmt.setString(1, inVO.getFileId());
			pstmt.setInt(2, inVO.getSeq());
			pstmt.setString(3, inVO.getOrgNm());
			pstmt.setString(4, inVO.getSaveNm());
			pstmt.setString(5, inVO.getSavePath());
			pstmt.setLong(6, inVO.getFileSize());
			pstmt.setString(7, inVO.getExt());
			pstmt.setString(8, inVO.getFilePart());
			pstmt.setString(9, inVO.getRegId());
			flag = pstmt.executeUpdate();
			LOG.debug("4. flag="+flag);
		}catch(SQLException e) {
			LOG.debug("===================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("===================");
			e.printStackTrace();
		}finally {
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return flag;
	}
	
	/*
	public int doInsert02(List<?> dto) {
		int flag = 0;
		Connection connection = connectionMaker.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO FILEMNG(                                               \n");
		sb.append("					fileid                                            \n");
		sb.append("					,seq                                              \n");
		sb.append("					,orgnm                                            \n");
		sb.append("					,savenm                                           \n");
		sb.append("                 ,savepath                                      	  \n");
		sb.append("                 ,filesize                                      	  \n");
		sb.append("                 ,ext                                              \n");
		sb.append("					,filepart                                         \n");
		sb.append("					,regid                                            \n");
		sb.append("			) VALUES (                                                \n");
		sb.append("			 	?      												  \n");
		sb.append("			   ,?                                                     \n");
		sb.append("			   ,?                                                     \n");
		sb.append("			   ,?                                                     \n");
		sb.append("            ,?                                                     \n");
		sb.append("            ,?                                                     \n");
		sb.append("            ,?                                                     \n");
		sb.append("			   ,?                                                     \n");
		sb.append("			   ,?                                                     \n");
		sb.append("            )                                                      \n");
		PreparedStatement pstmt = null;
		FileMngVO inVO = (FileMngVO) dto;
		try {
			LOG.debug("2. sql=\n"+sb.toString());
			LOG.debug("2.1. param=\n"+inVO);
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("3. pstmt="+pstmt);
			pstmt.setString(1, inVO.getFileId());
			pstmt.setInt(2, inVO.getSeq());
			pstmt.setString(3, inVO.getOrgNm());
			pstmt.setString(4, inVO.getSaveNm());
			pstmt.setString(5, inVO.getSavePath());
			pstmt.setLong(6, inVO.getFileSize());
			pstmt.setString(7, inVO.getExt());
			pstmt.setString(8, inVO.getFilePart());
			pstmt.setString(9, inVO.getRegId());
			flag = pstmt.executeUpdate();
			LOG.debug("4. flag="+flag);
		}catch(SQLException e) {
			LOG.debug("===================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("===================");
			e.printStackTrace();
		}finally {
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return flag;
	}
	*/
	
	/**
	 * 
	 *메서드명 : doInsertAdd
	 *작성일 : 2020. 2. 17.
	 *작성자 : sist
	 *설명 : 첨부파일 추가 인서트 메서드
	 *@param dto
	 *@return int
	 */
	public int doInsertAdd(DTO dto) {
		int flag = 0;
		Connection connection = connectionMaker.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO FILEMNG(                                               \n");
		sb.append("					fileid                                            \n");
		sb.append("					,seq                                              \n");
		sb.append("					,orgnm                                            \n");
		sb.append("					,savenm                                           \n");
		sb.append("                    ,savepath                                      \n");
		sb.append("                    ,filesize                                      \n");
		sb.append("                    ,ext                                           \n");
		sb.append("					,filepart                                         \n");
		sb.append("					,regid                                            \n");
		sb.append("			) VALUES (                                                \n");
		sb.append("			?													      \n");
		sb.append("			,?                                                        \n");
		sb.append("			,?                                                        \n");
		sb.append("			,?                                                        \n");
		sb.append("            ,?                                                     \n");
		sb.append("            ,?                                                     \n");
		sb.append("            ,?                                                     \n");
		sb.append("			,?                                                        \n");
		sb.append("			,?                                                        \n");
		sb.append("            )                                                      \n");
		PreparedStatement pstmt = null;
		FileMngVO inVO = (FileMngVO) dto;
		try {
			LOG.debug("2. sql=\n"+sb.toString());
			LOG.debug("2.1. param=\n"+inVO);
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("3. pstmt="+pstmt);
			pstmt.setString(1, inVO.getFileId());
			pstmt.setInt(2, inVO.getSeq());
			pstmt.setString(3, inVO.getOrgNm());
			pstmt.setString(4, inVO.getSaveNm());
			pstmt.setString(5, inVO.getSavePath());
			pstmt.setLong(6, inVO.getFileSize());
			pstmt.setString(7, inVO.getExt());
			pstmt.setString(8, inVO.getFilePart());
			pstmt.setString(9, inVO.getRegId());
			flag = pstmt.executeUpdate();
			LOG.debug("4. flag="+flag);
		}catch(SQLException e) {
			LOG.debug("===================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("===================");
			e.printStackTrace();
		}finally {
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return flag;
	}

	/**
	 * 
	 *메서드명 : doSelectOne
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 첨부파일 대표(seq = 1) 1건만 출력 메서드
	 *@param dto
	 *@return DTO
	 */
	@Override
	public DTO doSelectOne(DTO dto) {
		FileMngVO inVO = (FileMngVO) dto;
		FileMngVO outVO = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = connectionMaker.getConnection();
			LOG.debug("1. connection:	"+connection);
			StringBuilder sb=new StringBuilder();
			sb.append("SELECT FileId                \n");
			sb.append("	  ,Seq                      \n");
			sb.append("	  ,OrgNm                    \n");
			sb.append("	  ,SaveNm                   \n");
			sb.append("	  ,REPLACE(SUBSTR(savepath,INSTR(savepath,'WebContent')+10,1000),'\\','/')||'/' savepath                 \n");
			sb.append("	  ,FileSize                 \n");
			sb.append("	  ,Ext                      \n");
			sb.append("	  ,FilePart                 \n");
			sb.append("	  ,RegId                    \n");
			sb.append("	  ,RegDt                    \n");
			sb.append("	  ,ModId                    \n");
			sb.append("	  ,ModDt                    \n");
			sb.append("FROM filemng                 \n");
			sb.append("WHERE fileid = ?             \n");
			sb.append("AND seq = 1                  \n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PrepareStatement:	"+pstmt);
			LOG.debug("2.1. sql	:\n"+sb.toString());
			LOG.debug("3. param:	"+inVO);
			pstmt.setString(1,  inVO.getFileId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				outVO = new FileMngVO();
				outVO.setFileId(rs.getString("FileId"));
				outVO.setSeq(rs.getInt("Seq"));
				outVO.setOrgNm(rs.getString("OrgNm"));
				outVO.setSaveNm(rs.getString("SaveNm"));
				outVO.setSavePath(rs.getString("SavePath"));
				outVO.setFileSize(rs.getLong("FileSize"));
				outVO.setExt(rs.getString("Ext"));
				outVO.setFilePart(rs.getString("FilePart"));
				outVO.setRegId(rs.getString("RegId"));
				outVO.setRegDt(rs.getString("RegDt"));
				outVO.setModId(rs.getString("ModId"));
				outVO.setModDt(rs.getString("ModDt"));
				LOG.debug("4. return :"+outVO);
			}
		}catch(SQLException e) {
			LOG.debug("===============================");
			LOG.debug("=SQLException="+e.getMessage());
			LOG.debug("===============================");
			e.printStackTrace();
		}finally {
			JDBCResClose.close(rs);
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return outVO;
	}

	@Override
	public int doUpdate(DTO dto) {
		return 0;
	}

	/**
	 * 
	 *메서드명 : doDelete
	 *작성일 : 2020. 2. 17.
	 *작성자 : sist
	 *설명 : 첨부파일 fileid 해당건 전체 삭제 메서드
	 *@param dto
	 *@return int
	 */
	@Override
	public int doDelete(DTO dto) {
		int flag = 0;
		Connection connection = connectionMaker.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append(" DELETE FROM filemng \n");
		sb.append(" WHERE fileid = ?    \n");	
		PreparedStatement pstmt = null;
		FileMngVO inVO = (FileMngVO) dto;
		try {
			LOG.debug("2.sql=\n"+sb.toString());
			LOG.debug("2.1 param=\n"+inVO);
			pstmt = connection.prepareStatement(sb.toString()); 
			LOG.debug("3.pstmt="+pstmt);
			pstmt.setString(1, inVO.getFileId());
			flag = pstmt.executeUpdate();
			LOG.debug("4.flag="+flag);
		} catch (SQLException e) {
			LOG.debug("===================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("===================");
			e.printStackTrace();
		} finally {
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return flag;
	}
	
	/**
	 * 
	 *메서드명 : doDeleteSeq
	 *작성일 : 2020. 2. 17.
	 *작성자 : sist
	 *설명 : 첨부파일 fileid 과 seq 해당건 삭제 메서드
	 *@param dto
	 *@return int
	 */
	public int doDeleteSeq(DTO dto) {
		int flag = 0;
		Connection connection = connectionMaker.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append(" DELETE FROM filemng \n");
		sb.append(" WHERE fileid = ?    \n");
		sb.append(" AND seq = ?   	    \n");	
		PreparedStatement pstmt = null;
		FileMngVO inVO = (FileMngVO) dto;
		try {
			LOG.debug("2.sql=\n"+sb.toString());
			LOG.debug("2.1 param=\n"+inVO);
			pstmt = connection.prepareStatement(sb.toString()); 
			LOG.debug("3.pstmt="+pstmt);
			pstmt.setString(1, inVO.getFileId());
			pstmt.setInt(2, inVO.getSeq());
			flag = pstmt.executeUpdate();
			LOG.debug("4.flag="+flag);
		} catch (SQLException e) {
			LOG.debug("===================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("===================");
			e.printStackTrace();
		} finally {
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return flag;
	}

	/**
	 * 
	 *메서드명 : doRetrieve
	 *작성일 : 2020. 2. 18.
	 *작성자 : sist
	 *설명 : 첨부파일 파일ID별, 파일생성페이지 별 셀렉트 리스트 메서드
	 *@param dto
	 *@return List<?>
	 */
	@Override
	public List<?> doRetrieve(DTO dto) {
		FileMngVO inVO = (FileMngVO) dto;
		List<FileMngVO> list = new ArrayList<FileMngVO>(); //return
		
		Connection connection = null; //DB Connection
		PreparedStatement pstmt = null; //VS Statement 해킹에 취약
		ResultSet rs = null; //결과 값 처리 class
		
		try {
			//1.Connection
			connection = connectionMaker.getConnection();
			LOG.debug("1.connection : "+connection);
			
			//2.PreparedStatement
			//2.1.SQL-단건 조회 query
			StringBuilder sb = new StringBuilder();
			sb.append("	SELECT fileid                                                									\n");
			sb.append("	        ,seq              																		\n");
			sb.append("	        ,orgnm                    																\n");
			sb.append("	        ,savenm            																		\n");
			sb.append("	        ,REPLACE(SUBSTR(savepath,INSTR(savepath,'WebContent')+10,1000),'\\','/')||'/' savepath  \n");
			sb.append("	        ,filesize    																			\n");
			sb.append("	        ,ext  																					\n");
			sb.append("	        ,filepart                                              									\n");
			sb.append("	        ,regid																					\n");
			sb.append("	        ,TO_CHAR(REGDT, 'YYYY/MM/DD') regdt                										\n");
			sb.append("	        ,modid																					\n");
			sb.append("	        ,TO_CHAR(MODDT, 'YYYY/MM/DD') moddt    													\n");
			sb.append("	FROM filemng																					\n");
			sb.append("	WHERE fileid = ?																				\n");
			LOG.debug("2.SQL :\n"+sb.toString());
			//2.2.pstmt
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1.PreparedStatement : "+pstmt);
			
			//3.Param setting 
			LOG.debug("3.param : "+inVO);
			//3.1.Param binding
			pstmt.setString(1, inVO.getFileId());
			
			//4.Query 수행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FileMngVO outVO = new FileMngVO();
				outVO.setFileId(rs.getString("fileid"));
				outVO.setSeq(rs.getInt("seq"));
				outVO.setOrgNm(rs.getString("orgnm"));
				outVO.setSaveNm(rs.getString("savenm"));
				outVO.setSavePath(rs.getString("savepath"));
				outVO.setFileSize(rs.getLong("filesize"));
				outVO.setExt(rs.getString("ext"));
				outVO.setFilePart(rs.getString("filepart"));
				outVO.setRegId(rs.getString("regid"));
				outVO.setRegDt(rs.getString("regdt"));
				outVO.setModId(rs.getString("modid"));
				outVO.setModDt(rs.getString("moddt"));
				list.add(outVO);
			}
		} catch (SQLException e) {
			LOG.debug("===========================");
			LOG.debug("=======SQLException======="+e.getMessage());
			LOG.debug("===========================");
			e.printStackTrace();
		} finally {
			//5.preparedStatement, ResultSet 자원 반납 - 사용하는 역순으로 close
			//6.Connection 종료
			JDBCResClose.close(rs);
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return list;
	}

}
