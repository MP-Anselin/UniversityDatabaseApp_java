package com.adpmp.universityApp.microservices.director.components.repository;


import com.adpmp.universityApp.microservices.director.components.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    Assignment findBySubject(String subject);
}
