package com.onecampus.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.onecampus.util.SougouUtil;

public class SougouUtilTest {
	@Test
	public void getOpenidTest() {
		String openid = SougouUtil.getOpenid("36氪", "wow36kr");
		// System.out.print(openid);
		// http://junit.org/javadoc/latest/index.html
		assertEquals(openid, "oIWsFt-NQJJTI1l_HJBI-iEy3qbg");
	}
}
