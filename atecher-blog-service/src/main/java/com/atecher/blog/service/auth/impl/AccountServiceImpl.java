package com.atecher.blog.service.auth.impl;

import com.atecher.blog.mapper.auth.AccountMapper;
import com.atecher.blog.model.AuthUser;
import com.atecher.blog.model.Menu;
import com.atecher.blog.service.auth.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
	@Autowired
	private AccountMapper accountMapper;
	@Override
	public AuthUser getAuthUserByAccount(String account) {
		return accountMapper.getAuthUserByAccount(account);
	}
	@Override
	public List<Menu> getMenus(Long userId){
		HashMap<String, Object> query=new HashMap<String, Object>(2);
		query.put("parentCode", "system");
		query.put("userId", userId);
		return accountMapper.selectAuthMenuByParentCode(query);
	}
	

}
