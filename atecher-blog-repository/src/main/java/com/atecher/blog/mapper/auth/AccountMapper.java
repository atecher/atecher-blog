package com.atecher.blog.mapper.auth;

import com.atecher.blog.model.AuthUser;
import com.atecher.blog.model.Menu;

import java.util.HashMap;
import java.util.List;

public interface AccountMapper {

	AuthUser getAuthUserByAccount(String account);
	
	List<Menu> selectAuthMenuByParentCode(HashMap<String, Object> query);
	
}
