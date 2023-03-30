package com.onlinehospital.services;

import com.onlinehospital.entities.patient_info_schema.patient_info.GenderEntity;
import com.onlinehospital.enums.EGender;
import com.onlinehospital.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class GenderService {
    @Autowired
    private GenderRepository genderRepository;

    public GenderEntity getGender(String name) {
        Optional<GenderEntity> optional = genderRepository.findByName(EGender.valueOf(name));
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new EntityNotFoundException();
    }

}
