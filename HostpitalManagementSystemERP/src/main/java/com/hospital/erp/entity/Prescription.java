package com.hospital.erp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicines;
    private String dosage;
    private LocalDate issuedDate;
    private boolean active;

    public Prescription() {
    }

    public Prescription(Long id, String medicines, String dosage, LocalDate issuedDate, boolean active) {
        this.id = id;
        this.medicines = medicines;
        this.dosage = dosage;
        this.issuedDate = issuedDate;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getMedicines() { return medicines; }
    public String getDosage() { return dosage; }
    public LocalDate getIssuedDate() { return issuedDate; }
    public boolean isActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setMedicines(String medicines) { this.medicines = medicines; }
    public void setDosage(String dosage) { this.dosage = dosage; }
    public void setIssuedDate(LocalDate issuedDate) { this.issuedDate = issuedDate; }
    public void setActive(boolean active) { this.active = active; }
}