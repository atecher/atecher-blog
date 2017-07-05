package com.atecher.blog.service.content.impl;

import com.atecher.blog.mapper.content.CategoryMapper;
import com.atecher.blog.mapper.content.TagMapper;
import com.atecher.blog.mapper.content.WebsiteMapper;
import com.atecher.blog.model.Article;
import com.atecher.blog.service.content.IWebsiteService;
import com.atecher.blog.common.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mark on 2017/6/16.
 */
@Service("websiteService")
public class WebsiteServiceImpl implements IWebsiteService {
    @Autowired
    private WebsiteMapper websiteMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;
    @Override
    public Page<Article> selectArticleForPage(int pageNo, int limit, Map<String, Object> parameter) {
        parameter.put("start", (pageNo - 1) * limit);
        parameter.put("limit", limit);
        int total = websiteMapper.queryArticleForPageCount(parameter);
        if (total == 0) {
            return new Page<>(0, new ArrayList<Article>());
        } else {
            return new Page(total, websiteMapper.queryArticleForPage(parameter));
        }
    }




    @Transactional
    public boolean addViewRecord(Map<String,Object> param) {
        if(websiteMapper.checkVistorViewArticle(param)==0){
            websiteMapper.articleClickCount(Long.valueOf(param.get("article_id").toString()));
            websiteMapper.addVistorView(param);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public Article getArticle(long id) {
        return websiteMapper.getArticleById(id);
    }

    @Override
    public List<Article> getPreNextArticle(long id) {
        return websiteMapper.getPreNextArticle(id);
    }



    @Override
    public Page<Article> queryArticleByTagForPage(int pageNo, int limit, Map<String, Object> parameter) {
        parameter.put("start", (pageNo - 1) * limit);
        parameter.put("limit", limit);
        int total = websiteMapper.queryArticleByTagForPageCount(parameter);
        if (total == 0) {
            return new Page<>(0, new ArrayList<Article>());
        } else {
            return new Page(total, websiteMapper.queryArticleByTagForPage(parameter));
        }
    }



}
