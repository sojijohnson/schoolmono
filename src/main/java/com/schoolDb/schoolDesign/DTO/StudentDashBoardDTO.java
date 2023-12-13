package com.schoolDb.schoolDesign.DTO;

import com.schoolDb.schoolDesign.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class StudentDashBoardDTO {

    private Student student;
    private List<GradeDTO> grades;

    public StudentDashBoardDTO(Student student, List<GradeDTO> grades) {
        this.student = student;
        this.grades = grades;
    }
}
