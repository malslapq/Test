package com.board.DAO;

import java.util.List;
import java.util.Map;

import com.board.Model.TestDTO;
import com.board.Model.UserDTO;

public interface TestDAO {
	public int insertUser(TestDTO dto);
	public List<UserDTO> selectAll();
	public List<Map<String, Object>> selectAllmap();
	public List<Map<String, Object>> selectColumn();
}
