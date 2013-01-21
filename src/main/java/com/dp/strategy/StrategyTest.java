package com.dp.strategy;

public class StrategyTest {

	// strategy pattern is designed to encapsulate an algorithm and whereby implementation of an 
	//algorithm to be selected is decided at runtime
	public static void main(String[] args) {
		Algo add = new Algo(new Add());
		System.out.println(add.executeStrategy(10, 10));
		
		Algo s = new Algo(new Subtract());
		System.out.println(s.executeStrategy(10, 10));
		
		Algo m = new Algo(new Multiply());
		System.out.println(m.executeStrategy(10, 10));
	}
}
