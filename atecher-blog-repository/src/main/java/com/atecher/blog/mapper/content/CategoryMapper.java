package com.atecher.blog.mapper.content;

import com.atecher.blog.model.Category;


import java.util.List;
import java.util.Map;
import com.atecher.blog.common.model.TreeNode;

/**
 * Created by mark on 2017/6/19.
 */
public interface CategoryMapper {

    List<Category> queryCategoryList(Map<String, Object> param);

    List<Category> selectCategoryForPage(Map<String, Object> param);

    int selectCategoryForPageCount(Map<String, Object> param);

    List<TreeNode> selectCategoryByParent(Map<String, Object> param);

    Category getCategory(int id);

    int disableCategory(int id);

    int checkCategoryPath(Category category);

    int updateCategory(Category category);

    void insertCategory(Category category);

    Category getParentCategory(int childId);

    Category getCategoryByPath(String path);

}
