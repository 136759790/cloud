package org.service.hi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApp {
    public static void main( String[] args ){
        SpringApplication.run(ServiceHiApp.class, args);
    }
    
    @Bean
    public RestTemplate getRestTemplate(){
    	return new RestTemplate();
    }
    @Bean
    public AlwaysSampler alwaysSampler(){
    	return new AlwaysSampler();
    }
    @Autowired
    RestTemplate restTemplate;
    
    @Value("${server.port}")
    String port;
    @GetMapping("/hi")
    public String home(String name){
    	return "hello:"+name+"->"+port;
    }
    
    @GetMapping("/hizip")
    public String hi(){
    	return restTemplate.getForObject("http://SERVICE-RIBBON/home", String.class);
    }
    @GetMapping("/home")
    public String hihome(){
    	return "i'm from service-hi";
    }
}
