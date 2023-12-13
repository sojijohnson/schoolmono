package com.schoolDb.schoolDesign.controller;


import com.schoolDb.schoolDesign.DTO.GradeDTO;
import com.schoolDb.schoolDesign.DTO.StudentDTO;
import com.schoolDb.schoolDesign.model.Student;
import com.schoolDb.schoolDesign.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/dashboard")
public class StudentDashBoardController {

private StudentService studentService;
    @GetMapping("student/{studentid}")
public ResponseEntity<StudentDashBoardController> getStudentDashboard(@PathVariable("studentId")Long id ){

           StudentDTO student=  studentService.findStudent(id)  ;

      //  GradeDTO  grades=


return new ResponseEntity<>(HttpStatus.OK);

    }




}
