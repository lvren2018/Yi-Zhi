package com.ruoyi.admin.mapper;

import java.util.List;
import com.ruoyi.admin.domain.DevUser;

/**
 * 账户管理Mapper接口
 * 
 * @author 曾令根
 * @date 2024-06-04
 */
public interface DevUserMapper 
{
    /**
     * 查询账户管理
     * 
     * @param id 账户管理主键
     * @return 账户管理
     */
    public DevUser selectDevUserById(Long id);

    /**
     * 查询账户管理列表
     * 
     * @param devUser 账户管理
     * @return 账户管理集合
     */
    public List<DevUser> selectDevUserList(DevUser devUser);

    /**
     * 新增账户管理
     * 
     * @param devUser 账户管理
     * @return 结果
     */
    public int insertDevUser(DevUser devUser);

    /**
     * 修改账户管理
     * 
     * @param devUser 账户管理
     * @return 结果
     */
    public int updateDevUser(DevUser devUser);

    /**
     * 删除账户管理
     * 
     * @param id 账户管理主键
     * @return 结果
     */
    public int deleteDevUserById(Long id);

    /**
     * 批量删除账户管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDevUserByIds(Long[] ids);
}
