package com.mal_a.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.mal_a.cmn.DTO;

public class MailService {
	private final Logger LOG = Logger.getLogger(MailService.class);

	public int sendMail(DTO dto) {
		MailVO inVO = (MailVO) dto;
		int flag = 0;
		
		String recAddr = inVO.getRecAddr();//받는사람
		String title = inVO.getTitle();//제목
		String message = inVO.getMessage();//내용
		
		// --------------------------------------------------------//
		// * 1. 발신자 mail 계정과 비번
		// * 2. property에 smtp계정과 비번, SSL,인증
		// * 3. smtp서버정보를 기반으로 session 클래스의 인스턴스 생성
		// * 4. Message 클래스를 사용하여 수신자, 내용, 제목, 메세지를 작성
		// * 5. Transport 클래스를 이용해 전송.
		// --------------------------------------------------------//
		// POP 서버명 : pop.naver.com SMTP
//		서버명 : smtp.naver.com 
//		POP 포트 : 995, 보안연결(SSL) 필요
//		SMTP 포트 : 465, 보안 연결(SSL) 필요
//		아이디 : qkrtmdwhd2
//		비밀번호 : 네이버 로그인 비밀번호

		// * 1. 발신자 mail 계정과 비번
		String host = "smtp.naver.com"; // 서버명
		String user = "qkrtmdwhd2@naver.com"; // naver사용자 계정
		String password = "!264813dkdk"; // naver 사용자 비번

		// * 2. property에 smtp계정과 비번, SSL,인증
		Properties pros = new Properties();
		pros.put("mail.smtp.host", host);
		pros.put("mail.smtp.port", 465);
		pros.put("mail.smtp.auth", "true");
		pros.put("mail.smtp.ssl.enable", "true");
		pros.put("mail.smtp.ssl.trust", host);

		// * 3. smtp서버정보를 기반으로 session 클래스의 인스턴스 생성
		Session session = Session.getDefaultInstance(pros, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);

			}

		});

		try {
			// * 4. Message 클래스를 사용하여 수신자, 내용, 제목, 메세지를 작성
			MimeMessage mimeMessage = new MimeMessage(session);
			// 4.1 from
			mimeMessage.setFrom(new InternetAddress(user));
			// 4.2 to
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recAddr));
			// 4.3 title
			mimeMessage.setSubject(title);
			// 4.4 내용
			mimeMessage.setText(message);

			// * 5. Transport 클래스를 이용해 전송.
			Transport.send(mimeMessage);

		} catch (MessagingException e) {
			LOG.debug("==============================");
			LOG.debug("=MessagingException" + e.getMessage());
			LOG.debug("==============================");
			e.printStackTrace();
		}
		flag = 1;

		return flag;

	}
}
