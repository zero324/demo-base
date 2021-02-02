package com.lagou;

import com.lagou.bean.ServiceConsumerComponent;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

public class ServiceConsumerMain {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConsumerConfigration.class);
        applicationContext.start();
        ServiceConsumerComponent component = applicationContext.getBean(ServiceConsumerComponent.class);
        while(true){
            System.in.read();
            String world = component.sayHello("world");
            System.out.println("调用成功: "+world);
        }

    }
    @Configuration
    @EnableDubbo
    @PropertySource("classpath:/dubbo-consumer.properties")
    @ComponentScan(value="com.lagou.bean")
    static class ConsumerConfigration{

    }
}
