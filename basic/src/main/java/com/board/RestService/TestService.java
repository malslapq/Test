package com.board.RestService;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.board.JPA.User;
import com.board.Model.UserDTO;


public interface TestService {
	public UserDTO selectOne(String id);
	public void ExcelDown(HttpServletResponse response);
	public void SXSSFtset(HttpServletResponse response);
	public List<UserDTO> selectAll();
	public List<Map<String, Object>> selectAllmap();
	public List<Map<String, Object>> selectColumn();
	public String[] SetHeadColumn(List<Map<String, Object>> columnMaplist);
	public Boolean idcheck(String id);
	public void save(User uentity);
}
