package com.sample.app;

import com.sample.resource.JaxrsController;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(JaxrsController.class);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }

}
