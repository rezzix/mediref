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

    @Column(name = "property", length = 50)
    private String property;

    @Column(name = "time_aspct", length = 50)
    private String timeAspct;

    @Column(name = "system_", length = 110)
    private String system;

    @Column(name = "class_", length = 50)
    private String clazz;

    @Column(name = "formula", length = 500)
    private String formula;

    @Column(name = "shortname", length = 80)
    private String shortName;

    @Column(name = "long_common_name", length = 359)
    private String longCommonName;

    @Column(name = "display_name", length = 440)
    private String displayName;

    @Column(name = "definition_description", length = 5100)
    private String definitionDescription;

    // Getters and Setters

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
