package com.fabrick.bank.dto.common;

import java.io.Serializable;

public class Creditor implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private Account account;
	private Address address;
	
	public Creditor(String name, Account account, Address address) {
		super();
		this.name = name;
		this.account = account;
		this.address = address;
	}
	public Creditor() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
