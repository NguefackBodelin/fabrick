package com.fabrick.bank.dto.balance;

import java.util.List;

public class ResponseBalance {

	private String status;
	private List<String> errors;
	private SaldoAccount payload;
	
	public ResponseBalance() {
		super();
	}
	public ResponseBalance(String status, List<String> errors, SaldoAccount payload) {
		super();
		this.status = status;
		this.errors = errors;
		this.payload = payload;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public SaldoAccount getPayload() {
		return payload;
	}
	public void setPayload(SaldoAccount payload) {
		this.payload = payload;
	}
}
