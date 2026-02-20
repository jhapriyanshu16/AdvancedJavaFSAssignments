package org.lpu.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aadhaar_id", unique = true)
    private Aadhaar aadhaar;

    public Person() {}

    public Person(String name, Aadhaar aadhaar) {
        this.name = name;
        this.aadhaar = aadhaar;
    }


    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Aadhaar getAadhaar() { return aadhaar; }
    public void setAadhaar(Aadhaar aadhaar) { this.aadhaar = aadhaar; }
}