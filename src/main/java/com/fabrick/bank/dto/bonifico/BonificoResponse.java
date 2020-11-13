package com.fabrick.bank.dto.bonifico;

import java.io.Serializable;
import java.util.ArrayList;

import com.fabrick.bank.dto.common.Amount;
import com.fabrick.bank.dto.common.Creditor;
import com.fabrick.bank.dto.common.Debtor;
import com.fabrick.bank.dto.common.Fee;
import com.fabrick.bank.dto.common.TaxRelief;
import com.fabrick.bank.exception.ApiRequestException;

public class BonificoResponse extends ApiRequestException implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String moneyTransferId;
	private String status;
	private String direction;
	private Creditor creditor;
	private Debtor Debtor;
	private String cro;
	private String uri;
	private String trn;
	private String description;
	private String createdDatetime;
	private String accountedDatetime;
	private String debtorValueDate;
	private String creditorValueDate;
	private Amount amount;
	private boolean isUrgent;
	private boolean isInstant;
	private String feeType;
	private String feeAccountId;
	private ArrayList<Fee> fees = new ArrayList<>();
	private TaxRelief taxRelief;
	
	public BonificoResponse(String message) {
		super(message);
	}
	
	public String getMoneyTransferId() {
		return moneyTransferId;
	}
	public void setMoneyTransferId(String moneyTransferId) {
		this.moneyTransferId = moneyTransferId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Creditor getCreditor() {
		return creditor;
	}
	public void setCreditor(Creditor creditor) {
		this.creditor = creditor;
	}
	public Debtor getDebtor() {
		return Debtor;
	}
	public void setDebtor(Debtor debtor) {
		Debtor = debtor;
	}
	public String getCro() {
		return cro;
	}
	public void setCro(String cro) {
		this.cro = cro;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getTrn() {
		return trn;
	}
	public void setTrn(String trn) {
		this.trn = trn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedDatetime() {
		return createdDatetime;
	}
	public void setCreatedDatetime(String createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	public String getAccountedDatetime() {
		return accountedDatetime;
	}
	public void setAccountedDatetime(String accountedDatetime) {
		this.accountedDatetime = accountedDatetime;
	}
	public String getDebtorValueDate() {
		return debtorValueDate;
	}
	public void setDebtorValueDate(String debtorValueDate) {
		this.debtorValueDate = debtorValueDate;
	}
	public String getCreditorValueDate() {
		return creditorValueDate;
	}
	public void setCreditorValueDate(String creditorValueDate) {
		this.creditorValueDate = creditorValueDate;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	public boolean isUrgent() {
		return isUrgent;
	}
	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}
	public boolean isInstant() {
		return isInstant;
	}
	public void setInstant(boolean isInstant) {
		this.isInstant = isInstant;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getFeeAccountId() {
		return feeAccountId;
	}
	public void setFeeAccountId(String feeAccountId) {
		this.feeAccountId = feeAccountId;
	}
	public ArrayList<Fee> getFees() {
		return fees;
	}
	public void setFees(ArrayList<Fee> fees) {
		this.fees = fees;
	}
	public TaxRelief getTaxRelief() {
		return taxRelief;
	}
	public void setTaxRelief(TaxRelief taxRelief) {
		this.taxRelief = taxRelief;
	}
}
