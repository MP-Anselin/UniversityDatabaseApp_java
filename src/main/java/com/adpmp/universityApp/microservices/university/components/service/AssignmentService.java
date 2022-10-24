package com.adpmp.universityApp.microservices.university.components.service;

import com.adpmp.universityApp.microservices.director.components.model.Assignment;
import com.adpmp.universityApp.microservices.university.components.dto.AssignmentCreateDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AssignmentService extends UniversityService{
    public AssignmentService(String serviceUrl) {
        super(serviceUrl);
    }

    public AssignmentService() {
    }

    public Assignment addAssignment(AssignmentCreateDto elements) {
        try {
            return restTemplate.postForObject(serviceUrl + "/director/add", elements, Assignment.class);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public String test() {
        System.out.println("[AssignmentService] test");
        try {
            String url = serviceUrl + "/test";
            System.out.println("URL = " + url);
            return restTemplate.getForObject(serviceUrl + "/director/test", String.class);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public void deleteAssignment(Long id) {
        try {
            restTemplate.postForObject(serviceUrl + "/director/delete/{id}", null, Void.class, id);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Assignment> getAllAssignment() {
        Assignment[] assignments = null;

        try {
            assignments = restTemplate.getForObject(serviceUrl + "/director/assignments", Assignment[].class);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
        }
        if (assignments == null || assignments.length == 0)
            return null;
        return Arrays.asList(assignments);
    }
}
