package com.example.btvn_buoi_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BtvnBuoi3Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BtvnBuoi3Application.class, args);
        Store authController = context.getBean(Store.class);

    }


}
