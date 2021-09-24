package in.mindbridges.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("eureka-client")
public interface MyFeignClientForEurekaClientApp {

	@RequestMapping(value = "/service-instances/eureka-client", method = RequestMethod.GET)
	String eurekaClientServiceInstances();
}