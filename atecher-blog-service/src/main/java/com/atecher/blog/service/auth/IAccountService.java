package com.atecher.blog.service.auth;

import com.atecher.blog.model.AuthUser;
import com.atecher.blog.model.Menu;

import java.util.List;

public interface IAccountService {

	List<Menu> getMenus(Long userId);
	
	AuthUser getAuthUserByAccount(String account);
}
