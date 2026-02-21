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

    @OneToOne(mappedBy = "medicalRecord")
    private Patient patient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public MedicalRecord(Long id, LocalDate recordDate, String diagnosis, String notes, Patient patient) {
        this.id = id;
        this.recordDate = recordDate;
        this.diagnosis = diagnosis;
        this.notes = notes;
        this.patient = patient;
    }
}