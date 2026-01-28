package com.mediref.repository.jpa;

import com.mediref.model.Loinc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.domain.Pageable;

@Repository
public interface LoincRepository extends JpaRepository<Loinc, String> {
    List<Loinc> findByLoincNumGreaterThan(String loincNum, Pageable pageable);
}
