package com.onecampus.service;

import com.onecampus.util.SougouUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {
	private static final Logger logger = LogManager.getLogger("Demo");

	public static void main(String[] args) {
		logger.warn("Hello, World!");
		String openid = SougouUtil.getOpenid("36氪", "wow36kr");
    	System.out.println(openid);
	}
}
