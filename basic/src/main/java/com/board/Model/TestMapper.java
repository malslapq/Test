package com.board.Model;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
	int insertUser(TestDTO dto);
}
