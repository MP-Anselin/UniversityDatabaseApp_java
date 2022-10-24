package com.adpmp.universityApp.microservices.director.components.dao;

import com.adpmp.universityApp.microservices.director.components.model.Assignment;
import com.adpmp.universityApp.microservices.director.components.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AssignmentDao {
    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment save(Assignment newUser) {
        return assignmentRepository.save(newUser);
    }

    public void update(Assignment newUser) {
        assignmentRepository.save(newUser);
    }
    public Assignment create(Assignment newUser) {
        return assignmentRepository.save(newUser);
    }

    public Optional<Assignment> findById(Long id){
        return assignmentRepository.findById(id);
    }

    public Assignment findBySubject(String subject){
        return assignmentRepository.findBySubject(subject);
    }

    public void delete(Assignment toDelete){
        assignmentRepository.delete(toDelete);
    }

    public List<Assignment> getFindAll() {
        return assignmentRepository.findAll();
    }
}
