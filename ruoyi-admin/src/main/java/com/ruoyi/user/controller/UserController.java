package com.ruoyi.user.controller;

import com.ruoyi.admin.domain.*;
import com.ruoyi.admin.mapper.DevValuationMapper;
import com.ruoyi.admin.service.impl.DevEntriesServiceImpl;
import com.ruoyi.admin.service.impl.DevValuationServiceImpl;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    private String uploadPath = "E:\\LvRen2018\\Java\\RuoYi-Vue\\file";

    @Autowired
    private IUserService userService;

    @Autowired
    private DevEntriesServiceImpl devEntriesService;

    @Autowired
    private DevValuationServiceImpl devValuationService;


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

    /**
     * 用户报名
     */
    @PreAuthorize("@ss.hasPermi('user:user:add')")
    @Log(title = "用户报名", businessType = BusinessType.INSERT)
    @PutMapping("/signup")
    public AjaxResult add(@RequestBody EnrollDTO enrollDTO, @RequestParam("file") MultipartFile file)
    {
        return toAjax(userService.insertEnroll(enrollDTO));
    }

    /**
     * 报名文件上传
     */
    @PreAuthorize("@ss.hasPermi('user:user:add')")
    @Log(title = "用户报名", businessType = BusinessType.INSERT)
    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file){
        // 文件保存路径
        String filePath = uploadPath + File.separator + file.getOriginalFilename();
        File dest = new File(filePath);

        // 保存文件
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success(filePath);
    }

    /**
     * 用户端作品列表
     */
    @PreAuthorize("@ss.hasPermi('user:entries:list')")
    @GetMapping("/list")
    public TableDataInfo list(DevEntries devEntries)
    {
        startPage();
        List<EntriesDTO> list = devEntriesService.getList(devEntries);
        return getDataTable(list);
    }


}

