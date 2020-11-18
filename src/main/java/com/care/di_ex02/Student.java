package com.care.di_ex02;

import org.springframework.context.annotation.Bean;

public class Student {
	
	public void namePrint(String name) {
		System.out.println("당신의 이름 : " + name);
	}
	public void agePrint(int age) {
		System.out.println("당신의 나이 : " + age);
	}
}
