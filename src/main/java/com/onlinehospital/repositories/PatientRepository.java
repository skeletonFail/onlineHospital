package com.onlinehospital.repositories;

import com.onlinehospital.entities.patient_info_schema.patient_info.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    Optional<PatientEntity> findByPassportId(String passportId);
    boolean existsByPassportId(String passportId);
}
