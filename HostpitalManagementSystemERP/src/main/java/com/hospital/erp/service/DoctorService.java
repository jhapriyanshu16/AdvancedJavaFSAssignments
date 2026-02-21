package com.hospital.erp.service;

import com.hospital.erp.entity.Doctor;
import com.hospital.erp.entity.Patient;
import com.hospital.erp.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class DoctorService {

    public void save(Doctor doctor) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(doctor);
        tx.commit();
        em.close();
    }

    public Doctor findById(Long id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Doctor doctor = em.find(Doctor.class, id);
        em.close();
        return doctor;
    }

    public void assignPatient(Long doctorId, Long patientId) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Doctor doctor = em.find(Doctor.class, doctorId);
        Patient patient = em.find(Patient.class, patientId);
        doctor.addPatient(patient);
        tx.commit();
        em.close();
    }

    public List<Doctor> findByDepartmentName(String name) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Doctor> list = em.createQuery(
                        "SELECT d FROM Doctor d WHERE d.department.name = :n",
                        Doctor.class)
                .setParameter("n", name)
                .getResultList();
        em.close();
        return list;
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Doctor doctor = em.find(Doctor.class, id);
        em.remove(doctor);
        tx.commit();
        em.close();
    }
}