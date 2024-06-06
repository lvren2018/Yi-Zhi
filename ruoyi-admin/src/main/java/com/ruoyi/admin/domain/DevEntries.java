package com.ruoyi.admin.domain;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 作品管理对象 dev_entries
 * 
 * @author ruoyi
 * @date 2024-06-05
 */
public class DevEntries extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 作品名 */
    @ApiModelProperty(value = "作品名")
    @Excel(name = "作品名")
    private String entries;

    /** 主键 */
    @ApiModelProperty(value = "ID")
    private Long entriesId;

    /** 联系方式 */
    @ApiModelProperty(value = "联系方式")
    @Excel(name = "联系方式")
    private String phone;

    /** 实时平均分 */
    @ApiModelProperty(value = "平均分")
    @Excel(name = "实时平均分")
    private Long score;

    /** 账号ID */
    @ApiModelProperty(value = "账号ID")
    private Long userId;

    public void setEntries(String entries) 
    {
        this.entries = entries;
    }

    public String getEntries() 
    {
        return entries;
    }
    public void setEntriesId(Long entriesId) 
    {
        this.entriesId = entriesId;
    }

    public Long getEntriesId() 
    {
        return entriesId;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("entries", getEntries())
            .append("entriesId", getEntriesId())
            .append("phone", getPhone())
            .append("score", getScore())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
