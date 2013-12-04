package com.javaseven;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class MethodHandleTest {

	public static void makeMh() {
		MethodHandleTest mh1 = new MethodHandleTest();
		
		MethodType methodType = MethodType.methodType(void.class, int.class, int.class);
		
		try {
			MethodHandle mh = MethodHandles.lookup().findVirtual(MethodHandleTest.class, "add", methodType);
			mh.invoke(mh1, 1, 2);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void makeReflection() {
		MethodHandleTest mh1 = new MethodHandleTest();
		
		try {
			Method rfl = MethodHandleTest.class.getDeclaredMethod("add", int.class, int.class);
			try {
				rfl.invoke(mh1, 1, 2);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
	}
	
	private void add(int i, int j) {
		System.out.println((i + j));
	}
	
	

}
