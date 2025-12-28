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

    public SearchController(DiagnosticReferenceSearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @GetMapping
    public List<DiagnosticReferenceDoc> search(@RequestParam("q") String query) {
        return searchRepository.searchByAny(query);
    }
}
