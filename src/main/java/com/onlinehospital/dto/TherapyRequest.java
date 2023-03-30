package com.onlinehospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TherapyRequest {
    private String medicines;
    private String description;
    private String instruction;
    private String therapyDate;
}
