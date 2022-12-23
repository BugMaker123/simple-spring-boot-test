package com.example.simplespringboottest.prac.worktools.excelanalysis;

import lombok.Data;

import java.io.Serializable;

/**
 * @ ClassName: BasicData
 * @Author: legen
 * @Date: 2021/4/20
 */
@Data
public class BasicData implements Serializable {
    private Integer row;

    private Integer column;

    private String data;



    public BasicData(Integer row, Integer column, String data) {
        this.row = row;
        this.column = column;
        this.data = data;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
