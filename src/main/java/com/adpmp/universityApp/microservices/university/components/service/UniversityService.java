package com.adpmp.universityApp.microservices.university.components.service;

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

    public UniversityService(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl : "http://" + serviceUrl;
    }

    public UniversityService() {
    }
}
