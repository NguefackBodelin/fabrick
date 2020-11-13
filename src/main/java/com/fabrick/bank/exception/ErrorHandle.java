package com.fabrick.bank.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorHandle implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("code")
	private String code;
	@JsonProperty("description")
	private String description;
	@JsonProperty("params")
	private String params;
	
	
	public ErrorHandle() {
		super();
	}
	public ErrorHandle(String code, String description, String params) {
		super();
		this.code = code;
		this.description = description;
		this.params = params;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	
	
}
