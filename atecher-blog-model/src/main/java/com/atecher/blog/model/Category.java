package com.atecher.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Category implements Serializable {
    private String[] nums = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final long serialVersionUID = 8127206611141982939L;
    private Integer category_id;
    private Integer parent_id = -1;
    private Boolean is_display = true;
    private String category_name;
    private String category_path;
    private String keywords;
    private String description;
    private Integer category_level;
    private Integer priority;
    private Category parent;
    private List<Category> children = new ArrayList<Category>();
    public void addChild(Category category) {
        children.add(category);
    }
    public String getLevelDesc() {
        if (this.category_level != null && this.category_level < 10) {
            return nums[this.category_level - 1] + "级";
        } else {
            return this.category_level + "级";
        }
    }
}