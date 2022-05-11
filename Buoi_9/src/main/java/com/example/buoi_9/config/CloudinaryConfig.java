package com.example.buoi_9.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary config(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "dhr3hjtd3");
        config.put("apk_key", "771816697161379");
        config.put("api_secret", "iLdtT_AOuPQuTbe7cJNJEHGqhpQ");
        return new Cloudinary(config);
    }
}
