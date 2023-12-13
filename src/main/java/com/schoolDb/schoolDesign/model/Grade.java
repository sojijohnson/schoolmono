package com.schoolDb.schoolDesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

@NamedQuery(name="Grade.findByStudentId", query="select new com.schoolDb.schoolDesign.wrapper.GradeWrapper(s.gradeValue, s.courses.courseId, s.student.studentId) from Grade s where s.student.studentId=:studentId")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gradeValue;
    private Date gradeDate;

    @ManyToOne()
    @JoinColumn(name="studentId")
    private Student student;

    @ManyToOne()
  //  @JoinColumn(name="courseId")
   // private Course course;
//    @ManyToMany()
 //  @JoinColumn(name="courseId")
   private Course courses;
//    @ManyToMany
//    @JoinTable(name = "grade_course",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "courseId"))
//    private List<Course> courses;
}
