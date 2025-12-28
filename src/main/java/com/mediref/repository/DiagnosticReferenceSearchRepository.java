package com.mediref.repository;

import com.mediref.model.DiagnosticReferenceDoc;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosticReferenceSearchRepository extends ElasticsearchRepository<DiagnosticReferenceDoc, Long> {
    
    @org.springframework.data.elasticsearch.annotations.Query("{\"query_string\": {\"query\": \"*?0*\", \"fields\": [\"code\", \"diagnostic\", \"ordre\", \"diagnosticLower\", \"codeLower\"]}}")
    List<DiagnosticReferenceDoc> searchByAny(String query);
}
