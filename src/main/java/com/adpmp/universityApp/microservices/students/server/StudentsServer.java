package com.adpmp.universityApp.microservices.students.server;

import com.adpmp.universityApp.microservices.authentication.server.AuthenticationServer;
import com.adpmp.universityApp.microservices.university.server.UniversityServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentsServer {

    public static void main(String[] args) {
        // Default to registration server on localhost
        if (System.getProperty(AuthenticationServer.AUTHENTICATION_SERVER_HOSTNAME) == null)
            System.setProperty(AuthenticationServer.AUTHENTICATION_SERVER_HOSTNAME, "localhost");

        System.setProperty("spring.config.name", "students-server");

        SpringApplication.run(StudentsServer.class, args);
    }
}
