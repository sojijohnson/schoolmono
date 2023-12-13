package com.schoolDb.schoolDesign.controller;


import com.schoolDb.schoolDesign.DTO.StudentDTO;
import com.schoolDb.schoolDesign.model.Student;
import com.schoolDb.schoolDesign.service.StudentService;
import com.schoolDb.schoolDesign.wrapper.StudentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/registerStudent")
    public ResponseEntity<String> registerStudent(@RequestBody() Student registerstudent){

        return  studentService.registerStudent(registerstudent);

    }


    @DeleteMapping("deleteall")
    public ResponseEntity<String> deleteAllStudents(){

        return studentService.deleteAllStudents();
    }

      @GetMapping("/findstudent")
    public ResponseEntity<StudentDTO> findStudent(@RequestParam(value ="id") Long id){
        return new ResponseEntity<>(studentService.findStudent(id),HttpStatus.OK);
    }



    @GetMapping("/findstudentClass")
    public ResponseEntity<List<StudentWrapper>> findStudentClass(@RequestParam(value="classRoomId") Long classRoomId){
           // List<Student> dd  =  studentService.findStudentByClassId(id);
                    System.out.println("finding student");
           return studentService.findStudentByClassId(classRoomId);



    }

    //using request params
    @DeleteMapping("deletestudent")
    public ResponseEntity<String>deleteStudent(@RequestParam(value = "id")Long studentId){

           studentService.deleteStudent(studentId);


         return new ResponseEntity<>("student deleted", HttpStatus.OK);
    }
}
