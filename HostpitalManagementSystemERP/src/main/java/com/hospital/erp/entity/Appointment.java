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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    public Appointment() {
    }

    public Appointment(Long id, LocalDateTime appointDate, String status, String reason) {
        this.id = id;
        this.appointDate = appointDate;
        this.status = status;
        this.reason = reason;
    }

    public Long getId() { return id; }
    public LocalDateTime getAppointDate() { return appointDate; }
    public String getStatus() { return status; }
    public String getReason() { return reason; }
    public Prescription getPrescription() { return prescription; }

    public void setId(Long id) { this.id = id; }
    public void setAppointDate(LocalDateTime appointDate) { this.appointDate = appointDate; }
    public void setStatus(String status) { this.status = status; }
    public void setReason(String reason) { this.reason = reason; }
    public void setPrescription(Prescription prescription) { this.prescription = prescription; }
}