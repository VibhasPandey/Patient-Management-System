package com.pm.patient_service.service;


import com.pm.patient_service.dto.PatientRequestDTO;
import com.pm.patient_service.dto.PatientResponseDTO;
import com.pm.patient_service.exception.EmailAlreadyExistsException;
import com.pm.patient_service.exception.PatientNotFoundException;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.models.Patient;
import com.pm.patient_service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }


    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email already exists:"+patientRequestDTO.getEmail());
        }
        Patient newPatient= patientRepository.save(PatientMapper.toModel(
                patientRequestDTO
        ));

        return PatientMapper.toDTO(newPatient);
    }

    public PatientResponseDTO updatePatient(UUID uuid,PatientRequestDTO patientRequestDTO){

        Patient patient=patientRepository.findById(uuid).orElseThrow(
                ()->new PatientNotFoundException("Patient not found, id: "+uuid));

        if(patientRepository.existsByEmailAndUidNot(patientRequestDTO.getEmail(),uuid)){
            throw new EmailAlreadyExistsException("A patient with this email already exists:"+patientRequestDTO.getEmail());
        }

        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        LocalDate dobDate = LocalDate.parse(patientRequestDTO.getDob());
        patient.setDob(dobDate.atStartOfDay());

        Patient updatedPatient = patientRepository.save(patient);

        return PatientMapper.toDTO(updatedPatient);

    }

    public void deletePatient(UUID id){
        patientRepository.deleteById(id);
    }


}
