package es.thalesalv;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class MicroservicesCourseHystrixApplication {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/startclient")
	@HystrixCommand(fallbackMethod = "failOver")
	public List<String> startClient() {
		return this.restTemplate.getForObject("http://localhost:8888/service", List.class);
	}

	public List<String> failOver() {
		return Arrays.asList("default1", "default2");
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCourseHystrixApplication.class, args);
	}

}
