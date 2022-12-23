package com.example.simplespringboottest.prac.worktools.delete205data;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 员工工作信息
 * </p>
 *
 * @author dyh
 * @since 2020-07-22
 */
@Data
public class PcEmployeeJobInfoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 员工基本信息表主键id
     */
    private Integer empId;

    /**
     * 员工编码即工号
     */
    private String empCode;

    /**
     * 入职日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date hiredate;

    /**
     * 试用期期限
     */
    private Integer period;

    /**
     * 转正日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date positiveDate;

    /**
     * 离职日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Long leavingDate;


    /**
     * 锁定时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date lockingTime;

    /**
     * 是否交接完毕（0默认，1是，2否）
     */
    private Integer handover;

    /**
     * 在职状态（2-离职，0-试用，1-正式 ，3-在职,4-锁定 ）
     */
   private Integer workingState;

    /**
     * 部门编码
     */
    private String departmentCode;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     *  部门级别
     */
    private Integer departmentLevel;

    /**
     * 网点编码
     */
    private String cpCode;

    /**
     * 岗位编码
     */
    private String jobCode;

    /**
     * 岗位名称
     */
    private String jobName;

    /**
     * 岗位级别
     */
    private Integer jobLevel;

    /**
     * 岗位类型
     */
    private Integer jobType;

    /**
     * 业务员口令
     */
    private String operatorPassword;

    /**
     * 业务模块
     */
    private String businessModule;

    /**
     * 运营类型  1：直营和2：承包'
     */
    private String businessModel;

    /**
     * 工业手机
     */
    private String industryMobile;

    /**
     * 业务员类型：0-表示组织,1-表示个人
     */
    private Integer courierType;

    /**
     * 业务员编码长度4位
     */
    private Integer courierCode;

    /**
     * 数据来源（0 银河 1 soa 2 业务员 3 彩虹桥移动端）
     */
    private Integer source;

    /**
     * 客户编码
     */
    private String customCode;

    /**
     * 客户名称
     */
    private String customName;

    /**
     * 1：职能员工， 2：业务员， 3：非员工
     */
    private Integer empType;

    /**
     * 韵达账号：0-需韵达账号；1-无需韵达账号
     */
    private Integer accountYunda;

    /**
     * 揽件码
     */
    private String packageCode;

    /**
     * 业务员APP登陆密码
     */
    private String mkl;

    /**
     * 员工组
     */
    private String empGroup;

    /**
     * 员工组的名称
     */
    private String empGroupName;

    /**
     * 成本中心
     */
    private String zkostl;

    /**
     * 成本中心描述
     */
    private String zkostlName;

    /**
     * 0 有效 1 删除
     */
    private Integer delFlag = 0;

    /**
     * 新的部门编码
     */

    private String newDepmentCode;

    /**
     * 新的岗位编码
     */
    private String newJobCode;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Long updateTime;

    /**
     * 更新人编码
     */
    private String updateUserCode;

    /**
     * 更新人姓名
     */
    private String updateUser;
}

