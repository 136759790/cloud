package org.service.feign;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi{

	@Override
	public String sayHi(String name) {
		return "feign:error:"+name;
	}

}
