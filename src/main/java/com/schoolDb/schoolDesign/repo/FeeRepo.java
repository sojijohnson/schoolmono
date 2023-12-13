package com.schoolDb.schoolDesign.repo;

import com.schoolDb.schoolDesign.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository




public interface FeeRepo extends JpaRepository <Fee,Long>{
}
