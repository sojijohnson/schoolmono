package com.schoolDb.schoolDesign.controller;

import com.schoolDb.schoolDesign.model.Course;
import com.schoolDb.schoolDesign.service.CourseService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @PostMapping("register")
    public ResponseEntity<String> registerCourse(@RequestBody Course course){

        return  courseService.registerCourse(course);

    }


}
