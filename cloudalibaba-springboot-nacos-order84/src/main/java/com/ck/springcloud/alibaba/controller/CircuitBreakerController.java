package com.ck.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ck.springcloud.alibaba.service.PaymentService;
import com.ck.springcloud.entities.CommonResult;
import com.ck.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class CircuitBreakerController {
    public static final String SERVICE_URL="http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallbak",fallback = "handlerFallback")
    @SentinelResource(value = "fallbak",blockHandler = "handlerBlock",fallback = "handlerFallback",exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult<Payment> result=restTemplate.getForObject(SERVICE_URL+"/paymentSQL/"+id,CommonResult.class);
        if(id==4){
            throw new IllegalArgumentException("非法参数");
        }else if(result.getData()==null){
            throw new NullPointerException("空指针异常");
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable("id") Long id) {
        return new CommonResult<>(444,"handlerFallback,exception  o(╥﹏╥)o  ");
    }

    public CommonResult handlerBlock(@PathVariable Long id, BlockException block){
        return new CommonResult(445,"handlerBlock,exception o(╥﹏╥)o");
    }

    @Resource
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult paymentSQL(@PathVariable Long id){
        return paymentService.paymentSQL(id);
    }

}
