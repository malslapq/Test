package com.board.RestService;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

public interface KakaoService {
	public String getKakaoToken(String code);
	public JsonNode getKakaoUserInfo(String token);
	public Map<String, String> UserInfoPaser(JsonNode userinfo);
}
