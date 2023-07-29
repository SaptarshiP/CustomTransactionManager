package com.psja.PaymentModule.assembler;

import org.springframework.stereotype.Component;

import com.psja.PaymentModule.entity.PaymentEntity;
import com.psja.PaymentModule.request.CreatePaymentRequest;

@Component
public class PaymentAssembler {

	
	public PaymentEntity toDomain( Object obj ) {
		System.out.println("ENTERING toDomain");
		CreatePaymentRequest createPaymentRequest = (CreatePaymentRequest)obj;
		PaymentEntity paymentEntity = new PaymentEntity();
		paymentEntity.setPaymentType( createPaymentRequest.getPaymentType() );
		paymentEntity.setPaymentAmount( createPaymentRequest.getPaymentAmount() );
		paymentEntity.setTransactionId( createPaymentRequest.getTransactionId() );
		System.out.println("EXITING toDomain");
		return paymentEntity;
	}
}
