package com.atecher.blog.service.content.impl;

import com.atecher.blog.mapper.content.TagMapper;
import com.atecher.blog.model.Tag;
import com.atecher.blog.service.content.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mark on 2017/6/20.
 */
@Service("tagService")
public class TagServiceImpl implements ITagService {
    @Autowired
    private TagMapper tagMapper;
    @Override
    public List<Tag> allTags() {
        return tagMapper.selectTags();
    }

    @Override
    public Tag getTag(String tag) {
        return tagMapper.getTagByTag(tag);
    }

    @Override
    public List<Tag> getHotTagsTop(int limit) {
        return tagMapper.getHotTagsTop(limit);
    }

}
