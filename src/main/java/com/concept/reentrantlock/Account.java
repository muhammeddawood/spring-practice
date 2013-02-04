package com.concept.reentrantlock;

public class Account {
	private int balance = 1000;
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public static void transfer(Account a1, Account a2, int amount) {
		a1.withdraw(amount);
		a2.deposit(amount);
		
	}
}
