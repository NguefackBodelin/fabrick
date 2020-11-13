package com.fabrick.bank.dto.common;

import java.io.Serializable;

public class TaxRelief implements Serializable{

	private static final long serialVersionUID = 1L;
	private String taxReliefId;
	

	private boolean isCondoUpgrade;
	
	
	private String creditorFiscalCode;
	
	
	private String beneficiaryType;
	
	private NaturalPersonBeneficiary naturalPersonBeneficiary;
	
	private LegalPersonBeneficiary legalPersonBeneficiary;


	// Getter Methods 

	public String getTaxReliefId() {
		return taxReliefId;
	}

	public boolean getIsCondoUpgrade() {
		return isCondoUpgrade;
	}

	public String getCreditorFiscalCode() {
		return creditorFiscalCode;
	}

	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	public NaturalPersonBeneficiary getNaturalPersonBeneficiary() {
		return naturalPersonBeneficiary;
	}

	public LegalPersonBeneficiary getLegalPersonBeneficiary() {
		return legalPersonBeneficiary;
	}

	// Setter Methods 

	public void setTaxReliefId(String taxReliefId) {
		this.taxReliefId = taxReliefId;
	}

	public void setIsCondoUpgrade(boolean isCondoUpgrade) {
		this.isCondoUpgrade = isCondoUpgrade;
	}

	public void setCreditorFiscalCode(String creditorFiscalCode) {
		this.creditorFiscalCode = creditorFiscalCode;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public void setNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
		if(this.getBeneficiaryType().equalsIgnoreCase("NATURAL_PERSON")) {
			this.naturalPersonBeneficiary = naturalPersonBeneficiary; 
		}
		
	}

	public void setLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
		if(this.getBeneficiaryType().equalsIgnoreCase("LEGAL_PERSON")) {
			this.legalPersonBeneficiary = legalPersonBeneficiary; 
		}
	}
}