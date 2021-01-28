package com.board.Service;

import com.board.Model.EmailDTO;
import com.board.Model.MailSenderDTO;

public interface MailService {
	public void sendMail(MailSenderDTO dto);
	public void insert(EmailDTO edto);
}
