package com.fabrick.bank.dto.transactions;

import java.io.Serializable;
import java.util.List;

public class ResponseTransactions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ResponseTransaction> list;

	public List<ResponseTransaction> getList() {
		return list;
	}

	public void setList(List<ResponseTransaction> list) {
		this.list = list;
	}

	
}
