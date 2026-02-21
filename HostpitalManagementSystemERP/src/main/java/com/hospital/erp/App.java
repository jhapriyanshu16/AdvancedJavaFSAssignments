package com.hospital.erp;

import com.hospital.erp.entity.*;
import com.hospital.erp.service.*;
import com.hospital.erp.util.JPAUtil;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        DepartmentService departmentService = new DepartmentService();
        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();

        Department department = new Department();
        department.setName("Cardiology");
        departmentService.save(department);

        Doctor doctor = new Doctor();
        doctor.setName("Dr. Smith");
        doctor.setSpecialization("Heart Specialist");
        doctor.setDepartment(department);
        doctorService.save(doctor);

        Patient patient = new Patient();
        patient.setName("John Doe");
        patient.setDob(LocalDate.of(1995, 5, 20));
        patient.setBloodGroup("O+");
        patient.setPhone("9999999999");
        patientService.save(patient);

        doctorService.assignPatient(doctor.getId(), patient.getId());


    }
}