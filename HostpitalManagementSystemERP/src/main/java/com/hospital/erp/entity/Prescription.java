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


    @OneToOne
    @JoinColumn(name = "appointment_id", unique = true)
    private Appointment appointment;

    public Prescription() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public Prescription(Long id, String medicines, String dosage, LocalDate issuedDate, Appointment appointment) {
        this.id = id;
        this.medicines = medicines;
        this.dosage = dosage;
        this.issuedDate = issuedDate;
        this.appointment = appointment;
    }
}
