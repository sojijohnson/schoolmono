package com.schoolDb.schoolDesign.service;

import com.schoolDb.schoolDesign.model.Course;
import com.schoolDb.schoolDesign.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class CourseService {
     @Autowired
    private CourseRepo courseRepo;
    public ResponseEntity<String> registerCourse(Course course) {

        Course course1= new Course();
        course1.setCourseName(course.getCourseName());
        course1.setTeacher(course.getTeacher());
        course1.setCourseCode(course.getCourseCode());

            Course c= courseRepo.save(course1)  ;
   try{     if (!Objects.isNull(c)) {
       return new ResponseEntity<>("Course save", HttpStatus.OK);
   }} catch(Exception ex){ ex.printStackTrace();}
       return new ResponseEntity<>("unknown error", HttpStatus.INTERNAL_SERVER_ERROR) ;
    }
}
