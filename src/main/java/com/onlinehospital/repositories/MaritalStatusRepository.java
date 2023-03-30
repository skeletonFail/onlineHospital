package com.onlinehospital.repositories;

import com.onlinehospital.entities.patient_info_schema.patient_info.MaritalStatusEntity;
import com.onlinehospital.enums.EMaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaritalStatusRepository extends JpaRepository<MaritalStatusEntity, Long> {
    Optional<MaritalStatusEntity> findByName(EMaritalStatus name);
    boolean existsByName(EMaritalStatus name);
}
