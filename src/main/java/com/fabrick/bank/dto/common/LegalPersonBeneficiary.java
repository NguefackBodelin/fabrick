package com.fabrick.bank.dto.common;

import java.io.Serializable;

public class LegalPersonBeneficiary implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private String fiscalCode;
	
	
	private String legalRepresentativeFiscalCode;


	// Getter Methods 

	public String getFiscalCode() {
		return fiscalCode;
	}

	public String getLegalRepresentativeFiscalCode() {
		return legalRepresentativeFiscalCode;
	}

	// Setter Methods 

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public void setLegalRepresentativeFiscalCode(String legalRepresentativeFiscalCode) {
		this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
	}
}
