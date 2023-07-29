package com.psja.PaymentModule.dao;

public interface PaymentRepository<T, I> {

	public void savePaymentData(T t)throws Exception; 
	public void deletePaymentDataUsingTransactionId( String transactionId )throws Exception;
	public void updateWithNativeQuery( String sqlQuery )throws Exception;
}
