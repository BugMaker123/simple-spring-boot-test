package com.example.simplespringboottest.prac.worktools.excelanalysis;

import lombok.Data;

import java.io.Serializable;

/**
 * @ ClassName: ResultData
 * @Author: legen
 * @Date: 2021/4/20
 */
@Data
public class ResultData implements Serializable {
    private String emp_code;
    private String w_qulality_cn;

}
