package com.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.dto.Cat;

public class MainClass {

	public static void main(String[] args) {
		
		//java에서 xml 실행시
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("bean.xml");
		
		//xml에서 생성된 Object룰 읽어온다
		Cat myCat = ctx.getBean("myCat", Cat.class);
		
		myCat.info();
		myCat.setAge(3);
	}
}
