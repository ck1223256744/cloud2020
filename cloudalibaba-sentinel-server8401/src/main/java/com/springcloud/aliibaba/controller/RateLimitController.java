package com.springcloud.aliibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ck.springcloud.entities.CommonResult;
import com.ck.springcloud.entities.Payment;
import com.springcloud.aliibaba.myHandler.customerBlockHanderler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"by Resource OK",new Payment(2020L,"serial001"));
    }

    public CommonResult handleException(BlockException ex){
        return new CommonResult(444,ex.getClass().getCanonicalName()+"\t服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"by URL OK",new Payment(2020L,"serial002"));
    }

    @GetMapping("/rateLimit/customerBlockHanderler")
    @SentinelResource(value = "customerBlockHanderler",blockHandlerClass = customerBlockHanderler.class,blockHandler = "handlerException2")
    public CommonResult customerBlockHanderler(){
        return new CommonResult(200,"by customer definition OK",new Payment(2020L,"serial003"));
    }


}
