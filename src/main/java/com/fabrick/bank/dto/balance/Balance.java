package com.fabrick.bank.dto.balance;

import java.util.List;

public class Balance {
	private String status;
	private List<String> errors;
	private PayloadBalance payload;
	public Balance(String status, List<String> errors, PayloadBalance payload) {
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
	public PayloadBalance getPayload() {
		return payload;
	}
	public void setPayload(PayloadBalance payload) {
		this.payload = payload;
	}
		
}
