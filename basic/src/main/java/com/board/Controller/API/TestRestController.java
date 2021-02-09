package com.board.Controller.API;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.JPA.User;
import com.board.Model.MailSenderDTO;
import com.board.Model.UserDTO;
import com.board.RestService.KakaoService;
import com.board.RestService.TestService;
import com.board.Service.MailService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class TestRestController {
		
	@Autowired
	private KakaoService kakao;
	@Autowired
	private MailService mservice;
	@Autowired
	private TestService service;

	@PostMapping("/admin/api/idcheck")
	public Boolean idcheck(@RequestBody UserDTO dto) {
		return service.idcheck(dto.getId());
	}

	@PostMapping("/admin/api/mailsend")
	public void mailtest(@RequestBody MailSenderDTO dto) throws MessagingException, IOException {
		mservice.sendMail(dto);
	}

	@GetMapping("/kakaoapi")
	public Map<String, String> KakaoUserInfo(@RequestParam("code") String code) {
		String token = kakao.getKakaoToken(code);
		JsonNode userinfo = kakao.getKakaoUserInfo(token);
		Map<String, String> map = kakao.UserInfoPaser(userinfo);
		return map;
	}

	@GetMapping("/admin/api/selectAll")
	public List<UserDTO> selectAll() {
		return service.selectAll();
	}

	@GetMapping("/admin/api/selectAllmap")
	public List<Map<String, Object>> selectAllmap() {
		return service.selectAllmap();
	}

	@GetMapping("/admin/api/excelDown")
	public void excelDownload(HttpServletRequest request, HttpServletResponse response) {
		service.ExcelDown(response);
	}

	@GetMapping("/admin/api/sxssf")
	public void sxssf(HttpServletResponse response) {
		service.SXSSFtset(response);
	}
	
	@PostMapping("/users")
	public String save(User user) {
		service.save(user);
		return "가입성공";
	}
	
	@RequestMapping(value = "/users/{num}", method = RequestMethod.PATCH)
	public void updateuser(@PathVariable("num")Long num, User user) {
		
	}
		
}
