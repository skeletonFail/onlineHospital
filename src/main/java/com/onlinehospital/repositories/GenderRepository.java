package com.onlinehospital.repositories;

import com.onlinehospital.entities.patient_info_schema.patient_info.GenderEntity;
import com.onlinehospital.enums.EGender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenderRepository extends JpaRepository<GenderEntity, Long> {
    Optional<GenderEntity> findByName(EGender name);
    boolean existsByName(EGender name);
}
