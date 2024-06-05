package com.ruoyi.user.service;

import com.ruoyi.admin.domain.DevUser;
import com.ruoyi.admin.domain.EnrollDTO;

public interface IUserService {

    /**
     * 用户登录
     * @param devUser
     * @return
     */
    DevUser userLogin(DevUser devUser);

    int updateUser(DevUser devUser);

    int insertEnroll(EnrollDTO enrollDTO);
}
