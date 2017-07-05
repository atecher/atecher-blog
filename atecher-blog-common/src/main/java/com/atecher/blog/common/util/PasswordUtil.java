package com.atecher.blog.common.util;


/**
 * 描述：密码工具类，提供了生成随机密码和密码加密的功能
 * @作者    mark.han
 * @邮箱    hongwei.han@qq.com
 * @日期    2014-7-29
 * @版本    v1.0
 */
public class PasswordUtil {
	
	/**
	 * 描述：生成8位随机密码
	 * @作者 mark.han
	 * @日期 2014-7-29
	 * @邮箱 hongwei.han@qq.com
	 * @return
	 */
	public static  String passwordGen() {
		return StringCommonUtils.getRandomString(8);
	}
	/**
	 * 描述：对密码进行MD5加密
	 * @author mark.han
	 * @日期 2014-7-29
	 * @邮箱 hongwei.han@qq.com
	 * @param password
	 * @return
	 */
	public static  String passwordEncrypt(String password) {
		return MD5Util.MD5(password);
	}
	

}
