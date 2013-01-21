package com.dp.facade;

public class FacadeTest {

	/**
	 * provides a simplified interface for complex subsystem
	 * @param args
	 */
	public static void main(String[] args) {
		Computer facade = new Computer();
		facade.startComputer();
	}

}
