package com.mediref.repository;

import com.mediref.model.SnomedCT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnomedCTRepository extends JpaRepository<SnomedCT, Long> {
}
