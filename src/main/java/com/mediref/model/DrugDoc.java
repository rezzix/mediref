package com.mediref.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "medicaments_gmr")
@Setting(shards = 1, replicas = 0)
public class DrugDoc {

    @Id
    private Long id; // Maps to drugCode

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private String codeATC;

    @Field(type = FieldType.Text)
    private String dci;

    @Field(type = FieldType.Long)
    private Long drugCode;

    @Field(type = FieldType.Text)
    private String forme;

    @Field(type = FieldType.Text)
    private String presentation;

    @Field(type = FieldType.Text)
    private String classTherapeutique;

    @Field(type = FieldType.Text)
    private String tableauabc;

    @Field(type = FieldType.Text)
    private String laboratory;

    @Field(type = FieldType.Float)
    private Float dosage;

    @Field(type = FieldType.Text)
    private String unit;

    @Field(type = FieldType.Text)
    private String ppv;

    @Field(type = FieldType.Text)
    private String ph;

    @Field(type = FieldType.Integer)
    private Integer reimbursementRate;

    @Field(type = FieldType.Integer)
    private Integer isGeneric;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodeATC() {
        return codeATC;
    }

    public void setCodeATC(String codeATC) {
        this.codeATC = codeATC;
    }

    public String getDci() {
        return dci;
    }

    public void setDci(String dci) {
        this.dci = dci;
    }

    public Long getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(Long drugCode) {
        this.drugCode = drugCode;
    }

    public String getForme() {
        return forme;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getClassTherapeutique() {
        return classTherapeutique;
    }

    public void setClassTherapeutique(String classTherapeutique) {
        this.classTherapeutique = classTherapeutique;
    }

    public String getTableauabc() {
        return tableauabc;
    }

    public void setTableauabc(String tableauabc) {
        this.tableauabc = tableauabc;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public Float getDosage() {
        return dosage;
    }

    public void setDosage(Float dosage) {
        this.dosage = dosage;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPpv() {
        return ppv;
    }

    public void setPpv(String ppv) {
        this.ppv = ppv;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public Integer getReimbursementRate() {
        return reimbursementRate;
    }

    public void setReimbursementRate(Integer reimbursementRate) {
        this.reimbursementRate = reimbursementRate;
    }

    public Integer getIsGeneric() {
        return isGeneric;
    }

    public void setIsGeneric(Integer isGeneric) {
        this.isGeneric = isGeneric;
    }
}
