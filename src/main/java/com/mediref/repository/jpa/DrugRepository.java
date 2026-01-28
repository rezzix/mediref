package com.mediref.repository.jpa;

import com.mediref.model.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {
    List<Drug> findByDrugCodeGreaterThan(Long drugCode, org.springframework.data.domain.Pageable pageable);
}
