package com.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PamentMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(PamentMain9003.class,args);
    }
}
