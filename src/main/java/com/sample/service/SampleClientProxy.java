package com.sample.service;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;
import org.springframework.stereotype.Component;

@Component
public class SampleClientProxy {

	private Client client;
	
	public SampleClientProxy() {
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), 
				Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
		this.client = ClientBuilder.newClient(config);
	}

	@SuppressWarnings("unchecked")
	public String getDataFromClient() {
		Map<String, Object> response = client
			.target("https://us-central1-fernando-machado.cloudfunctions.net")
			.path("/indice-validacao")
			.request(MediaType.APPLICATION_JSON)
			.get(Map.class);
				
		return response.toString();		
		
	}
	
}
