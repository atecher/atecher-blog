package com.atecher.blog.web.util;

import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class WebUtil {
	private static final String START_WITH_DEFAULT="search_";
	public static Map<String, Object> getQueryConditionStartWith(
			HttpServletRequest request, String startString) {
		return WebUtils.getParametersStartingWith(request, startString);
	}

	public static Map<String, Object> getQueryConditionStartWith(HttpServletRequest request) {
		return getQueryConditionStartWith(request, START_WITH_DEFAULT);
	}
	
	public static void putQueryConditionStartWith(HttpServletRequest request,Map<String, Object> queryCondition,String startString) {
		Iterator<Entry<String, Object>> entryIterator= queryCondition.entrySet().iterator();
		while (entryIterator.hasNext()) {
			Entry<String, Object> entry=entryIterator.next();
			request.setAttribute(startString+entry.getKey(), entry.getValue());
		}
	}
	public static void putQueryConditionStartWith(HttpServletRequest request,Map<String, Object> queryCondition) {
		putQueryConditionStartWith(request, queryCondition, START_WITH_DEFAULT);
	}
	
	public static String buildUrlParamString(HttpServletRequest request, String prefix){
		Map<String, Object> queryCondition =getQueryConditionStartWith(request,prefix);
		StringBuffer sb=new StringBuffer();
		Iterator<Entry<String, Object>> entryIterator= queryCondition.entrySet().iterator();
		while (entryIterator.hasNext()) {
			Entry<String, Object> entry=entryIterator.next();
			sb.append("&");
			sb.append(prefix+entry.getKey());
			sb.append("=");
			sb.append(entry.getValue());
		}
		return sb.toString();
	}
	
	
}
