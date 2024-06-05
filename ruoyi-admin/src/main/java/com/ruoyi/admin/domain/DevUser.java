package com.ruoyi.admin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 账户管理对象 dev_user
 * 
 * @author 曾令根
 * @date 2024-06-04
 */
public class DevUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 身份 */
    @Excel(name = "身份")
    private String identity;

    /** 学校 */
    @Excel(name = "学校")
    private String school;

    /** 账号名 */
    @Excel(name = "账号名")
    private String userName;

    /** 密码 */
    private String password;

    /** ID */
    private Long id;

    /** 报名分组 */
    @Excel(name = "报名分组")
    private String groupName;

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setIdentity(String identity) 
    {
        this.identity = identity;
    }

    public String getIdentity() 
    {
        return identity;
    }
    public void setSchool(String school) 
    {
        this.school = school;
    }

    public String getSchool() 
    {
        return school;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setGroupName(String groupName) 
    {
        this.groupName = groupName;
    }

    public String getGroupName() 
    {
        return groupName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("name", getName())
            .append("identity", getIdentity())
            .append("school", getSchool())
            .append("userName", getUserName())
            .append("password", getPassword())
            .append("id", getId())
            .append("groupName", getGroupName())
            .toString();
    }
}
