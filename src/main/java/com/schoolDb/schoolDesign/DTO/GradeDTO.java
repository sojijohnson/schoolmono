package com.schoolDb.schoolDesign.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;
@Data

public class GradeDTO {
    private Long id;
    private String gradeValue;
    private Date gradeDate;

    private Long Student;
    private Long courses;
}
