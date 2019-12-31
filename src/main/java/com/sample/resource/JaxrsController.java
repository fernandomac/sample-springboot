package com.sample.resource;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
@Component
public class JaxrsController {

    @GET
    @Produces("application/json")
    public String getAllUsers() {
        return "Jersey is working";
    }

}
