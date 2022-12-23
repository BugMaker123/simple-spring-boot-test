package com.example.simplespringboottest.prac.practice.annoation.annotationlevel;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @ ClassName: User
 * @Author: legen
 * @Date: 2021/3/25
 */
@Data
public class User {
    private String age;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", locale = "zh", timezone = "GMT+8")
    private Date createDate;
}
