package com.adpmp.universityApp.microservices.administrators.server;
import com.adpmp.universityApp.microservices.registration.RegistrationServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdministratorsServer {

    public static void main(String[] args) {
        // Default to registration server on localhost
        if (System.getProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME) == null)
            System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

        System.setProperty("spring.config.name", "administrators-server");

        SpringApplication.run(AdministratorsServer.class, args);
    }
}
