package com.atecher.blog.mapper.content;

import com.atecher.blog.model.Article;

import java.util.List;
import java.util.Map;

/**
 * Created by mark on 2017/6/19.
 */
public interface ArticleMapper {

    List<Map<String, Object>> queryMainArticles(Map<String, Object> param);


    List<Article> selectArticleForPage(Map<String, Object> param);

    int selectArticleForPageCount(Map<String, Object> param);

    List<Article> hotArticle();

    Article getArticle(Long article_id);

    void insertArticle(Article article);

    void insertPicture(Map<String, Object> param);

    int deletePictures(Map<String, Object> param);

    int updateArticle(Article article);

    int deleteArticle(Long articleId);

    void insertArticleTag(Map<String, Object> param);

    int deleteTagsByArticleId(Long articleId);

    int countArticleTag(Long tagId);

}
