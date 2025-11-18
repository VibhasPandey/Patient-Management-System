package com.pm.patient_service.dto;

import com.pm.patient_service.validators.CreatePatientValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {

    @NotBlank(message= "Name is required")
    @Size(max= 100, message= "Name cannot exceed more than 100 charaters")
    private String name;

    @NotBlank(message= "Email is required")
    @Email(message="Email should be valid")
    private String email;

    @NotBlank(message= "Address is required")
    private String address;

    @NotBlank(message= "Date of Birth is required")
    private String dob;

    @NotBlank(groups = CreatePatientValidationGroup.class ,message= "Registered date is required")
    private String registeredDate;

    public @NotBlank(message = "Name is required") @Size(max = 100, message = "Name cannot exceed more than 100 charaters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is required") @Size(max = 100, message = "Name cannot exceed more than 100 charaters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Address is required") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Address is required") String address) {
        this.address = address;
    }

    public @NotBlank(message = "Date of Birth is required") String getDob() {
        return dob;
    }

    public void setDob(@NotBlank(message = "Date of Birth is required") String dob) {
        this.dob = dob;
    }

    public  String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(@NotBlank(message = "Registered date is required") String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
