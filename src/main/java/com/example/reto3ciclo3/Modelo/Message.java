package com.example.reto3ciclo3.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "message")

public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn (name="costumeid")
    @JsonIgnoreProperties ({"Messages","Reservations"})
    private Costume costume;

    @ManyToOne
    @JoinColumn (name="clientid")
    @JsonIgnoreProperties ({"Messages","Reservations"})
    private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Costume getCostumes() {
        return costume;
    }

    public void setCostumes(Costume costumes) {
        this.costume = costumes;
    }

    public Client getClients() {
        return client;
    }

    public void setClients(Client clients) {
        this.client= clients;
    }
}
