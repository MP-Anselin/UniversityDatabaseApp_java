package com.adpmp.universityApp.microservices.university.components.service;

import com.adpmp.universityApp.microservices.university.components.dto.RegistrationDto;
import com.adpmp.universityApp.microservices.university.components.model.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    @LoadBalanced
    protected RestTemplate restTemplate;
    protected String serviceUrl;

    public UniversityService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    public UniversityService() {
    }

    public Authentication registration(RegistrationDto credentials) {
        try {
            return restTemplate.postForObject(serviceUrl + "/auth/signup", credentials, Authentication.class);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public Authentication login(RegistrationDto credentials) {
        try {
            return restTemplate.postForObject(serviceUrl + "/auth/login", credentials, Authentication.class);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public String test() {
        System.out.println("[UniversityService] test");
        try {
            String url = serviceUrl + "/test";
            System.out.println("URL = " + url);
            return restTemplate.getForObject(serviceUrl + "/auth/test", String.class);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void logout(Long id) {
        try {
            restTemplate.postForObject(serviceUrl + "/auth/logout/{id}", null, Void.class, id);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Authentication> getAllAccount() {
        Authentication[] authentication = null;

        try {
            authentication = restTemplate.getForObject(serviceUrl + "/auth/accounts", Authentication[].class);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
        }
        if (authentication == null || authentication.length == 0)
            return null;
        return Arrays.asList(authentication);
    }
}
