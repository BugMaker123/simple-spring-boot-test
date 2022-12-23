package com.example.simplespringboottest.prac.practice.annoation;

import lombok.Data;

/**
 * @ ClassName: User
 * @Author: legen
 * @Date: 2021/1/25
 */
@Data
public class User {
    private String userName;
    @NotNull(message = "密码不能为空")
    private String password;
}
