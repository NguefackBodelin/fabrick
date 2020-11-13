package com.fabrick.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrick.bank.dto.balance.Balance;
import com.fabrick.bank.dto.balance.BalanceRequest;
import com.fabrick.bank.dto.bonifico.BonificoRequestTest;
import com.fabrick.bank.dto.bonifico.BonificoResponse;
import com.fabrick.bank.dto.transactions.Response;
import com.fabrick.bank.dto.transactions.TransactionRequest;
import com.fabrick.bank.service.ApiService;

@RequestMapping("/api")
@RestController
public class ApiController {
	
	@Autowired
	private ApiService apiService;
	
	@PostMapping("/balance") //ok
	public Balance getSaldo(@RequestBody BalanceRequest request) {
		return apiService.getSaldo(Long.valueOf(request.getAccountId()));
	}
	
	@PostMapping("/transactions")//ok
	public ResponseEntity<Response> getTransactions(@RequestBody TransactionRequest transactionRequest) {
		return apiService.listaTransazioni(transactionRequest);
	}
	
	@PostMapping("/{accountId}/bonifico")//ko
	public BonificoResponse bonifico(@RequestBody BonificoRequestTest bonifico, @PathVariable String accountId, Errors error) {
		return apiService.Bonifico(bonifico,Long.valueOf(accountId),error);
	}
}
