package com.care.di_ex03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.member.MemberDTO;

@Controller
@RequestMapping("/member02")
public class MyController02 {
/*
 * @RequestMapping("directory")를 최상단에 설정하면
 * 하위의 모든 매핑에 directory가 생략되는 것과 같다
 * 즉 실제 하위에 설정된 mapping값은 /member02/index와 같음 (전부다)
 * */

	@RequestMapping(value="index")
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
	
	// form의 method가 get이던 post이던 같이 동작함
	// 만약에 따로 동작을 원하면 다음과 같이 method를 설정하면 됨
	// 다른 방식으로 전송한다면 405에러(허용되지 않는 메서드)가 실행됨
	// RequestMethod는 직접 입력해야함? - 아마
	@RequestMapping(value="result", method=RequestMethod.GET)
	public String memberResult(HttpServletRequest request, Model model) {
		
		model.addAttribute("name", request.getParameter("name"));
		model.addAttribute("age", request.getParameter("age"));
		return "/member02/result";
	}
/*
 * PostMapping, GetMapping 사용하는 방법
 * pom.xml을 수정함
 * 10 <properties>의 <org.springframework-version>5.0.2.RELEASE로 설정
 * 136 <plugin>의 version을 3.7.0으로, 그 하위의 source와 target의 버전을 1.8로
 * 
 * annotation으로 값을 받아올 수 있음
 * public String memberRe02(@RequestParam("name") String n, @RequestParam("age") String a, Model model) {
 * */
	
	@PostMapping("result")
	public String memberRe02(@RequestParam("name") String n, @RequestParam("age") String a, Model model) {
		model.addAttribute("name", n);
		model.addAttribute("age", a);
		return "member02/result";
	}
/*
 * 매개변수에 클래스
 * 모델 데이터는 dispatcher를 통해 뷰로 다 알아서 전달이 된다.
 * 1. 객체 생성해서 저장하고
 * 2. 같은 이름으로 전달된 파라미터의 값을 setter로 저장한다
 * 3. model 데이터에 추가한다. ==> 뷰로 넘어가며 데이터도 같이 넘어간다
 * 명시하지 않으면 첫글자가 소문자인 newArticleCommand로 getter를 통해 꺼낼 수 있다
 * 		(${newArticleCommand.xxxx})
 * 그 이름을 지정해주고 싶다면, @modelAttribute("command")를 사용해 key로 쓸 이름을 지정할 수 있다
 * 
 * 간단하게 정리하면
 * 1. 폼에서 보내지는 action값과 mapping값이 같아야 한다
 * 2. 매개변수에 있는 dto(class)가 가지는 변수명과 폼에서 보내지는 name이 같아야한다
 * 그렇다면 따로 객체를 생성할 필요 없이 변수의 데이터가 주입된다
 * */
	@RequestMapping(value="result01")
	public String result01(MemberDTO dto, Model model) {
		model.addAttribute("mem", dto);
		return "member02/result02";
	}
}
