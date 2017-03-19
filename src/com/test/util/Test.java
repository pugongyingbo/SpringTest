package com.test.util;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.bean.User;

public class Test {
public static void main(String[] args) {
	 	Date date = new Date();
		User u = new User();
		u.setId(1);
		u.setName("zzb");
		
		u.setSex(0);
		u.setStatus(1);
		
		
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();
		session.close();
		
		
	}
}
