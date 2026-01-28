package com.mediref.repository.jpa;

import com.mediref.model.SnomedCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SnomedCTRepository extends JpaRepository<SnomedCT, Long> {
    List<SnomedCT> findByCodeGreaterThan(Long code, org.springframework.data.domain.Pageable pageable);
}
