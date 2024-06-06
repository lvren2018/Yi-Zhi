package com.ruoyi.admin.service.impl;

import java.util.List;

import com.ruoyi.admin.domain.ValuationDTO;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.admin.domain.DevEntries;
import com.ruoyi.admin.mapper.DevValuationMapper;
import com.ruoyi.admin.domain.DevValuation;
import com.ruoyi.admin.service.IDevValuationService;

/**
 * 评价管理Service业务层处理
 * 
 * @author 曾令根
 * @date 2024-06-05
 */
@Service
public class DevValuationServiceImpl implements IDevValuationService 
{
    @Autowired
    private DevValuationMapper devValuationMapper;

    /**
     * 查询评价管理
     * 
     * @param id 评价管理主键
     * @return 评价管理
     */
    @Override
    public DevValuation selectDevValuationById(Long id)
    {
        return devValuationMapper.selectDevValuationById(id);
    }

    /**
     * 查询评价管理列表
     * 
     * @param devValuation 评价管理
     * @return 评价管理
     */
    @Override
    public List<DevValuation> selectDevValuationList(DevValuation devValuation)
    {
        return devValuationMapper.selectDevValuationList(devValuation);
    }

    /**
     * 新增评价管理
     * 
     * @param devValuation 评价管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertDevValuation(DevValuation devValuation)
    {
        devValuation.setCreateTime(DateUtils.getNowDate());
        int rows = devValuationMapper.insertDevValuation(devValuation);
        insertDevEntries(devValuation);
        return rows;
    }

    /**
     * 修改评价管理
     * 
     * @param devValuation 评价管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateDevValuation(DevValuation devValuation)
    {
        devValuationMapper.deleteDevEntriesByEntriesId(devValuation.getId());
        insertDevEntries(devValuation);
        return devValuationMapper.updateDevValuation(devValuation);
    }

    /**
     * 批量删除评价管理
     * 
     * @param ids 需要删除的评价管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDevValuationByIds(Long[] ids)
    {
        devValuationMapper.deleteDevEntriesByEntriesIds(ids);
        return devValuationMapper.deleteDevValuationByIds(ids);
    }

    /**
     * 删除评价管理信息
     * 
     * @param id 评价管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDevValuationById(Long id)
    {
        devValuationMapper.deleteDevEntriesByEntriesId(id);
        return devValuationMapper.deleteDevValuationById(id);
    }

    /**
     * 查询作品管理列表
     * @param devValuation
     * @return
     */
    @Override
    public List<ValuationDTO> getList(DevValuation devValuation) {
        List<ValuationDTO> list = devValuationMapper.getList(devValuation);
        return list;
    }

    /**
     * 新增作品管理信息
     * 
     * @param devValuation 评价管理对象
     */
    public void insertDevEntries(DevValuation devValuation)
    {
        devValuationMapper.insertDevValuation(devValuation);
    }
}
