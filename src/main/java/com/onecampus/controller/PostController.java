package com.onecampus.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onecampus.domain.Post;

@RestController
public class PostController {
	@RequestMapping("/posts")
    public Post p(@RequestParam(value="name", defaultValue="World") String name) {
		Post p = new Post();
		p.setTitle("title");
		p.setDate(new Date());
		p.setContent("content");
        return p;
    }
}
