package com.psja.PaymentModule.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAYMENT_ENTITY")
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "payment_type")
	private String paymentType;
	@Column(name = "payment_amount")
	private String paymentAmount;
	@Column(name = "transaction_id")
	private String transactionId; 
	
	public Integer getId() {
		return this.id;
	}
	public void setId( Integer id ) {
		this.id = id;
	}
	
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
