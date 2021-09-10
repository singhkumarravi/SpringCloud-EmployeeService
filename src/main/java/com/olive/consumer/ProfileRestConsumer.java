package com.olive.consumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProfileRestConsumer {
	@Autowired
	DiscoveryClient clients;

	public String getDataFromEureka() {
		List<ServiceInstance> instances = clients.getInstances("PROFILE-APP");
		ServiceInstance serviceInstance = instances.get(0);
		URI uri = serviceInstance.getUri();
		        String url=uri+"/profile/msg";
		        
		        RestTemplate rt=new RestTemplate();
		        String obs = rt.getForObject(url, String.class);
		            
		return obs;
	}
	
}
