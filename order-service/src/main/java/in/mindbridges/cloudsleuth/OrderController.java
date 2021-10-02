package in.mindbridges.cloudsleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping("/order/{orderId}")
	public String foo(@PathVariable String orderId) {
		
		logger.info("order id - {}", orderId);
		
		return "your order "+ orderId +" has been placed";
	}

}
