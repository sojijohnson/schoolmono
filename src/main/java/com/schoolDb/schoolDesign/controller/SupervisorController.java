package com.schoolDb.schoolDesign.controller;

import com.schoolDb.schoolDesign.model.Student;
import com.schoolDb.schoolDesign.model.Supervisor;
import com.schoolDb.schoolDesign.service.SupervisorService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;
    @PostMapping("/register")
    public ResponseEntity<String > createAdmin(@RequestBody Supervisor supervisor){

        return supervisorService.createAdmin(supervisor);
    }
    @PostMapping("/login")
    public ResponseEntity<String> supervisorLogin(@RequestBody Map<String,String>responsemap){

        return supervisorService.supervisorLogin(responsemap);
    }
    @GetMapping("/findstudent/{studentId}")
    public String findStudentRecord(@PathVariable("studentId")Long studentId){
        return supervisorService.findStudentRecord(studentId);

    }


}
