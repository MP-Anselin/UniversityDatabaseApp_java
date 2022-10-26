package com.adpmp.universityApp.microservices.university.components.service;

import com.adpmp.universityApp.microservices.university.components.dto.ProfileCreateDto;
import com.adpmp.universityApp.microservices.university.components.model.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProfilesService extends UniversityService{
    public ProfilesService(String serviceUrl) {
        super(serviceUrl);
    }

    public ProfilesService() {
    }

    public Profile createNewProfile(ProfileCreateDto profileCreateDto) {
        try {
            return restTemplate.postForObject(serviceUrl + "/profile/create", profileCreateDto, Profile.class);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Profile> getStudentsToCheck() {
        Profile[] profiles = null;

        try {
            profiles = restTemplate.getForObject(serviceUrl + "/profiles/student/tocheck", Profile[].class);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
        }
        if (profiles == null || profiles.length == 0)
            return null;
        return Arrays.asList(profiles);
    }


    public String test() {
        System.out.println("[ProfileService] test");
        try {
            String url = serviceUrl + "/profiles/test";
            System.out.println("URL = " + url);
            return restTemplate.getForObject(serviceUrl + "/profiles/test", String.class);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public List<Profile> getAllProfile() {
        Profile[] profiles = null;

        try {
            profiles = restTemplate.getForObject(serviceUrl + "/profiles", Profile[].class);
        } catch (Exception e) {
            System.out.println("ERROR message: " + e.getMessage());
            e.printStackTrace();
        }
        if (profiles == null || profiles.length == 0)
            return null;
        return Arrays.asList(profiles);
    }
}
