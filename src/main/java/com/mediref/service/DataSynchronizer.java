package com.mediref.service;

import com.mediref.model.*;
import com.mediref.repository.jpa.*;
import com.mediref.repository.search.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class DataSynchronizer {

    private final Logger logger = LoggerFactory.getLogger(DataSynchronizer.class);
    private final DiagnosticReferenceRepository jpaRepository;
    private final DiagnosticReferenceSearchRepository searchRepository;
    private final DrugRepository drugRepository;
    private final DrugSearchRepository drugSearchRepository;
    private final SnomedCTRepository snomedCTRepository;
    private final SnomedCTSearchRepository snomedCTSearchRepository;
    private final LoincRepository loincRepository;
    private final LoincSearchRepository loincSearchRepository;

    public DataSynchronizer(DiagnosticReferenceRepository jpaRepository,
                            DiagnosticReferenceSearchRepository searchRepository,
                            DrugRepository drugRepository,
                            DrugSearchRepository drugSearchRepository,
                            SnomedCTRepository snomedCTRepository,
                            SnomedCTSearchRepository snomedCTSearchRepository,
                            LoincRepository loincRepository,
                            LoincSearchRepository loincSearchRepository) {
        this.jpaRepository = jpaRepository;
        this.searchRepository = searchRepository;
        this.drugRepository = drugRepository;
        this.drugSearchRepository = drugSearchRepository;
        this.snomedCTRepository = snomedCTRepository;
        this.snomedCTSearchRepository = snomedCTSearchRepository;
        this.loincRepository = loincRepository;
        this.loincSearchRepository = loincSearchRepository;
    }

    @Scheduled(fixedRate = 3600000, initialDelay = 10000)
    public void synchronize() {
        System.out.println("DEBUG: synchronize() method triggered");
        logger.info("Starting data synchronization...");

        CompletableFuture<Void> diagnosticTask = CompletableFuture.runAsync(this::synchronizeDiagnostic);
        CompletableFuture<Void> drugTask = CompletableFuture.runAsync(this::synchronizeDrugs);
        CompletableFuture<Void> snomedTask = CompletableFuture.runAsync(this::synchronizeSnomed);
        CompletableFuture<Void> loincTask = CompletableFuture.runAsync(this::synchronizeLoinc);

        CompletableFuture.allOf(diagnosticTask, drugTask, snomedTask, loincTask).join();
        logger.info("All data synchronization tasks completed.");
    }

    public void synchronizeDiagnostic() {
        logger.info("Starting diagnostic synchronization...");
        try {
            int pageSize = 2000;
            long lastSeenId = 0L;
            List<DiagnosticReference> batch;

            do {
                Pageable pageable = PageRequest.of(0, pageSize, Sort.by("id").ascending());
                batch = jpaRepository.findByIdGreaterThan(lastSeenId, pageable);

                if (!batch.isEmpty()) {
                    List<DiagnosticReferenceDoc> docs = batch.stream()
                            .map(this::convertToDoc)
                            .collect(Collectors.toList());

                    searchRepository.saveAll(docs);
                    DiagnosticReference lastEntity = batch.get(batch.size() - 1);
                    lastSeenId = lastEntity.getId();
                    logger.info("Synchronized batch of {} records (last id: {}) to Elasticsearch.", docs.size(), lastSeenId);
                }
            } while (!batch.isEmpty());

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
            int pageSize = 2000;
            long lastSeenId = 0L;
            List<Drug> batch;

            do {
                Pageable pageable = PageRequest.of(0, pageSize, Sort.by("drugCode").ascending());
                batch = drugRepository.findByDrugCodeGreaterThan(lastSeenId, pageable);

                if (!batch.isEmpty()) {
                    List<DrugDoc> docs = batch.stream()
                            .map(this::convertDrugToDoc)
                            .collect(Collectors.toList());
                    
                    drugSearchRepository.saveAll(docs);
                    Drug lastEntity = batch.get(batch.size() - 1);
                    lastSeenId = lastEntity.getDrugCode();
                    logger.info("Synchronized batch of {} drugs (last id: {}) to Elasticsearch.", docs.size(), lastSeenId);
                }
            } while (!batch.isEmpty());

            logger.info("Drug synchronization completed.");

        } catch (Exception e) {
            logger.error("Error during drug synchronization", e);
        }
    }

    public void synchronizeSnomed() {
        logger.info("Starting SnomedCT synchronization...");
        try {
            int pageSize = 2000;
            long lastSeenId = 0L;
            List<SnomedCT> batch;

            do {
                Pageable pageable = PageRequest.of(0, pageSize, Sort.by("code").ascending());
                batch = snomedCTRepository.findByCodeGreaterThan(lastSeenId, pageable);

                if (!batch.isEmpty()) {
                    List<SnomedCTDoc> docs = batch.stream()
                            .map(this::convertSnomedToDoc)
                            .collect(Collectors.toList());

                    snomedCTSearchRepository.saveAll(docs);
                    SnomedCT lastEntity = batch.get(batch.size() - 1);
                    lastSeenId = lastEntity.getCode();
                    logger.info("Synchronized batch of {} Snomed entries (last id: {}) to Elasticsearch.", docs.size(), lastSeenId);
                }
            } while (!batch.isEmpty());

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

    private LoincDoc convertLoincToDoc(Loinc entity) {
        LoincDoc doc = new LoincDoc();
        doc.setId(entity.getLoincNum());
        doc.setLoincNum(entity.getLoincNum());
        doc.setComponent(entity.getComponent());
        doc.setClazz(entity.getClazz());
        doc.setStatusText(entity.getStatusText());
        doc.setDisplayName(entity.getDisplayName());
        return doc;
    }

    public void synchronizeLoinc() {
        System.out.println("DEBUG: synchronizeLoinc() started");
        logger.info("Starting Loinc synchronization...");
        try {
            long dbCount = loincRepository.count();
            System.out.println("DEBUG: Loinc records in DB: " + dbCount);
            logger.info("Total Loinc records found in database: {}", dbCount);

            int pageSize = 2000;
            String lastSeenId = "";
            List<Loinc> batch;

            do {
                Pageable pageable = PageRequest.of(0, pageSize, Sort.by("loincNum").ascending());
                batch = loincRepository.findByLoincNumGreaterThan(lastSeenId, pageable);
                
                if (!batch.isEmpty()) {
                    List<LoincDoc> docs = batch.stream()
                            .map(this::convertLoincToDoc)
                            .collect(Collectors.toList());

                    loincSearchRepository.saveAll(docs);
                    lastSeenId = batch.get(batch.size() - 1).getLoincNum();
                    logger.info("Synchronized batch of {} Loinc entries (last id: {}) to Elasticsearch.", docs.size(), lastSeenId);
                }
            } while (!batch.isEmpty());

            logger.info("Loinc synchronization completed.");

        } catch (Exception e) {
            System.err.println("DEBUG ERROR in synchronizeLoinc: " + e.getMessage());
            e.printStackTrace();
            logger.error("Error during Loinc synchronization", e);
        }
    }
}