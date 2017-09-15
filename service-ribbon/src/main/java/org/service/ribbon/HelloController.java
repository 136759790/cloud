package org.service.ribbon;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ch.qos.logback.classic.Logger;

@RestController
public class HelloController {
	private static Logger logger=(Logger) LoggerFactory.getLogger(HelloController.class.getName());
	@Autowired
	HelloService helloService;
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/hi")
	public String hi(String name){
		return helloService.sayHi(name);
	}
	
	@GetMapping("/hizip")
	public String hizip(){
		logger.info("--------------------------->进入到service-ribbon的hizip");
		return restTemplate.getForObject("http://SERVICE-HI/home", String.class);
	}
	@GetMapping("/home")
	public String home(){
		return "i'm from service-ribbon";
	}
}
