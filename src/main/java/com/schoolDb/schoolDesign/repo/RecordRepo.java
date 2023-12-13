package com.schoolDb.schoolDesign.repo;

import com.schoolDb.schoolDesign.model.Recordd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepo extends JpaRepository<Recordd,Long> {
}
