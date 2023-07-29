package com.psja.PaymentModule.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatePaymentRequest {

	@JsonProperty("payment_type")
	private String paymentType;
	@JsonProperty("payment_amount")
	private String paymentAmount;
	@JsonProperty("transaction_id")
	private String transactionId;
	
	public String getPaymentType() {
		return this.paymentType;
	}
	public void setPaymentType( String paymentType ) {
		this.paymentType = paymentType;
	}
	
	public String getPaymentAmount() {
		return this.paymentAmount;
	}
	public void setPaymentAmount( String paymentAmount ) {
		this.paymentAmount = paymentAmount;
	}
	
	public String getTransactionId() {
		return this.transactionId;
	}
	public void setTransactionId( String transactionId ) {
		this.transactionId = transactionId;
	}
}
