package com.springcloud.aliibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String tA(){
//        try {
//            TimeUnit.MILLISECONDS.sleep(800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info(Thread.currentThread().getName()+"===testA");
        return "testA=====";
    }

    @GetMapping("/testB")
    public String tB(){
        return "testB=====";
    }

    @GetMapping("/testD")
    public String tD(){
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info(Thread.currentThread().getName()+"===testD");
        log.info("异常比");
        int a=1/0;
        return "testD=====";
    }

    @GetMapping("/testE")
    public String tE(){
        log.info("异常数");
        int a=1/0;
        return "testE=====";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException ex){
        return "======deal_testHotKey,o(╥﹏╥)o";
    }


}
