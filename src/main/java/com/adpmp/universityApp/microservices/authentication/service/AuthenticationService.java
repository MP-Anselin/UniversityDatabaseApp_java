package com.adpmp.universityApp.microservices.authentication.service;

import com.adpmp.universityApp.microservices.authentication.dto.RegistrationDto;
import com.adpmp.universityApp.microservices.authentication.model.Authentication;
import com.adpmp.universityApp.microservices.authentication.repository.AuthenticationRepository;
import com.adpmp.universityApp.exceptions.ResourceConflictException;
import com.adpmp.universityApp.exceptions.ResourceNotFoundException;
import com.adpmp.universityApp.exceptions.UnauthorizedException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public AuthenticationRepository authenticationRepository;
    protected String serviceUrl;

    public Authentication registration(RegistrationDto credentials) {
        Authentication newUser = authenticationRepository.findByDnie();
        if (newUser == null)
            throw new ResourceConflictException("user with dnie : " + credentials.getDnie() + "already have account");
        return authenticationRepository.save(newUser);
    }
    public Authentication login(RegistrationDto credentials) {
        Authentication currentUser = authenticationRepository.findByDnieAnAndFirst_nameAndLast_name(
                credentials.getDnie(),
                credentials.getFirst_name(),
                credentials.getLast_name());
        if (currentUser == null)
            throw new UnauthorizedException(credentials.getFirst_name() + "you dont have account");
        return currentUser;
    }

    public void logout(Long userId) {
        Authentication user = this.getUserById(userId);
        user.setIs_log(false);
        authenticationRepository.save(user);
    }

    private Authentication getUserById(Long userId) {
        return authenticationRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find the user with id: " + userId));
    }
}
