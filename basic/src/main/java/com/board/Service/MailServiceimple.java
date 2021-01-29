package com.board.Service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;

import com.board.Handler.MailHandler;
import com.board.Model.EmailDTO;
import com.board.Model.EmailMapper;
import com.board.Model.MailSenderDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailServiceimple implements MailService{
	
	@Autowired
	private EmailMapper mapper;
	
	private JavaMailSender mailsender;
	
	public void sendMail(MailSenderDTO dto) {
		dto.setFrom("malslapq01@naver.com");
		//메일 받을 사람 메일 주소
		try {
			MailHandler handler = new MailHandler(mailsender);
			//받는사람
			handler.setTo(dto.getTo());
			//보내는 사람
			handler.setFrom(dto.getFrom());
			//제목
			handler.setSubject("테스트 메일");
			//내용
			String content = "이름 : "+dto.getName()+"<br> "
					+ "번호 : "+dto.getPhone()+"<br> "
					+ "이메일 : "+dto.getTo()+"<br> "
					+ "개인정보 동의 여부 : "+dto.getSendchk();
			handler.setText(content, true);
			handler.send();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(EmailDTO edto) {
		mapper.insert(edto);
	}
}
