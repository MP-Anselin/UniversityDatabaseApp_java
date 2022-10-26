package com.adpmp.universityApp.microservices.university.components.controller;

import com.adpmp.universityApp.microservices.university.components.dto.AssignmentCreateDto;
import com.adpmp.universityApp.microservices.university.components.dto.ProfileCreateDto;
import com.adpmp.universityApp.microservices.university.components.dto.RegistrationDto;
import com.adpmp.universityApp.microservices.university.components.model.Assignment;
import com.adpmp.universityApp.microservices.university.components.model.Authentication;
import com.adpmp.universityApp.microservices.university.components.model.Profile;
import com.adpmp.universityApp.microservices.university.components.service.AssignmentService;
import com.adpmp.universityApp.microservices.university.components.service.AuthenticationService;
import com.adpmp.universityApp.microservices.university.components.service.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RequestMapping("university")
@RestController
public class UniversityController {
    @Autowired
    protected AuthenticationService authenticationService;

    @Autowired
    protected AssignmentService assignmentService;

    @Autowired
    protected ProfilesService profilesService;

    protected Logger logger = Logger.getLogger(UniversityController.class.getName());

    public UniversityController(AuthenticationService authenticationService, AssignmentService assignmentService, ProfilesService profilesService) {
        this.authenticationService = authenticationService;
        this.assignmentService = assignmentService;
        this.profilesService = profilesService;
    }

    // --------------------------------------- AUTHENTICATION -------------------------------------------
    @PostMapping("/login")
    public ResponseEntity<Authentication> login(@RequestBody RegistrationDto credentials) {
        Authentication response = this.authenticationService.login(credentials);
        if (response == null)
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/auth/test")
    public ResponseEntity<String> testAccount() {
        System.out.println("[UniversityController] REQUEST ACCOUNT TEST ");
        String response = this.authenticationService.test();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Authentication> registration(@RequestBody RegistrationDto credentials) {
        Authentication response = this.authenticationService.registration(credentials);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/logout/{id}")
    public ResponseEntity<Authentication> logout(@PathVariable("id") Long userId) {
        this.authenticationService.logout(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Authentication>> allAccounts() {
        List<Authentication> response = this.authenticationService.getAllAccount();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // --------------------------------------- ASSIGNMENT -------------------------------------------


    @PostMapping("/assignment/add")
    public ResponseEntity<Assignment> addAssignment(@RequestBody AssignmentCreateDto credentials) {
        Assignment response = this.assignmentService.addAssignment(credentials);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/assignment/delete/{id}")
    public ResponseEntity<Assignment> deleteAssignment(@PathVariable("id") Long userId) {
        this.assignmentService.deleteAssignment(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/assignment/test")
    public ResponseEntity<String> testAssignment() {
        System.out.println("[UniversityController] REQUEST ASSIGNMENT TEST ");
        String response = this.assignmentService.test();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/assignments")
    public ResponseEntity<List<Assignment>> allAssignment() {
        List<Assignment> response = this.assignmentService.getAllAssignment();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // --------------------------------------- PROFILES -------------------------------------------

    @PostMapping("/profile/create")
    public ResponseEntity<Profile> add(@RequestBody ProfileCreateDto credentials) {
        Profile response = this.profilesService.createNewProfile(credentials);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/profiles/student/tocheck")
    public ResponseEntity<List<Profile>> getStudentsInvalid() {
        List<Profile> response = this.profilesService.getStudentsToCheck();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/profiles/test")
    public ResponseEntity<String> testProfiles() {
        System.out.println("[UniversityController] REQUEST PROFILES TEST ");
        String response = this.profilesService.test();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> getAll() {
        List<Profile> response = this.profilesService.getAllProfile();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
