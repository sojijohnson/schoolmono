package com.schoolDb.schoolDesign.DTO;

import com.schoolDb.schoolDesign.model.ClassRoom;
import com.schoolDb.schoolDesign.model.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDTO {
    private Long studentId;
    private String firstname;
    private String lastname;
    private String middlename;
    private int age;
    private ClassRoom classRoom;
    private String stateOfOrigin;
    private String email;
    private Date dob;
    private  String phone;
    private String address;
   private List<Course> courses;
}
