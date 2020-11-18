package com.care.di_ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	@RequestMapping("index")
	public String index() {
		return "member/index";
	}
}
