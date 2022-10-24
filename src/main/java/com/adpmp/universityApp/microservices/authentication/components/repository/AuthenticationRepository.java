package com.adpmp.universityApp.microservices.authentication.components.repository;

import com.adpmp.universityApp.microservices.authentication.components.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticationRepository extends JpaRepository<Accounts, Long> {
    Accounts findByDnieAndFirstNameAndLastName(String dnie, String first_name, String Last_name);

    Accounts findByDnie(String dnie);

    Optional<Accounts> findById(Long id);
}
