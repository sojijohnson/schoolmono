package com.schoolDb.schoolDesign.service;

import com.schoolDb.schoolDesign.model.Teacher;
import com.schoolDb.schoolDesign.repo.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
private TeacherRepo teacherRepo;
    public ResponseEntity<String> registerTeacher(Teacher newTeacher) {
        try{
        Teacher iniTeacher= new Teacher();

        iniTeacher.setAge(newTeacher.getAge());
        iniTeacher.setCourses(newTeacher.getCourses().stream().toList());
        iniTeacher.setLastname(newTeacher.getLastname());
        iniTeacher.setFirstname(newTeacher.getFirstname());
        iniTeacher.setAddress(newTeacher.getAddress());
        iniTeacher.setMiddlename(newTeacher.getMiddlename());
        iniTeacher.setStateOfOrigin(newTeacher.getStateOfOrigin());
        iniTeacher.setPhone(newTeacher.getPhone());
        iniTeacher.setDob(newTeacher.getDob());
      // teacherRepo.save(iniTeacher);
       System.out.println(iniTeacher);

        teacherRepo.save(iniTeacher);

        return new ResponseEntity<>("new teacher save", HttpStatus.OK);}catch (Exception ex){ex.printStackTrace();}

return new ResponseEntity<>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public ResponseEntity<Teacher> findTeacher(Long teacherId) {

       try{
         Optional<Teacher> teacher  = teacherRepo.findById(teacherId);
           System.out.println(teacher);
           return new ResponseEntity<>(teacher.orElseThrow(),HttpStatus.OK);
       }catch (Exception ex){ex.printStackTrace();}

       return new ResponseEntity<>(new Teacher(),HttpStatus.NOT_FOUND);

    }
}
