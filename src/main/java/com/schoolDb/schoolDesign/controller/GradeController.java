package com.schoolDb.schoolDesign.controller;

import com.schoolDb.schoolDesign.model.Grade;
import com.schoolDb.schoolDesign.model.Recordd;
import com.schoolDb.schoolDesign.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping("/create")
    public ResponseEntity<String> createGrade(@RequestBody Grade grade){


        return   gradeService.createGrade(grade);

    }

    @PostMapping("/recreate")
    public ResponseEntity<String> createGrade(@RequestBody Recordd grade){


        return   gradeService.cGrade(grade);

    }

    @DeleteMapping("/deletegrade")
    public ResponseEntity<String> deleteGrade(@RequestParam(value = "id" ,required = false) Long id, @RequestParam(value = "code",required = false) Long code){
        //try{

        return gradeService.deleteGrade(id,code);



        // return new ResponseEntity<String>("classdeleted",HttpStatus.OK);
    }
}
