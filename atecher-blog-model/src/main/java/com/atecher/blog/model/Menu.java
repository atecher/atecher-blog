package com.atecher.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private Integer id;

    private String code;

    private String name;

    private String url;

    private Integer level;

    private String parentCode;

    private String fullCode;

    private String icon;

    private Integer order;

    private Boolean leaf;

    private Boolean visible;

    private List<Menu> children;

}