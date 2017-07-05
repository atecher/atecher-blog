package com.atecher.blog.service.content;

import com.atecher.blog.model.Article;
import com.atecher.blog.common.model.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by mark on 2017/6/16.
 */
public interface IWebsiteService {

    Page<Article> selectArticleForPage(int pageNo, int limit, Map<String, Object> parameter);

    boolean addViewRecord(Map<String, Object> param);

    Article getArticle(long id);

    List<Article> getPreNextArticle(long id);

    Page<Article> queryArticleByTagForPage(int pageNo, int limit, Map<String, Object> parameter);







}
