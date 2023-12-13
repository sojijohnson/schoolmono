package com.schoolDb.schoolDesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="course")
@AllArgsConstructor
@NoArgsConstructor

public class Course {
    @Id
    @SequenceGenerator(sequenceName = "course_sequence", name="course_sequence" )
    // @SequenceGenerator( name = "student_id_sequence",sequenceName = "student_id_sequence")
    @GeneratedValue(generator = "course_sequence", strategy= GenerationType.SEQUENCE)
    private Long courseId;


    private String courseName;
    private  String courseCode;
    private int credit;
   @ManyToMany(mappedBy = "courses")
   //@OneToMany(mappedBy = "courses")

    private List<Student> student;
    @ManyToOne()
    private Teacher teacher;
//@OneToMany(mappedBy = "course")
@ManyToMany(mappedBy = "courses")
    private List<Grade> grade;

@ManyToMany(mappedBy = "course")
private List<Recordd> recordd;
}
