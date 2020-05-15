/**
 *<pre>
 * 프로젝트명 : MAL_A
 * 패키지명 : com.mal_a.payment
 * 클래스명 : PaymentDao.java
 * 설명 : 
 * 수정 정보
 * 
 *   수정일                 수정자               수정내용
 *  ----------   ---------   -------------------------------
 *  2020-02-06    sist        최초생성
 *
 * @author 쌍용교육센터 E반 2조 MAL_A
 * @since 2020-02-06 오후 6:28:25
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mal_a.cmn.SearchVO;
import com.mal_a.cmn.ConnectionMaker;
import com.mal_a.cmn.DTO;
import com.mal_a.cmn.JDBCResClose;
import com.mal_a.cmn.WorkDiv;

/**
 * @author sist
 *
 */
public class PaymentDao extends WorkDiv {

	private ConnectionMaker connectionMaker;
	
	public PaymentDao() {
		connectionMaker = new ConnectionMaker();
	}
	
	/**
	 * 
	 *메서드명 : doInsert
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 결제시 결제내역 추가 메서드
	 *@param dto
	 *@return int
	 */
	@Override
	public int doInsert(DTO dto) {
		int flag = 0;
		Connection connection = connectionMaker.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO payment (               							\n");
		sb.append("						pno            							\n");
		sb.append("						,startdt       							\n");
		sb.append("						,enddt         							\n");
		sb.append("						,pay           							\n");
		sb.append("						,usepoint      							\n");
		sb.append("						,regid         							\n");
		sb.append("						,sno           							\n");
		sb.append("						,rno           							\n");
		sb.append(") VALUES (                          							\n");
		sb.append("	TO_CHAR(sysdate,'YYMMDD')||LPAD(payment_pno.nextval,6,0)	\n");
		sb.append("						,?             							\n");
		sb.append("						,?             							\n");
		sb.append("						,?             							\n");
		sb.append("						,?             							\n");
		sb.append("						,?             							\n");
		sb.append("						,?             							\n");
		sb.append("						,?             							\n");
		sb.append(")                                   							\n");
		PreparedStatement pstmt = null;
		PaymentVO inVO = (PaymentVO) dto;
		try {
			LOG.debug("2. sql=\n"+sb.toString());
			LOG.debug("2.1. param=\n"+inVO);
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("3. pstmt="+pstmt);
			pstmt.setString(1, inVO.getStartDt());/*시작 날짜*/
			pstmt.setString(2, inVO.getEndDt());/*종료 날짜*/
			pstmt.setString(3, inVO.getPay());/*결제 금액*/
			pstmt.setString(4, inVO.getUsePoint());/*사용 포인트*/
			pstmt.setString(5, inVO.getRegId());/*등록자 아이디*/
			pstmt.setString(6, inVO.getSno());/*해당 업체 번호*/
			pstmt.setString(7, inVO.getRno());/*해당 업체 방 번호*/
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
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 단건 조회
	 *@param dto
	 *@return int
	 */
	@Override
	public DTO doSelectOne(DTO dto) {
		PaymentVO inVO = (PaymentVO) dto;
		PaymentVO outVO = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = connectionMaker.getConnection();
			LOG.debug("1. connection:	"+connection);
			StringBuilder sb=new StringBuilder();
			sb.append("SELECT *                                  			 		 \n");
			sb.append("FROM (                                  			 			 \n");
			sb.append("SELECT P.pno pno                                  			 \n");
			sb.append("      ,TO_CHAR(p.startdt, 'YYYY/MM/DD') startdt               \n");
			sb.append("      ,TO_CHAR(p.enddt  , 'YYYY/MM/DD') enddt                 \n");
			sb.append("      ,p.pay pay             								 \n");
			sb.append("      ,TO_CHAR(p.paydt, 'YYYY/MM/DD') paydt                 	 \n");
			sb.append("      ,p.usepoint usepoint  									 \n");
			sb.append("      ,p.savepoint savepoint 								 \n");
			sb.append("      ,get_code('RS',p.rs) rs                         		 \n");
			sb.append("      ,TO_CHAR(p.paycmpdt , 'YYYY/MM/DD') paycmpdt            \n");
			sb.append("      ,TO_CHAR(p.cancdt   , 'YYYY/MM/DD') cancdt              \n");
			sb.append("      ,TO_CHAR(p.canccmpdt, 'YYYY/MM/DD') canccmpdt           \n");
			sb.append("      ,p.regid                               			     \n");
			sb.append("      ,TO_CHAR(p.regdt, 'YYYY/MM/DD') regdt                   \n");
			sb.append("      ,p.modid                                			     \n");
			sb.append("      ,TO_CHAR(p.moddt, 'YYYY/MM/DD') moddt                   \n");
			sb.append("      ,s.name sname                           			     \n");
			sb.append("      ,r.name rname                           			     \n");
			sb.append("FROM payment p , store s, room r     			     		 \n");
			sb.append("WHERE p.sno = s.sno                           			     \n");
			sb.append("AND p.rno = r.rno                             			     \n");
			sb.append("AND p.regid = ?                                   			 \n");
			sb.append("ORDER BY pno DESC                                  			 \n");
			sb.append(")                                  			 				 \n");
			sb.append("WHERE ROWNUM = 1                                  			 \n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PrepareStatement:	"+pstmt);
			LOG.debug("2.1. sql	:\n"+sb.toString());
			LOG.debug("3. param:	"+inVO);
			pstmt.setString(1,  inVO.getRegId());/*등록자 ID*/
			rs = pstmt.executeQuery();
			if(rs.next()) {
				outVO = new PaymentVO();
				outVO.setPno(rs.getString("pno"));/*예약 번호*/
				outVO.setStartDt(rs.getString("startdt"));/*시작 날짜*/
				outVO.setEndDt(rs.getString("enddt"));/*종료 날짜*/
				outVO.setPay(rs.getString("pay"));/*결제 금액*/
				outVO.setPayDt(rs.getString("paydt"));/*결제 날짜*/
				outVO.setUsePoint(rs.getString("usepoint"));/*사용 포인트*/
				outVO.setSavePoint(rs.getString("savepoint"));/*적립 포인트*/
				outVO.setRs(rs.getString("rs"));/*예약 상태*/
				outVO.setPayCmpDt(rs.getString("paycmpdt"));/*구매 확정 날짜*/
				outVO.setCancDt(rs.getString("cancdt"));/*환불 요청 날짜*/
				outVO.setCancCmpDt(rs.getString("canccmpdt"));/*환불 완료 날짜*/
				outVO.setRegId(rs.getString("regid"));/*등록자 아이디*/
				outVO.setRegDt(rs.getString("regdt"));/*등록 날짜*/
				outVO.setModId(rs.getString("modid"));/*수정자 아이디*/
				outVO.setModDt(rs.getString("moddt"));/*수정 날짜*/
				outVO.setSno(rs.getString("sname"));/*해당 업체 이름*/
				outVO.setRno(rs.getString("rname"));/*해당 업체 방 이름*/
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
	
	public DTO doSelectOnePno(DTO dto) {
		PaymentVO inVO = (PaymentVO) dto;
		PaymentVO outVO = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = connectionMaker.getConnection();
			LOG.debug("1. connection:	"+connection);
			StringBuilder sb=new StringBuilder();
			sb.append("SELECT P.pno pno                                  			 \n");
			sb.append("      ,TO_CHAR(p.startdt, 'YYYY/MM/DD') startdt               \n");
			sb.append("      ,TO_CHAR(p.enddt  , 'YYYY/MM/DD') enddt                 \n");
			sb.append("      ,p.pay pay             								 \n");
			sb.append("      ,TO_CHAR(p.paydt, 'YYYY/MM/DD') paydt                 	 \n");
			sb.append("      ,p.usepoint usepoint  									 \n");
			sb.append("      ,p.savepoint savepoint 								 \n");
			sb.append("      ,get_code('RS',p.rs) rs                         		 \n");
			sb.append("      ,TO_CHAR(p.paycmpdt , 'YYYY/MM/DD') paycmpdt            \n");
			sb.append("      ,TO_CHAR(p.cancdt   , 'YYYY/MM/DD') cancdt              \n");
			sb.append("      ,TO_CHAR(p.canccmpdt, 'YYYY/MM/DD') canccmpdt           \n");
			sb.append("      ,p.regid                               			     \n");
			sb.append("      ,TO_CHAR(p.regdt, 'YYYY/MM/DD') regdt                   \n");
			sb.append("      ,p.modid                                			     \n");
			sb.append("      ,TO_CHAR(p.moddt, 'YYYY/MM/DD') moddt                   \n");
			sb.append("      ,s.name sname                           			     \n");
			sb.append("      ,r.name rname                           			     \n");
			sb.append("FROM payment p , store s, room r     			     		 \n");
			sb.append("WHERE p.sno = s.sno                           			     \n");
			sb.append("AND p.rno = r.rno                             			     \n");
			sb.append("AND p.pno = ?                                   			 	 \n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PrepareStatement:	"+pstmt);
			LOG.debug("2.1. sql	:\n"+sb.toString());
			LOG.debug("3. param:	"+inVO);
			pstmt.setString(1,  inVO.getPno());/*등록자 ID*/
			rs = pstmt.executeQuery();
			if(rs.next()) {
				outVO = new PaymentVO();
				outVO.setPno(rs.getString("pno"));/*예약 번호*/
				outVO.setStartDt(rs.getString("startdt"));/*시작 날짜*/
				outVO.setEndDt(rs.getString("enddt"));/*종료 날짜*/
				outVO.setPay(rs.getString("pay"));/*결제 금액*/
				outVO.setPayDt(rs.getString("paydt"));/*결제 날짜*/
				outVO.setUsePoint(rs.getString("usepoint"));/*사용 포인트*/
				outVO.setSavePoint(rs.getString("savepoint"));/*적립 포인트*/
				outVO.setRs(rs.getString("rs"));/*예약 상태*/
				outVO.setPayCmpDt(rs.getString("paycmpdt"));/*구매 확정 날짜*/
				outVO.setCancDt(rs.getString("cancdt"));/*환불 요청 날짜*/
				outVO.setCancCmpDt(rs.getString("canccmpdt"));/*환불 완료 날짜*/
				outVO.setRegId(rs.getString("regid"));/*등록자 아이디*/
				outVO.setRegDt(rs.getString("regdt"));/*등록 날짜*/
				outVO.setModId(rs.getString("modid"));/*수정자 아이디*/
				outVO.setModDt(rs.getString("moddt"));/*수정 날짜*/
				outVO.setSno(rs.getString("sname"));/*해당 업체 이름*/
				outVO.setRno(rs.getString("rname"));/*해당 업체 방 이름*/
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
	
	/**
	 * 
	 *메서드명 : doSelectOnePayCmpCount
	 *작성일 : 2020. 2. 20.
	 *작성자 : sist
	 *설명 : 구매 확정 해야할 총 건수 조회 메서드
	 *@return DTO
	 */
	public DTO doSelectOnePayCmpCount() {
		PaymentVO outVO = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = connectionMaker.getConnection();
			LOG.debug("1. connection:	"+connection);
			StringBuilder sb=new StringBuilder();
			sb.append("SELECT COUNT(1) paycmpcount                                              \n");
			sb.append("FROM payment                                                             \n");
			sb.append("WHERE rs = 1                                                             \n");
			sb.append("AND TO_CHAR(enddt,'YYYYMMDD')+1 = TO_CHAR(SYSDATE,'YYYYMMDD')            \n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PrepareStatement:	"+pstmt);
			LOG.debug("2.1. sql	:\n"+sb.toString());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				outVO = new PaymentVO();
				outVO.setNum(rs.getInt("paycmpcount"));/*행수*/
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
	
	/**
	 * 
	 *메서드명 : doSelectOnePayCmpPno
	 *작성일 : 2020. 2. 20.
	 *작성자 : sist
	 *설명 : 구매 확정 해야 할 예약 번호 조회 메서드
	 *@param dto
	 *@return DTO
	 */
	public DTO doSelectOnePayCmpPno(DTO dto) {
		PaymentVO inVO = (PaymentVO) dto;
		PaymentVO outVO = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connection = connectionMaker.getConnection();
			LOG.debug("1. connection:	"+connection);
			StringBuilder sb=new StringBuilder();
			sb.append("SELECT pno                                                         \n");
			sb.append("		 ,pay*0.05 upsavepoint      								  \n");
			sb.append("		 ,regid				      									  \n");
			sb.append("FROM payment                                                       \n");
			sb.append("WHERE rs = 1                                                       \n");
			sb.append("AND TO_CHAR(enddt,'YYYYMMDD')+1 = TO_CHAR(SYSDATE,'YYYYMMDD')      \n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PrepareStatement:	"+pstmt);
			LOG.debug("2.1. sql	:\n"+sb.toString());
			LOG.debug("3. param:	"+inVO);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				outVO = new PaymentVO();
				outVO.setPno(rs.getString("pno"));/*예약 번호*/
				outVO.setSavePoint(rs.getString("upsavepoint"));/*적립 예정 포인트*/
				outVO.setRegId(rs.getString("regid"));/*등록자 아이디*/
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
	 *메서드명 : doUpdatePayCmp
	 *작성일 : 2020. 2. 20.
	 *작성자 : sist
	 *설명 : 구매 확정 업데이트 메서드
	 *@param dto
	 *@return int
	 */
	public int doUpdatePayCmp(DTO dto) {
		int flag = 0;
		PaymentVO inVO = (PaymentVO) dto;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = connectionMaker.getConnection();
			LOG.debug("1. connection:	"+connection);
			StringBuilder sb=new StringBuilder();
			sb.append("UPDATE payment               \n");
			sb.append("SET                          \n");
			sb.append("    savepoint = ?            \n");
			sb.append("    ,rs = '2'            	\n");
			sb.append("    ,paycmpdt 	= SYSDATE   \n");
			sb.append("    ,modid    	= 'SYSTEM'	\n");
			sb.append("    ,moddt    	= SYSDATE	\n");
			sb.append("WHERE                        \n");
			sb.append("    pno = ?                  \n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PrepareStatement:	"+pstmt);
			LOG.debug("2.1. query:\n"+sb.toString());
			LOG.debug("3. param:	"+inVO);
			pstmt.setString(1, inVO.getSavePoint());/*적립 포인트*/
			pstmt.setString(2, inVO.getPno());/*예약 번호*/
			flag = pstmt.executeUpdate();
			LOG.debug("4. flag:	"+flag);
		}catch(SQLException e) {
			LOG.debug("===============================");
			LOG.debug("=SQLException="+e.getMessage());
			LOG.debug("===============================");
			e.printStackTrace();
			JDBCResClose.rollBack(connection);
		}finally {
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return flag;
	}

	/**
	 * 
	 *메서드명 : doUpdateCanc
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 취소요청 업데이트 메서드
	 *@param dto
	 *@return int
	 */
	public int doUpdateCanc(DTO dto) {
		int flag = 0;
		PaymentVO inVO = (PaymentVO) dto;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = connectionMaker.getConnection();
			LOG.debug("1. connection:	"+connection);
			StringBuilder sb=new StringBuilder();
			sb.append("UPDATE payment	        \n");
			sb.append("SET  rs   	 = 3	    \n");
			sb.append("    ,cancdt 	 = SYSDATE  \n");
			sb.append("    ,modid    = ?		\n");
			sb.append("    ,moddt    = SYSDATE	\n");
			sb.append("WHERE pno     = ?	    \n");
			sb.append("AND   rs      = 1	    \n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PrepareStatement:	"+pstmt);
			LOG.debug("2.1. query:\n"+sb.toString());
			LOG.debug("3. param:	"+inVO);
			pstmt.setString(1, inVO.getModId());/*수정자 아이디*/
			pstmt.setString(2, inVO.getPno());/*예약 번호*/
			flag = pstmt.executeUpdate();
			LOG.debug("4. flag:	"+flag);
		}catch(SQLException e) {
			LOG.debug("===============================");
			LOG.debug("=SQLException="+e.getMessage());
			LOG.debug("===============================");
			e.printStackTrace();
			JDBCResClose.rollBack(connection);
		}finally {
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return flag;
	}
	
	public int doUpdateCancCanc(DTO dto) {
		int flag = 0;
		PaymentVO inVO = (PaymentVO) dto;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = connectionMaker.getConnection();
			LOG.debug("1. connection:	"+connection);
			StringBuilder sb=new StringBuilder();
			sb.append("UPDATE payment	        \n");
			sb.append("SET  rs   	 = 1	    \n");
			sb.append("    ,cancdt 	 = SYSDATE  \n");
			sb.append("    ,modid    = ?		\n");
			sb.append("    ,moddt    = SYSDATE	\n");
			sb.append("WHERE pno     = ?	    \n");
			sb.append("AND   rs      = 3	    \n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PrepareStatement:	"+pstmt);
			LOG.debug("2.1. query:\n"+sb.toString());
			LOG.debug("3. param:	"+inVO);
			pstmt.setString(1, inVO.getModId());/*수정자 아이디*/
			pstmt.setString(2, inVO.getPno());/*예약 번호*/
			flag = pstmt.executeUpdate();
			LOG.debug("4. flag:	"+flag);
		}catch(SQLException e) {
			LOG.debug("===============================");
			LOG.debug("=SQLException="+e.getMessage());
			LOG.debug("===============================");
			e.printStackTrace();
			JDBCResClose.rollBack(connection);
		}finally {
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return flag;
	}
	
	/**
	 * 
	 *메서드명 : doUpdateCancCmp
	 *작성일 : 2020. 2. 10.
	 *작성자 : sist
	 *설명 : 취소완료 업데이트 메서드
	 *@param dto
	 *@return int
	 */
	public int doUpdateCancCmp(DTO dto) {
		int flag = 0;
		PaymentVO inVO = (PaymentVO) dto;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = connectionMaker.getConnection();
			LOG.debug("1. connection:	"+connection);
			StringBuilder sb=new StringBuilder();
			sb.append("UPDATE payment	        \n");
			sb.append("SET  rs   	  = 4	    \n");
			sb.append("    ,canccmpdt = SYSDATE \n");
			sb.append("    ,modid     = ?		\n");
			sb.append("    ,moddt     = SYSDATE	\n");
			sb.append("WHERE pno      = ? 		\n");
			sb.append("AND 	 rs      IN (1,3) 	\n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PrepareStatement:	"+pstmt);
			LOG.debug("2.1. query:\n"+sb.toString());
			LOG.debug("3. param:	"+inVO);
			pstmt.setString(1, inVO.getModId());/*수정자 아이디*/
			pstmt.setString(2, inVO.getPno());/*예약 번호*/
			flag = pstmt.executeUpdate();
			LOG.debug("4. flag:	"+flag);
		}catch(SQLException e) {
			LOG.debug("===============================");
			LOG.debug("=SQLException="+e.getMessage());
			LOG.debug("===============================");
			e.printStackTrace();
			JDBCResClose.rollBack(connection);
		}finally {
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return flag;
	}
	
	/**
	 * 
	 *메서드명 : doUpdatePay
	 *작성일 : 2020. 2. 26.
	 *작성자 : sist
	 *설명 : 예약으로 상태 변경 업데이트 메서드
	 *@param dto
	 *@return int
	 */
	public int doUpdatePay(DTO dto) {
		int flag = 0;
		PaymentVO inVO = (PaymentVO) dto;
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			connection = connectionMaker.getConnection();
			LOG.debug("1. connection:	"+connection);
			StringBuilder sb=new StringBuilder();
			sb.append("UPDATE payment	        \n");
			sb.append("SET  rs   	  = 1	    \n");
			sb.append("    ,modid     = ?		\n");
			sb.append("    ,moddt     = SYSDATE	\n");
			sb.append("WHERE pno      = ? 		\n");
			sb.append("AND   rs       = 3 		\n");
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2. PrepareStatement:	"+pstmt);
			LOG.debug("2.1. query:\n"+sb.toString());
			LOG.debug("3. param:	"+inVO);
			pstmt.setString(1, inVO.getModId());/*수정자 아이디*/
			pstmt.setString(2, inVO.getPno());/*예약 번호*/
			flag = pstmt.executeUpdate();
			LOG.debug("4. flag:	"+flag);
		}catch(SQLException e) {
			LOG.debug("===============================");
			LOG.debug("=SQLException="+e.getMessage());
			LOG.debug("===============================");
			e.printStackTrace();
			JDBCResClose.rollBack(connection);
		}finally {
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return flag;
	}
	
	@Override
	public int doDelete(DTO dto) {
		return 0;
	}

	/**
	 * 
	 *메서드명 : doRetrieve
	 *작성일 : 2020. 2. 11.
	 *작성자 : sist
	 *설명 : 다건 조회
	 *@param dto
	 *@return List<?>
	 */
	@Override
	public List<?> doRetrieve(DTO dto) {
		SearchVO inVO = (SearchVO) dto;
		
		PaymentVO inPaymentVO = new PaymentVO();
		inPaymentVO.setRegId(inVO.getSearchWord());
		
		List<PaymentVO> outList = new ArrayList<PaymentVO>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sbWhere = new StringBuilder();
		StringBuilder sb = new StringBuilder();
		//검색구분 : 1(회원아이디), 2(업체번호)
		if(null != inVO.getSearchDiv() || !inVO.getSearchDiv().equals("")) {
			if("1".equals(inVO.getSearchDiv())) {//회원 아이디
				sbWhere.append(" WHERE t1.regid = ? \n");
			}else if("2".equals(inVO.getSearchDiv())) {//업체 번호
				sbWhere.append(" WHERE t1.sno = ? \n");
			}
		}
		sb.append("SELECT *                                                         \n");
		sb.append("FROM(                                                            \n");
		sb.append("    SELECT rnum num,                                             \n");
		sb.append("		   b.pno,                                                   \n");
		sb.append("		   b.reviewcheck,                                           \n");
		sb.append("		   TO_CHAR(b.startdt, 'YYYY/MM/DD') startdt,                \n");                             
		sb.append("		   TO_CHAR(b.enddt,   'YYYY/MM/DD') enddt,                  \n");                      
		sb.append("        b.pay pay,              									\n");
		sb.append("		   TO_CHAR(b.paydt, 'YYYY/MM/DD') paydt,                    \n");
		sb.append("		   b.usepoint usepoint,    									\n");
		sb.append("		   b.savepoint savepoint,  									\n");
		sb.append("		   get_code('RS',b.rs) rs,                                  \n");
		sb.append("		   TO_CHAR(b.paycmpdt,  'YYYY/MM/DD') paycmpdt,             \n");
		sb.append("		   TO_CHAR(b.cancdt,    'YYYY/MM/DD') cancdt,               \n");
		sb.append("		   TO_CHAR(b.canccmpdt, 'YYYY/MM/DD') canccmpdt,            \n");
		sb.append("		   b.regid,													\n");
		sb.append("		   TO_CHAR(b.regdt,  	'YYYY/MM/DD') regdt,                \n");
		sb.append("		   b.modid,													\n");
		sb.append("		   TO_CHAR(b.moddt,  	'YYYY/MM/DD') moddt,                \n");
		sb.append("		   s.name sname,                                            \n");
		sb.append("		   r.name rname                                             \n");
		sb.append("    FROM (                                                       \n");
		sb.append("        SELECT rownum as rnum, a.*                               \n");
		sb.append("        FROM(                                                    \n");
		sb.append("            SELECT t1.*,                                         \n");
		sb.append("            		review_check_func(?, t1.pno) reviewcheck 		\n");
		sb.append("            FROM payment t1                                      \n");
		sb.append("            --검색어                                              					    \n");
		sb.append("			--WHERE t1.REGID LIKE ?||'%' \n                         \n");
		//-where-------------------------------------------------------------------------
			if(null != inVO.getSearchDiv() || !inVO.getSearchDiv().equals("")) {
				if(null != inVO.getSearchWord()) {
					sb.append(sbWhere.toString());
				}
			}
		//-where-------------------------------------------------------------------------
		sb.append("            ORDER BY t1.pno DESC                                 \n");
		sb.append("        )a                                                       \n");
		sb.append("		WHERE rownum <=(?*(?-1)+?)      						    \n");
		sb.append("	)B, store s, room r                                    			\n");
		sb.append("	WHERE b.sno = s.sno                                             \n");
		sb.append("	AND b.rno = r.rno                                               \n");
		sb.append("	AND rnum >=(?*(?-1)+1)                      				    \n");
		sb.append("            ORDER BY b.pno DESC                                  \n");
		sb.append(")                                                                \n");
		sb.append("CROSS JOIN                                                       \n");
		sb.append("(                                                                \n");
		sb.append("	SELECT COUNT(*) TOTAL                                           \n");
		sb.append("    FROM payment t1                                              \n");
		sb.append("    --검색어                                                      						    \n");
		sb.append("    --WHERE t1.REGID LIKE ?||'%' \n                              \n");
		//-where-------------------------------------------------------------------------
			if(null != inVO.getSearchDiv() || !inVO.getSearchDiv().equals("")) {
				if(null != inVO.getSearchWord()) {
					sb.append(sbWhere.toString());
				}
			}
		//-where-------------------------------------------------------------------------
		sb.append(")                                                                \n");
		try {
			connection = this.connectionMaker.getConnection();
			LOG.debug("1. connection="+connection);
			LOG.debug("2. query=\n"+sb.toString());
			pstmt = connection.prepareStatement(sb.toString());
			LOG.debug("2.1. pstmt="+pstmt);
			LOG.debug("3. param="+inVO);
			//검색어 있는 경우
			if((inVO.getSearchDiv() != null && !inVO.getSearchDiv().equals("")) && inVO.getSearchWord() != null) {
				pstmt.setString(1,  inPaymentVO.getRegId());/*검색어*/
				pstmt.setString(2,  inVO.getSearchWord());/*검색어*/
				pstmt.setInt(3,  inVO.getPageSize());/*페이지 사이즈*/
				pstmt.setInt(4,  inVO.getPageNum());/*페이지 넘버*/
				pstmt.setInt(5,  inVO.getPageSize());/*페이지 사이즈*/
				pstmt.setInt(6,  inVO.getPageSize());/*페이지 사이즈*/
				pstmt.setInt(7,  inVO.getPageNum());/*페이지 넘버*/
				pstmt.setString(8,  inVO.getSearchWord());/*검색어*/
			//검색어 없을 때
			}else {
				pstmt.setString(1,  inPaymentVO.getRegId());/*검색어*/
				pstmt.setInt(2,  inVO.getPageSize());/*페이지 사이즈*/
				pstmt.setInt(3,  inVO.getPageNum());/*페이지 넘버*/
				pstmt.setInt(4,  inVO.getPageSize());/*페이지 사이즈*/
				pstmt.setInt(5,  inVO.getPageSize());/*페이지 사이즈*/
				pstmt.setInt(6,  inVO.getPageNum());/*페이지 넘버*/
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PaymentVO outVO = new PaymentVO();
				outVO.setPno(rs.getString("pno"));/*예약 번호*/
				outVO.setReviewCheck(rs.getString("reviewcheck"));/*리뷰 여부 체크*/
				outVO.setStartDt(rs.getString("startdt"));/*시작 날짜*/
				outVO.setEndDt(rs.getString("enddt"));/*종료 날짜*/
				outVO.setPay(rs.getString("pay"));/*결제 금액*/
				outVO.setPayDt(rs.getString("paydt"));/*결제 날짜*/
				outVO.setUsePoint(rs.getString("usepoint"));/*사용 포인트*/
				outVO.setSavePoint(rs.getString("savepoint"));/*적립 포인트*/
				outVO.setRs(rs.getString("rs"));/*예약 상태*/
				outVO.setPayCmpDt(rs.getString("paycmpdt"));/*구매 확정 날짜*/
				outVO.setCancDt(rs.getString("cancdt"));/*환불 요청 날짜*/
				outVO.setCancCmpDt(rs.getString("canccmpdt"));/*환불 완료 날짜*/
				outVO.setRegId(rs.getString("regid"));/*등록자 아이디*/
				outVO.setRegDt(rs.getString("regdt"));/*등록 날짜*/
				outVO.setModId(rs.getString("modid"));/*수정자 아이디*/
				outVO.setModDt(rs.getString("moddt"));/*수정 날짜*/
				outVO.setSno(rs.getString("sname"));/*해당 업체 이름*/
				outVO.setRno(rs.getString("rname"));/*해당 업체 방 이름*/
				outVO.setNum(rs.getInt("num"));
				outVO.setTotal(rs.getInt("total"));/*총 검색 건수*/
				outList.add(outVO);
			}
			LOG.debug("4. return :"+outList);
		}catch(SQLException e) {
			LOG.debug("======================");
			LOG.debug("=SQLException="+e.getMessage());
			LOG.debug("======================");
			e.printStackTrace();
		}finally {
			JDBCResClose.close(rs);
			JDBCResClose.close(pstmt);
			JDBCResClose.close(connection);
		}
		return outList;
	}

}
