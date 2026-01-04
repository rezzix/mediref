package com.mediref.repository;

import com.mediref.model.SnomedCTDoc;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SnomedCTSearchRepository extends ElasticsearchRepository<SnomedCTDoc, Long> {
    
    @Query("{\"query_string\": {\"query\": \"*?0*\", \"fields\": [\"valueSet\", \"description\", \"purpose\"]}}")
    List<SnomedCTDoc> searchByAny(String query);
}
