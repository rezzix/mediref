package com.mediref.repository.search;

import com.mediref.model.DrugDoc;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.annotations.Query;

import java.util.List;

@Repository
public interface DrugSearchRepository extends ElasticsearchRepository<DrugDoc, Long> {
    
    @Query("{\"query_string\": {\"query\": \"*?0*\", \"fields\": [\"description\", \"codeATC\", \"dci\", \"classTherapeutique\"]}}")
    List<DrugDoc> searchByAny(String query);
}
