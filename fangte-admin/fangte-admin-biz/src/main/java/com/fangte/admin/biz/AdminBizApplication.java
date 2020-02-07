package com.fangte.admin.biz;


import com.fangte.admin.api.annotation.EnableResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 系统API业务接口 admin
 *
 * @date
 */
@EnableResourceServer
@MapperScan("com.fangte.admin.biz.mapper")
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class AdminBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminBizApplication.class, args);
    }
}
