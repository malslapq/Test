package com.board.RestService;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.board.Model.TestDTO;
import com.board.Model.UserDTO;


public interface TestService {
	public void ExcelDown(HttpServletResponse response);
	public void SXSSFtset(HttpServletResponse response);
	public int insertUser(TestDTO dto);
	public List<UserDTO> selectAll();
	public List<Map<String, Object>> selectAllmap();
	public List<Map<String, Object>> selectColumn();
	public String[] SetHeadColumn(List<Map<String, Object>> columnMaplist);
}
