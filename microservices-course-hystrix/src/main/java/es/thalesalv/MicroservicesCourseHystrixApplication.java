package es.thalesalv;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class MicroservicesCourseHystrixApplication {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/startclient")
	@HystrixCommand(fallbackMethod = "failOver", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500") })
	public List<String> startClient(@RequestParam long time) throws InterruptedException {
		Thread.sleep(time);
		return this.restTemplate.getForObject("http://localhost:8888/service", List.class);
	}

	public List<String> failOver(long time) {
		return Arrays.asList("default1", "default2");
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCourseHystrixApplication.class, args);
	}

}
