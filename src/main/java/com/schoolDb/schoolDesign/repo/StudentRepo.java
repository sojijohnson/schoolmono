package com.schoolDb.schoolDesign.repo;

import com.schoolDb.schoolDesign.model.Student;
import com.schoolDb.schoolDesign.wrapper.StudentWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    //@Override
    //Student findById(Long id);
    Student getById(Long id);

  //  String findByUsername(String username);

    List<StudentWrapper> findByClassRoomId(@Param("classRoomId") Long classRoomId);
   // List<Student> findByClassRoomId(@Param("classRoomId") Long classRoomId);
}
