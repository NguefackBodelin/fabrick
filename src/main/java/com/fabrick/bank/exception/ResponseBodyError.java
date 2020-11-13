package com.fabrick.bank.exception;
import java.util.List;

import org.springframework.validation.Errors;
public class ResponseBodyError extends ApiRequestException{
	private static final long serialVersionUID = 1L;
	private String statu;
	private ErrorHandle error;
	private String responseServiceHeader;
    private Errors validationError;
    private List<String> messages;
	
	
	public ResponseBodyError(String message, String statu, List<String> messages) {
		super(message);
		this.statu = statu;
		this.messages = messages;
	}


	public ResponseBodyError(String message, String statu, String responseServiceHeader, Errors validationError) {
		super(message);
		this.statu = statu;
		this.responseServiceHeader = responseServiceHeader;
		this.validationError = validationError;
	}


	public ResponseBodyError(String message, String status, ErrorHandle error, String responseServiceHeader) {
		super(message);
		this.statu = status;
		this.error = error;
		this.responseServiceHeader = responseServiceHeader;
	}


	public Errors getValidationError() {
		return validationError;
	}


	public void setValidationError(Errors validationError) {
		this.validationError = validationError;
	}


	public void setStatu(String statu) {
		this.statu = statu;
	}


	public ResponseBodyError(String message) {
		super(message);
	}


	public String getStatu() {
		return statu;
	}
	


	public List<String> getMessages() {
		return messages;
	}


	public void setMessages(List<String> messages) {
		this.messages = messages;
	}


	public void setStatus(String statu) {
		this.statu = statu;
	}


	public ErrorHandle getError() {
		return error;
	}


	public void setError(ErrorHandle error) {
		this.error = error;
	}


	public String getResponseServiceHeader() {
		return responseServiceHeader;
	}


	public void setResponseServiceHeader(String responseServiceHeader) {
		this.responseServiceHeader = responseServiceHeader;
	}

}
