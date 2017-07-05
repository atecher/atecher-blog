package com.atecher.blog.model;

import org.apache.shiro.authc.UsernamePasswordToken;

public class AccountLoginToken extends UsernamePasswordToken {

	private static final long serialVersionUID = -1745391401571633459L;
	public AccountLoginToken(String account,String password){
		super(account,password);
	}
	
	public String getAccount(){
		return getUsername();
	}
}
