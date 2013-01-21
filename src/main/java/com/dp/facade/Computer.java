package com.dp.facade;

public class Computer {
	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;
	
	public Computer() {
		cpu = new CPU();
		memory = new Memory();
		hardDrive = new HardDrive();
		
	}
	
	public void startComputer() {
		cpu.start();
		memory.load();
		hardDrive.read();
	}
}
