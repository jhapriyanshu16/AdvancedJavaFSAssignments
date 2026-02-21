package com.hospital.erp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dob;
    private String bloodGroup;
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_record_id", unique = true)
    private MedicalRecord medicalRecord;

    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors = new ArrayList<>();

    public Patient() {
    }

    public Patient(Long id, String name, LocalDate dob, String bloodGroup, String phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public LocalDate getDob() { return dob; }
    public String getBloodGroup() { return bloodGroup; }
    public String getPhone() { return phone; }
    public MedicalRecord getMedicalRecord() { return medicalRecord; }
    public List<Doctor> getDoctors() { return doctors; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setMedicalRecord(MedicalRecord medicalRecord) { this.medicalRecord = medicalRecord; }
    public void setDoctors(List<Doctor> doctors) { this.doctors = doctors; }
}