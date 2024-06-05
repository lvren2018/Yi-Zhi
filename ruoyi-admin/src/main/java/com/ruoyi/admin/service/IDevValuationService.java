package com.ruoyi.admin.service;

import java.util.List;
import com.ruoyi.admin.domain.DevValuation;
import com.ruoyi.admin.domain.ValuationDTO;

/**
 * 评价管理Service接口
 * 
 * @author 曾令根
 * @date 2024-06-05
 */
public interface IDevValuationService 
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
     * 批量删除评价管理
     * 
     * @param ids 需要删除的评价管理主键集合
     * @return 结果
     */
    public int deleteDevValuationByIds(Long[] ids);

    /**
     * 删除评价管理信息
     * 
     * @param id 评价管理主键
     * @return 结果
     */
    public int deleteDevValuationById(Long id);

    /**
     * 获取作品评价列表
     * @param devValuation
     * @return
     */
    List<ValuationDTO> getList(DevValuation devValuation);
}
