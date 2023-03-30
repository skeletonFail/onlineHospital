package com.onlinehospital;

import com.onlinehospital.security.jwt.JwtUtil;
import com.onlinehospital.services.PatientService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Server Start");
    }
}
