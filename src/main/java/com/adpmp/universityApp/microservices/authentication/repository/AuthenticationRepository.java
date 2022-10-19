package com.adpmp.universityApp.microservices.authentication.repository;

import com.adpmp.universityApp.microservices.authentication.model.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {
    Authentication findByDnieAnAndFirst_nameAndLast_name(String dnie, String first_name, String Last_name);
    Authentication findByDnie();
}
