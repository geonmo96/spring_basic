package com.care.di_ex01;

public class STBean {
	/*
	 * 이 클레스 입장에서는 print()를 하기 위해서는 st가 필요함
	 * 	> stBean은 st에 의존하고 있음
	 * 
	 * main에서 st를 생성해 setSt로 주입했음
	 * STBean은 new연산자를 사용한게 아니라 외부에서 주입된 개념임
	 * */
	private String name;
	private int age;
	private Student st;
	
	public void print() {
		st.namePrint(name);
		st.agePrint(age);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student getSt() {
		return st;
	}
	public void setSt(Student st) {
		this.st = st;
	}
	
	
}
