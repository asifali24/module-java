package com.module1.firstModule;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//    @Bean
    PaymentService test(){
        return new PaymentService();
    }
}
