package com.sp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sp.model.Shape;
import com.sp.model.Triangle;
import com.sp.model.User;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.registerShutdownHook();
		Triangle triangle = (Triangle)context.getBean("triangle");
		Shape circle = (Shape)context.getBean("circle");
		
		System.out.println("Greetings " + context.getMessage("greetings", new Object[]{}, null));
	
		triangle.draw();
		System.out.println(triangle.getPointA().getX() + " : point x  point y :" + triangle.getPointA().getY()); 
		circle.draw();

		// bean definition inheritance
		User user = (User)context.getBean("user");
		System.out.println(" -------------------------- ");
		System.out.println(" Bean defintion inheritance ");
		System.out.println(user.getUserName() + " " + user.getCreatedBy());
		context.close();
	}

}
