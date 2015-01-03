package com.onecampus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onecampus.dao.PostDaoImpl;
import com.onecampus.domain.Post;

@Service
public class PostServiceImpl implements PostService {

	@Override
	public List<Post> getAllPosts() {
		return null;
	}

}
