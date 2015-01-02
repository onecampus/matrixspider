package com.onecampus.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SougouUtil {
	@SuppressWarnings("deprecation")
	public static String getOpenid(String weixinNickname, String weixinnumber) {
		Document doc = null;
		String url = "http://weixin.sogou.com/weixin?query=";
		url += URLEncoder.encode(weixinNickname);
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element parentNode = null;
		Elements weixinnumbers = doc.select("div.txt-box > h4");
		for (Element element : weixinnumbers) {
			if (element.toString().matches(".*" + weixinnumber + ".*")) {
				parentNode = element.parent().parent();
				break;
			} else {
				continue;
			}
		}
		String text = parentNode.toString();
        String reg = ".*openid=([a-zA-Z0-9\\-\\_]+).*";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(text);
        String openid = null;
        while (m.find()) {
        	openid = m.group(1);
        }
		return openid;
	}
}
