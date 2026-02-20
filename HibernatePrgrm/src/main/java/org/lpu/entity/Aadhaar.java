package org.lpu.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "aadhaar")
public class Aadhaar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, length = 12)
    private String number;

    @OneToOne(mappedBy = "aadhaar")
    private Person person;

    public Aadhaar() {}

    public Aadhaar(String number) {
        this.number = number;
    }

}
