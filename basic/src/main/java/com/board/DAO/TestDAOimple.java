package com.board.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.board.Model.TestDTO;
import com.board.Model.TestMapper;
import com.board.Model.UserDTO;
import com.board.Model.UserMapper;

@Repository
public class TestDAOimple implements TestDAO{

	@Autowired
	private TestMapper tmapper;
	@Autowired
	private UserMapper umapper;
	
	@Override
	public int insert(UserDTO dto) {
		return umapper.insert(dto);
	}

	
	@Override
	public List<UserDTO> selectAll() {
		return umapper.selectAll();
	}

	@Override
	public List<Map<String, Object>> selectAllmap() {
		return umapper.selectAllmap();
	}

	@Override
	public List<Map<String, Object>> selectColumn() {
		return umapper.selectColumn();
	}

	@Override
	public UserDTO selectOne(String id) {
		return umapper.selectOne(id);
	}

}
