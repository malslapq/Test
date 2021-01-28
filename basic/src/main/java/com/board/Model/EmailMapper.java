package com.board.Model;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMapper {
	public int insert(EmailDTO edto);
}
