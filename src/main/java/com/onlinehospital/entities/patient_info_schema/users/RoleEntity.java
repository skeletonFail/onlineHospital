package com.onlinehospital.entities.patient_info_schema.users;

import com.onlinehospital.enums.ERole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "users", name = "roles")
@NoArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Enumerated(value = EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ERole name;

}
