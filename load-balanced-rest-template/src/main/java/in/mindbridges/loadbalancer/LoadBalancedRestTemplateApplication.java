package in.mindbridges.loadbalancer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class LoadBalancedRestTemplateApplication {
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/")
	public String hello() {
		return restTemplate().getForObject("http://eureka-client/service-instances/eureka-client", String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LoadBalancedRestTemplateApplication.class, args);
	}
}
