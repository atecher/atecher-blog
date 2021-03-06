package com.atecher.blog.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

public class CookieUtil {
	private static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String createCookieCode(int length) {
	    return generateString(length);
	   }
	
	public static Cookie getCookie(HttpServletRequest request, String name) {
	     Cookie cookies[] = request.getCookies();
	     if (cookies == null || name == null || name.length() == 0) {
	       return null;
	     }
	     for (int i = 0; i < cookies.length; i++) {
	       if (name.equals(cookies[i].getName())) {
	         return cookies[i];
	       }
	     }
	     return null;
	   }

	   public static void deleteCookie(HttpServletRequest request,
	       HttpServletResponse response, Cookie cookie) {
	     if (cookie != null) {
	       cookie.setPath(getPath(request));
	       cookie.setValue("");
	       cookie.setMaxAge(0);
	       response.addCookie(cookie);
	     }
	   }

	   public static void setCookie(HttpServletRequest request,
	       HttpServletResponse response, String name, String value) {
	     setCookie(request, response, name, value, 0x278d00);
	   }

	   public static void setCookie(HttpServletRequest request,
	       HttpServletResponse response, String name, String value, int maxAge) {
	     Cookie cookie = new Cookie(name, value == null ? "" : value);
	     cookie.setMaxAge(maxAge);
	     cookie.setPath(getPath(request));
//	     cookie.setDomain(request.getServerName());
	     response.addCookie(cookie);
	   }

	   private static String getPath(HttpServletRequest request) {
	     String path = request.getContextPath();
	     return (path == null || path.length()==0) ? "/" : path;
	   }
	   
	   private static String generateString(int length) //参数为返回随机数的长度
	    {
	     StringBuffer sb = new StringBuffer();
	     Random random = new Random();
	     for (int i = 0; i < length; i++)
	     {
	      sb.append(allChar.charAt(random.nextInt(allChar.length())));
	     }
	    return sb.toString();
	    }
}
