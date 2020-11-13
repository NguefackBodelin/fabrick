package com.fabrick.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fabrick.bank.dto.balance.Balance;
import com.fabrick.bank.dto.balance.PayloadBalance;
import com.fabrick.bank.dto.balance.ResponseBalance;
import com.fabrick.bank.dto.bonifico.BonificoRequestTest;
import com.fabrick.bank.dto.bonifico.BonificoResponse;
import com.fabrick.bank.dto.transactions.Response;
import com.fabrick.bank.dto.transactions.TransactionRequest;
import com.fabrick.bank.dto.vatidator.CustomValidator;
import com.fabrick.bank.exception.ErrorHandle;
import com.fabrick.bank.exception.ResponseBodyError;
import com.google.gson.Gson;

@Service
public class ApiServiceImpl implements ApiService{
	private static final Logger logger = LogManager.getLogger(ApiServiceImpl.class);
	private RestTemplate restTemplate = new RestTemplate();
	private HttpHeaders headers;
	private  static final String URL__PREFIX="https://sandbox.platfr.io/";


	@Override
	public Balance getSaldo(Long accountId) {
		logger.info("START - getSaldo method");
		setHeader();
		String uri =URL__PREFIX+"api/gbs/banking/v4.0/accounts/"+accountId+"/balance";
		HttpEntity<String> entity = new HttpEntity<>("paramters",headers);
		try {
			logger.info("START - rest service call");
			ResponseEntity<ResponseBalance> res = restTemplate.exchange(uri, HttpMethod.GET,entity,ResponseBalance.class);
			logger.info("END - call Sandbox service");
			Balance balanceResponse = new Balance(res.getBody().getStatus(),res.getBody().getErrors(),new PayloadBalance(res.getBody().getPayload().getBalance()));
			logger.info("END - call Sandbox service");
			return balanceResponse;
		}catch (HttpClientErrorException ex) {
			logger.error("SANDBOX - Service Sandbox fail call");
			JSONObject objorig = new JSONObject(ex.getResponseBodyAsString());
			String status = objorig.getString("status");
			JSONArray arr=(JSONArray)objorig.get("errors");
			String errjson =  arr.get(0).toString();
			Gson gson = new Gson();
			ErrorHandle errorHandle =  gson.fromJson(errjson, ErrorHandle.class);			
			List<String> messages = new ArrayList<>();
			messages.add( "Code : "+errorHandle.getCode());
			messages.add( "Description : "+errorHandle.getDescription());
			messages.add( "Params : "+errorHandle.getParams());
			throw new ResponseBodyError("bad response from service Sandbox",status, messages);
		}

	}

	private void setHeader() {
		logger.info("START - set Header");
		headers = new HttpHeaders();
		headers.set("Auth-Schema","S2S");
		headers.set("Api-Key","FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
		logger.info("END - set Header");
	}

	@Override
	public ResponseEntity<Response> listaTransazioni(TransactionRequest transactionRequest) {
		logger.info("START - getTransactions method");
		setHeader();
		headers.setContentType(new MediaType("application","json"));
		String uri =URL__PREFIX+"api/gbs/banking/v4.0/accounts/"+transactionRequest.getAccountId()+"/transactions?fromAccountingDate="+transactionRequest.getFromAccountingDate()+"&toAccountingDate="+transactionRequest.getToAccountingDate();
		HttpEntity<String> entity = new HttpEntity<>("paramters",headers);
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		try {
			logger.info("START - call Sandbox service");
			ResponseEntity<Response>  res =  restTemplate.exchange(uri, HttpMethod.GET,entity,Response.class);
			logger.info("END - call Sandbox service");
			logger.info("END - getTransactions method");
			return res;
		}catch (HttpClientErrorException ex) {
			logger.error("SANDBOX - Service Sandbox fail call");
			JSONObject objorig = new JSONObject(ex.getResponseBodyAsString());
			String status = objorig.getString("status");
			JSONArray arr=(JSONArray)objorig.get("errors");
			String errjson =  arr.get(0).toString();
			Gson gson = new Gson();
			ErrorHandle errorHandle =  gson.fromJson(errjson, ErrorHandle.class);
			List<String> messages = new ArrayList<>();
			messages.add( "Code : "+errorHandle.getCode());
			messages.add( "Description : "+errorHandle.getDescription());
			messages.add( "Params : "+errorHandle.getParams());
			throw new ResponseBodyError("bad response from service Sandbox",status, messages);
		}
	}


	@Override
	public BonificoResponse Bonifico(BonificoRequestTest bonificoRequestTest, Long accountId,Errors error) {
		logger.info("START - Bonifico method");
		CustomValidator validateur = new CustomValidator();
		validateur.validate(bonificoRequestTest, error);
		List<ObjectError> errors = error.getAllErrors();
		List<String> message = new ArrayList<>();
		if(error.hasErrors()) {
			for(ObjectError f : errors) {
				message.add(f.getDefaultMessage());
			}
			throw new ResponseBodyError("validation - error ",HttpStatus.BAD_REQUEST.toString(), message);
		}
		setHeader();
		headers.setContentType(new MediaType("application","json"));
		headers.set("X-Time-Zone","Europe/Rome");
		HttpEntity<BonificoRequestTest> requestEntity = new HttpEntity<BonificoRequestTest>(bonificoRequestTest, headers);
		String uri =URL__PREFIX+"api/gbs/banking/v4.0/accounts/14537780/payments/money-transfers";
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		logger.info("START - rest service call");
		try {
			ResponseEntity<BonificoResponse> res =restTemplate.postForEntity(uri, requestEntity, BonificoResponse.class);
			logger.info("END - call Sandbox service");
			logger.info("END  - Bonifico method");
			return res.getBody();
		}catch (HttpClientErrorException ex) {
			logger.error("SANDBOX - Service Sandbox fail call");
			JSONObject objorig = new JSONObject(ex.getResponseBodyAsString());
			String status = objorig.getString("status");
			JSONArray arr=(JSONArray)objorig.get("errors");
			String errjson =  arr.get(0).toString();
			Gson gson = new Gson();
			ErrorHandle errorHandle =  gson.fromJson(errjson, ErrorHandle.class);	
			List<String> messages = new ArrayList<>();
			messages.add( "Code : "+errorHandle.getCode());
			messages.add( "Description : "+errorHandle.getDescription());
			messages.add( "Params : "+errorHandle.getParams());
			throw new ResponseBodyError("bad response from service Sandbox",status, messages);
		}

	}
}
