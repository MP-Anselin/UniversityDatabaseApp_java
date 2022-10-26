package com.adpmp.universityApp.microservices.director.components.service;

import com.adpmp.universityApp.exceptions.ResourceConflictException;
import com.adpmp.universityApp.exceptions.ResourceNotFoundException;
import com.adpmp.universityApp.microservices.director.components.dao.AssignmentDao;
import com.adpmp.universityApp.microservices.director.components.dto.AssignmentCreateDto;
import com.adpmp.universityApp.microservices.director.components.model.Assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentDao assignmentDao;

    public Assignment addAssignment(AssignmentCreateDto element) {
        Assignment oldAssignment = assignmentDao.findBySubject(element.getSubject());
        if (oldAssignment != null)
            throw new ResourceConflictException("Assignment with subject : " + element.getSubject() + " already existed");

        Assignment newAssignment = new Assignment();
        newAssignment.setSubject(element.getSubject());
        newAssignment.setCredit(element.getCredit());
        newAssignment.setStudy_filed(element.getStudy_filed());
        return assignmentDao.save(newAssignment);
    }

    public void deleteAssignment(Long id) {
        Assignment toDelete = assignmentDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Can't find Assignment with id : " + id));
        assignmentDao.delete(toDelete);
    }

    public List<Assignment> getAllAssignment() {
        return assignmentDao.getFindAll();
    }
}
