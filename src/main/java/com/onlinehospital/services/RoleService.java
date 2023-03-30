package com.onlinehospital.services;

import com.onlinehospital.entities.patient_info_schema.users.RoleEntity;
import com.onlinehospital.enums.ERole;
import com.onlinehospital.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<RoleEntity> getRoles(String[] names) {
        List<RoleEntity> roles = new ArrayList<>();
        for (String name: names) {
            Optional<RoleEntity> optional = roleRepository.findByName(ERole.valueOf(name));
            if (optional.isPresent()) {
                roles.add(optional.get());
            } else throw new EntityNotFoundException();
        }
        return roles;
    }

}
