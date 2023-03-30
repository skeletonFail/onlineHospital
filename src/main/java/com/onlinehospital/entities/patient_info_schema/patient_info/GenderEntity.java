package com.onlinehospital.entities.patient_info_schema.patient_info;

import com.onlinehospital.enums.EGender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(schema = "patient_info", name = "gender")
@NoArgsConstructor
public class GenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, insertable = false, updatable = false, unique = true)
    private EGender name;

}
