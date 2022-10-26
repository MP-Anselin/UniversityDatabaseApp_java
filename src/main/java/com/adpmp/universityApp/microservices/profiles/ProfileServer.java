package com.adpmp.universityApp.microservices.profiles;
import com.adpmp.universityApp.microservices.profiles.configuration.ProfileConfiguration;
import com.adpmp.universityApp.microservices.registration.RegistrationServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient
@Import(ProfileConfiguration.class)
public class ProfileServer {

    public static void main(String[] args) {
        if (System.getProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME) == null)
            System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

        System.setProperty("spring.config.name", "profile-server");

        SpringApplication.run(ProfileServer.class, args);
    }
}
