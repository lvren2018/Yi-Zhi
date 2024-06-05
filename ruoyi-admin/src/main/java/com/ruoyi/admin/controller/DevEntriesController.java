package com.ruoyi.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.admin.domain.EntriesDTO;
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
import com.ruoyi.admin.domain.DevEntries;
import com.ruoyi.admin.service.IDevEntriesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 作品管理Controller
 * 
 * @author 曾令根
 * @date 2024-06-05
 */
@RestController
@RequestMapping("/admin/entries")
public class DevEntriesController extends BaseController
{
    @Autowired
    private IDevEntriesService devEntriesService;

    /**
     * 查询作品管理列表
     */
    @PreAuthorize("@ss.hasPermi('admin:entries:list')")
    @GetMapping("/list")
    public TableDataInfo list(DevEntries devEntries)
    {
        startPage();
//        List<DevEntries> list = devEntriesService.selectDevEntriesList(devEntries);
//        return getDataTable(list);
        List<EntriesDTO> list = devEntriesService.getList(devEntries);
        System.out.println("............................................." + list);
        return getDataTable(list);

    }



    /**
     * 获取作品管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:entries:query')")
    @GetMapping(value = "/{entriesId}")
    public AjaxResult getInfo(@PathVariable("entriesId") Long entriesId)
    {
        return success(devEntriesService.selectDevEntriesByEntriesId(entriesId));
    }

    /**
     * 新增作品管理
     */
    @PreAuthorize("@ss.hasPermi('admin:entries:add')")
    @Log(title = "作品管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DevEntries devEntries)
    {
        return toAjax(devEntriesService.insertDevEntries(devEntries));
    }

    /**
     * 修改作品管理
     */
    @PreAuthorize("@ss.hasPermi('admin:entries:edit')")
    @Log(title = "作品管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DevEntries devEntries)
    {
        return toAjax(devEntriesService.updateDevEntries(devEntries));
    }

    /**
     * 删除作品管理
     */
    @PreAuthorize("@ss.hasPermi('admin:entries:remove')")
    @Log(title = "作品管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{entriesIds}")
    public AjaxResult remove(@PathVariable Long[] entriesIds)
    {
        return toAjax(devEntriesService.deleteDevEntriesByEntriesIds(entriesIds));
    }
}
