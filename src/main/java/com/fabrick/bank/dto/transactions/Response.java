package com.fabrick.bank.dto.transactions;

import java.util.List;

public class Response {
	private String status;
	private List<String> errors;
	private ResponseTransactions payload;
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
	public ResponseTransactions getPayload() {
		return payload;
	}
	public void setPayload(ResponseTransactions payload) {
		this.payload = payload;
	}
}

