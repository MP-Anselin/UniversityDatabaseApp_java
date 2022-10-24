package com.adpmp.universityApp.microservices.authentication.components.service;

import com.adpmp.universityApp.exceptions.ResourceConflictException;
import com.adpmp.universityApp.exceptions.ResourceNotFoundException;
import com.adpmp.universityApp.exceptions.UnauthorizedException;
import com.adpmp.universityApp.microservices.authentication.components.dao.AuthenticationDao;
import com.adpmp.universityApp.microservices.authentication.components.dto.RegistrationDto;
import com.adpmp.universityApp.microservices.authentication.components.model.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationDao authenticationDao;

    public Accounts registration(RegistrationDto credentials) {
        Accounts userOld = authenticationDao.findByDnie(credentials.getDnie());
        if (userOld != null)
            throw new ResourceConflictException("User with dnie : " + credentials.getDnie() + " already have account");

        Accounts newUser = new Accounts();
        newUser.setDnie(credentials.getDnie());
        newUser.setFirst_name(credentials.getFirstName());
        newUser.setLast_name(credentials.getLastName());
        newUser.setUser_role_id(credentials.getUserRoleId());
        return authenticationDao.create(newUser);
    }

    public Accounts login(RegistrationDto credentials) {
        Accounts currentUser = authenticationDao.findByDnieAndFirstNameAndLastName(
                credentials.getDnie(),
                credentials.getFirstName(),
                credentials.getLastName());
        if (currentUser == null)
            throw new UnauthorizedException(credentials.getLastName() + "you dont have account");
        currentUser.setIs_log(true);
        return authenticationDao.save(currentUser);
    }

    public void logout(Long userId) {
        Accounts user = authenticationDao.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find the user with id: " + userId));
        user.setIs_log(false);
        authenticationDao.update(user);
    }

    public List<Accounts> getAllAccount() {
        return authenticationDao.getFindAll();
    }
}
