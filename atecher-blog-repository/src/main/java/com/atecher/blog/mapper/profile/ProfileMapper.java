package com.atecher.blog.mapper.profile;

import java.util.List;
import java.util.Map;

/**
 * Created by mark on 2017/6/20.
 */
public interface ProfileMapper {

    Map<String, Object> getProfile();

    List<Map<String, Object>> getConstants();

    int updateProfile(Map<String, Object> param);

}
