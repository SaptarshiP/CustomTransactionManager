package com.psja.PaymentModule.controller;

import org.springframework.web.bind.annotation.RestController;

import com.psja.PaymentModule.request.CreatePaymentRequest;
import com.psja.PaymentModule.response.SuccessResponse;
import com.psja.PaymentModule.service.BasePaymentService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ApplicationController {

	@Autowired
	private BasePaymentService basePaymentService;
	
	@RequestMapping( value = "/createPayment", method = RequestMethod.POST )
	public ResponseEntity<?> createPayment(@RequestBody CreatePaymentRequest createPaymentRequest )throws Exception{
		
		
		basePaymentService.paymentSave(createPaymentRequest);
		
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setStatus( "STATUS" );
		return ResponseEntity.status(HttpStatus.OK).contentType( MediaType.APPLICATION_JSON ).body( successResponse );
	}

	@RequestMapping( value = "/cancelPayment", method = RequestMethod.GET )
	public ResponseEntity<?> calPayment( @RequestParam("transaction_id")String transactionId )throws Exception{
		
		basePaymentService.paymentDeleteWithTransactionId(transactionId);
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setStatus( "STATUS" );
		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body( successResponse );
	}
	
}
