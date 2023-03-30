package com.onlinehospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardRequest {
    private String allergies;
    private String registrationDate;
    private DiagnosisRequest[] diagnoses;
}
