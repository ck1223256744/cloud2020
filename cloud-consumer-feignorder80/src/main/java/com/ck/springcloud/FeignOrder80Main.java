package com.ck.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignOrder80Main {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrder80Main.class,args);
    }
}
