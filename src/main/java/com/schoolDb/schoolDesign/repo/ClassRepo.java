package com.schoolDb.schoolDesign.repo;

import com.schoolDb.schoolDesign.model.ClassRoom;
import com.schoolDb.schoolDesign.wrapper.ClassWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository



public interface ClassRepo extends JpaRepository<ClassRoom, Long> {
    ClassRoom findByClassCode(@Param("classcode") String code);

   List<ClassWrapper>  getAll(@Param("capacity") int capacity);
}
