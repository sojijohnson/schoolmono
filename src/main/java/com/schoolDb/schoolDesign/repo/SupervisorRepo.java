package com.schoolDb.schoolDesign.repo;

import com.schoolDb.schoolDesign.model.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository



public interface SupervisorRepo extends JpaRepository<Supervisor, Long> {


   Optional<Supervisor> findById(Long id);
//@Query("SELECT a FROM Supervisor a WHERE LOWER(a.username)= LOWER(:username)")
    Supervisor findByUsername(@Param("username") String username);

  //  Supervisor findByUsername(String username);
}
