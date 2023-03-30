package com.onlinehospital.services;

import com.onlinehospital.entities.patient_info_schema.patient_info.ImageEntity;
import com.onlinehospital.entities.patient_info_schema.patient_info.PatientEntity;
import com.onlinehospital.mapping.DtoToEntity;
import com.onlinehospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

@Service
public class ImageService {
    @Autowired
    private PatientRepository patientRepository;

    @Async(value = "imageExecutor")
    public CompletableFuture<String> addImage(MultipartFile file, PatientEntity patient) {
        if (file != null) {
            ImageEntity image = DtoToEntity.getImage(file);
            patient.setImage(image);
            patientRepository.save(patient);
            return CompletableFuture.completedFuture("Success Saved");
        }
        else throw new NullPointerException();
    }



}
