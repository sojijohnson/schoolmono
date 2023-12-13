package com.schoolDb.schoolDesign.wrapper;

import com.schoolDb.schoolDesign.model.Student;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class ClassWrapper {

    private Long classRoomId;
    private String classCode;
    private int capacity;


    private Student student;

    public ClassWrapper(Long classRoomId, String classCode, int capacity) {
        this.classRoomId = classRoomId;
        this.classCode = classCode;
        this.capacity = capacity;
       // this.student = student;
    }

    public ClassWrapper(Long classRoomId, String classCode) {
        this.classRoomId = classRoomId;
        this.classCode = classCode;
    }
}
