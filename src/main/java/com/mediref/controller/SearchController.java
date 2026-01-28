package com.mediref.controller;

import com.mediref.model.DiagnosticReferenceDoc;
import com.mediref.repository.search.*;
import com.mediref.model.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final DiagnosticReferenceSearchRepository searchRepository;
    private final DrugSearchRepository drugSearchRepository;
    private final SnomedCTSearchRepository snomedCTSearchRepository;
    private final LoincSearchRepository loincSearchRepository;

    public SearchController(DiagnosticReferenceSearchRepository searchRepository, 
                            DrugSearchRepository drugSearchRepository,
                            SnomedCTSearchRepository snomedCTSearchRepository,
                            LoincSearchRepository loincSearchRepository) {
        this.searchRepository = searchRepository;
        this.drugSearchRepository = drugSearchRepository;
        this.snomedCTSearchRepository = snomedCTSearchRepository;
        this.loincSearchRepository = loincSearchRepository;
    }

    @GetMapping("/diagnosis")
    public List<DiagnosticReferenceDoc> searchDiagnosys(@RequestParam("q") String query) {
        return searchRepository.searchByAny(query);
    }

    @GetMapping("/drugs")
    public List<DrugDoc> searchDrug(@RequestParam("q") String query) {
        return drugSearchRepository.searchByAny(query);
    }

    @GetMapping("/snomed")
    public List<SnomedCTDoc> searchSnomed(@RequestParam("q") String query) {
        return snomedCTSearchRepository.searchByAny(query);
    }

    @GetMapping("/loinc")
    public List<LoincDoc> searchLoinc(@RequestParam("q") String query) {
        return loincSearchRepository.searchByAny(query);
    }
}
