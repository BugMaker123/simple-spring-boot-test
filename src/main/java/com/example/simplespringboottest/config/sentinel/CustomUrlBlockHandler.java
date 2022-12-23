/*
package com.example.simplespringboottest.config.sentinel;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.yundasys.basicinfo.common.utils.JsonUtils;
import com.yundasys.basicinfo.result.ResultCode;
import com.yundasys.basicinfo.result.ResultModel;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CustomUrlBlockHandler implements UrlBlockHandler {
    @Override
    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
        httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
        log.error("触发限流保护机制，资源路径：{}，调用方：{}",e.getRule().getResource(),e.getRuleLimitApp());
        String message = JsonUtils.toJSONString(ResultModel.createResult(ResultCode.SERVER_BUSY));
        httpServletResponse.getWriter().write(message);
    }
}
*/
