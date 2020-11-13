package com.fabrick.bank.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import com.fabrick.bank.dto.balance.Balance;
import com.fabrick.bank.dto.bonifico.BonificoRequestTest;
import com.fabrick.bank.dto.bonifico.BonificoResponse;
import com.fabrick.bank.dto.transactions.Response;
import com.fabrick.bank.dto.transactions.TransactionRequest;

public interface ApiService {

	public Balance getSaldo(Long accountId); 
	
	public ResponseEntity<Response> listaTransazioni(TransactionRequest transactionRequest);
	
	public BonificoResponse Bonifico(BonificoRequestTest bonificoRequestTest,Long accountId,Errors error);
}
