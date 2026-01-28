package com.mediref.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loinc", schema = "public")
public class Loinc {

    @Id
    @Column(name = "loinc_num", length = 50)
    private String loincNum;

    @Column(name = "component", length = 470)
    private String component;

    @Column(name = "method_typ", length = 120)
    private String methodTyp;

    @Column(name = "class_", length = 50)
    private String clazz;

    @Column(name = "version_last_changed")
    private Float versionLastChanged;

    @Column(name = "definition_description", length = 5100)
    private String definitionDescription;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "consumer_name", length = 150)
    private String consumerName;

    @Column(name = "classtype")
    private Integer classType;

    @Column(name = "formula", length = 500)
    private String formula;

    @Column(name = "exmpl_answers", length = 4970)
    private String exmplAnswers;

    @Column(name = "survey_quest_text", length = 650)
    private String surveyQuestText;

    @Column(name = "survey_quest_src", length = 150)
    private String surveyQuestSrc;

    @Column(name = "unitsrequired", length = 140)
    private String unitsRequired;

    @Column(name = "relatednames2", length = 1850)
    private String relatedNames2;

    @Column(name = "shortname", length = 80)
    private String shortName;

    @Column(name = "order_obs", length = 50)
    private String orderObs;

    @Column(name = "hl7_field_subfield_id", length = 50)
    private String hl7FieldSubfieldId;

    @Column(name = "external_copyright_notice", length = 2810)
    private String externalCopyrightNotice;

    @Column(name = "example_units", length = 50)
    private String exampleUnits;

    @Column(name = "long_common_name", length = 359)
    private String longCommonName;

    @Column(name = "example_ucum_units", length = 50)
    private String exampleUcumUnits;

    @Column(name = "status_reason", length = 50)
    private String statusReason;

    @Column(name = "status_text", length = 820)
    private String statusText;

    @Column(name = "display_name", length = 440)
    private String displayName;

    // Getters and Setter

    public String getLoincNum() {
        return loincNum;
    }

    public void setLoincNum(String loincNum) {
        this.loincNum = loincNum;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getDefinitionDescription() {
        return definitionDescription;
    }

    public void setDefinitionDescription(String definitionDescription) {
        this.definitionDescription = definitionDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public Integer getClassType() {
        return classType;
    }

    public void setClassType(Integer classType) {
        this.classType = classType;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getExmplAnswers() {
        return exmplAnswers;
    }

    public void setExmplAnswers(String exmplAnswers) {
        this.exmplAnswers = exmplAnswers;
    }

    public String getSurveyQuestText() {
        return surveyQuestText;
    }

    public void setSurveyQuestText(String surveyQuestText) {
        this.surveyQuestText = surveyQuestText;
    }

    public String getSurveyQuestSrc() {
        return surveyQuestSrc;
    }

    public void setSurveyQuestSrc(String surveyQuestSrc) {
        this.surveyQuestSrc = surveyQuestSrc;
    }

    public String getUnitsRequired() {
        return unitsRequired;
    }

    public void setUnitsRequired(String unitsRequired) {
        this.unitsRequired = unitsRequired;
    }

    public String getRelatedNames2() {
        return relatedNames2;
    }

    public void setRelatedNames2(String relatedNames2) {
        this.relatedNames2 = relatedNames2;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getOrderObs() {
        return orderObs;
    }

    public void setOrderObs(String orderObs) {
        this.orderObs = orderObs;
    }

    public String getHl7FieldSubfieldId() {
        return hl7FieldSubfieldId;
    }

    public void setHl7FieldSubfieldId(String hl7FieldSubfieldId) {
        this.hl7FieldSubfieldId = hl7FieldSubfieldId;
    }

    public String getExternalCopyrightNotice() {
        return externalCopyrightNotice;
    }

    public void setExternalCopyrightNotice(String externalCopyrightNotice) {
        this.externalCopyrightNotice = externalCopyrightNotice;
    }

    public String getExampleUnits() {
        return exampleUnits;
    }

    public void setExampleUnits(String exampleUnits) {
        this.exampleUnits = exampleUnits;
    }

    public String getLongCommonName() {
        return longCommonName;
    }

    public void setLongCommonName(String longCommonName) {
        this.longCommonName = longCommonName;
    }

    public String getExampleUcumUnits() {
        return exampleUcumUnits;
    }

    public void setExampleUcumUnits(String exampleUcumUnits) {
        this.exampleUcumUnits = exampleUcumUnits;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }


    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
