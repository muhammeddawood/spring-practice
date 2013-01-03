package com.sp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	//@Before("execution(public void draw())")
	// also can execute to a specific class com.sp.model.Triangle.draw()
	// wildcards public * get*(*)
	@Before("allDraw()")
	public void printAspect() {
		System.out.println(" before method");
	}
	
	@Pointcut("execution(public * draw())")
	public void allDraw() {
		
	}
	
	

}
