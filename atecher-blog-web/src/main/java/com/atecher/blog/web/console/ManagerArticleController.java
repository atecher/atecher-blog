package com.atecher.blog.web.console;

import com.atecher.blog.model.Article;
import com.atecher.blog.service.content.IArticleService;
import com.atecher.blog.service.content.ICategoryService;
import com.atecher.blog.service.content.ITagService;
import com.atecher.blog.common.model.Page;
import com.atecher.blog.common.model.PaginationRequest;
import com.atecher.blog.common.model.TreeNode;
import com.atecher.blog.web.common.GenericActionController;
import com.atecher.blog.web.util.ResponseResult;
import com.atecher.blog.web.util.WebForwardConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

/**
 * 描述：负责后台文章管理
 * @作者    mark.han
 * @邮箱    hongwei.han@qq.com
 * @日期    2014-7-29
 * @版本    v1.0
 */
@Controller
@RequestMapping(value = "/manage/article")
public class ManagerArticleController extends GenericActionController {
	private static final Logger logger = LoggerFactory.getLogger(ManagerArticleController.class);
	@Autowired
	private IArticleService articleService;
	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private ITagService tagService;
	/**
	 * 描述：文章查询
	 * @作者 mark.han
	 * @日期 2014-7-29
	 * @邮箱 hongwei.han@qq.com
	 * @return
	 */
	@RequestMapping(method= RequestMethod.GET)
	public String index() {	
		return WebForwardConstants.MANAGER_ARTICLE_LIST;
	}
	
	@RequestMapping(value="/data",method= RequestMethod.POST)
	@ResponseBody
	public Page<Article> getArticlePage(PaginationRequest pagination, @RequestParam(value="search",required=false) String search) throws ParseException, IOException {
		HashMap<String, Object> params= new HashMap<>();
		if(!StringUtils.isEmpty(pagination.getSort())){
			params.put("sort", pagination.getSort());
			params.put("order", pagination.getOrder());
		}
		params.put("search", search);
		return articleService.selectArticleForPage(pagination.getPageNo(), pagination.getLimit(), params);
	}
	
	@RequestMapping(value="/categoryTree",method= RequestMethod.POST)
	@ResponseBody
	public List<TreeNode> categoryTree(HttpServletRequest request) throws ParseException, IOException {
		HashMap<String, Object> param= new HashMap<>(2);
		param.put("code",-1);
		return categoryService.selectCategoryByParent(param);
	}
	
	@RequestMapping(value = "/add",method= RequestMethod.GET)
	public String add(Model model) {
		logger.debug("正在创建文章");
		model.addAttribute("article", new Article());
		model.addAttribute("tags", tagService.getHotTagsTop(10));
		return WebForwardConstants.MANAGER_ARTICLE_EDIT;
	}
	
	@RequestMapping(value = "/edit/{article_id}",method= RequestMethod.GET)
	public String edit(@PathVariable("article_id") Long article_id, Model model) {
		Article article=articleService.getArticle(article_id);
		model.addAttribute("article", article);
		model.addAttribute("tags", tagService.getHotTagsTop(10));
		logger.debug("正在编辑ID为{}的文章", article.getArticle_id());
		return WebForwardConstants.MANAGER_ARTICLE_EDIT;
	}
	
	/**
	 * 描述：保存文章信息
	 * @作者 mark.han
	 * @日期 2014-7-29
	 * @邮箱 hongwei.han@qq.com
	 * @param article
	 * @return
	 */
	@RequestMapping(value="/save",method= RequestMethod.POST)
	public String save(@ModelAttribute("article") Article article){
			articleService.saveArticle(article);
			return WebForwardConstants.MANAGER_REDIRECT_ARTICLE_LIST;
	}
	
	/**
	 * 描述：删除文章
	 * @作者 mark.han
	 * @日期 2014-7-29
	 * @邮箱 hongwei.han@qq.com
	 * @param article_id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/remove/{article_id}",method = RequestMethod.GET)
	@ResponseBody
	public ResponseResult delete(@PathVariable("article_id") Long article_id) throws IOException{
		articleService.deleteArticle(article_id);
		return new ResponseResult("success");
	}

}
