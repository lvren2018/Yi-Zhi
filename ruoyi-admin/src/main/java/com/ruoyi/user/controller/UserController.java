package com.ruoyi.user.controller;

import com.ruoyi.admin.domain.DevUser;
import com.ruoyi.admin.domain.EnrollDTO;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 账户管理Controller
 *
 * @author 曾令根
 * @date 2024-06-05
 */
@RestController
@RequestMapping("/user/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    /**
     * 用户登录
     */
    @PreAuthorize("@ss.hasPermi('user:user:login')")
    @PostMapping("/login")
    public AjaxResult list(@RequestBody DevUser devUser)
    {
        DevUser user = userService.userLogin(devUser);
        if(!devUser.getUserName().equals(user.getUserName())  || !devUser.getPassword().equals(user.getPassword())){
            return error("用户名或密码错误!");
        }
        return success(user);
    }

    /**
     * 用户修改密码
     */
    @PreAuthorize("@ss.hasPermi('user:user:edit')")
    @Log(title = "用户信息修改", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DevUser devUser)
    {
        return toAjax(userService.updateUser(devUser));
    }


}
