package com.atecher.blog.web.util;

/**
 * 描述：页面跳转静态常量类
 * 
 * @author hongwei.han@qq.com
 * @version v1.0
 */
public class WebForwardConstants {
	public static final String REDIRECT_ROOT = "redirect:/";
	public static final String FWD_LOGIN = "account/login";
	public static final String REDIRECT_LOGIN = "redirect:/account/login";
	
	/**
	 * 管理
	 */
	public static final String FWD_MANAGER_INDEX="console/index";
	public static final String FWD_MANAGER_DASHBOARD="console/dashboard";
	/** 分类管理 */
	public static final String MANAGER_CATEGORY_LIST = "console/category/index";
	public static final String MANAGER_CATEGORY_EDIT = "console/category/edit";
	
	public static final String MANAGER_ARTICLE_LIST = "console/article/index";
	public static final String MANAGER_ARTICLE_EDIT = "console/article/edit";
	public static final String MANAGER_REDIRECT_ARTICLE_LIST = "redirect:/manage/article";
	/**PROFILE*/
	
	public static final String FWD_MANAGER_SETTING = "console/setting/setting";
	public static final String FWD_MANAGER_PROFILE = "console/setting/profile";
	
	public static final String FWD_MANAGER_HOME = "console/home/index";
	public static final String FWD_MANAGER_HOME_PASSWORD = "console/home/password";
	public static final String FWD_MANAGER_HOME_AVATAR = "console/home/avatar";
	
	public static final String ERROR_500 = "error/500";
	
	/** 系统登录跳转页面 */
	public static final String REDIRECT = "redirect:";
	
	public static final String FWD_WEBSITE_INDEX="website/index";
	public static final String FWD_WEBSITE_CATEGORY="website/category";
	public static final String FWD_WEBSITE_DETAIL="website/detail";
	public static final String FWD_WEBSITE_TAG="website/tag";
	public static final String FWD_WEBSITE_SINGLE="website/single";
	public static final String FWD_WEBSITE_SEARCH="website/search";


}
