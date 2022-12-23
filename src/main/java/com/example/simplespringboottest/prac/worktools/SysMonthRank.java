package com.example.simplespringboottest.prac.worktools;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 月考核得分对象 sys_month_rank
 * 
 * @author ruoyi
 * @date 2022-03-06
 */
public class SysMonthRank
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 部门id */
    private Long deptId;

    /** 部门名称 */
    private String deptName;

    /** 人员id */
    private Long userId;

    /** 服刑编号 */
    private String loginName;

    /** 姓名 */
    private String userName;

    /** 统计时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date statisticDate;

    /** 工种类型 */
    private String workType;

    /** 工种名称 */
    private String workTypeName;

    /** 车工等级 */
    private String cutLevel;

    /** 月度产值 */
    private BigDecimal monthValue;

    /** 月度任务 */
    private BigDecimal monthTask;

    /** 完成率 */
    private BigDecimal completion;

    /** 出工天数 */
    private Long attendanceDays;

    /** 日均产值 */
    private BigDecimal dayValue;
    /** 日均产值 */
    private BigDecimal dayTask;

    /** 基础得分 */
    private BigDecimal baseStore;
    /** 月考核得分 */
    private Integer mothStore;

    /** 排名 */
    private Integer ranks;

    /** 修改人编码 */
    private String updateUserCode;

    /** 修改人姓名 */
    private String updateUserName;

    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setStatisticDate(Date statisticDate) 
    {
        this.statisticDate = statisticDate;
    }

    public Date getStatisticDate() 
    {
        return statisticDate;
    }
    public void setWorkType(String workType) 
    {
        this.workType = workType;
    }

    public String getWorkType() 
    {
        return workType;
    }
    public void setWorkTypeName(String workTypeName) 
    {
        this.workTypeName = workTypeName;
    }

    public String getWorkTypeName() 
    {
        return workTypeName;
    }
    public void setCutLevel(String cutLevel) 
    {
        this.cutLevel = cutLevel;
    }

    public String getCutLevel() 
    {
        return cutLevel;
    }
    public void setMonthValue(BigDecimal monthValue) 
    {
        this.monthValue = monthValue;
    }

    public BigDecimal getMonthValue() 
    {
        return monthValue;
    }
    public void setMonthTask(BigDecimal monthTask) 
    {
        this.monthTask = monthTask;
    }

    public BigDecimal getMonthTask() 
    {
        return monthTask;
    }
    public void setCompletion(BigDecimal completion) 
    {
        this.completion = completion;
    }

    public BigDecimal getCompletion() 
    {
        return completion;
    }
    public void setAttendanceDays(Long attendanceDays) 
    {
        this.attendanceDays = attendanceDays;
    }

    public Long getAttendanceDays() 
    {
        return attendanceDays;
    }
    public void setDayValue(BigDecimal dayValue) 
    {
        this.dayValue = dayValue;
    }

    public BigDecimal getDayValue() 
    {
        return dayValue;
    }
    public void setMothStore(Integer mothStore)
    {
        this.mothStore = mothStore;
    }

    public Integer getMothStore()
    {
        return mothStore;
    }
    public void setRanks(Integer ranks)
    {
        this.ranks = ranks;
    }

    public Integer getRanks()
    {
        return ranks;
    }
    public void setUpdateUserCode(String updateUserCode) 
    {
        this.updateUserCode = updateUserCode;
    }

    public String getUpdateUserCode() 
    {
        return updateUserCode;
    }
    public void setUpdateUserName(String updateUserName) 
    {
        this.updateUserName = updateUserName;
    }

    public String getUpdateUserName() 
    {
        return updateUserName;
    }

    public BigDecimal getDayTask() {
        return dayTask;
    }

    public void setDayTask(BigDecimal dayTask) {
        this.dayTask = dayTask;
    }

    public BigDecimal getBaseStore() {
        return baseStore;
    }

    public void setBaseStore(BigDecimal baseStore) {
        this.baseStore = baseStore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("userId", getUserId())
            .append("loginName", getLoginName())
            .append("userName", getUserName())
            .append("statisticDate", getStatisticDate())
            .append("workType", getWorkType())
            .append("workTypeName", getWorkTypeName())
            .append("cutLevel", getCutLevel())
            .append("monthValue", getMonthValue())
            .append("monthTask", getMonthTask())
            .append("completion", getCompletion())
            .append("attendanceDays", getAttendanceDays())
            .append("dayValue", getDayValue())
            .append("mothStore", getMothStore())
            .append("ranks", getRanks())
            .append("updateUserCode", getUpdateUserCode())
            .append("updateUserName", getUpdateUserName())
            .append("updateTime", getUpdateTime())
            .append("dayTask", getDayTask())
            .append("baseStore", getBaseStore())
            .toString();
    }
}
