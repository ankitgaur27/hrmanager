package com.nagarro.hrmanager.model;

import java.util.logging.Level;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 

/**
 * This class is used to configure the database
 * @author ankitgaur
 *
 */
public class HibernateConfig {
	public static Session session;
	public static SessionFactory factory;
	
	public static void connectionSetup(){

//		 @SuppressWarnings("All")
//	      org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
//	      java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF); 
		 Configuration cf = new Configuration();
	     cf.configure("hibernate.cfg.xml");
	     factory = cf.buildSessionFactory();
	     session= factory.openSession();	 
    }

}
