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
    private String property;

    @Field(type = FieldType.Text)
    private String timeAspct;

    @Field(type = FieldType.Text)
    private String system;

    @Field(type = FieldType.Text)
    private String clazz;

    @Field(type = FieldType.Text)
    private String formula;

    @Field(type = FieldType.Text)
    private String shortName;

    @Field(type = FieldType.Text)
    private String longCommonName;

    @Field(type = FieldType.Text)
    private String displayName;

    @Field(type = FieldType.Text)
    private String definitionDescription;

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

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getTimeAspct() {
        return timeAspct;
    }

    public void setTimeAspct(String timeAspct) {
        this.timeAspct = timeAspct;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongCommonName() {
        return longCommonName;
    }

    public void setLongCommonName(String longCommonName) {
        this.longCommonName = longCommonName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDefinitionDescription() {
        return definitionDescription;
    }

    public void setDefinitionDescription(String definitionDescription) {
        this.definitionDescription = definitionDescription;
    }
}
