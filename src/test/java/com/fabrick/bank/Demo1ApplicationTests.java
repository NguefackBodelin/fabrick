package com.fabrick.bank;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fabrick.bank.dto.balance.BalanceRequest;
import com.fabrick.bank.dto.transactions.TransactionRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class Demo1ApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired 
	private ObjectMapper mapper;

	@Test
	void balanceLoads() throws Exception {
		BalanceRequest request = new BalanceRequest();
		request.setAccountId(Long.valueOf(14537780));
		 String json = mapper.writeValueAsString(request);
		 this.mockMvc.perform(post("/api/balance")
				   .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON))
			       .andExpect(status().isOk());
	}
	
	@Test
	void listTransactionLoads() throws Exception {
		TransactionRequest t = new TransactionRequest();
		t.setAccountId(Long.valueOf(14537780));
		t.setFromAccountingDate("2019-01-01");
		t.setToAccountingDate("2019-12-01");
		 String json = mapper.writeValueAsString(t);
		this.mockMvc.perform(post("/api/transactions")
				   .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON))
			       .andExpect(status().isOk());
	}
	
	@Test
	void bonificoLoads() throws Exception {
		 String json = "{\n" + 
		 		"  \"creditor\": {\n" + 
		 		"    \"name\": \"John Doe\",\n" + 
		 		"    \"account\": {\n" + 
		 		"      \"accountCode\": \"IT23A0336844430152923804660\",\n" + 
		 		"      \"bicCode\": \"SELBIT2BXXX\"\n" + 
		 		"    },\n" + 
		 		"    \"address\": {\n" + 
		 		"      \"address\": null,\n" + 
		 		"      \"city\": null,\n" + 
		 		"      \"countryCode\": null\n" + 
		 		"    }\n" + 
		 		"  },\n" + 
		 		"  \"executionDate\": \"2019-04-01\",\n" + 
		 		"  \"uri\": \"REMITTANCE_INFORMATION\",\n" + 
		 		"  \"description\": \"Payment invoice 75/2017\",\n" + 
		 		"  \"amount\": 800,\n" + 
		 		"  \"currency\": \"EUR\",\n" + 
		 		"  \"isUrgent\": false,\n" + 
		 		"  \"isInstant\": false,\n" + 
		 		"  \"feeType\": \"SHA\",\n" + 
		 		"  \"feeAccountId\": \"45685475\",\n" + 
		 		"  \"taxRelief\": {\n" + 
		 		"    \"taxReliefId\": \"L449\",\n" + 
		 		"    \"isCondoUpgrade\": false,\n" + 
		 		"    \"creditorFiscalCode\": \"56258745832\",\n" + 
		 		"    \"beneficiaryType\": \"NATURAL_PERSON\",\n" + 
		 		"    \"naturalPersonBeneficiary\": {\n" + 
		 		"      \"fiscalCode1\": \"MRLFNC81L04A859L\",\n" + 
		 		"      \"fiscalCode2\": null,\n" + 
		 		"      \"fiscalCode3\": null,\n" + 
		 		"      \"fiscalCode4\": null,\n" + 
		 		"      \"fiscalCode5\": null\n" + 
		 		"    },\n" + 
		 		"    \"legalPersonBeneficiary\": {\n" + 
		 		"      \"fiscalCode\": null,\n" + 
		 		"      \"legalRepresentativeFiscalCode\": null\n" + 
		 		"    }\n" + 
		 		"  }\n" + 
		 		"}";
		this.mockMvc.perform(post("/api/14537780/bonifico")
				   .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON))
			       .andExpect(status().is(400));
	}
}
