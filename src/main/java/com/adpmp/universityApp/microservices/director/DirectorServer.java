package com.adpmp.universityApp.microservices.director;
import com.adpmp.universityApp.microservices.director.configuration.DirectorConfiguration;
import com.adpmp.universityApp.microservices.registration.RegistrationServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import(DirectorConfiguration.class)
public class DirectorServer {

    public static void main(String[] args) {
        if (System.getProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME) == null)
            System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

        System.setProperty("spring.config.name", "director-server");

        SpringApplication.run(DirectorServer.class, args);
    }
}
