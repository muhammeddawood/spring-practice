package com.concept.threadlocal;

public class MyThreadLocal {
	private static final ThreadLocal<Context> threadLocal = new ThreadLocal<>();

	public static void set(Context context) {
		threadLocal.set(context);
	}
	
	public static void unset() {
		threadLocal.remove();
	}
	
	public static Context get() {
		return threadLocal.get();
	}
}
