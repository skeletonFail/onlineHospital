package com.onlinehospital.repositories;

import com.onlinehospital.entities.patient_info_schema.patient_info.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    Optional<ImageEntity> findById(String id);
}
