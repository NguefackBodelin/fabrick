package com.fabrick.bank.dto.vatidator;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fabrick.bank.dto.bonifico.BonificoRequestTest;

import io.github.jakaarl.iban.IbanValidator;

public class CustomValidator implements Validator{
	private static final Logger logger = LogManager.getLogger(CustomValidator.class);
	
	public boolean supports(Class clazz) {
        return BonificoRequestTest.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
    	logger.info("START - validator Bonifico request");
        BonificoRequestTest bonificoRequest = (BonificoRequestTest) target;
        boolean isValidIban = false;
		boolean isSepa =false;
        IbanValidator val = new IbanValidator();
		if(bonificoRequest!=null) {
			if(bonificoRequest.getCreditor()== null) {
				logger.error(" validateRequest - missing informations about  credidore");
				 errors.reject("validation","the informations about  credidore is required ");
			}else {	
				if(StringUtils.isEmpty(bonificoRequest.getCreditor().getName()) || StringUtils.isEmpty(bonificoRequest.getCreditor().getAccount())) {
					logger.error(" validateRequest - missing informations about credidore name and credidore account");
					 errors.reject("validation","the informations about credidore name and account are required ");
				}else {
					if(StringUtils.isEmpty(bonificoRequest.getCreditor().getAccount().getAccountCode())) {
						logger.error(" validateRequest - missing informations about credidore account code");
						 errors.reject("validation","the informations about credidore account code is required");
					}else {
						String inputIban = bonificoRequest.getCreditor().getAccount().getAccountCode();
						isValidIban = val.validate(inputIban);
						if(!isValidIban && StringUtils.isEmpty(bonificoRequest.getCreditor().getAccount().getBicCode())) {
							logger.error(" validateRequest - BicCode is required  when AccountCode is not an IBAN");
							 errors.reject("validation"," BicCode is required  when AccountCode is not an IBAN");
						}else {
							if(!isSepa && bonificoRequest.getCreditor().getAddress()==null) {
								logger.error(" validateRequest - address info. Required if the creditor account is rooted on a non-SEPA bank");
								 errors.reject("validation","address info. Required if the creditor account is rooted on a non-SEPA bank");
							}
						}
					}
				}
			}
			if(!bonificoRequest.isInstant() && StringUtils.isEmpty(bonificoRequest.getExecutionDate())) {
				logger.error(" validateRequest - The date on which the money transfer must be executed. This field is required unless 'isInstant == true'");
				 errors.reject("validation","The date on which the money transfer must be executed. This field is required unless 'isInstant == true'");
			}
			if(StringUtils.isEmpty(bonificoRequest.getDescription())|| StringUtils.isEmpty(bonificoRequest.getAmount())|| StringUtils.isEmpty(bonificoRequest.getCurrency())) {
				logger.error(" validateRequest - missing information about one of this field: Description, Amount and Currency");
				 errors.reject("validation","missing information about one of this field: Description, Amount and Currency ");
			}

			if(!bonificoRequest.getFeeType().equals("SHA") && isSepa) {
				logger.error(" validateRequest - "+ bonificoRequest.getFeeType()+" valid only if the creditor account is rooted on a non-SEPA bank");
				errors.reject("validation","valid only if the creditor account is rooted on a non-SEPA bank");
			}

			if(bonificoRequest.getTaxRelief()==null) {
				logger.error(" validateRequest - missing TaxRelief Node");
				errors.reject("validation","missing TaxRelief Node"); 
			}else {

				if(StringUtils.isEmpty(bonificoRequest.getTaxRelief().getIsCondoUpgrade()) || 
						StringUtils.isEmpty(bonificoRequest.getTaxRelief().getCreditorFiscalCode())||
						StringUtils.isEmpty(bonificoRequest.getTaxRelief().getBeneficiaryType())){
					logger.error(" validateRequest - missing information about one of this TaxRelief Node field: BeneficiaryType, CreditorFiscalCode ");
					errors.reject("validation","missing information about one of this TaxRelief Node field : BeneficiaryType, CreditorFiscalCode"); 
				}else {
					String taxReliefId = bonificoRequest.getTaxRelief().getTaxReliefId();
					List<String> taxReliefIds= Arrays.asList("119R","L027", "DL50", "L090", "L296", "L449");
					if(!taxReliefIds.contains(taxReliefId)) {
						logger.error(" validateRequest - The ID of the tax relief is not exist");
						errors.reject("validation","The ID of the tax relief is not exist"); 
					}
					String beneficiaryType = bonificoRequest.getTaxRelief().getBeneficiaryType();
					if(!beneficiaryType.equals("NATURAL_PERSON") && !beneficiaryType.equals("LEGAL_PERSON")) {
						logger.error(" validateRequest - beneficiaryType that you insert is not exist ");
						errors.reject("validation","beneficiaryType that you insert is not exist"); 
					}
					if(bonificoRequest.getTaxRelief().getBeneficiaryType().equals("NATURAL_PERSON") && bonificoRequest.getTaxRelief().getNaturalPersonBeneficiary()==null) {
						logger.error(" validateRequest - NaturalPersonBeneficiary Node required for BeneficiaryType=NATURAL_PERSON");
						errors.reject("validation","NaturalPersonBeneficiary Node required for BeneficiaryType=NATURAL_PERSON"); 
					}else if(bonificoRequest.getTaxRelief().getBeneficiaryType().equals("NATURAL_PERSON") && StringUtils.isEmpty(bonificoRequest.getTaxRelief().getNaturalPersonBeneficiary().getFiscalCode1())){
						logger.error(" validateRequest - fiscalCode1 required for BeneficiaryType=NATURAL_PERSON");
						errors.reject("validation","fiscalCode1 required for BeneficiaryType=NATURAL_PERSON");
					}

					if(bonificoRequest.getTaxRelief().getBeneficiaryType().equals("LEGAL_PERSON") && bonificoRequest.getTaxRelief().getLegalPersonBeneficiary()==null) {
						logger.error(" validateRequest - LegalPersonBeneficiary Node required for BeneficiaryType=LEGAL_PERSON");
						errors.reject("validation","LegalPersonBeneficiary Node required for BeneficiaryType=LEGAL_PERSON"); 
					}else if(bonificoRequest.getTaxRelief().getBeneficiaryType().equals("LEGAL_PERSON") && (StringUtils.isEmpty(bonificoRequest.getTaxRelief().getLegalPersonBeneficiary().getFiscalCode()) ||
							StringUtils.isEmpty(bonificoRequest.getTaxRelief().getLegalPersonBeneficiary().getLegalRepresentativeFiscalCode()))){
						logger.error(" validateRequest - missing information about one of this field: LegalRepresentativeFiscalCode, FiscalCode for BeneficiaryType=LEGAL_PERSON");
						errors.reject("validation","missing information about one of this field: LegalRepresentativeFiscalCode, FiscalCode for BeneficiaryType=LEGAL_PERSON"); 
					}
				}				
			}
		}
		logger.info("END - validator Bonifico request");
    }

}
