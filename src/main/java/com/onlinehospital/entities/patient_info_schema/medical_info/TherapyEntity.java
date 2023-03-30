package com.onlinehospital.entities.patient_info_schema.medical_info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "medical_info", name = "therapy")
@NoArgsConstructor
public class TherapyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String medicines;

    @Getter
    @Setter
    private String instruction;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @Temporal(value = TemporalType.DATE)
    private Date therapyDate;

}
