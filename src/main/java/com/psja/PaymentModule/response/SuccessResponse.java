package com.psja.PaymentModule.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SuccessResponse {

	@JsonProperty("status")
	private String status;
	
	public String getStatus() {
		return this.status;
	}
	public void setStatus( String status ) {
		this.status = status;
	}
	
}
