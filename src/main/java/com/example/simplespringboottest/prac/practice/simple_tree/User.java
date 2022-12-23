package com.example.simplespringboottest.prac.practice.simple_tree;

import lombok.Data;

/**
 * @ ClassName: User
 * @Author: legen
 * @Date: 2021/4/16
 */
@Data
public class User {
    private Integer id;

    private String userName;

    private String password;

    private Integer jobLevel;

    private String jobName;

    private String deptName;

    private String deptCode;
}
