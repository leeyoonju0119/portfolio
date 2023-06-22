package com.portfolio.service;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.portfolio.dto.EmailDTO;

import lombok.Setter;

@Service
public class EmailServiceImpl implements EmailService {

	// email-config.xml의 mailSender bean주입을 받는다.
	@Setter(onMethod_ = {@Autowired})
	private JavaMailSender mailSender;
	
	@Override
	public void sendMail(EmailDTO dto, String message) {
		
		// 메일구성정보를 담당하는 객체(받는사람, 보내는 사람, 전자우편주소, 본문내용)
		MimeMessage msg = mailSender.createMimeMessage();
		
/*
 try{
  실행부분;
}catch(Exception e){
  예외가 발생한 경우(에러), 처리할 부분.
}finally{
  무조건 실행되는 부분;
}
*/
		try {
			// 받는사람의 메일주소
			msg.addRecipient(RecipientType.TO, new InternetAddress(dto.getReceiverMail()));
			// 보내는 사람(메일, 이름)
			msg.addFrom(new InternetAddress[] {new InternetAddress(dto.getSenderName())});
			// 메일제목
			msg.setSubject(dto.getSubject(), "utf-8");
			// 본문내용
			msg.setText(message, "utf-8");		
			
			mailSender.send(msg); // send-발송하다 보내다
		}catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
