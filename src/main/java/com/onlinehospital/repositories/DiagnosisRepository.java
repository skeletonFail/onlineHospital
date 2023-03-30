package com.onlinehospital.repositories;

import com.onlinehospital.entities.patient_info_schema.medical_info.DiagnosisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisRepository extends JpaRepository<DiagnosisEntity, Long> {
}
