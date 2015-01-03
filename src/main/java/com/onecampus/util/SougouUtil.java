package com.onecampus.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.onecampus.domain.Post;

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

	public static List<Post> getPostsByOpenid(String openid, Integer page) {
		String url = "http://weixin.sogou.com/gzh?openid=" + openid;
		String jsUrl = "http://weixin.sogou.com/gzhjs?openid=" + openid
				+ "&page=" + page;
		Document doc = null;
		try {
			doc = Jsoup.connect(jsUrl).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(doc);
		return null;
	}

	public static String getBody(String openid, Integer page) {
		String jsUrl = "http://weixin.sogou.com/gzhjs?openid=" + openid
				+ "&page=" + page;
		@SuppressWarnings({ "resource", "deprecation" })
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpgets = new HttpGet(jsUrl);
		HttpResponse response = null;
		try {
			response = httpclient.execute(httpgets);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpEntity entity = response.getEntity();
		String body = null;
		try {
			body = EntityUtils.toString(entity);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}
}
