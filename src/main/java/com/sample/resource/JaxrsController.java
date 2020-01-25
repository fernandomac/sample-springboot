package com.sample.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.service.SampleClientProxy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@Component
public class JaxrsController {

	@Autowired
	private SampleClientProxy simpleClientProxy;
	
    @GET
    @Produces("application/json")
    public String getAllUsers() {
        return "Jersey is working";
    }
    
    @GET
    @Path("/client")
    public String getDataFromClient() {
    	return simpleClientProxy.getDataFromClient();
    }

}
