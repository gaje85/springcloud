package in.mindbridges.cloudsleuth;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {

	Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/order")
	public String foo() {

		Random random = new Random();

		int orderId = random.nextInt();

		logger.info("generated orderId: {}", orderId);

		return restTemplate.getForObject("http://localhost:8083/order/" + orderId, String.class);
	}

}
