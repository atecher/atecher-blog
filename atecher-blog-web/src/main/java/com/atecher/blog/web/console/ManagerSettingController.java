package com.atecher.blog.web.console;

import com.atecher.blog.service.content.IProfileService;
import com.atecher.blog.service.search.ISearchService;
import com.atecher.blog.web.common.GenericActionController;
import com.atecher.blog.web.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * 描述：网站参数配置
 * @author    hongwei.han@qq.com
 * @version    v1.0
 */
@Controller
public class ManagerSettingController extends GenericActionController {
	@Autowired
	private ISearchService searchService;
	@Autowired
	private IProfileService profileService;


	@RequestMapping(value="/admin/setting",method = RequestMethod.GET)
	public String setting() throws IOException {
		return WebForwardConstants.FWD_MANAGER_SETTING;
	}

	@RequestMapping(value="/admin/profile",method = RequestMethod.GET)
	public String create(Model model) throws IOException {
		Map<String,Object> profileSetting=profileService.getProfile();
		model.addAttribute("profile", profileSetting);
		return WebForwardConstants.FWD_MANAGER_PROFILE;
	}
	/**
	 * 描述：保存
	 * @作者 mark.han
	 * @日期 2014-7-29
	 * @邮箱 hongwei.han@qq.com
	 * @param  model
	 * @param  request
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/admin/profile",method = RequestMethod.POST)
	public String update(Model model, HttpServletRequest request) throws IOException {
		Map<String,Object> update= WebUtil.getQueryConditionStartWith(request, "profile_");
		profileService.updateProfile(update);
		model.addAttribute(Constants.BIZ_MESS, Message.SUCCESS("成功提示：保存成功！"));
		Map<String,Object> profileSetting=profileService.getProfile();
		model.addAttribute("profile", profileSetting);
//		ServletContextUtil.readSystemSetting(request.getSession().getServletContext());
		return WebForwardConstants.FWD_MANAGER_PROFILE;
	}

	@RequestMapping(value="/admin/buildIndex",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult buildIndex() throws IOException {
		searchService.buildIndexAll();
		return new ResponseResult("success");
	}
}
