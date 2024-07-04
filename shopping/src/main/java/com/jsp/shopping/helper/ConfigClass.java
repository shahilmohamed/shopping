package com.jsp.shopping.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jsp.shopping.dto.Staff;

public class ConfigClass {
	public static SessionFactory getSession()
	{
		System.out.println("In configclass");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Staff.class);
		SessionFactory sf = cfg.buildSessionFactory();
		return sf;
	}

}
