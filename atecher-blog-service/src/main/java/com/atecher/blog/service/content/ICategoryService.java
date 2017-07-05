package com.atecher.blog.service.content;

import com.atecher.blog.model.Category;
import com.atecher.blog.common.model.Page;
import com.atecher.blog.common.model.TreeNode;

import java.util.List;
import java.util.Map;

public interface ICategoryService {

    List<TreeNode> selectCategoryByParent(Map<String, Object> param);

    List<Category> allCategories();

    Category getCategoryByPath(String path);

    List<Category> queryCategoryList(Map<String, Object> param);

    Page<Category> selectCategoryForPage(int pageNo, int limit, Map<String, Object> param);

    Category getCategory(int id);

    int disableCategory(int id);

    int checkCategoryPath(Category category);

    int updateCategory(Category category);

    void insertCategory(Category category);

    Category getParentCategory(int childId);

}
