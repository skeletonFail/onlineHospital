package com.onlinehospital.entities.patient_info_schema.patient_info;

import jdk.jfr.Unsigned;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(schema = "patient_info", name = "images")
@NoArgsConstructor
public class ImageEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Getter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String contentType;

    @Getter
    @Setter
    @Unsigned
    private Long size;

    @Getter
    @Setter
    @Lob
    private byte[] data;

}
