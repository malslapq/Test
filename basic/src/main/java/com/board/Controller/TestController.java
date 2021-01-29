package com.board.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class TestController {
	
	@RequestMapping("/index")
	public void index() {
	}
	
	@RequestMapping("/mailtest")
	public void mailtest() {
	}
	
	@RequestMapping("/kakaojs")
	public void kakaologin(Model model) {
		model.addAttribute("name","얍얍");
	}
	
	@RequestMapping("/kakaoapi")
	public String kakaoapi() {
		return "kakaoapi";
	}
	
	@RequestMapping(value = "/excelDown", method = RequestMethod.GET)
	public String excelDown() {
		return "index";
	}
}
