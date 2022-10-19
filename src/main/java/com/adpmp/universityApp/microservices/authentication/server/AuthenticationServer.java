package com.adpmp.universityApp.microservices.authentication.server;

import com.adpmp.universityApp.microservices.authentication.controller.AuthenticationController;
import com.adpmp.universityApp.microservices.authentication.service.AuthenticationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * All you need to run a Eureka registration server.
 * 
 * @author Paul Chapman
 */
@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class, //
        DataSourceAutoConfiguration.class })
@EnableEurekaServer
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class AuthenticationServer {

    public static final String AUTHENTICATION_SERVER_HOSTNAME = "authentication.server.hostname";

    public static void main(String[] args) {
        // Tell server to look for registration.properties or registration.yml
        System.setProperty("spring.config.name", "authentication-server");

        SpringApplication.run(AuthenticationServer.class, args);
    }
}
