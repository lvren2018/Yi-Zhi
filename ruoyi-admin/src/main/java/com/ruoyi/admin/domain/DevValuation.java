package com.ruoyi.admin.domain;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评价管理对象 dev_valuation
 * 
 * @author 曾令根
 * @date 2024-06-05
 */
public class DevValuation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    @ApiModelProperty(value = "id")
    private Long id;

    /** 教学实施 */
    @ApiModelProperty(value = "教学实施")
    @Excel(name = "教学实施")
    private Long teachingImplementationScore;

    /** 教案 */
    @ApiModelProperty(value = "教案")
    @Excel(name = "教案")
    private Long teachingPlanScore;

    /** 视频资料 */
    @ApiModelProperty(value = "视频资料")
    @Excel(name = "视频资料")
    private Long videoMaterialsScore;

    /** 专业人才培养方案 */
    @ApiModelProperty(value = "专业人才培养方案")
    @Excel(name = "专业人才培养方案")
    private Long trainingPlanScore;

    /** 课程标准 */
    @Excel(name = "课程标准")
    @ApiModelProperty(value = "课程标准")
    private Long curriculumCriterionScore;

    /** 教材选用 */
    @Excel(name = "教材选用")
    @ApiModelProperty(value = "教材选用")
    private Long textbookSelectionScore;

    /** 作品ID */
    @ApiModelProperty(value = "作品ID")
    @Excel(name = "作品ID")
    private Long entriesId;

    /** 评委名 */
    @ApiModelProperty(value = "评委名")
    @Excel(name = "评委名")
    private String createName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTeachingImplementationScore(Long teachingImplementationScore) 
    {
        this.teachingImplementationScore = teachingImplementationScore;
    }

    public Long getTeachingImplementationScore() 
    {
        return teachingImplementationScore;
    }
    public void setTeachingPlanScore(Long teachingPlanScore) 
    {
        this.teachingPlanScore = teachingPlanScore;
    }

    public Long getTeachingPlanScore() 
    {
        return teachingPlanScore;
    }
    public void setVideoMaterialsScore(Long videoMaterialsScore) 
    {
        this.videoMaterialsScore = videoMaterialsScore;
    }

    public Long getVideoMaterialsScore() 
    {
        return videoMaterialsScore;
    }
    public void setTrainingPlanScore(Long trainingPlanScore) 
    {
        this.trainingPlanScore = trainingPlanScore;
    }

    public Long getTrainingPlanScore() 
    {
        return trainingPlanScore;
    }
    public void setCurriculumCriterionScore(Long curriculumCriterionScore) 
    {
        this.curriculumCriterionScore = curriculumCriterionScore;
    }

    public Long getCurriculumCriterionScore() 
    {
        return curriculumCriterionScore;
    }
    public void setTextbookSelectionScore(Long textbookSelectionScore) 
    {
        this.textbookSelectionScore = textbookSelectionScore;
    }

    public Long getTextbookSelectionScore() 
    {
        return textbookSelectionScore;
    }
    public void setEntriesId(Long entriesId) 
    {
        this.entriesId = entriesId;
    }

    public Long getEntriesId() 
    {
        return entriesId;
    }
    public void setCreateName(String createName) 
    {
        this.createName = createName;
    }

    public String getCreateName() 
    {
        return createName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teachingImplementationScore", getTeachingImplementationScore())
            .append("teachingPlanScore", getTeachingPlanScore())
            .append("videoMaterialsScore", getVideoMaterialsScore())
            .append("trainingPlanScore", getTrainingPlanScore())
            .append("curriculumCriterionScore", getCurriculumCriterionScore())
            .append("textbookSelectionScore", getTextbookSelectionScore())
            .append("createTime", getCreateTime())
            .append("entriesId", getEntriesId())
            .append("createName", getCreateName())
            .toString();
    }
}
