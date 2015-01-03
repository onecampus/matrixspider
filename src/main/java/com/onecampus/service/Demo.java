package com.onecampus.service;

import java.util.Date;

import com.onecampus.domain.Post;
import com.onecampus.util.HibernateUtil;
import com.onecampus.util.SougouUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

public class Demo {
	private static final Logger logger = LogManager.getLogger("Demo");

	public static void main(String[] args) {
		logger.warn("Hello, World!");
		Post p = new Post();
		p.setId(1);
		p.setDate(new Date());
		p.setTitle("title");
		p.setContent("content");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
		System.err.println("Done");
	}
}
