package com.github.dzeko14.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coach {
    @Id
    private String phoneNumber;
    private String name;
    private String gymAddress;

    public Coach() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGymAddress() {
        return gymAddress;
    }

    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }
}
