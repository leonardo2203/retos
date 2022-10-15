package com.example.reto3ciclo3.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "costume")

public class Costume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String name ;
    private String brand;
    @Column(name = "years")
    private Integer year ;
    private String description;

    @ManyToOne
    @JoinColumn(name= "categoryId")
    @JsonIgnoreProperties("Costume")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "costumes")
    @JsonIgnoreProperties({"Costume","Message"})
    public List<Reservation>reservations;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "costume")
    @JsonIgnoreProperties({"Costume","Client"})
    public  List<Message>messages;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarca() {
        return
                brand;
    }

    public void setMarca(String marca) {
        this.
                brand =
                brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
