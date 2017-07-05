package com.atecher.blog.service.content.impl;

import com.atecher.blog.mapper.content.ArticleMapper;
import com.atecher.blog.mapper.content.TagMapper;
import com.atecher.blog.model.Article;
import com.atecher.blog.model.Tag;
import com.atecher.blog.service.content.IArticleService;
import com.atecher.blog.common.model.Page;
import com.atecher.blog.common.util.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service("articleService")
public class ArticleServiceImpl  implements IArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private TagMapper tagMapper;

	private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

	public void saveArticle(Article article) {
		List<String> imgList=new ArrayList<>();
		if(article!=null&&article.getContent()!=null){
			Document doc = Jsoup.parse(article.getContent());
			if(StringUtils.isEmpty(article.getSummary())){
				String con=doc.text().trim();
				article.setSummary((con.length()>100?con.substring(0, 100):con).trim());
			}
			Elements images=doc.getElementsByTag("img");
			for(Element im:images){
				String urlString=im.attr("src");
				if(!StringUtils.isEmpty(urlString)&&urlString.startsWith("http")){
					 try {
						BufferedImage sourceImg =ImageIO.read(new URL(urlString));
						if(sourceImg.getWidth()*sourceImg.getHeight()>10000){
							imgList.add(urlString);
						}
					} catch (Exception e) {
						logger.error("无法获取图片", e);
					}
				}
			}
			
			if(StringUtils.isEmpty(article.getCover_path())&&imgList.size()>0){
				article.setCover_path(imgList.get(0));
			 }
			Map<String,Object> conditionMap=new HashMap<>();
			if(article.getArticle_id()!=null){
				articleMapper.updateArticle(article);
				conditionMap.put("source_id", article.getArticle_id());
				conditionMap.put("type", 1);
				articleMapper.deletePictures(conditionMap);
			}else{
				articleMapper.insertArticle(article);
				conditionMap.put("source_id", article.getArticle_id());
				conditionMap.put("type", 1);
			}
			int sorted=1;
			for(String url:imgList){
				conditionMap.put("pic_path", url);
				conditionMap.put("sorted", sorted++);
				articleMapper.insertPicture(conditionMap);
			}
			/**
			 * 添加Tag
			 */
			articleMapper.deleteTagsByArticleId(article.getArticle_id());
			String keywords=article.getKeywords();
			if(StringUtils.isEmpty(keywords)){
				String[] args=keywords.split(",");
				Map<String, Object> tagMap= new HashMap<>();
				tagMap.put("article_id", article.getArticle_id());
				for(String tag:args){
					tag=tag.trim();
					Long tagId=tagMapper.checkTag(tag);
					if(tagId==null){
						Tag tagModel=new Tag();
						tagModel.setTag(tag);
						try {
							tagModel.setCode(URLEncoder.encode(tag, Constants.CHARSET));
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						tagMapper.insertTag(tagModel);
						tagId=tagModel.getId();
					}
					tagMap.put("tag_id", tagId);
					articleMapper.insertArticleTag(tagMap);
				}
			}
		}
	}

	@Override
	public List<Article> hotArticle() {
		return articleMapper.hotArticle();
	}

	@Override
	public List<Map<String, Object>> queryMainArticles(Map<String, Object> param) {
		return articleMapper.queryMainArticles(param);
	}

	@Override
	public Page<Article> selectArticleForPage(int pageNo, int limit, Map<String, Object> parameter) {
		parameter.put("start", (pageNo - 1) * limit);
		parameter.put("limit", limit);
		int total = articleMapper.selectArticleForPageCount(parameter);
		if (total == 0) {
			return new Page<>(0, new ArrayList<Article>());
		} else {
			return new Page(total, articleMapper.selectArticleForPage(parameter));
		}
	}


	@Override
	public Article getArticle(long id) {
		return articleMapper.getArticle(id);
	}

	@Override
	public int deleteArticle(Long id) {
		return articleMapper.deleteArticle(id);
	}


}
