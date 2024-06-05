package com.ruoyi.admin.service.impl;

import java.util.List;

import com.ruoyi.admin.domain.EntriesDTO;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.admin.domain.DevUser;
import com.ruoyi.admin.mapper.DevEntriesMapper;
import com.ruoyi.admin.domain.DevEntries;
import com.ruoyi.admin.service.IDevEntriesService;

/**
 * 作品管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
@Service
public class DevEntriesServiceImpl implements IDevEntriesService 
{
    @Autowired
    private DevEntriesMapper devEntriesMapper;

    /**
     * 查询作品管理
     * 
     * @param entriesId 作品管理主键
     * @return 作品管理
     */
    @Override
    public DevEntries selectDevEntriesByEntriesId(Long entriesId)
    {
        return devEntriesMapper.selectDevEntriesByEntriesId(entriesId);
    }

    /**
     * 查询作品管理列表
     * 
     * @param devEntries 作品管理
     * @return 作品管理
     */
    @Override
    public List<DevEntries> selectDevEntriesList(DevEntries devEntries)
    {
        return devEntriesMapper.selectDevEntriesList(devEntries);
    }

    /**
     * 新增作品管理
     * 
     * @param devEntries 作品管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertDevEntries(DevEntries devEntries)
    {
        devEntries.setCreateTime(DateUtils.getNowDate());
        int rows = devEntriesMapper.insertDevEntries(devEntries);
        insertDevUser(devEntries);
        return rows;
    }

    /**
     * 修改作品管理
     * 
     * @param devEntries 作品管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateDevEntries(DevEntries devEntries)
    {
        devEntriesMapper.deleteDevUserById(devEntries.getEntriesId());
        insertDevUser(devEntries);
        return devEntriesMapper.updateDevEntries(devEntries);
    }

    /**
     * 批量删除作品管理
     * 
     * @param entriesIds 需要删除的作品管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDevEntriesByEntriesIds(Long[] entriesIds)
    {
        devEntriesMapper.deleteDevUserByIds(entriesIds);
        return devEntriesMapper.deleteDevEntriesByEntriesIds(entriesIds);
    }

    /**
     * 删除作品管理信息
     * 
     * @param entriesId 作品管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteDevEntriesByEntriesId(Long entriesId)
    {
        devEntriesMapper.deleteDevUserById(entriesId);
        return devEntriesMapper.deleteDevEntriesByEntriesId(entriesId);
    }

    @Override
    public List<EntriesDTO> getList(DevEntries devEntries) {
        return devEntriesMapper.getList(devEntries);
    }

    /**
     * 新增账户管理信息
     * 
     * @param devEntries 作品管理对象
     */
    public void insertDevUser(DevEntries devEntries)
    {
        List<DevUser> devUserList = devEntries.getDevUserList();
        Long entriesId = devEntries.getEntriesId();
        if (StringUtils.isNotNull(devUserList))
        {
            List<DevUser> list = new ArrayList<DevUser>();
            for (DevUser devUser : devUserList)
            {
                devUser.setId(entriesId);
                list.add(devUser);
            }
            if (list.size() > 0)
            {
                devEntriesMapper.batchDevUser(list);
            }
        }
    }
}
