package com.board.Controller.API;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.Model.MailSenderDTO;
import com.board.Model.UserDTO;
import com.board.RestService.KakaoService;
import com.board.RestService.TestService;
import com.board.Service.MailService;
import com.fasterxml.jackson.databind.JsonNode;

@RequestMapping("/api")
@RestController
public class TestRestController {
		
	@Autowired
	private KakaoService kakao;
	@Autowired
	private MailService mservice;
	@Autowired
	private TestService service;

	@PutMapping("/insert")
	public void test(@RequestBody UserDTO dto) {
		service.insertUser(dto);
	}

	@PostMapping("/admin/mailsend")
	public void mailtest(@RequestBody MailSenderDTO dto) throws MessagingException, IOException {
		mservice.sendMail(dto);
	}

	@GetMapping("/admin/kakaoapi")
	public Map<String, String> KakaoUserInfo(@RequestParam("code") String code) {
		String token = kakao.getKakaoToken(code);
		JsonNode userinfo = kakao.getKakaoUserInfo(token);
		Map<String, String> map = kakao.UserInfoPaser(userinfo);
		return map;
	}

	@GetMapping("/admin/selectAll")
	public List<UserDTO> selectAll() {
		return service.selectAll();
	}

	@GetMapping("/selectAllmap")
	public List<Map<String, Object>> selectAllmap() {
		return service.selectAllmap();
	}

	@GetMapping("/admin/excelDown")
	public void excelDownload(HttpServletRequest request, HttpServletResponse response) {
		service.ExcelDown(response);
	}

	@GetMapping("/admin/sxssf")
	public void sxssf(HttpServletResponse response) {
		service.SXSSFtset(response);
	}
	
}
