package com.adpmp.universityApp.microservices.managers.server;

import com.adpmp.universityApp.microservices.authentication.server.AuthenticationServer;
import com.adpmp.universityApp.microservices.university.server.UniversityServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ManagersServer {

    public static void main(String[] args) {
        // Default to registration server on localhost
        if (System.getProperty(AuthenticationServer.AUTHENTICATION_SERVER_HOSTNAME) == null)
            System.setProperty(AuthenticationServer.AUTHENTICATION_SERVER_HOSTNAME, "localhost");

        System.setProperty("spring.config.name", "managers-server");

        SpringApplication.run(ManagersServer.class, args);
    }
}
