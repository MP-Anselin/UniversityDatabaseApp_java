package com.adpmp.universityApp.microservices.university.server;

import com.adpmp.universityApp.microservices.authentication.controller.AuthenticationController;
import com.adpmp.universityApp.microservices.authentication.service.AuthenticationService;
import com.adpmp.universityApp.microservices.university.controller.UniversityController;
import com.adpmp.universityApp.microservices.university.service.UniversityService;
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
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class UniversityServer {

    public static final String ACCOUNTS_SERVICE_URL = "http://UNIVERSITY-SERVICE";

    public static void main(String[] args) {
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
        return new UniversityService(ACCOUNTS_SERVICE_URL);
    }
}
