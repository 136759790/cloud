package org.service.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Autowired
	SchedualServiceHi schedualServiceHi;
	
	@RequestMapping(value="/hi",method=RequestMethod.GET)
	public String sayHi(String name){
		return schedualServiceHi.sayHi(name);
	}
}
