package com.ck.springcloud.alibaba.service;

import com.ck.springcloud.entities.CommonResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class fallBackService implements PaymentService{
    @Override
    public CommonResult paymentSQL(Long id) {
        return new CommonResult(444444,"降级返回","降级检查provider");
    }
}
