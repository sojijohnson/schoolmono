package com.schoolDb.schoolDesign.controller;


import com.schoolDb.schoolDesign.DTO.GradeDTO;
import com.schoolDb.schoolDesign.DTO.StudentDTO;
import com.schoolDb.schoolDesign.DTO.StudentDashBoardDTO;
import com.schoolDb.schoolDesign.model.Student;
import com.schoolDb.schoolDesign.service.GradeService;
import com.schoolDb.schoolDesign.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequiredArgsConstructor
@RequestMapping("/dashboard")
public class StudentDashBoardController {
@Autowired
private StudentService studentService;
@Autowired
private GradeService gradeService;
    @GetMapping("/student")
public ResponseEntity<StudentDashBoardDTO> getStudentDashboard(@RequestParam(value="studentId") Long id ){

           StudentDTO student=  studentService.findStudent(id);
                       System.out.println(student);
                       System.out.println("student dashboard");
        ResponseEntity<List<GradeDTO>> grades= this.gradeService.findGradeById(id);
System.out.println(grades);
        StudentDashBoardDTO dashBoardDTO= new StudentDashBoardDTO(student,grades);
              System.out.println(dashBoardDTO);
return new ResponseEntity<>(dashBoardDTO,HttpStatus.OK);

    }




}
