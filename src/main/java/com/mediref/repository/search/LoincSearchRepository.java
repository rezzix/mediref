package com.mediref.repository.search;

import com.mediref.model.LoincDoc;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoincSearchRepository extends ElasticsearchRepository<LoincDoc, String> {

    @Query("{\"query_string\": {\"query\": \"*?0*\", \"fields\": [\"loincNum\", \"component\", \"shortName\", \"longCommonName\"]}}")
    List<LoincDoc> searchByAny(String query);
}
