package com.ruoyi.admin.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

@Data
public class EnrollDTO {
    /** 作品名 */
    @Excel(name = "作品名")
    private String entries;

    /** 报名分组 */
    @Excel(name = "报名分组")
    private String groupName;

    /** 学校 */
    @Excel(name = "学校")
    private String school;

    /** 团队成员 */
    @Excel(name = "团队成员")
    private String team;

    /** 参赛资格 */
    @Excel(name = "参赛资格")
    private int qualification;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    private int id;

}
