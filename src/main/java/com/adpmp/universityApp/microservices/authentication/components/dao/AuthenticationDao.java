package com.adpmp.universityApp.microservices.authentication.components.dao;

import com.adpmp.universityApp.microservices.authentication.components.model.Accounts;
import com.adpmp.universityApp.microservices.authentication.components.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthenticationDao {
    @Autowired
    private AuthenticationRepository authenticationRepository;

    public Accounts save(Accounts newUser) {
        return authenticationRepository.save(newUser);
    }

    public void update(Accounts newUser) {
        authenticationRepository.save(newUser);
    }
    public Accounts create(Accounts newUser) {
        return authenticationRepository.save(newUser);
    }

    public Accounts findByDnieAndFirstNameAndLastName(String dnie, String first_name, String Last_name) {
        return authenticationRepository.findByDnieAndFirstNameAndLastName(dnie, first_name, Last_name);
    }

    public Accounts findByDnie(String dnie) {
        return authenticationRepository.findByDnie(dnie);
    }

    public Optional<Accounts> findById(Long id){
        return authenticationRepository.findById(id);
    }

    public List<Accounts> getFindAll() {
        return authenticationRepository.findAll();
    }


}
