package com.ruoyi.admin.service;

import java.util.List;
import com.ruoyi.admin.domain.DevEntries;
import com.ruoyi.admin.domain.EntriesDTO;

/**
 * 作品管理Service接口
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public interface IDevEntriesService 
{
    /**
     * 查询作品管理
     * 
     * @param entriesId 作品管理主键
     * @return 作品管理
     */
    public DevEntries selectDevEntriesByEntriesId(Long entriesId);

    /**
     * 查询作品管理列表
     * 
     * @param devEntries 作品管理
     * @return 作品管理集合
     */
    public List<DevEntries> selectDevEntriesList(DevEntries devEntries);

    /**
     * 新增作品管理
     * 
     * @param devEntries 作品管理
     * @return 结果
     */
    public int insertDevEntries(DevEntries devEntries);

    /**
     * 修改作品管理
     * 
     * @param devEntries 作品管理
     * @return 结果
     */
    public int updateDevEntries(DevEntries devEntries);

    /**
     * 批量删除作品管理
     * 
     * @param entriesIds 需要删除的作品管理主键集合
     * @return 结果
     */
    public int deleteDevEntriesByEntriesIds(Long[] entriesIds);

    /**
     * 删除作品管理信息
     * 
     * @param entriesId 作品管理主键
     * @return 结果
     */
    public int deleteDevEntriesByEntriesId(Long entriesId);

    List<EntriesDTO> getList(DevEntries devEntries);
}
