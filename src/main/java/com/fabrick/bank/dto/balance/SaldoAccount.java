package com.fabrick.bank.dto.balance;

import java.io.Serializable;


public class SaldoAccount implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String date;
	private double balance;
	private double availableBalance;
	private String currency;

	public SaldoAccount() {
		super();
	}
	public SaldoAccount(String date, double balance, double availableBalance, String currency) {
		super();
		this.date = date;
		this.balance = balance;
		this.availableBalance = availableBalance;
		this.currency = currency;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
