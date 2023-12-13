package com.schoolDb.schoolDesign.repo;

import com.schoolDb.schoolDesign.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Long> {
}
