package com.schoolDb.schoolDesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="teacher")
public class Teacher {

    @Id
    @SequenceGenerator( name = "teacher_id_sequence",sequenceName = "teacher_id_sequence")
    @GeneratedValue(generator = "teacher_id_sequence", strategy= GenerationType.SEQUENCE)
    private Long teacherId;
    private String firstname;
    private String lastname;
    private String middlename;
    private int age;
    private String address;
    //@ManyToMany()

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses;
    private String stateOfOrigin;
    private Date dob;
    private  String phone;
}
