package com.psja.PaymentModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.psja.PaymentModule.assembler.PaymentAssembler;
import com.psja.PaymentModule.dao.PaymentRepository;
import com.psja.PaymentModule.entity.PaymentEntity;
import com.psja.PaymentModule.request.CreatePaymentRequest;

@Service
public class BasePaymentService implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PaymentAssembler paymentAssembler;
	
	//@Transactional(transactionManager = "CUSTOM_TX_MANAGER",  rollbackFor = Exception.class )
	private void persistPaymentMethod(PaymentEntity paymentEntity)throws Exception {
		paymentRepository.savePaymentData(paymentEntity);
		
	}
	
	@Override
	@Transactional(transactionManager = "CUSTOM_TX_MANAGER",  rollbackFor = Exception.class )
	public void paymentSave( CreatePaymentRequest createPaymentRequest ) throws Exception{
		
		
		PaymentEntity paymentEntity = paymentAssembler.toDomain(createPaymentRequest);
		//persistPaymentMethod( paymentEntity );
		paymentRepository.savePaymentData(paymentEntity);
		
	}
	
	@Override
	@Transactional(transactionManager = "CUSTOM_TX_MANAGER",  rollbackFor = Exception.class )
	public void paymentDeleteWithTransactionId( String transactionId )throws Exception{
		paymentRepository.deletePaymentDataUsingTransactionId(transactionId);
	}
	
	

}
