package com.ruoyi.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.admin.mapper.DevUserMapper;
import com.ruoyi.admin.domain.DevUser;
import com.ruoyi.admin.service.IDevUserService;

/**
 * 账户管理Service业务层处理
 * 
 * @author 曾令根
 * @date 2024-06-04
 */
@Service
public class DevUserServiceImpl implements IDevUserService 
{
    @Autowired
    private DevUserMapper devUserMapper;

    /**
     * 查询账户管理
     * 
     * @param id 账户管理主键
     * @return 账户管理
     */
    @Override
    public DevUser selectDevUserById(Long id)
    {
        return devUserMapper.selectDevUserById(id);
    }

    /**
     * 查询账户管理列表
     * 
     * @param devUser 账户管理
     * @return 账户管理
     */
    @Override
    public List<DevUser> selectDevUserList(DevUser devUser)
    {
        return devUserMapper.selectDevUserList(devUser);
    }

    /**
     * 新增账户管理
     * 
     * @param devUser 账户管理
     * @return 结果
     */
    @Override
    public int insertDevUser(DevUser devUser)
    {
        return devUserMapper.insertDevUser(devUser);
    }

    /**
     * 修改账户管理
     * 
     * @param devUser 账户管理
     * @return 结果
     */
    @Override
    public int updateDevUser(DevUser devUser)
    {
        return devUserMapper.updateDevUser(devUser);
    }

    /**
     * 批量删除账户管理
     * 
     * @param ids 需要删除的账户管理主键
     * @return 结果
     */
    @Override
    public int deleteDevUserByIds(Long[] ids)
    {
        return devUserMapper.deleteDevUserByIds(ids);
    }

    /**
     * 删除账户管理信息
     * 
     * @param id 账户管理主键
     * @return 结果
     */
    @Override
    public int deleteDevUserById(Long id)
    {
        return devUserMapper.deleteDevUserById(id);
    }
}
