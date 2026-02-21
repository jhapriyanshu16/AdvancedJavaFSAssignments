package com.hospital.erp.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private String licenseNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private List<Appointment> appointments = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "patient_doctors",
            joinColumns = @JoinColumn(name = "doctor_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Patient> patients = new ArrayList<>();

    public Doctor() {
    }

    public Doctor(Long id, String name, String specialization, String licenseNo) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.licenseNo = licenseNo;
    }

    public void addPatient(Patient p) {
        patients.add(p);
        p.getDoctors().add(this);
    }

    public void removePatient(Patient p) {
        patients.remove(p);
        p.getDoctors().remove(this);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public String getLicenseNo() { return licenseNo; }
    public Department getDepartment() { return department; }
    public List<Appointment> getAppointments() { return appointments; }
    public List<Patient> getPatients() { return patients; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public void setLicenseNo(String licenseNo) { this.licenseNo = licenseNo; }
    public void setDepartment(Department department) { this.department = department; }
}