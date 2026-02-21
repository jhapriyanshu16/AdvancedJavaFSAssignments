package com.hospital.erp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate recordDate;
    private String diagnosis;
    private String notes;

    public MedicalRecord() {
    }

    public MedicalRecord(Long id, LocalDate recordDate, String diagnosis, String notes) {
        this.id = id;
        this.recordDate = recordDate;
        this.diagnosis = diagnosis;
        this.notes = notes;
    }

    public Long getId() { return id; }
    public LocalDate getRecordDate() { return recordDate; }
    public String getDiagnosis() { return diagnosis; }
    public String getNotes() { return notes; }

    public void setId(Long id) { this.id = id; }
    public void setRecordDate(LocalDate recordDate) { this.recordDate = recordDate; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public void setNotes(String notes) { this.notes = notes; }
}