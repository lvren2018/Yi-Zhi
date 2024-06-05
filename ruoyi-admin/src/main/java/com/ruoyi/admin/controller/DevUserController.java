package com.ruoyi.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.admin.domain.DevUser;
import com.ruoyi.admin.service.IDevUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 账户管理Controller
 * 
 * @author 曾令根
 * @date 2024-06-04
 */
@RestController
@RequestMapping("/admin/user")
public class DevUserController extends BaseController
{
    @Autowired
    private IDevUserService devUserService;

    /**
     * 查询账户管理列表
     */
    @PreAuthorize("@ss.hasPermi('admin:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(DevUser devUser)
    {
        startPage();
        List<DevUser> list = devUserService.selectDevUserList(devUser);
        return getDataTable(list);
    }

    /**
     * 导出账户管理列表
     */
    @PreAuthorize("@ss.hasPermi('admin:user:export')")
    @Log(title = "账户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DevUser devUser)
    {
        List<DevUser> list = devUserService.selectDevUserList(devUser);
        ExcelUtil<DevUser> util = new ExcelUtil<DevUser>(DevUser.class);
        util.exportExcel(response, list, "账户管理数据");
    }

    /**
     * 获取账户管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(devUserService.selectDevUserById(id));
    }

    /**
     * 新增账户管理
     */
    @PreAuthorize("@ss.hasPermi('admin:user:add')")
    @Log(title = "账户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DevUser devUser)
    {
        return toAjax(devUserService.insertDevUser(devUser));
    }

    /**
     * 修改账户管理
     */
    @PreAuthorize("@ss.hasPermi('admin:user:edit')")
    @Log(title = "账户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DevUser devUser)
    {
        return toAjax(devUserService.updateDevUser(devUser));
    }

    /**
     * 删除账户管理
     */
    @PreAuthorize("@ss.hasPermi('admin:user:remove')")
    @Log(title = "账户管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(devUserService.deleteDevUserByIds(ids));
    }
}
