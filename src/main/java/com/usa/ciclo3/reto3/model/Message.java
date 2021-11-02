package com.usa.ciclo3.reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "message")
public class Message implements Serializable {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idMessage;
        private String messageText;

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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

        

        @ManyToOne
        @JoinColumn(name="idDoctor")
        @JsonIgnoreProperties({"messages", "client", "reservations"})
        private Doctor doctor;

        @ManyToOne
        @JoinColumn(name="idClient")
        @JsonIgnoreProperties({"messages", "reservations", "client"})
        private Client client;

}


