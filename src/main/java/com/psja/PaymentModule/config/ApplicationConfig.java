package com.psja.PaymentModule.config;

import javax.sql.DataSource;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	//@Value("${checkMy.db.driverClassName}")
	private String driverClassName = "com.mysql.cj.jdbc.Driver";
	//@Value("${checkMy.db.url}")
	private String url = "jdbc:mysql://localhost:3306/orchestra";
	//@Value("${checkMy.db.username}")
	private String userName = "root";
	//@Value("${checkMy.db.password}")
	private String password = "root";
	
	@Bean
	DataSource createDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(driverClassName);
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(userName);
		driverManagerDataSource.setPassword(password);
		
		return driverManagerDataSource;
	}
	
	@Bean("CUSTOM_TX_MANAGER")
	PlatformTransactionManager createPlatFormTransactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setDataSource( createDataSource() );
		jpaTransactionManager.setEntityManagerFactory( entityManagerFactory().getObject() );
		return jpaTransactionManager;
	}
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource( createDataSource() );
		localContainerEntityManagerFactoryBean.setPackagesToScan( "com.psja.PaymentModule.entity" );
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		
		vendorAdapter.setShowSql(Boolean.TRUE);
		vendorAdapter.setGenerateDdl(true);
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		
		return localContainerEntityManagerFactoryBean;
	}
}
