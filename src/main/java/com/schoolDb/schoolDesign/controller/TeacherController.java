package com.schoolDb.schoolDesign.controller;

import com.schoolDb.schoolDesign.model.Teacher;
import com.schoolDb.schoolDesign.repo.TeacherRepo;
import com.schoolDb.schoolDesign.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/registerteacher")
    public ResponseEntity<String> registerTeacher(@RequestBody()Teacher newTeacher){

       return teacherService.registerTeacher(newTeacher);



    }
@GetMapping("findteacher/{teacherId}")
    public ResponseEntity<Teacher> findTeacher(@PathVariable("teacherId") Long teacherId){


        return teacherService.findTeacher(teacherId);
    }
}
