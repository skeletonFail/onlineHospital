package com.onlinehospital.entities.patient_info_schema.patient_info;

import com.onlinehospital.entities.patient_info_schema.medical_info.MedicalCardEntity;
import jdk.jfr.Unsigned;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "patient_info", name = "patient")
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String passportId;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @Column(nullable = false)
    private String lastName;

    @Getter
    @Setter
    @Unsigned
    private Integer age;

    @Getter
    @Setter
    @Temporal(value = TemporalType.DATE)
    private Date birthday;

    @Getter
    @Setter
    @Temporal(value = TemporalType.DATE)
    private Date registrationDate;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private ContactInfoEntity contactInfo;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private GenderEntity gender;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private MaritalStatusEntity maritalStatus;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private ImageEntity image;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MedicalCardEntity medicalCard;

}
