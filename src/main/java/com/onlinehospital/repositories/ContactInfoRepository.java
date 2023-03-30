package com.onlinehospital.repositories;

import com.onlinehospital.entities.patient_info_schema.patient_info.ContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfoEntity, Long> {

}
