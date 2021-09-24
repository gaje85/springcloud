package in.mindbridges.feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableFeignClients
public class FeignClientApplication {
	@Autowired
	MyFeignClientForEurekaClientApp myFeignClientForEurekaClientApp;

	@RequestMapping("/")
	public String eurekaClientServiceInstances() {
		return myFeignClientForEurekaClientApp.eurekaClientServiceInstances();
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}

}
