package com.example.simplespringboottest.prac.worktools.entity;

import lombok.Data;

/**
 * @ ClassName: EmpInfoNotCompleted
 * @Author: legen
 * @Date: 2021/3/17
 */
@Data
public class EmpInfoNotCompleted {
    /**
     * 大区ID
     */
    private String rgId;
    /**
     * 大区名称
     */
    private String rgName;
    /**
     * 父级网点编码
     */
    private String parentCpCode;
    /**
     * 父级网点名称
     */
    private String parentCpName;
    /**
     * 网点编码
     */
    private String cpCode;
    /**
     * 网点名称
     */
    private String cpName;
    /**
     * 员工工号
     */
    private String empCode;
    /**
     * 员工姓名
     */
    private String realName;
}
