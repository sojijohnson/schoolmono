package com.schoolDb.schoolDesign.DTO;

import com.schoolDb.schoolDesign.model.Student;

import java.util.List;

public class ClassRoomDTO {

    private Long classRoomId;
    private String classCode;
    private int capacity;
    private List<Student> student;
}
