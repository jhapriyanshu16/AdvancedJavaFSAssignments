package org.lpu.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;
    private String state;

    @Column(name = "nation")
    private String country;

    @Transient
    private double letItBe;   // not stored in DB

    @Temporal(TemporalType.DATE)
    private Date date;        // must be java.util.Date (not String)

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;     // image stored as byte[]

    public Address() {}

    public Address(String city, String state, String country, Date date, User user, byte[] image) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.date = date;
        this.user = user;
        this.image = image;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }
}
