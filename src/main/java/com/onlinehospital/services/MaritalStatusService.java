package com.onlinehospital.services;

import com.onlinehospital.entities.patient_info_schema.patient_info.MaritalStatusEntity;
import com.onlinehospital.enums.EMaritalStatus;
import com.onlinehospital.repositories.MaritalStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class MaritalStatusService {
    @Autowired
    private MaritalStatusRepository maritalStatusRepository;

    public MaritalStatusEntity getMaritalStatus(String name) {
        Optional<MaritalStatusEntity> optional = maritalStatusRepository.findByName(EMaritalStatus.valueOf(name));
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new EntityNotFoundException();
    }

}
