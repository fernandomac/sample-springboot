package com.sample.app;

import com.sample.resource.JaxrsController;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(JaxrsController.class);
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
        register(new LoggingFeature(Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME),
        	    Level.INFO, LoggingFeature.Verbosity.PAYLOAD_ANY, 10000));
    }

}
