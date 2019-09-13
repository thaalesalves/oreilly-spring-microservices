package es.thalesalv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroservicesCourseEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCourseEurekaClientApplication.class, args);
	}

}
