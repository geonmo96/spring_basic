package com.care.di_ex03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController02 {

	@RequestMapping(value="/member02/index")
	public String memberIndex(Model model) {
		return "/member02/index";
		// 404 error라 뜸
		// default package인 ex01이 아니여서 그럼
		/*
		 * 순서는
		 * 1.web.xml의 <servlet-mapping> -> <appServlet>의 param >
		 * 2. servlet-context의 마지막부분의  <context:component-scan>테그를 읽는다
		 * 	위에서 base-package에 현재 이 패키지가 없다면 실행되지 않는다
		 * base-package만 체크하기 때문에
		 * 
		 * 컨트롤러의 이름이 같으면 에러가 발생함
		 * */
	}
	
	@RequestMapping("member02/result")
	public String memberResult(HttpServletRequest request, Model model) {
		model.addAttribute("name", request.getParameter("name"));
		model.addAttribute("age", request.getParameter("age"));
		return "/member02/result";
	}
}
