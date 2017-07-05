package com.atecher.blog.service.search;

import com.atecher.blog.common.model.Page;
import com.atecher.blog.model.Article;

import java.io.IOException;


/**
 * Created by hanhongwei on 2016/6/14.
 * @author hongwei.han@qq.com
 */
public interface ISearchService {

    void buildIndexAll() throws IOException;

    Page<Article> search(int page, int limit, String text);

}
