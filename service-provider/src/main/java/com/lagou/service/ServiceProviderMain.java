package com.lagou.service;

import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

public class ServiceProviderMain {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ServiceProviderConfigration.class);
        applicationContext.start();
        //System.in.read();
        while(true){

        }
    }
    @Configuration
    @EnableDubbo(scanBasePackages="com.lagou.service.impl")
    @PropertySource("classpath:/dubbo-provider.properties")
    static class ServiceProviderConfigration{
        @Bean
        public RegistryConfig registryConfig(){
            RegistryConfig registryConfig = new RegistryConfig();

            registryConfig.setAddress("zookeeper://192.168.230.130:2181?timeout=10000");
            return registryConfig;
        }
    }
}
