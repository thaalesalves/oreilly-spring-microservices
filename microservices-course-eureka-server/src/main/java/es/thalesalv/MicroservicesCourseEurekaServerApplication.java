package es.thalesalv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicesCourseEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCourseEurekaServerApplication.class, args);
	}

}
