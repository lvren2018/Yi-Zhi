package com.ruoyi.admin.domain;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "姓名")
    @Excel(name = "姓名")
    private String name;

    /** 身份 */
    @ApiModelProperty(value = "身份")
    @Excel(name = "身份")
    private String identity;

    /** 学校 */
    @ApiModelProperty(value = "学校")
    @Excel(name = "学校")
    private String school;

    /** 账号名 */
    @ApiModelProperty(value = "账号名")
    @Excel(name = "账号名")
    private String userName;

    /** 密码 */
    @ApiModelProperty(value = "密码")
    @Excel(name = "密码")
    private String password;

    /** 团队成员 */
    @ApiModelProperty(value = "团队成员")
    @Excel(name = "团队成员")
    private String team;

    /** 联系方式 */
    @ApiModelProperty(value = "个人联系方式")
    @Excel(name = "个人联系方式")
    private String phone;

    /** 参赛资格 */
    @ApiModelProperty(value = "参赛资格")
    @Excel(name = "参赛资格")
    private int qualification;



    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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
        return "DevUser{" +
                "name='" + name + '\'' +
                ", identity='" + identity + '\'' +
                ", school='" + school + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", team='" + team + '\'' +
                ", phone='" + phone + '\'' +
                ", qualification=" + qualification +
                ", id=" + id +
                ", groupName='" + groupName + '\'' +
                '}';
    }

}
