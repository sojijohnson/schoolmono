package com.schoolDb.schoolDesign.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recordd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;
    private String term;
    private  String Session;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;

}
