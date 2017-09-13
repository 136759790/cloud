package org.service.hi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApp {
    public static void main( String[] args ){
        SpringApplication.run(ServiceHiApp.class, args);
    }
    
    @Value("${server.port}")
    String port;
    @GetMapping("/hi")
    public String home(String name){
    	return "hello:"+name+"->"+port;
    }
}
