package com.sample.service;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;
import org.springframework.stereotype.Component;

import com.sample.service.domain.SampleRequest;

@Component
public class SampleClientProxy {

	private Client client;
	
	public SampleClientProxy() {
		ClientConfig config = new ClientConfig();
		config.register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME), 
				Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
		this.client = ClientBuilder.newClient(config);
	}

	public Response getDataFromClient() {
		Response response = client
			.target("https://us-central1-fernando-machado.cloudfunctions.net")
			.path("/indice-validacao")
			.request(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.get();
		
		return response;		
		
	}
	
	public SampleRequest postDataToClient() {
		Entity<SampleRequest> entity = Entity.json(new SampleRequest(1L, "name", new Date(), 123.45));
		
		SampleRequest response = client
			.target("https://us-central1-fernando-machado.cloudfunctions.net")
			.path("/sample-post")
			.request(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)
			.post(entity, SampleRequest.class);
		
		return response;
		
	}
	
}
