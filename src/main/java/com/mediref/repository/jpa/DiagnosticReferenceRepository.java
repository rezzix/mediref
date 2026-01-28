package com.mediref.repository.jpa;

import com.mediref.model.DiagnosticReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DiagnosticReferenceRepository extends JpaRepository<DiagnosticReference, Long> {
    List<DiagnosticReference> findByIdGreaterThan(Long id, org.springframework.data.domain.Pageable pageable);
}
