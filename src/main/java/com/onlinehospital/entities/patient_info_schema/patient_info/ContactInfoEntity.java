package com.onlinehospital.entities.patient_info_schema.patient_info;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;

@Entity
@Table(schema = "patient_info", name = "contact_info")
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
public class ContactInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String phoneNumber;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    @Column(nullable = false)
    private String address;
}
