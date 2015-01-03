package com.onecampus.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.onecampus.util.SougouUtil;

public class Application {
	private static final Logger logger = LogManager.getLogger("Demo");

	public static void main(String[] args) throws ClientProtocolException, IOException {
		logger.warn("Hello, World!");
		// List<Post> posts = SougouUtil.getPostsByOpenid("oIWsFt-NQJJTI1l_HJBI-iEy3qbg", 1);
		String body = SougouUtil.getBody("oIWsFt-NQJJTI1l_HJBI-iEy3qbg", 1);
		System.out.println(body);
	}
}
