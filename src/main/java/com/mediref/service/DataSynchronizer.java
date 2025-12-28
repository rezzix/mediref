package com.mediref.service;

import com.mediref.model.DiagnosticReference;
import com.mediref.model.DiagnosticReferenceDoc;
import com.mediref.repository.DiagnosticReferenceRepository;
import com.mediref.repository.DiagnosticReferenceSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
public class DataSynchronizer {

    private final Logger logger = LoggerFactory.getLogger(DataSynchronizer.class);
    private final DiagnosticReferenceRepository jpaRepository;
    private final DiagnosticReferenceSearchRepository searchRepository;

    public DataSynchronizer(DiagnosticReferenceRepository jpaRepository, DiagnosticReferenceSearchRepository searchRepository) {
        this.jpaRepository = jpaRepository;
        this.searchRepository = searchRepository;
    }

    // Run every 5 minutes (300,000 ms), with an initial delay of 1 minute (60,000 ms)
    @Scheduled(fixedRate = 300000, initialDelay = 60000)
    public void synchronize() {
        logger.info("Starting data synchronization...");
        try {
            int pageIs = 0;
            int pageSize = 500;
            Page<DiagnosticReference> page;

            do {
                Pageable pageable = PageRequest.of(pageIs, pageSize);
                page = jpaRepository.findAll(pageable);

                List<DiagnosticReferenceDoc> docs = page.getContent().stream()
                        .map(this::convertToDoc)
                        .collect(Collectors.toList());

                if (!docs.isEmpty()) {
                    searchRepository.saveAll(docs);
                    logger.info("Synchronized batch {} ({} records) to Elasticsearch.", pageIs + 1, docs.size());
                }

                pageIs++;
            } while (page.hasNext());

            logger.info("Data synchronization completed.");

        } catch (Exception e) {
            logger.error("Error during data synchronization", e);
        }
    }

    private DiagnosticReferenceDoc convertToDoc(DiagnosticReference entity) {
        DiagnosticReferenceDoc doc = new DiagnosticReferenceDoc();
        doc.setId(entity.getId());
        doc.setCode(entity.getCode());
        doc.setDiagnostic(entity.getDiagnostic());
        doc.setOrdre(entity.getOrdre());
        doc.setDiagnosticLower(entity.getDiagnosticLower());
        doc.setCodeLower(entity.getCodeLower());
        return doc;
    }
}
