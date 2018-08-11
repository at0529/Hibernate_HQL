package com.abc.hibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory= createSessionfactory();
	
	
	public static Session openSession() {
		return sessionFactory.openSession();
	}

	private static SessionFactory createSessionfactory() {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		return configuration.buildSessionFactory(builder.build());
		
	}
}
