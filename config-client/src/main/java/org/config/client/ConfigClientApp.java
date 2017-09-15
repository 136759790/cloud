package org.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class ConfigClientApp {
    public static void main( String[] args ) {
        SpringApplication.run(ConfigClientApp.class, args);
    }
    
    @Value("${zxt}")
    String foo;
    
    @RequestMapping("/hi")
    public String hi(){
    	return foo;
    }
}
