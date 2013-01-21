package com.dp.strategy;

public class Algo {
	private Strategy strategy;

	public Algo(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public int executeStrategy(int a, int b) {
		return strategy.execute(a, b);
	}
	
}
