package com.fabrick.bank.dto.common;

public class Fee {
	private String feeCode;
	private String description;
	private float amount;
	private String currency;


	// Getter Methods 

	public String getFeeCode() {
		return feeCode;
	}

	public String getDescription() {
		return description;
	}

	public float getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	// Setter Methods 

	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
