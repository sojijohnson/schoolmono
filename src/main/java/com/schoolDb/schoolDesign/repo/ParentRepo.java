package com.schoolDb.schoolDesign.repo;

import com.schoolDb.schoolDesign.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepo extends JpaRepository<Parent,Long> {



}
