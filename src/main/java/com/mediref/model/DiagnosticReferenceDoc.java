package com.mediref.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "diagnostic_reference")
@Setting(shards = 1, replicas = 0)
public class DiagnosticReferenceDoc {

    @Id
    private Long id;

    @Field(type = FieldType.Text)
    private String code;

    @Field(type = FieldType.Text)
    private String diagnostic;

    @Field(type = FieldType.Text)
    private String ordre;

    // We can add more fields if we want to search on them, but these seem most relevant for full text search.
    // I'll add the lower case ones too just in case, though ES analysis usually handles case.
    
    @Field(type = FieldType.Text)
    private String diagnosticLower;
    
    @Field(type = FieldType.Text)
    private String codeLower;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public String getDiagnosticLower() {
        return diagnosticLower;
    }

    public void setDiagnosticLower(String diagnosticLower) {
        this.diagnosticLower = diagnosticLower;
    }

    public String getCodeLower() {
        return codeLower;
    }

    public void setCodeLower(String codeLower) {
        this.codeLower = codeLower;
    }
}
