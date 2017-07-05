package com.atecher.blog.service.auth.impl;

import com.atecher.blog.model.AccountLoginToken;
import com.atecher.blog.model.AuthUser;
import com.atecher.blog.service.auth.IAccountService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authRealm")
public class ShiroRealm extends AuthorizingRealm {
	private final Logger log = LoggerFactory.getLogger(ShiroRealm.class);
	@Autowired
	private IAccountService accountService;

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("授权认证：" + principals.getRealmNames());
		AuthUser authUser=(AuthUser)principals.fromRealm(getName()).iterator().next();  
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if(authUser.getRoles()!=null){
			for(String role:authUser.getRoles()){
				info.addRole(role);
			}
		}
		return info;

	}

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		if(authcToken instanceof AccountLoginToken){
			AccountLoginToken token = (AccountLoginToken) authcToken;
			log.info("认证账号:" + token.getUsername());
			AuthUser authUser =accountService.getAuthUserByAccount(token.getUsername());
			if(authUser!=null){
				return new SimpleAuthenticationInfo(authUser, authUser.getPassword(),getName());
			}else{
				return null;
			}
		}else{
			throw new AuthenticationException("不支持的认证类型");
		}
	}
}
