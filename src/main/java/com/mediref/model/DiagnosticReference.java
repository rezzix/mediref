package com.mediref.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnostic_reference", schema = "public")
public class DiagnosticReference {

    @Id
    private Long id;

    @Column(name = "\"level\"")
    private Integer level;

    private Long id4;

    @Column(length = 50)
    private String code;

    private Long id3;

    @Column(nullable = false, length = 500)
    private String diagnostic;

    private Long id5;

    private Long id7;

    @Column(name = "diagnostic_lower", length = 500)
    private String diagnosticLower;

    private Long id1;

    private Long id2;

    private String ordre;

    @Column(name = "\"type\"", length = 10)
    private String type;

    private Long id6;

    @Column(name = "code_lower", length = 50)
    private String codeLower;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getId4() {
        return id4;
    }

    public void setId4(Long id4) {
        this.id4 = id4;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getId3() {
        return id3;
    }

    public void setId3(Long id3) {
        this.id3 = id3;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Long getId5() {
        return id5;
    }

    public void setId5(Long id5) {
        this.id5 = id5;
    }

    public Long getId7() {
        return id7;
    }

    public void setId7(Long id7) {
        this.id7 = id7;
    }

    public String getDiagnosticLower() {
        return diagnosticLower;
    }

    public void setDiagnosticLower(String diagnosticLower) {
        this.diagnosticLower = diagnosticLower;
    }

    public Long getId1() {
        return id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }

    public String getOrdre() {
        return ordre;
    }

    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId6() {
        return id6;
    }

    public void setId6(Long id6) {
        this.id6 = id6;
    }

    public String getCodeLower() {
        return codeLower;
    }

    public void setCodeLower(String codeLower) {
        this.codeLower = codeLower;
    }
}
