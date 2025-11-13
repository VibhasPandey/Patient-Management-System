package com.pm.patient_service.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID uid;


    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private LocalDateTime dob;

    @NotNull
    private LocalDateTime registrationDate;

    public Patient(UUID uid, String name, String email, LocalDateTime dob, LocalDateTime registrationDate) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.registrationDate = registrationDate;
    }

    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email String email) {
        this.email = email;
    }

    public @NotNull LocalDateTime getDob() {
        return dob;
    }

    public void setDob(@NotNull LocalDateTime dob) {
        this.dob = dob;
    }

    public @NotNull LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(@NotNull LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
