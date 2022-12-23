package com.example.simplespringboottest.prac.worktools;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询人员信息详情-resp
 */
@Data
public class EmpInfoQueryRespDTO implements Serializable {
    /**
     * 基本信息主键id
     */
    private Integer empId;
    /**
     * 工作信息主键id
     */
    private Integer empJobId;
     /**
     * 网点名称
     */
    private String networkName;
     /**
     * 网点编码
     */
    private String cpCode;
     /**
     * 真实姓名
     */
    private String realName;
     /**
     * 昵称
     */
    private String nickName;
     /**
     * soa工号
     */
    private String empCode;
     /**
     * 人员来源(soa,ywy，银河)
     */
    private Integer source;
     /**
     * 工作状态
     */
    private Integer workingState;
     /**
     * 入职日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date hiredate;
     /**
     * 离职日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date leavingDate;
    /**
     * 锁定时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date lockingTime;
     /**
     * 部门编码
     */
    private String departmentCode;
    /**
     * 部门名称
     */
    private String departmentName;
     /**
     * 运营模式
     */
    private Integer businessModel;
    /**
     * 岗位编码
     */
    private String jobCode;
     /**
     * 岗位名称
     */
    private String jobName;
     /**
     * 岗位类型
     */
    private Integer jobType;
     /**
     * 岗位级别
     */
    private Integer jobLevel;
     /**
     * 身份证号码
     */
    private String cardNo;
    /**
     * 证件类型
     */
    private String cardType;
     /**
     * 性别
     */
    private Integer gender;
     /**
     * 年龄
     */
    private Integer age;
     /**
     * 手机号码
     */
    private String phoneNo;
     /**
     * 籍贯
     */
    private String nativePlace;
     /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date createTime;
     /**
     * 创建人姓名
     */
    private String createUser;
     /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date updateTime;
     /**
     * 修改人名字
     */
    private String updateUser;
    /**
     * 转正日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date positiveDate;
    /**
     * 业务员编码
     */
    private String courierCode;
    /**
     * 业务员类型 1：网点职能员工， 2：业务员 ，3：总部职能'
     */
    private Integer empType;
}
