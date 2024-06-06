package com.ruoyi.admin.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.admin.domain.ValuationDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.admin.domain.DevValuation;
import com.ruoyi.admin.service.IDevValuationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评价管理Controller
 * 
 * @author 曾令根
 * @date 2024-06-05
 */
@Api(tags = "评价管理接口")
@RestController
@RequestMapping("/admin/valuation")
public class DevValuationController extends BaseController
{
    @Autowired
    private IDevValuationService devValuationService;

    /**
     * 查询评价管理列表
     */
    @ApiOperation("查询评价管理列表")
    @PreAuthorize("@ss.hasPermi('admin:valuation:list')")
    @GetMapping("/list")
    public TableDataInfo list(DevValuation devValuation)
    {
        startPage();
//        List<DevValuation> list = devValuationService.selectDevValuationList(devValuation);
//        return getDataTable(list);
        List<ValuationDTO> list = devValuationService.getList(devValuation);
        return getDataTable(list);
    }

    /**
     * 导出评价管理列表
     */
    @PreAuthorize("@ss.hasPermi('admin:valuation:export')")
    @Log(title = "评价管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DevValuation devValuation)
    {
        List<DevValuation> list = devValuationService.selectDevValuationList(devValuation);
        ExcelUtil<DevValuation> util = new ExcelUtil<DevValuation>(DevValuation.class);
        util.exportExcel(response, list, "评价管理数据");
    }

    /**
     * 获取评价管理详细信息
     */
    @ApiOperation("获取评价详细信息")
    @PreAuthorize("@ss.hasPermi('admin:valuation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(devValuationService.selectDevValuationById(id));
    }

    /**
     * 新增评价管理
     */
    @ApiOperation("新增评价")
    @PreAuthorize("@ss.hasPermi('admin:valuation:add')")
    @Log(title = "评价管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DevValuation devValuation)
    {
        return toAjax(devValuationService.insertDevValuation(devValuation));
    }

    /**
     * 修改评价管理
     */
    @ApiOperation("修改评价")
    @PreAuthorize("@ss.hasPermi('admin:valuation:edit')")
    @Log(title = "评价管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DevValuation devValuation)
    {
        return toAjax(devValuationService.updateDevValuation(devValuation));
    }

    /**
     * 删除评价管理
     */
    @ApiOperation("删除评价")
    @PreAuthorize("@ss.hasPermi('admin:valuation:remove')")
    @Log(title = "评价管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(devValuationService.deleteDevValuationByIds(ids));
    }
}
