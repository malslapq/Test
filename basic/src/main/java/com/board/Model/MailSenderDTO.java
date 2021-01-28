package com.board.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailSenderDTO {
	private String name;
	private String phone;
	private String To;
	private String from;
	private String sendchk;
}
