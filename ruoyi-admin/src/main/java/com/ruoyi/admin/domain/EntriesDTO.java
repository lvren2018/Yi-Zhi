package com.ruoyi.admin.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EntriesDTO {
    /** 学校 */
    @Excel(name = "学校")
    private String school;

    /** 报名分组 */
    @Excel(name = "报名分组")
    private String groupName;

    /** 作品名 */
    @Excel(name = "作品名")
    private String entries;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 实时平均分 */
    @Excel(name = "实时平均分")
    private Long score;

    /** 提交时间 */
    @Excel(name = "提交时间")
    private LocalDateTime createTime;
}
