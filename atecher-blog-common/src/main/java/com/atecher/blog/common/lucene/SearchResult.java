package com.atecher.blog.common.lucene;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hanhongwei on 2016/6/14.
 */
@Data

@NoArgsConstructor
@AllArgsConstructor
public class SearchResult implements Serializable {
    private Long id;
    private String title;
    private Date modifiedTime;
    private String content;
}
