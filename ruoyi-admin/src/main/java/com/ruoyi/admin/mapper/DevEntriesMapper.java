package com.ruoyi.admin.mapper;

import java.util.List;
import com.ruoyi.admin.domain.DevEntries;
import com.ruoyi.admin.domain.DevUser;
import com.ruoyi.admin.domain.EntriesDTO;

/**
 * 作品管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public interface DevEntriesMapper 
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
     * 删除作品管理
     * 
     * @param entriesId 作品管理主键
     * @return 结果
     */
    public int deleteDevEntriesByEntriesId(Long entriesId);

    /**
     * 批量删除作品管理
     * 
     * @param entriesIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDevEntriesByEntriesIds(Long[] entriesIds);

    /**
     * 批量删除账户管理
     * 
     * @param entriesIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDevUserByIds(Long[] entriesIds);
    
    /**
     * 批量新增账户管理
     * 
     * @param devUserList 账户管理列表
     * @return 结果
     */
    public int batchDevUser(List<DevUser> devUserList);
    

    /**
     * 通过作品管理主键删除账户管理信息
     * 
     * @param entriesId 作品管理ID
     * @return 结果
     */
    public int deleteDevUserById(Long entriesId);

    /**
     * 查询作品管理列表
     * @param devEntries
     * @return
     */
    List<EntriesDTO> getList(DevEntries devEntries);
}
