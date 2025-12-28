package com.mediref.repository;

import com.mediref.model.DiagnosticReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticReferenceRepository extends JpaRepository<DiagnosticReference, Long> {
}
