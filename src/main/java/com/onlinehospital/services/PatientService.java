package com.onlinehospital.services;

import com.onlinehospital.dto.PatientRequest;
import com.onlinehospital.entities.patient_info_schema.patient_info.GenderEntity;
import com.onlinehospital.entities.patient_info_schema.patient_info.MaritalStatusEntity;
import com.onlinehospital.entities.patient_info_schema.patient_info.PatientEntity;
import com.onlinehospital.mapping.DtoToEntity;
import com.onlinehospital.repositories.PatientRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private GenderService genderService;
    @Autowired
    private MaritalStatusService maritalStatusService;

    @Async(value = "taskExecutor")
    public CompletableFuture<String> addPatient(PatientRequest request) {
        if (request != null) {
            GenderEntity gender = genderService.getGender(request.getGender());
            MaritalStatusEntity maritalStatus = maritalStatusService.getMaritalStatus(request.getMaritalStatus());
            if (!patientRepository.existsByPassportId(request.getPassportId())) {
                PatientEntity patientEntity = DtoToEntity.getPatient(request, maritalStatus, gender);
                patientRepository.save(patientEntity);
                return CompletableFuture.completedFuture("Success Saved");
            }
            else return CompletableFuture.completedFuture("Patient Exists");
        }
        else throw new NullPointerException();
    }

    @Async(value = "taskExecutor")
    public CompletableFuture<String> deletePatient(String passportId) {
        if (passportId != null) {
            Optional<PatientEntity> optional = patientRepository.findByPassportId(passportId);
            if (optional.isPresent()) {
                patientRepository.delete(optional.get());
                return CompletableFuture.completedFuture("Success Deleted");
            } else return CompletableFuture.completedFuture("Patient Not Found");
        } else throw new NullPointerException();
    }

    @Async(value = "taskExecutor")
    @Transactional(readOnly = true)
    public CompletableFuture<PatientEntity> getPatient(String passportId) {
        Optional<PatientEntity> optional = patientRepository.findByPassportId(passportId);
        if (optional.isPresent()) {
            PatientEntity patient = optional.get();
            init(patient.getGender(), patient.getMaritalStatus(),
                    patient.getContactInfo(), patient.getImage());
            return CompletableFuture.completedFuture(patient);
        } else throw new EntityNotFoundException();
    }

    private void init(Object... objs) {
        for (int i = 0; i < objs.length; i++) {
            Hibernate.initialize(objs[i]);
        }
    }


}
