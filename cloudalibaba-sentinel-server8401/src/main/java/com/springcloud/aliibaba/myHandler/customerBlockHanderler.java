package com.springcloud.aliibaba.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ck.springcloud.entities.CommonResult;

public class customerBlockHanderler {
    public static CommonResult handlerException1(BlockException ex){
        return new CommonResult(4444,"global definition handlerException----1");
    }

    public static CommonResult handlerException2(BlockException ex){
        return new CommonResult(4444,"global definition handlerException----2");
    }
}
