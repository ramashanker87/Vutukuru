package com.revanth.app.service;

import com.revanth.app.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PatientService {
        Map<String, Patient> patients=new HashMap<>();

        public Patient createPatient(Patient patient){
            patients.put(patient.getId(),patient);
            return patient;
        }

        public Map<String,Patient> readAllPatient() {
            return patients;
        }

        public Patient updatePatientHospital(String id,String newHospitalName){
            Patient patient=patients.get(id);
            patient.setHospitalName(newHospitalName);
            return patient;
        }

        public void deletePatient(String id){
            patients.remove(id);
        }

        public Patient readPatientByName(String name){
            Patient result=patients.get(name);
            return result;
        }

}
