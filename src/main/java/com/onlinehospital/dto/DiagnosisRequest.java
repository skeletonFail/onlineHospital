package com.onlinehospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisRequest {
    private String name;
    private String description;
    private String clinic;
    private String doctorFullName;
    private String diagnosticDate;
    private TherapyRequest therapy;

}
