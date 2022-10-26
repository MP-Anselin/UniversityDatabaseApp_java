package com.adpmp.universityApp.microservices.profiles.components.controller;

import com.adpmp.universityApp.microservices.profiles.components.dto.ProfileCreateDto;
import com.adpmp.universityApp.microservices.profiles.components.model.Profile;
import com.adpmp.universityApp.microservices.profiles.components.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfilesController {
    protected ProfilesService profilesService;

    @Autowired
    public ProfilesController(ProfilesService profilesService){
        this.profilesService = profilesService;
    }

    @PostMapping("/profile/create")
    public ResponseEntity<Profile> add(@RequestBody ProfileCreateDto credentials){
        Profile response = this.profilesService.addNewStudent(credentials);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/profiles/student/tocheck")
    public ResponseEntity<List<Profile>> getStudentsToCheck(){
        List<Profile> response = this.profilesService.getStudentsToCheck();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/profiles/test")
    public ResponseEntity<String> test(){
        System.out.println("[ProfilesController] test  ");
        String response = "I PASS IN PROFILE CONTROLLER ";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> getAll(){
        List<Profile> response = this.profilesService.getAllProfile();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
