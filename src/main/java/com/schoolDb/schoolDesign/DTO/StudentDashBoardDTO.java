package com.schoolDb.schoolDesign.DTO;

import com.schoolDb.schoolDesign.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
@NoArgsConstructor

public class StudentDashBoardDTO {

    private StudentDTO student;
    private ResponseEntity<List<GradeDTO>> grades;

    public StudentDashBoardDTO(StudentDTO student, ResponseEntity<List<GradeDTO>> grades) {
        this.student = student;
        this.grades = grades;
    }
}
