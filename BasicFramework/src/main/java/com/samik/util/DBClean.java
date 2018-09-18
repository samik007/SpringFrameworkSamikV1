package com.samik.util;

import org.hibernate.SessionFactory;

public class DBClean {

	public static void cleanSession(SessionFactory sessionFactory) {
		if (sessionFactory != null && sessionFactory.isOpen()) {
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().clear();
		}
	}
}
