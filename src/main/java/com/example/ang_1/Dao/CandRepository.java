package com.example.ang_1.Dao;

import com.example.ang_1.Entity.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandRepository extends JpaRepository<Candidates,Long> {
   public Candidates findByUsername ( String username );
}
