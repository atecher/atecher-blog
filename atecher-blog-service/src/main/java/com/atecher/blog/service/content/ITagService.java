package com.atecher.blog.service.content;

import com.atecher.blog.model.Tag;

import java.util.List;

/**
 * Created by mark on 2017/6/20.
 */
public interface ITagService {

    List<Tag> allTags();

    Tag getTag(String tag);

    List<Tag> getHotTagsTop(int limit);
}
