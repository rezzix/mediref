package com.mediref.service;

import com.mediref.model.*;
import com.mediref.repository.*;
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
    private final DrugRepository drugRepository;
    private final DrugSearchRepository drugSearchRepository;
    private final SnomedCTRepository snomedCTRepository;
    private final SnomedCTSearchRepository snomedCTSearchRepository;

    public DataSynchronizer(DiagnosticReferenceRepository jpaRepository,
                            DiagnosticReferenceSearchRepository searchRepository,
                            DrugRepository drugRepository,
                            DrugSearchRepository drugSearchRepository,
                            SnomedCTRepository snomedCTRepository,
                            SnomedCTSearchRepository snomedCTSearchRepository) {
        this.jpaRepository = jpaRepository;
        this.searchRepository = searchRepository;
        this.drugRepository = drugRepository;
        this.drugSearchRepository = drugSearchRepository;
        this.snomedCTRepository = snomedCTRepository;
        this.snomedCTSearchRepository = snomedCTSearchRepository;
    }

    // Run every hour, with an initial delay of 10 seconds
    @Scheduled(fixedRate = 3600000, initialDelay = 10000)
    public void synchronize() {
        logger.info("Starting data synchronization...");
        synchronizeDiagnostic();
        synchronizeDrugs();
        synchronizeSnomed();
    }

    public void synchronizeDiagnostic() {
        logger.info("Starting diagnostic synchronization...");
        try {
            int pageIs = 0;
            int pageSize = 1000;
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

        } catch (Exception e) {
            logger.error("Error during diagnostic synchronization", e);
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

    public void synchronizeDrugs() {
        logger.info("Starting drug synchronization...");
        try {
            int pageIs = 0;
            int pageSize = 500;
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

    public void synchronizeSnomed() {
        logger.info("Starting SnomedCT synchronization...");
        try {
            int pageIs = 0;
            int pageSize = 1000; // Snomed might be large, but let's start safe
            Page<SnomedCT> page;

            do {
                Pageable pageable = PageRequest.of(pageIs, pageSize);
                page = snomedCTRepository.findAll(pageable);

                List<SnomedCTDoc> docs = page.getContent().stream()
                        .map(this::convertSnomedToDoc)
                        .collect(Collectors.toList());

                if (!docs.isEmpty()) {
                    snomedCTSearchRepository.saveAll(docs);
                    logger.info("Synchronized batch {} ({} Snomed entries) to Elasticsearch.", pageIs + 1, docs.size());
                }

                pageIs++;
            } while (page.hasNext());

            logger.info("SnomedCT synchronization completed.");

        } catch (Exception e) {
            logger.error("Error during SnomedCT synchronization", e);
        }
    }

    private DrugDoc convertDrugToDoc(Drug entity) {
        DrugDoc doc = new DrugDoc();
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

    private SnomedCTDoc convertSnomedToDoc(SnomedCT entity) {
        SnomedCTDoc doc = new SnomedCTDoc();
        doc.setId(entity.getCode());
        doc.setCode(entity.getCode());
        doc.setValueSet(entity.getValueSet());
        doc.setDescription(entity.getDescription());
        doc.setPurpose(entity.getPurpose());
        return doc;
    }
}