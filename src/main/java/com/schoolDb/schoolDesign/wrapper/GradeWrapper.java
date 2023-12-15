package com.schoolDb.schoolDesign.wrapper;

import com.schoolDb.schoolDesign.model.Course;
import com.schoolDb.schoolDesign.model.Student;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
@Data
public class GradeWrapper {

    private Long id;

    private String gradeValue;
    private Date gradeDate;


    private Long student;


    private Long courses;

    public GradeWrapper( String gradeValue, Long student, Long courses) {
       // this.id = id;
        this.gradeValue = gradeValue;
      //  this.gradeDate = gradeDate;
        this.student = student;
        this.courses = courses;
    }
}
