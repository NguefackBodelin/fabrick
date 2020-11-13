package com.fabrick.bank.dto.balance;

public class PayloadBalance {
	private double balance;

	public PayloadBalance(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
