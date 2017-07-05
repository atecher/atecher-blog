package com.atecher.blog.web.common;

import com.atecher.blog.model.AuthUser;
import com.atecher.blog.web.util.Constants;
import com.atecher.blog.web.util.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：控制层基类
 * @作者    mark.han
 * @邮箱    hongwei.han@qq.com
 * @日期    2014-7-29
 * @版本    v1.0
 */
public class GenericActionController {
	private static final Logger logger = LoggerFactory.getLogger(GenericActionController.class);
	/**
	 * 描述：将用户信息加入到session中
	 * @作者 mark.han
	 * @日期 2014-7-29
	 * @邮箱 hongwei.han@qq.com
	 * @param request
	 * @param user
	 */
	protected void setCurrentUser(HttpServletRequest request,AuthUser user){
		request.getSession().setAttribute(Constants.WEBSITE_CURRENT_USER,user);
	}
	/**
	 * 描述：获取当前登录用户的ID
	 * @作者 mark.han
	 * @日期 2014-7-29
	 * @邮箱 hongwei.han@qq.com
	 * @param request
	 * @return
	 */
	protected Long getCurrentUserId(HttpServletRequest request){
		AuthUser user=(AuthUser)request.getSession().getAttribute(Constants.WEBSITE_CURRENT_USER);
		if(user!=null){
			return user.getId();
		}else{
			return null;
		}
	}
	
	protected AuthUser getCurrentUser(HttpServletRequest request){
		AuthUser user=(AuthUser)request.getSession().getAttribute(Constants.WEBSITE_CURRENT_USER);
		if(user!=null){
			return user;
		}else{
			return null;
		}
	}
	/**
	 * 描述：获取访问者信息
	 * @author mark.han
	 * @date 2014-7-29
	 * @email hongwei.han@qq.com
	 * @param request
	 * @param response
	 * @return
	 */
	protected Map<String,Object> getVisitorInfo(HttpServletRequest request,HttpServletResponse response) {
		String real_ip = request.getHeader("X-Real-IP");
		String agent_ip=request.getRemoteAddr();
		if (StringUtils.isBlank(real_ip) ||"unknown".equalsIgnoreCase(real_ip)) {
			real_ip=request.getHeader("X-Forwarded-For");
		}
		if (!StringUtils.isBlank(real_ip) && !"unknown".equalsIgnoreCase(real_ip)) {
			// 多次反向代理后会有多个IP值，第一个为真实IP。
			int index = real_ip.indexOf(',');
			if (index != -1) {
				real_ip=real_ip.substring(0, index);
			}
		}
		if(StringUtils.isBlank(real_ip) || "unknown".equalsIgnoreCase(real_ip)) {
			real_ip = request.getHeader("WL-Proxy-Client-IP");
		}

		if(StringUtils.isBlank(real_ip) || "unknown".equalsIgnoreCase(real_ip)) {
			real_ip=agent_ip;
		}
		Map<String,Object> map= new HashMap<>();
		map.put("real_ip", real_ip);
		map.put("agent_ip", agent_ip);
		Cookie cookie=  CookieUtil.getCookie(request, "yd_cookie_code");
		String cookie_code;
		if(cookie==null){
			cookie_code=(String)request.getSession().getAttribute("session_cookie_code");
			CookieUtil.setCookie(request, response, "yd_cookie_code", StringUtils.defaultIfEmpty(cookie_code,CookieUtil.createCookieCode(20)));
			logger.debug("生成了用户的cookie_code:{}",cookie_code);
		}else{
			cookie_code=cookie.getValue();
		}
		map.put("cookie_code", cookie_code);
		return map;
	}
}
