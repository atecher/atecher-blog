package com.atecher.blog.service.content;

import com.atecher.blog.model.Article;
import com.atecher.blog.common.model.Page;

import java.util.List;
import java.util.Map;

public interface IArticleService {

    void saveArticle(Article article);

    Article getArticle(long id);

    int deleteArticle(Long id);

    List<Article> hotArticle();

    List<Map<String, Object>> queryMainArticles(Map<String,Object> param);

    Page<Article> selectArticleForPage(int pageNo, int limit, Map<String, Object> parameter);
}
