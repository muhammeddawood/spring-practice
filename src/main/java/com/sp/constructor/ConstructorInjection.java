package com.sp.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjection {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sp/constructor/beans.xml");
		
		Sequence sequence = (Sequence)context.getBean("sequence");
		
		System.out.println(sequence);
	}

}
