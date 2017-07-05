package com.atecher.blog.web.util;

import java.util.Properties;

public class Constants {

	public static final String WEBSITE_CURRENT_USER = "website_current_user";
	public static final String BIZ_MESS = "BIZ_MESS";
	public static final String CHARSET="UTF-8";
	public static final String TRUE = "1";
	public static final String OAUTH_TENCENT="tencent";
	public static final String OAUTH_WEIBO="weibo";
	private static Properties props = new Properties();
	public static String getValue(String key) {
		return props.getProperty(key);
	}

	public static void updateProperties(String key, String value) {
		props.setProperty(key, value);
	}

}
