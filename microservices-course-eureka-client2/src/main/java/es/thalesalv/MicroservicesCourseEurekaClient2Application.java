package es.thalesalv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class MicroservicesCourseEurekaClient2Application {

	@Autowired
	private EurekaClient client;

	@RequestMapping("/serviceinfo")
	public String serviceInfo() {
		InstanceInfo instance = client.getNextServerFromEureka("myOtherClient", false);
		return instance.getHomePageUrl();
	}

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesCourseEurekaClient2Application.class, args);
	}

}
