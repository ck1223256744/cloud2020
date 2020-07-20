package com.springcloud.aliibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinalServerMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinalServerMain8401.class,args);
    }
}
