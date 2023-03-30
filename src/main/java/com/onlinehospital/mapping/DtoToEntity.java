package com.onlinehospital.mapping;

import com.onlinehospital.dto.*;
import com.onlinehospital.entities.patient_info_schema.medical_info.DiagnosisEntity;
import com.onlinehospital.entities.patient_info_schema.medical_info.MedicalCardEntity;
import com.onlinehospital.entities.patient_info_schema.medical_info.TherapyEntity;
import com.onlinehospital.entities.patient_info_schema.patient_info.*;
import com.onlinehospital.entities.patient_info_schema.users.UserEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DtoToEntity {

    public static PatientEntity getPatient(PatientRequest dto, MaritalStatusEntity maritalStatus, GenderEntity gender) {
        PatientEntity patient = new PatientEntity();
        patient.setPassportId(dto.getPassportId());
        patient.setName(dto.getName());
        patient.setLastName(dto.getLastName());
        patient.setAge(dto.getAge());
        patient.setBirthday(DateMapper.stringToDate(dto.getBirthday()));
        patient.setMaritalStatus(maritalStatus);
        patient.setGender(gender);
        patient.setRegistrationDate(new Date());
        patient.setContactInfo(getContactInfo(dto.getContactInfo()));
        patient.setMedicalCard(getMedicalCard(dto.getMedicalCard()));
        return patient;
    }

    public static ContactInfoEntity getContactInfo(ContactInfo contactInfo) {
        ContactInfoEntity entity = new ContactInfoEntity();
        entity.setEmail(contactInfo.getEmail());
        entity.setAddress(contactInfo.getAddress());
        entity.setPhoneNumber(contactInfo.getPhoneNumber());
        return entity;
    }

    public static ImageEntity getImage(MultipartFile file) {
        ImageEntity image = new ImageEntity();
        try {
            image.setName(StringUtils.cleanPath(file.getOriginalFilename()));
            image.setContentType(file.getContentType());
            image.setSize(file.getSize());
            image.setData(file.getBytes());
            return image;
        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    public static TherapyEntity getTherapy(TherapyRequest request) {
        TherapyEntity entity = new TherapyEntity();
        entity.setMedicines(request.getMedicines());
        entity.setDescription(request.getDescription());
        entity.setInstruction(request.getInstruction());
        entity.setTherapyDate(DateMapper.stringToDate(request.getTherapyDate()));
        return entity;
    }

    public static DiagnosisEntity getDiagnosis(DiagnosisRequest request) {
        DiagnosisEntity entity = new DiagnosisEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setClinic(request.getClinic());
        entity.setDoctorFullName(request.getDoctorFullName());
        entity.setDiagnosticDate(DateMapper.stringToDate(request.getDiagnosticDate()));
        entity.setTherapy(getTherapy(request.getTherapy()));
        return entity;
    }

    public static MedicalCardEntity getMedicalCard(MedicalCardRequest request) {
        MedicalCardEntity entity = new MedicalCardEntity();
        entity.setAllergies(request.getAllergies());
        entity.setRegistrationDate(DateMapper.stringToDate(request.getRegistrationDate()));

        List<DiagnosisEntity> diagnoses = new ArrayList<>();
        for (int i = 0; i < request.getDiagnoses().length; i++) {
            diagnoses.add(getDiagnosis(request.getDiagnoses()[i]));
        }

        entity.setDiagnosisEntities(diagnoses);
        return entity;
    }


}
