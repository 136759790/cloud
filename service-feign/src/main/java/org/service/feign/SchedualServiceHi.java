package org.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="service-hi",fallback=SchedualServiceHiHystrix.class)
public interface SchedualServiceHi {
	@RequestMapping(value="/hi",method=RequestMethod.GET)
	String sayHi(@RequestParam(value="name") String name);
}
