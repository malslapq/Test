package com.board.Model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

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
@Alias("UserDTO")
public class UserDTO {
	private int num;
	private String id;
	private String passwd;
	private String name;
	private String phone;
	private String auth;
	private Date regdate;
}
