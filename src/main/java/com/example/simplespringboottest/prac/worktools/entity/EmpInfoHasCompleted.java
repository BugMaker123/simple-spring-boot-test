package com.example.simplespringboottest.prac.worktools.entity;

import lombok.Data;

/**
 * @ ClassName: EmpInfoHasCompleted
 * @Author: legen
 * @Date: 2021/3/17
 */
@Data
public class EmpInfoHasCompleted {
    /**
     * 大区ID
     */
    private String rgId;
    /**
     * 大区名称
     */
    private String rgName;
   /* *//**
     * 父级网点编码
     *//*
    private String parentCpCode;
    *//**
     * 父级网点名称
     *//*
    private String parentCpName;*/
    /**
     * 网点编码
     */
    private String cpCode;
    /**
     * 网点名称
     */
    private String cpName;
    /**
     * 员工姓名
     */
    private String realName;
    /**
     * 部门编码
     */
    private String deptCode;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 岗位编码
     */
    private String jobCode;
    /**
     * 岗位名称
     */
    private String jobName;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer gender;
    /**
     * 是否离职
     */
    private Integer workingState;
    /**
     * 经营模式
     */
    private Integer businessModel;
}
