package in.mindbridges.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@RestController
	@RefreshScope
	class ConfigClientController {

		private final String value;

		ConfigClientController(@Value("${foo:not working}") String value) {
			this.value = value;
		}

		@GetMapping("/foo")
		public String foo() {
			return this.value;
		}
	}

}
