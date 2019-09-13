package es.thalesalv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class SimpleServiceConfiguration {

	@Autowired
	public IClientConfig ribbonClientConfig;
	
	@Bean
	public IPing ping() {
		return new PingUrl();
	}
	
	@Bean
	public IRule rule(IClientConfig config) {
		return new AvailabilityFilteringRule();
	}
}
