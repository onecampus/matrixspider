package com.onecampus.controller;

import java.util.List;

import org.hibernate.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onecampus.domain.Post;
import com.onecampus.util.HibernateUtil;

@RestController
public class PostController {
	@RequestMapping("/posts")
    public List<Post> posts() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Post> posts = session.createQuery("from Post").list();
		System.out.print("hehe");
		session.getTransaction().commit();
		session.close();
		return posts;
    }
}
