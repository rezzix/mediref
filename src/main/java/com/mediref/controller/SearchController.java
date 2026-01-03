package com.mediref.controller;

import com.mediref.model.DiagnosticReferenceDoc;
import com.mediref.repository.DiagnosticReferenceSearchRepository;
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
    private final com.mediref.repository.DrugSearchRepository drugSearchRepository;

    public SearchController(DiagnosticReferenceSearchRepository searchRepository, com.mediref.repository.DrugSearchRepository drugSearchRepository) {
        this.searchRepository = searchRepository;
        this.drugSearchRepository = drugSearchRepository;
    }

    @GetMapping("/diagnosis")
    public List<DiagnosticReferenceDoc> searchDiagnosys(@RequestParam("q") String query) {
        return searchRepository.searchByAny(query);
    }

    @GetMapping("/drugs")
    public java.util.List<com.mediref.model.DrugDoc> searchDrug(@RequestParam("q") String query) {
        return drugSearchRepository.searchByAny(query);
    }
}
