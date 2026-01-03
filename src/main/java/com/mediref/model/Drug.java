package com.mediref.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicaments_gmr")
public class Drug {

    @Id
    @Column(name = "DRUG_CODE")
    private Long drugCode;

    @Column(name = "DESCRIPTION", length = 100)
    private String description;

    @Column(name = "Code_ATC", length = 50)
    private String codeATC;

    @Column(name = "DCI", length = 100)
    private String dci;

    @Column(name = "FORME", length = 100)
    private String forme;

    @Column(name = "PRESENTATION", length = 128)
    private String presentation;

    @Column(name = "CLASS_THERAPEUTIQUE", length = 100)
    private String classTherapeutique;

    @Column(name = "TABLEAUABC", length = 50)
    private String tableauabc;

    @Column(name = "LABORATORY", length = 50)
    private String laboratory;

    @Column(name = "DOSAGE")
    private Float dosage;

    @Column(name = "UNIT", length = 50)
    private String unit;

    @Column(name = "PPV", length = 50)
    private String ppv;

    @Column(name = "PH", length = 50)
    private String ph;

    @Column(name = "REIMBURSEMENT_RATE")
    private Integer reimbursementRate;

    @Column(name = "ISGENERIC")
    private Integer isGeneric;

    // Getters and Setters

    public Long getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(Long drugCode) {
        this.drugCode = drugCode;
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
