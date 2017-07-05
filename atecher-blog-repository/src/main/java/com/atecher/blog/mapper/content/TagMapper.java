package com.atecher.blog.mapper.content;

import com.atecher.blog.model.Tag;

import java.util.List;
import java.util.Map;

/**
 * Created by mark on 2017/6/16.
 */
public interface TagMapper {

    List<Tag> getHotTagsTop(int limit);
    List<Tag> selectTags();

    Tag getTagByTag(String tag);

    Long checkTag(String tag);

    int deleteTag(long id);

    void insertTag(Tag tag);

    int updateTagCount(Map<String,Object> map);

}
