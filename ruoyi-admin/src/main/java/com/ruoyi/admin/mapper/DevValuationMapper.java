package com.ruoyi.admin.mapper;

import java.util.List;
import com.ruoyi.admin.domain.DevValuation;
import com.ruoyi.admin.domain.DevEntries;
import com.ruoyi.admin.domain.ValuationDTO;

/**
 * 评价管理Mapper接口
 * 
 * @author 曾令根
 * @date 2024-06-05
 */
public interface DevValuationMapper 
{
    /**
     * 查询评价管理
     * 
     * @param id 评价管理主键
     * @return 评价管理
     */
    public DevValuation selectDevValuationById(Long id);

    /**
     * 查询评价管理列表
     * 
     * @param devValuation 评价管理
     * @return 评价管理集合
     */
    public List<DevValuation> selectDevValuationList(DevValuation devValuation);

    /**
     * 新增评价管理
     * 
     * @param devValuation 评价管理
     * @return 结果
     */
    public int insertDevValuation(DevValuation devValuation);

    /**
     * 修改评价管理
     * 
     * @param devValuation 评价管理
     * @return 结果
     */
    public int updateDevValuation(DevValuation devValuation);

    /**
     * 删除评价管理
     * 
     * @param id 评价管理主键
     * @return 结果
     */
    public int deleteDevValuationById(Long id);

    /**
     * 批量删除评价管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDevValuationByIds(Long[] ids);

    /**
     * 批量删除作品管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDevEntriesByEntriesIds(Long[] ids);
    
    /**
     * 批量新增作品管理
     * 
     * @param devEntriesList 作品管理列表
     * @return 结果
     */
    public int batchDevEntries(List<DevEntries> devEntriesList);
    

    /**
     * 通过评价管理主键删除作品管理信息
     * 
     * @param id 评价管理ID
     * @return 结果
     */
    public int deleteDevEntriesByEntriesId(Long id);

    /**
     * 查询作品管理列表
     * @param devValuation
     * @return
     */
    List<ValuationDTO> getList(DevValuation devValuation);
}
