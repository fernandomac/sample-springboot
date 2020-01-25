package com.sample.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
    JerseyConfig.class
})
@ComponentScan( {
	"com.sample.resource", 
	"com.sample.service" })
public class Application implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        logger.info("APP INITIALISED version={}", getClass().getPackage().getImplementationVersion());
    }
}

