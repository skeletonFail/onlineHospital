package com.onlinehospital.services;

import com.onlinehospital.dto.ContactInfo;
import com.onlinehospital.entities.patient_info_schema.patient_info.ContactInfoEntity;
import com.onlinehospital.entities.patient_info_schema.patient_info.PatientEntity;
import com.onlinehospital.mapping.DtoToEntity;
import com.onlinehospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ContactInfoService {
    @Autowired
    private PatientRepository patientRepository;

    public CompletableFuture<String> addContactInfo(ContactInfo contactInfo, PatientEntity patient) {
        if (contactInfo != null) {
            ContactInfoEntity entity = DtoToEntity.getContactInfo(contactInfo);
            patient.setContactInfo(entity);
            patientRepository.save(patient);
            return CompletableFuture.completedFuture("Success Saved");
        }
        else throw new NullPointerException();
    }


}
