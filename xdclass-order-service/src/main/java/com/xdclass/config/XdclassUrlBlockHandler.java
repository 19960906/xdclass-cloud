package com.xdclass.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *设置服务异常的同意返回
 */
@Component
public class XdclassUrlBlockHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        Map<String,Object> info = new HashMap<>();
        /*
         *判断异常类型
         */
        //流量异常
        if (e instanceof FlowException){
            info.put("code",-1);
            info.put("message","限流异常");
        }else if (e instanceof DegradeException){
            info.put("code",-2);
            info.put("message","降级异常");
        }else if (e instanceof ParamFlowException){
            info.put("code",-3);
            info.put("message","热点参数异常");
        }else if (e instanceof SystemBlockException){
            info.put("code",-4);
            info.put("message","系统异常");
        }else if (e instanceof AuthorityException){
            info.put("code",-5);
            info.put("message","授权异常");
        }
        //设置返回状态码
        response.setStatus(200);
        //设置返回数据格式
        response.setHeader("content-type","application/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(info));
    }
}