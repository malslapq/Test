package com.board.Model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	public List<UserDTO> selectAll();
	public List<Map<String, Object>> selectAllmap();
	public List<Map<String, Object>> selectColumn();
}
