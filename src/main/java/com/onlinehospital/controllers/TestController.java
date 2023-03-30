package com.onlinehospital.controllers;

import com.onlinehospital.dto.PatientRequest;
import com.onlinehospital.entities.patient_info_schema.patient_info.PatientEntity;
import com.onlinehospital.services.ImageService;
import com.onlinehospital.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutionException;

@RestController
public class TestController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private ImageService imageService;

    @PostMapping("/post")
    public String post(@RequestBody PatientRequest request) throws ExecutionException, InterruptedException {
        var temp = patientService.addPatient(request);
        return temp.get();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) throws ExecutionException, InterruptedException {
        var temp = patientService.deletePatient(id);
        return temp.get();
    }

    @PostMapping("/img")
    public ResponseEntity<String> img(@RequestParam("file")MultipartFile file, @RequestParam("id")String passportId) throws ExecutionException, InterruptedException {
        PatientEntity patient = patientService.getPatient(passportId).join();
        var temp = imageService.addImage(file, patient);
        return new ResponseEntity<>(temp.get(), HttpStatus.OK);
    }

}
