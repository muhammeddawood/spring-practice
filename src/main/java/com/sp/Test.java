package com.sp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sp.model.Circle;
import com.sp.model.Triangle;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Triangle bean = (Triangle)context.getBean("triangle");
		Circle circle = (Circle)context.getBean("circle");
		
		bean.draw();
		circle.draw();

	}

}
