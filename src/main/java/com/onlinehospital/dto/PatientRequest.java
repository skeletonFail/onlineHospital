package com.onlinehospital.dto;

import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRequest {
    private String passportId;
    private String name;
    private String lastName;
    @Unsigned
    private Integer age;
    private String birthday;
    private ContactInfo contactInfo;
    private String gender;
    private String maritalStatus;
    private MedicalCardRequest medicalCard;
}
