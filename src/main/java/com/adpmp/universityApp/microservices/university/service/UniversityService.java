package com.adpmp.universityApp.microservices.university.service;

import com.adpmp.universityApp.microservices.university.dto.RegistrationDto;
import com.adpmp.universityApp.microservices.university.model.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UniversityService {
    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;
    protected String serviceUrl;

    public UniversityService() {
    }

    public UniversityService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }


    public Authentication registration(RegistrationDto credentials) {
        try {
            return restTemplate.postForObject(serviceUrl + "/auth/registration", credentials, Authentication.class);
        } catch (Exception e) {
            return null;
        }
    }

    public Authentication login(RegistrationDto credentials) {
        try {
            return restTemplate.postForObject(serviceUrl + "/auth/login", credentials, Authentication.class);
        } catch (Exception e) {
            return null;
        }
    }

    public void logout(Long id) {
        try {
            restTemplate.postForObject(serviceUrl + "/auth/logout{id}", null, Authentication.class, id);
        } catch (Exception ignored) {
        }
    }
}
