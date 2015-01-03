package com.onecampus.controller;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onecampus.domain.Post;
import com.onecampus.util.HibernateUtil;

@RestController
@RequestMapping("/posts")
public class PostController {
	@RequestMapping(method=RequestMethod.GET)
    public List<Post> posts() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Post> posts = session.createQuery("from Post").list();
		session.getTransaction().commit();
		session.close();
		return posts;
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Post post(@PathVariable("id") long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Post where id = :id");
		query.setParameter("id", id);
		Post post = (Post) query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return post;
	}
}
