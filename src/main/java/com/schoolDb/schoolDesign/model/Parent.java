package com.schoolDb.schoolDesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstName;
    private String lastName;

    private String address;
    private String  phone;

//    @OneToMany()
//    @JoinColumn(name="studentId")
//    private List<Student> student;

}
