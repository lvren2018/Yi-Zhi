package com.ruoyi.user.service;

import com.ruoyi.admin.domain.DevUser;

public interface IUserService {

    /**
     * 用户登录
     * @param devUser
     * @return
     */
    DevUser userLogin(DevUser devUser);
}
