package com.care.redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/red")
public class RedirectController {
	
	@RequestMapping(value="ind")
	public String index() {
		return "red/index";
	}
	
	@RequestMapping(value="result")
	public String result(HttpServletRequest request) {
		String id = request.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:rsOk";
		}
		return "redirect:rsNo";
	}
/*
 * redirect: 라는 기능
 * */
	
	@RequestMapping(value="rsOk")
	public String resultOk() {
		return "red/rsOk";
	}
	
	@RequestMapping(value="rsNo")
	public String resultNo() {
		return "red/rsNo";
	}
}
