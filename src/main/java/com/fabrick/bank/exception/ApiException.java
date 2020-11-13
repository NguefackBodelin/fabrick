package com.fabrick.bank.exception;

import java.time.ZonedDateTime;
import java.util.List;

public class ApiException {
	
	private final String message;
	private  String httpStatus;
	private final ZonedDateTime timestamp;
	
	private List<String> messages;
	
	

	public ApiException(String message, String httpStatus, ZonedDateTime timestamp,List<String> messages) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
		this.messages = messages;
	}


	public String getMessage() {
		return message;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

}
