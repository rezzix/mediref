package com.mediref.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "snomed_ct", schema = "public")
public class SnomedCT {

    @Id
    @Column(name = "code")
    private Long code;

    @Column(name = "value_set", length = 150)
    private String valueSet;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "purpose", length = 1000)
    private String purpose;

    // Getters and Setters

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getValueSet() {
        return valueSet;
    }

    public void setValueSet(String valueSet) {
        this.valueSet = valueSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
