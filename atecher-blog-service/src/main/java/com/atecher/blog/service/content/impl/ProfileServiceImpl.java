package com.atecher.blog.service.content.impl;

import com.atecher.blog.mapper.profile.ProfileMapper;
import com.atecher.blog.service.content.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by mark on 2017/6/20.
 */
@Service("profileService")
public class ProfileServiceImpl implements IProfileService {
    @Autowired
    private ProfileMapper profileMapper;
    @Override
    public Map<String, Object> getProfile() {
        return profileMapper.getProfile();
    }

    @Override
    public List<Map<String, Object>> getConstants() {
        return profileMapper.getConstants();
    }

    @Override
    public int updateProfile(Map<String, Object> param) {
        return profileMapper.updateProfile(param);
    }
}
