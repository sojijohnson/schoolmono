package com.schoolDb.schoolDesign.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {
    private Long courseId;


    private String courseName;
    private  String courseCode;
    private int credit;
    private List<GradeDTO> grades;
}
