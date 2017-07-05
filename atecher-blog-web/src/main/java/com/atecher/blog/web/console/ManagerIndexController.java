package com.atecher.blog.web.console;
import com.atecher.blog.service.auth.IAccountService;
import com.atecher.blog.web.common.GenericActionController;
import com.atecher.blog.web.util.WebForwardConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 描述：后台管理主页控制类
 */
@Controller
@RequestMapping(value = "/admin/index")
public class ManagerIndexController extends GenericActionController {
	@Autowired
	private IAccountService accountService;
	/**
	 * 描述：管理主页面入口
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
		Long userId=getCurrentUserId(request);
		if(userId!=null){
			model.addAttribute("menu", accountService.getMenus(userId));
			return WebForwardConstants.FWD_MANAGER_INDEX;
		}else{
			return WebForwardConstants.REDIRECT_LOGIN;
		}
	}

}
