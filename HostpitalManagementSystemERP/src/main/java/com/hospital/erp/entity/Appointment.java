package com.hospital.erp.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime appointDate;
    private String status;
    private String reason;


    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Prescription prescription;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(LocalDateTime appointDate) {
        this.appointDate = appointDate;
    }

    public Appointment(Long id, Prescription prescription, Patient patient, Doctor doctor, String reason, String status, LocalDateTime appointDate) {
        this.id = id;
        this.prescription = prescription;
        this.patient = patient;
        this.doctor = doctor;
        this.reason = reason;
        this.status = status;
        this.appointDate = appointDate;
    }
}