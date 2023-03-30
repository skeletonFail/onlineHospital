package com.onlinehospital.entities.patient_info_schema.patient_info;

import com.onlinehospital.enums.EMaritalStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(schema = "patient_info", name = "marital_status")
@NoArgsConstructor
public class MaritalStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, insertable = false, unique = true)
    private EMaritalStatus name;

}
