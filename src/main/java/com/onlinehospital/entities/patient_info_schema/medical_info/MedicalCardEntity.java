package com.onlinehospital.entities.patient_info_schema.medical_info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "medical_info", name = "medical_card")
@NoArgsConstructor
public class MedicalCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String allergies;

    @Getter
    @Setter
    @Temporal(value = TemporalType.DATE)
    private Date registrationDate;

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_card_id")
    private List<DiagnosisEntity> diagnosisEntities;

}
