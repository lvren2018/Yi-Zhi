package com.ruoyi.user.service.impl;

import com.ruoyi.admin.domain.DevUser;
import com.ruoyi.admin.mapper.DevUserMapper;
import com.ruoyi.user.service.IUserService;
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

    @Override
    public DevUser userLogin(DevUser devUser) {
        DevUser user = devUserMapper.selectDevUserById(devUser.getId());
        return user;
    }
}
