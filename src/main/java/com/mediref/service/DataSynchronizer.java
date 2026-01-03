package com.mediref.service;

import com.mediref.model.DiagnosticReference;
import com.mediref.model.DiagnosticReferenceDoc;
import com.mediref.repository.DiagnosticReferenceRepository;
import com.mediref.repository.DiagnosticReferenceSearchRepository;
import com.mediref.repository.DrugRepository;
import com.mediref.repository.DrugSearchRepository;
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

    public DataSynchronizer(DiagnosticReferenceRepository jpaRepository,
                            DiagnosticReferenceSearchRepository searchRepository,
                            DrugRepository drugRepository,
                            DrugSearchRepository drugSearchRepository) {
        this.jpaRepository = jpaRepository;
        this.searchRepository = searchRepository;
        this.drugRepository = drugRepository;
        this.drugSearchRepository = drugSearchRepository;
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

            logger.info("Diagnostic synchronization completed.");
            
            synchronizeDrugs();

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

    private final com.mediref.repository.DrugRepository drugRepository;
    private final com.mediref.repository.DrugSearchRepository drugSearchRepository;

    public void synchronizeDrugs() {
        logger.info("Starting drug synchronization...");
        try {
            int pageIs = 0;
            int pageSize = 100;
            Page<com.mediref.model.Drug> page;

            do {
                Pageable pageable = PageRequest.of(pageIs, pageSize);
                page = drugRepository.findAll(pageable);

                List<com.mediref.model.DrugDoc> docs = page.getContent().stream()
                        .map(this::convertDrugToDoc)
                        .collect(Collectors.toList());

                if (!docs.isEmpty()) {
                    drugSearchRepository.saveAll(docs);
                    logger.info("Synchronized batch {} ({} drugs) to Elasticsearch.", pageIs + 1, docs.size());
                }

                pageIs++;
            } while (page.hasNext());

            logger.info("Drug synchronization completed.");

        } catch (Exception e) {
            logger.error("Error during drug synchronization", e);
        }
    }

    private com.mediref.model.DrugDoc convertDrugToDoc(com.mediref.model.Drug entity) {
        com.mediref.model.DrugDoc doc = new com.mediref.model.DrugDoc();
        doc.setId(entity.getDrugCode());
        doc.setDescription(entity.getDescription());
        doc.setCodeATC(entity.getCodeATC());
        doc.setDci(entity.getDci());
        doc.setDrugCode(entity.getDrugCode());
        doc.setForme(entity.getForme());
        doc.setPresentation(entity.getPresentation());
        doc.setClassTherapeutique(entity.getClassTherapeutique());
        doc.setTableauabc(entity.getTableauabc());
        doc.setLaboratory(entity.getLaboratory());
        doc.setDosage(entity.getDosage());
        doc.setUnit(entity.getUnit());
        doc.setPpv(entity.getPpv());
        doc.setPh(entity.getPh());
        doc.setReimbursementRate(entity.getReimbursementRate());
        doc.setIsGeneric(entity.getIsGeneric());
        return doc;
    }
}