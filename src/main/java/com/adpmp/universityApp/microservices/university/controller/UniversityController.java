package com.adpmp.universityApp.microservices.university.controller;

import com.adpmp.universityApp.microservices.university.dto.RegistrationDto;
import com.adpmp.universityApp.microservices.university.model.Authentication;
import com.adpmp.universityApp.microservices.university.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class UniversityController {
    @Autowired
    protected UniversityService authenticationService;

    public UniversityController(UniversityService authenticationService){
        this.authenticationService = authenticationService;
    }

   /* @PostMapping("/login")
    public ResponseEntity<Authentication> login(@RequestBody RegistrationDto credentials){
        Authentication response = this.authenticationService.login(credentials);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/registration")
    public ResponseEntity<Authentication> registration(@RequestBody RegistrationDto credentials){
        Authentication response = this.authenticationService.registration(credentials);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/logout/{id}")
    public ResponseEntity<Authentication> logout(@PathVariable("id") Long userId){
        this.authenticationService.logout(userId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }*/
}
