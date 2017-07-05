package com.atecher.blog.mapper.content;

import com.atecher.blog.model.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by mark on 2017/6/16.
 */
public interface WebsiteMapper {

    List<Article> queryArticleForPage(Map<String, Object> param);

    int queryArticleForPageCount(Map<String, Object> param);

    int checkVistorViewArticle(Map<String, Object> param);

    int articleClickCount(long articleId);

    void addVistorView(Map<String, Object> param);

    Article getArticleById(Long articleId);

    List<Article> getPreNextArticle(Long articleId);

    List<Article> queryArticleByTagForPage(Map<String, Object> param);

    int queryArticleByTagForPageCount(Map<String, Object> param);

}
