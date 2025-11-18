package com.pm.patient_service.mapper;

import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.models.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient){
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setId(patient.getUid().toString());
        patientResponseDTO.setName(patient.getName());
        patientResponseDTO.setEmail(patient.getEmail());
        patientResponseDTO.setDob(patient.getDob().toString());
        patientResponseDTO.setAddress(patient.getAddress());

        return patientResponseDTO;

    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());


        LocalDate dobDate = LocalDate.parse(patientRequestDTO.getDob());
        patient.setDob(dobDate.atStartOfDay());


        LocalDate regDate = LocalDate.parse(patientRequestDTO.getRegisteredDate());
        patient.setRegistrationDate(regDate.atStartOfDay());

        return patient;
    }
}
