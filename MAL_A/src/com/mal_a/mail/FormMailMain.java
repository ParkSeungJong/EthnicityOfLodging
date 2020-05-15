/**
 *<pre>
 * com.hr.mail
 * Class Name : FormMailMain.java
 * Description : 
 * Modification Information
 * 
 *   수정일      수정자              수정내용
 *  ---------   ---------   -------------------------------
 *  2020-03-18           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2020-03-18 
 * @version 1.0
 * 
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 * </pre>
 */
package com.mal_a.mail;

import org.apache.log4j.Logger;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;


/**
 * @author SIST
 *
 */
public class FormMailMain {

	/**
	 * 1. 발신자  mail 계정과 비번
	 * 2. property에 smtp계정과 비번
	 * 3. smtp서버정보를 기반으로 session 클래스의 인스턴스 생성
	 * 4. Message 클래스를 사용하여 수신자, 내용, 제목, 메세지를 작성
	 * 5. Transport 클래스를 이용해 전송.
	 *@Method Name:main
	 *@작성일: 2020. 3. 18.
	 *@작성자: SIST
	 *@설명:
	 *@param args
	*/
	private final static Logger LOG = Logger.getLogger(FormMailMain.class);
	
	public static int sendMail(String recAddr, String title, String message) {
		int flag = 0;
		//--------------------------------------------------------//
		// * 1. 발신자  mail 계정과 비번
		// * 2. property에 smtp계정과 비번, SSL,인증
		// * 3. smtp서버정보를 기반으로 session 클래스의 인스턴스 생성
		// * 4. Message 클래스를 사용하여 수신자, 내용, 제목, 메세지를 작성
		// * 5. Transport 클래스를 이용해 전송.
		//--------------------------------------------------------//
		//POP 서버명 : pop.naver.com SMTP 
//		서버명 : smtp.naver.com 
//		POP 포트 : 995, 보안연결(SSL) 필요
//		SMTP 포트 : 465, 보안 연결(SSL) 필요
//		아이디 : qkrtmdwhd2
//		비밀번호 : 네이버 로그인 비밀번호
		
		// * 1. 발신자  mail 계정과 비번
		String host = "smtp.naver.com"; //서버명
		String user = "qkrtmdwhd2@naver.com"; //naver사용자 계정
		String password = "!264813dkdk"; //naver 사용자 비번
		
		// * 2. property에 smtp계정과 비번, SSL,인증
		Properties pros= new Properties();
		pros.put("mail.smtp.host", host);
		pros.put("mail.smtp.port", 465);
		pros.put("mail.smtp.auth", "true");
		pros.put("mail.smtp.ssl.enable", "true");
		pros.put("mail.smtp.ssl.trust", host);
		
		// * 3. smtp서버정보를 기반으로 session 클래스의 인스턴스 생성
		Session session = Session.getDefaultInstance(pros, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			
			}
			
		});
		
		try {
			// * 4. Message 클래스를 사용하여 수신자, 내용, 제목, 메세지를 작성
			MimeMessage mimeMessage = new MimeMessage(session);
			//4.1 from
			mimeMessage.setFrom(new InternetAddress(user));
			//4.2 to
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recAddr));
			//4.3 title
			mimeMessage.setSubject(title);
			//4.4 내용
			mimeMessage.setText(message);
			
			// * 5. Transport 클래스를 이용해 전송.
			Transport.send(mimeMessage);
			
		}catch(MessagingException e){
			LOG.debug("==============================");
			LOG.debug("=MessagingException"+e.getMessage());
			LOG.debug("==============================");
			e.printStackTrace();
		}
		flag = 1;
		
		return flag;
		
		
	}
	public static void main(String[] args) {
		
		int flag = sendMail("jnhoon777@naver.com","sendMail 제목","좋은 하루되세요.");
		if(flag == 1) {
			LOG.debug("===================================");
			LOG.debug("=Send 성공=");
			LOG.debug("===================================");
		}
		

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
