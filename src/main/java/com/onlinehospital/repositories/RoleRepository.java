package com.onlinehospital.repositories;

import com.onlinehospital.entities.patient_info_schema.users.RoleEntity;
import com.onlinehospital.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(ERole name);
}
