package com.atecher.blog.service.content.impl;

import com.atecher.blog.mapper.content.CategoryMapper;
import com.atecher.blog.model.Category;
import com.atecher.blog.service.content.ICategoryService;
import com.atecher.blog.common.model.Page;
import com.atecher.blog.common.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mark on 2017/6/20.
 */
@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<TreeNode> selectCategoryByParent(Map<String, Object> param) {
        return categoryMapper.selectCategoryByParent(param);
    }
    @Override
    public List<Category> allCategories() {
        return categoryMapper.queryCategoryList(null);
    }
    @Override
    public Category getCategoryByPath(String path) {
        return categoryMapper.getCategoryByPath(path);
    }

    @Override
    public List<Category> queryCategoryList(Map<String, Object> param) {
        return categoryMapper.queryCategoryList(param);
    }

    @Override
    public Page<Category> selectCategoryForPage(int pageNo, int limit, Map<String, Object> parameter) {
        parameter.put("start", (pageNo - 1) * limit);
        parameter.put("limit", limit);
        int total = categoryMapper.selectCategoryForPageCount(parameter);
        if (total == 0) {
            return new Page<>(0, new ArrayList<Category>());
        } else {
            return new Page(total, categoryMapper.selectCategoryForPage(parameter));
        }
    }

    @Override
    public Category getCategory(int id) {
        return categoryMapper.getCategory(id);
    }

    @Override
    public int disableCategory(int id) {
        return categoryMapper.disableCategory(id);
    }

    @Override
    public int checkCategoryPath(Category category) {
        return categoryMapper.checkCategoryPath(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }

    @Override
    public void insertCategory(Category category) {
        categoryMapper.insertCategory(category);
    }

    @Override
    public Category getParentCategory(int childId) {
        return categoryMapper.getCategory(childId);
    }
}
