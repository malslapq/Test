package com.board.Handler;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailHandler {

	private JavaMailSender mailsender;
	private MimeMessage message;
	private MimeMessageHelper messageHelper;
	
	//생성자 통해 초기화
	public MailHandler(JavaMailSender jSender) throws MessagingException {
		this.mailsender = jSender;
		message = jSender.createMimeMessage();
		messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	}
	
	// 보내는 사람 이메일
    public void setFrom(String fromAddress) throws MessagingException {
        messageHelper.setFrom(fromAddress);
    }

    // 받는 사람 이메일
    public void setTo(String email) throws MessagingException {
        messageHelper.setTo(email);
    }

    // 제목
    public void setSubject(String subject) throws MessagingException {
        messageHelper.setSubject(subject);
    }

    // 메일 내용
    public void setText(String text, boolean useHtml) throws MessagingException {
        messageHelper.setText(text, useHtml);
    }
    // 발송
    public void send() {
        try {
            mailsender.send(message);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
