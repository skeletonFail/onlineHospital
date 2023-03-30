package com.onlinehospital.entities.patient_info_schema.medical_info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "medical_info", name = "diagnosis")
@NoArgsConstructor
public class DiagnosisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @Temporal(value = TemporalType.DATE)
    private Date diagnosticDate;

    @Getter
    @Setter
    private String clinic;

    @Getter
    @Setter
    private String doctorFullName;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private TherapyEntity therapy;

}
