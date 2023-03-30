package com.onlinehospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfo {
    private String phoneNumber;
    @Email
    private String email;
    private String address;
}