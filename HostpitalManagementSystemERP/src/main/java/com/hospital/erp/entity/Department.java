package com.hospital.erp.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String headDoctorName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Doctor> doctors = new ArrayList<>();

    public Department() {
    }

    public Department(Long id, String name, String location, String headDoctorName) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.headDoctorName = headDoctorName;
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
        d.setDepartment(this);
    }

    public void removeDoctor(Doctor d) {
        doctors.remove(d);
        d.setDepartment(null);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public String getHeadDoctorName() { return headDoctorName; }
    public List<Doctor> getDoctors() { return doctors; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    public void setHeadDoctorName(String headDoctorName) { this.headDoctorName = headDoctorName; }
}