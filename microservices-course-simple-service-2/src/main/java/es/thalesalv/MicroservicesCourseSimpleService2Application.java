package es.thalesalv;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MicroservicesCourseSimpleService2Application {

	@Value("${server.port}")
	public String port;
	
	@RequestMapping("/execute")
	public String execute() {
		return "Hello from " + this.port;
	}
	
	@RequestMapping("/")
	public String status() {
		return "Up!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCourseSimpleService2Application.class, args);
	}

}
