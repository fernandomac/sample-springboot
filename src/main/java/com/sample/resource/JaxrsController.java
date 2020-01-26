package com.sample.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.service.SampleClientProxy;
import com.sample.service.domain.SampleRequest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
    @Produces("application/json")
    public Response getDataFromClient() {
    	return simpleClientProxy.getDataFromClient();
    }
    
    @POST
    @Path("/user")
    @Produces("application/json")
    public SampleRequest postDataToClient() {
    	return simpleClientProxy.postDataToClient();
    }

}
