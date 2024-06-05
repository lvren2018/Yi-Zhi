package com.ruoyi.user.service.impl;

import com.ruoyi.admin.domain.DevEntries;
import com.ruoyi.admin.domain.DevUser;
import com.ruoyi.admin.domain.EnrollDTO;
import com.ruoyi.admin.mapper.DevEntriesMapper;
import com.ruoyi.admin.mapper.DevUserMapper;
import com.ruoyi.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户端Service业务层处理
 *
 * @author 曾令根
 * @date 2024-06-05
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private DevUserMapper devUserMapper;

    @Autowired
    private DevEntriesMapper devEntriesMapper;

    /**
     * 用户登录
     * @param devUser
     * @return
     */
    @Override
    public DevUser userLogin(DevUser devUser) {
        DevUser user = devUserMapper.selectDevUserById(devUser.getId());
        return user;
    }

    /**
     * 更新用户信息
     * @param devUser
     * @return
     */
    @Override
    public int updateUser(DevUser devUser) {
        return devUserMapper.updateDevUser(devUser);
    }

    @Override
    public int insertEnroll(EnrollDTO enrollDTO) {
        DevUser devUser = new DevUser();
        DevEntries devEntries = new DevEntries();
        devEntries.setUserId((long) enrollDTO.getId());
        BeanUtils.copyProperties(enrollDTO,devUser);
        BeanUtils.copyProperties(enrollDTO,devEntries);
        int entriesLows = devEntriesMapper.insertDevEntries(devEntries);
        int userLows = devUserMapper.updateDevUser(devUser);
        return entriesLows + userLows;
    }
}
