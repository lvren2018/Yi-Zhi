package com.ruoyi.admin.domain;

import com.ruoyi.common.annotation.Excel;
import lombok.Data;

@Data
public class ValuationDTO {

    /** 学校 */
    @Excel(name = "学校")
    private String school;

    /** 作品名 */
    @Excel(name = "作品名")
    private String entries;

    /** 评委名 */
    @Excel(name = "评委名")
    private String createName;

    /** 教学实施 */
    @Excel(name = "教学实施")
    private Long teachingImplementationScore;

    /** 教案 */
    @Excel(name = "教案")
    private Long teachingPlanScore;

    /** 视频资料 */
    @Excel(name = "视频资料")
    private Long videoMaterialsScore;

    /** 专业人才培养方案 */
    @Excel(name = "专业人才培养方案")
    private Long trainingPlanScore;

    /** 课程标准 */
    @Excel(name = "课程标准")
    private Long curriculumCriterionScore;

    /** 教材选用 */
    @Excel(name = "教材选用")
    private Long textbookSelectionScore;

    /** 得分 */
    @Excel(name = "得分")
    private Long score;

}
