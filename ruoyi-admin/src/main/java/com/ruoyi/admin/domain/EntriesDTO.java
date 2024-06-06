package com.ruoyi.admin.domain;

import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EntriesDTO {
    /** 学校 */
    @ApiModelProperty(value = "学校")
    @Excel(name = "学校")
    private String school;

    /** 报名分组 */
    @ApiModelProperty(value = "报名分组")
    @Excel(name = "报名分组")
    private String groupName;

    /** 作品名 */
    @ApiModelProperty(value = "作品名")
    @Excel(name = "作品名")
    private String entries;

    /** 姓名 */
    @ApiModelProperty(value = "姓名")
    @Excel(name = "姓名")
    private String name;

    /** 联系方式 */
    @ApiModelProperty(value = "联系方式")
    @Excel(name = "联系方式")
    private String phone;

    /** 实时平均分 */
    @ApiModelProperty(value = "实时平均分")
    @Excel(name = "实时平均分")
    private Long score;

    /** 提交时间 */
    @ApiModelProperty(value = "提交时间")
    @Excel(name = "提交时间")
    private LocalDateTime createTime;
}
