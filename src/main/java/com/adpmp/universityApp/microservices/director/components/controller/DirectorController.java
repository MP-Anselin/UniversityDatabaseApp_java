package com.adpmp.universityApp.microservices.director.components.controller;

import com.adpmp.universityApp.microservices.director.components.dto.AssignmentCreateDto;
import com.adpmp.universityApp.microservices.director.components.model.Assignment;
import com.adpmp.universityApp.microservices.director.components.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorController {
    protected AssignmentService assignmentService;

    @Autowired
    public DirectorController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    @PostMapping("/assignment/add")
    public ResponseEntity<Assignment> add(@RequestBody AssignmentCreateDto credentials){
        Assignment response = this.assignmentService.addAssignment(credentials);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/assignment/delete/{id}")
    public ResponseEntity<Assignment> delete(@PathVariable("id") Long userId){
        this.assignmentService.deleteAssignment(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        System.out.println("[DirectorController] test  ");
        String response = "I PASS IN DIRECTOR CONTROLLER ";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/assignments")
    public ResponseEntity<List<Assignment>> getAll(){
        List<Assignment> response = this.assignmentService.getAllAssignment();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
