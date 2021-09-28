package com.nagarro.hrmanager.data;

import static com.nagarro.hrmanager.model.HibernateConfig.connectionSetup;
import static com.nagarro.hrmanager.model.HibernateConfig.session;

import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		
		connectionSetup();

		Transaction transaction = session.beginTransaction();

		System.out.println("s");

		Manager manager = new Manager();
		manager.setEmail("developergaurankit@gmail.com");
		manager.setPassword("aa");
		manager.setUsername("aa");

		session.save(manager);

		transaction.commit();

	}
}
