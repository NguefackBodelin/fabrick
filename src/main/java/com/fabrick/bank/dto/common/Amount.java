package com.fabrick.bank.dto.common;

public class Amount {
	private float debtorAmount;
	 private String debtorCurrency;
	 private float creditorAmount;
	 private String creditorCurrency;
	 private String creditorCurrencyDate;
	 private float exchangeRate;


	 // Getter Methods 

	 public float getDebtorAmount() {
	  return debtorAmount;
	 }

	 public String getDebtorCurrency() {
	  return debtorCurrency;
	 }

	 public float getCreditorAmount() {
	  return creditorAmount;
	 }

	 public String getCreditorCurrency() {
	  return creditorCurrency;
	 }

	 public String getCreditorCurrencyDate() {
	  return creditorCurrencyDate;
	 }

	 public float getExchangeRate() {
	  return exchangeRate;
	 }

	 // Setter Methods 

	 public void setDebtorAmount(float debtorAmount) {
	  this.debtorAmount = debtorAmount;
	 }

	 public void setDebtorCurrency(String debtorCurrency) {
	  this.debtorCurrency = debtorCurrency;
	 }

	 public void setCreditorAmount(float creditorAmount) {
	  this.creditorAmount = creditorAmount;
	 }

	 public void setCreditorCurrency(String creditorCurrency) {
	  this.creditorCurrency = creditorCurrency;
	 }

	 public void setCreditorCurrencyDate(String creditorCurrencyDate) {
	  this.creditorCurrencyDate = creditorCurrencyDate;
	 }

	 public void setExchangeRate(float exchangeRate) {
	  this.exchangeRate = exchangeRate;
	 }
}
