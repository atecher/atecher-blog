package com.atecher.blog.web.auth;

import com.alibaba.fastjson.JSON;
import com.atecher.blog.common.util.PasswordUtil;
import com.atecher.blog.model.AccountLoginToken;
import com.atecher.blog.model.AuthUser;
import com.atecher.blog.model.Menu;
import com.atecher.blog.service.auth.IAccountService;
import com.atecher.blog.web.common.GenericActionController;
import com.atecher.blog.web.util.Constants;
import com.atecher.blog.web.util.Message;
import com.atecher.blog.web.util.WebForwardConstants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;

/**
 * 后台登陆控制类
 * 
 * @author Robin.han
 */
@Controller
public class UserAuthenticationController extends GenericActionController {
    
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private ShiroFilterFactoryBean shiroFilter;

    /**
     * 用户登陆
     * @param model
     * @param account 账号
     * @param password 密码
     * @param request
     * @return
     */
    @RequestMapping(value="/account/login",method = RequestMethod.POST)
    public String create(Model model, @RequestParam("user_account") String account, @RequestParam("user_password") String password, HttpServletRequest request, HttpServletResponse response) {
    	Subject subject=SecurityUtils.getSubject();
		try{
    		subject.login(new AccountLoginToken(account, PasswordUtil.passwordEncrypt(password)));
    	}catch(Exception e){
    		e.printStackTrace();
    		model.addAttribute(Constants.BIZ_MESS, Message.ERROR("提示：用户名或密码不正确！"));
    		return WebForwardConstants.FWD_LOGIN;
    	}
    	if(subject.isAuthenticated()){
    		setCurrentUser(request, (AuthUser)subject.getPrincipals().getPrimaryPrincipal());
//			System.out.println(JSON.toJSONString(subject.getSession(false).getAttributeKeys()));
    		SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);
    		 String successUrl=null;
            if (savedRequest != null && savedRequest.getMethod().equalsIgnoreCase(AccessControlFilter.GET_METHOD)) {
                successUrl = savedRequest.getRequestUrl();
            }else{
            	successUrl=shiroFilter.getSuccessUrl();
            }
            return WebForwardConstants.REDIRECT+successUrl;
    	}else{
    		return WebForwardConstants.FWD_LOGIN;
    	}
    }
    
    /**
     * 用户注销
     * @param request
     * @return
     */
    @RequestMapping(value="/account/logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
    	Subject subject=SecurityUtils.getSubject();
    	subject.logout();
    	request.getSession().invalidate();
    	SavedRequest savedRequest = WebUtils.getSavedRequest(request);
		 String forwardURI=null;
       if (savedRequest != null && savedRequest.getMethod().equalsIgnoreCase(AccessControlFilter.GET_METHOD)) {
    	   forwardURI = savedRequest.getRequestUrl();
       }else{
    	   forwardURI=shiroFilter.getLoginUrl();
       }
    	return WebForwardConstants.REDIRECT+forwardURI;
    }

    /**
     * 用户通过get方式访问login.htm
     * enterpriselogin
     * @param request
     * @return
     * @throws ParseException
     */
    @RequestMapping(value="/account/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request) throws ParseException {
    	AuthUser user = (AuthUser) request.getSession().getAttribute(Constants.WEBSITE_CURRENT_USER);
        if (user != null) {
            return WebForwardConstants.REDIRECT_ROOT;
        } else {
            return WebForwardConstants.FWD_LOGIN;
        }
    }
    
    @RequestMapping(value="/account/menu",method = RequestMethod.GET)
    @ResponseBody
    public List<Menu> getMenus(HttpServletRequest request) throws ParseException {
    	Subject subject=SecurityUtils.getSubject();
    	if(subject.isAuthenticated()){
    		return accountService.getMenus(getCurrentUserId(request));
    	}else{
    		return null;
    	}
    	
    }
    
    


}
