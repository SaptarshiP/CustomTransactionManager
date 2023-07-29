package com.psja.PaymentModule.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.psja.PaymentModule.entity.PaymentEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class PaymentRepsoitoryImpl implements PaymentRepository<PaymentEntity, Double>{
	
	@Autowired
	private EntityManager em;
	
	@Override
	public void savePaymentData( PaymentEntity paymentEntity )throws Exception {
		em.persist(paymentEntity);
		//throw new Exception("CHECKED_EXCEPTION");
	}
	
	@Override
	public void deletePaymentDataUsingTransactionId( String transactionId )throws Exception{
		String sqlQuery = "delete from PAYMENT_ENTITY where transaction_id = '"+transactionId+"'";
		updateWithNativeQuery( sqlQuery );
	}
	
	@Override
	public void updateWithNativeQuery( String sqlQuery )throws Exception{
		Query query = em.createNativeQuery(sqlQuery);
		int updatedData = query.executeUpdate();
		
		if ( updatedData != 1 )
			throw new Exception("UPDATE QUERY NOT WORKING");
	}

}
