package com.lucamartinelli.app.simplesite.home.ejb;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.lucamartinelli.app.simplesite.home.vo.ServiceVO;

@LocalBean
@Stateless
public class ServicesEJB {
	
	private final Logger log;
	
	@ConfigProperty(name = "services.discovery.endpoint")
	private String serviceDiscoveryEndpoint;
	
	public ServicesEJB() {
		log = Logger.getLogger(this.getClass().getCanonicalName());
	}
	
	
	public List<ServiceVO> loadServices(final String jwt) {
		log.fine("Building client for endpoint: " + serviceDiscoveryEndpoint);
		log.fine("JWT used is --> " + jwt);
		final Client client = ClientBuilder.newClient();
		final WebTarget webTarget = client.target(serviceDiscoveryEndpoint);
		final ServiceVO[] services = webTarget.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + jwt)
				.get(ServiceVO[].class);
		return Arrays.asList(services);
	}
	
	
}
