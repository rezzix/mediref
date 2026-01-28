package com.mediref.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "loinc")
@Setting(shards = 1, replicas = 0)
public class LoincDoc {

    @Id
    private String id; // Maps to LOINC_NUM

    @Field(type = FieldType.Text)
    private String loincNum;

    @Field(type = FieldType.Text)
    private String component;

    @Field(type = FieldType.Text)
    private String methodTyp;

    @Field(type = FieldType.Text)
    private String clazz;

    @Field(type = FieldType.Text)
    private String definitionDescription;

    @Field(type = FieldType.Text)
    private String status;

    @Field(type = FieldType.Text)
    private String consumerName;

    @Field(type = FieldType.Integer)
    private Integer classType;

    @Field(type = FieldType.Text)
    private String formula;

    @Field(type = FieldType.Text)
    private String exmplAnswers;

    @Field(type = FieldType.Text)
    private String surveyQuestText;

    @Field(type = FieldType.Text)
    private String surveyQuestSrc;

    @Field(type = FieldType.Text)
    private String unitsRequired;

    @Field(type = FieldType.Text)
    private String relatedNames2;

    @Field(type = FieldType.Text)
    private String shortName;

    @Field(type = FieldType.Text)
    private String orderObs;

    @Field(type = FieldType.Text)
    private String hl7FieldSubfieldId;

    @Field(type = FieldType.Text)
    private String externalCopyrightNotice;

    @Field(type = FieldType.Text)
    private String exampleUnits;

    @Field(type = FieldType.Text)
    private String longCommonName;

    @Field(type = FieldType.Text)
    private String exampleUcumUnits;

    @Field(type = FieldType.Text)
    private String statusReason;

    @Field(type = FieldType.Text)
    private String statusText;

    @Field(type = FieldType.Text)
    private String displayName;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
