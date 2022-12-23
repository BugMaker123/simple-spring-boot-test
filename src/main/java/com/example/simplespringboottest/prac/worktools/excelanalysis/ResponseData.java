package com.example.simplespringboottest.prac.worktools.excelanalysis;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ ClassName: ResponseData
 * @Author: legen
 * @Date: 2021/4/20
 */
@Data
public class ResponseData implements Serializable {
    private Integer code;

    private String msg;

    private List<ResultData> data;
}
