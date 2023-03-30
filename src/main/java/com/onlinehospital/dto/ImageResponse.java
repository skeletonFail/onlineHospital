package com.onlinehospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponse {
    private String id;
    private String contentType;
    private String name;
    private Long size;
    private byte[] data;
}
