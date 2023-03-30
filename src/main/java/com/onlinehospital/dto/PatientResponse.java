package com.onlinehospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponse {
    private String passportId;
    private String name;
    private String lastName;
    private Integer age;

    private String birthday;
    private String registrationDate;
    private String gender;
    private String maritalStatus;
    private ContactInfo contactInfo;
    private ImageResponse imageResponse;
}
