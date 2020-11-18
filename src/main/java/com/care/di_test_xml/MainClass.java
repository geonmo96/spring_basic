package com.care.di_test_xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String config = "classpath:application_test.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		PrintBean pb = ctx.getBean("pb" , PrintBean.class);
		
		pb.print();
	}
}
