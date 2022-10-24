package com.adpmp.universityApp.microservices.authentication.components.controller;

import com.adpmp.universityApp.microservices.authentication.components.dto.RegistrationDto;
import com.adpmp.universityApp.microservices.authentication.components.model.Accounts;
import com.adpmp.universityApp.microservices.authentication.components.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    protected AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<Accounts> login(@RequestBody RegistrationDto credentials){
        Accounts response = this.authenticationService.login(credentials);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/signup")
    public ResponseEntity<Accounts> registration(@RequestBody RegistrationDto credentials){
        Accounts response = this.authenticationService.registration(credentials);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/logout/{id}")
    public ResponseEntity<Accounts> logout(@PathVariable("id") Long userId){
        this.authenticationService.logout(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        System.out.println("[AuthenticationController] test  ");
        String response = "I PASS IN AUTHENTICATION CONTROLLER ";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Accounts>> allAccounts(){
        List<Accounts> response = this.authenticationService.getAllAccount();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
