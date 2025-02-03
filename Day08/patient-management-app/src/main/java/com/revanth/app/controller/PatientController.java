package com.revanth.app.controller;

import com.revanth.app.model.Patient;
import com.revanth.app.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @PostMapping("/create/patient")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @GetMapping("/get/all/patient")
    public Map<String, Patient> getAllPatient() {
        return patientService.readAllPatient();
    }


    @PutMapping("/update/patient")
    public Patient updatePatient(@RequestParam("id") String id,@RequestParam("newHospitalName") String newHospitalName) {
        return patientService.updatePatientHospital(id,newHospitalName );
    }

    @DeleteMapping("/delete/patient")
    public void deletePatients(@RequestParam("id") String id) {
        patientService.deletePatient(id);
    }
}
