package com.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.Model.UserMapper;

@SpringBootTest
class BasicApplicationTests {
	
	@Autowired
	private UserMapper mapper;
	
	@Test
	void contextLoads() {
		System.out.println(mapper.selectAll());
	}

}
