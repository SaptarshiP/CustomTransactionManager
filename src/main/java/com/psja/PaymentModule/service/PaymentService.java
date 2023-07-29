package com.psja.PaymentModule.service;

import com.psja.PaymentModule.request.CreatePaymentRequest;

public interface PaymentService {

	public void paymentSave( CreatePaymentRequest createPaymentRequest )throws Exception;
	public void paymentDeleteWithTransactionId( String transactionId )throws Exception;
}
