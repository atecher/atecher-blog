package com.atecher.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data

@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {
    private static final long serialVersionUID = -1195518622053857175L;
    private Long article_id;
    private Integer category_id;
    private String title;
    private String author;
    private String summary;
    private String original;
    private String template;
    private Date create_time;
    private Date update_time;
    private Integer total_clicks;
    private String keywords;
    private String content;
    private String cover_path;
    private String category_name;
    private String category_path;
    private Boolean pre = false;
    private Boolean next = false;
    private Integer status;
    private List<Tag> tags;


}