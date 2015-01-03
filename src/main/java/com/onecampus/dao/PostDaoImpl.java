package com.onecampus.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.onecampus.domain.Post;
import com.onecampus.util.HibernateUtil;
@Repository
public class PostDaoImpl implements PostDao {
	public List<Post> getAllPosts() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Post> posts = session.createQuery("from Post").list();
		session.getTransaction().commit();
		session.close();
		return posts;
	}
}
