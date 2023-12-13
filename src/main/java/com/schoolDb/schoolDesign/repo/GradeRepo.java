package com.schoolDb.schoolDesign.repo;

import com.schoolDb.schoolDesign.DTO.GradeDTO;
import com.schoolDb.schoolDesign.model.ClassRoom;
import com.schoolDb.schoolDesign.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GradeRepo extends JpaRepository<Grade, Long> {
    List<GradeDTO> findByStudentId(@Param("studentId") Long studentId);

    //Grade findByStudentId(@Param("studentId") Long studentId);
}
