package com.care.di_ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// xml파일로 di
		
		// xml에서 설정한 값 주석
		
//		STBean stBean = new STBean();
//		Student st = new Student();
		String config = "classpath:applicationST.xml";
		// classpath : > src/test/resources까지의 경로를 의미함
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		// ctx는 xml파일이라고 생각하면 됨
		STBean stBean = ctx.getBean("stb", STBean.class);
		// 가져오는 값은 xml에서 설정한 id
		// 가져오는 클래스 타입
		
		
		String name = "홍길동";
		int age = 20;
		stBean.setName(name);
		stBean.setAge(age);
//		stBean.setSt(st);
		stBean.print();
	}
}
