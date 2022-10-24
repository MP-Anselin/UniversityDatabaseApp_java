package com.adpmp.universityApp.microservices.university;

import com.adpmp.universityApp.microservices.registration.RegistrationServer;
import com.adpmp.universityApp.microservices.university.components.controller.UniversityController;
import com.adpmp.universityApp.microservices.university.components.service.UniversityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class, //
        DataSourceAutoConfiguration.class })
@EnableEurekaServer
@ComponentScan(useDefaultFilters = false)
public class UniversityServer {

    public static final String AUTHENTICATION_SERVICE_URL = "http://AUTHENTICATION-SERVICE";

    public static void main(String[] args) {

        if (System.getProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME) == null)
            System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

        System.setProperty("spring.config.name", "university-server");
        SpringApplication.run(UniversityServer.class, args);
    }
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public UniversityController authenticationController() {
        return new UniversityController(authenticationService());
    }
    @Bean
    public UniversityService authenticationService() {
        return new UniversityService(AUTHENTICATION_SERVICE_URL);
    }
}
