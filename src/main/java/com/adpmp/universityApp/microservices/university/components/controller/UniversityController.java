package com.adpmp.universityApp.microservices.university.components.controller;

import com.adpmp.universityApp.microservices.university.components.dto.RegistrationDto;
import com.adpmp.universityApp.microservices.university.components.model.Authentication;
import com.adpmp.universityApp.microservices.university.components.service.UniversityService;
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
    protected UniversityService authenticationService;

    protected Logger logger = Logger.getLogger(UniversityController.class.getName());

    public UniversityController(UniversityService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<Authentication> login(@RequestBody RegistrationDto credentials) {
        Authentication response = this.authenticationService.login(credentials);
        if (response == null)
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        System.out.println("[UniversityController] TEST ");
        String response = this.authenticationService.test();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
    @PostMapping("/signup")
    public ResponseEntity<Authentication> registration(@RequestBody RegistrationDto credentials){
        Authentication response = this.authenticationService.registration(credentials);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/logout/{id}")
    public ResponseEntity<Authentication> logout(@PathVariable("id") Long userId){
        this.authenticationService.logout(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Authentication>> allAccounts(){
        List<Authentication> response = this.authenticationService.getAllAccount();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
