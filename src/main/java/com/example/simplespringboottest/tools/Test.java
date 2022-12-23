package com.example.simplespringboottest.tools;


import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;

public class Test {
    public static String ADDRESS = "https://zhihu-web-analytics.zhihu.com/api/v2/za/logs/batch";

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = HttpClientUtil.doPostJson(ADDRESS, JSON.toJSONString(""));
        System.out.println(s);
    }
}
