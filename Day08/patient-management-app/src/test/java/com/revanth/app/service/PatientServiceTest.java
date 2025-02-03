package com.revanth.app.service;

import com.revanth.app.model.Patient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {

    PatientService patientService=new PatientService();
//    @InjectMocks
//    private PatientService patientService;
//
//    @Mock
//    private Patient patient;


//      private PatientService patientService;
//
//      void setUp(){
//          patientService = new PatientService();
//      }


    @Test
    public void testCreatePatient() {
        Patient patient = new Patient("Patient1", "1", "HospitalA", 30, "M");

        Patient expectedPatient = patientService.createPatient(patient);

        assertNotNull(expectedPatient);
        assertEquals(patient.getId(), expectedPatient.getId());
        assertEquals(patient.getName(), expectedPatient.getName());
        assertEquals(patient.getHospitalName(), expectedPatient.getHospitalName());
        assertEquals(patient.getAge(), expectedPatient.getAge());
    }

    @Test
    public void testReadAllPatient(){
        Patient p1 = new Patient("Patient1", "1", "HospitalA", 30, "M");
        Patient p2 = new Patient("Patient1", "1", "HospitalA", 30, "M");
        Patient p3 = new Patient("Patient1", "1", "HospitalA", 30, "M");

        patientService.createPatient(p1);
        patientService.createPatient(p2);
        patientService.createPatient(p3);

        Map<String, Patient> resultPatients=patientService.readAllPatient();
        assertEquals(1,resultPatients.size());
        assert resultPatients.containsKey(p1.getId());
        assert resultPatients.containsKey(p1.getId());
        assert resultPatients.containsKey(p1.getId());
    }

    @Test
    public void testUpdatePatientHospital() {
        Patient patient = new Patient("Patient1", "1", "HospitalA", 30, "M");
        patientService.createPatient(patient);

        Patient updatedPatient = patientService.updatePatientHospital("1", "HospitalB");

        assertNotNull(updatedPatient);
        assertEquals(patient.getId(), updatedPatient.getId());
        assertEquals(patient.getName(), updatedPatient.getName());
        assertEquals(patient.getHospitalName(), updatedPatient.getHospitalName());
    }

    @Test
    public  void testDeletePatient() {
        Patient patient = new Patient("Patient1", "1", "HospitalA", 30, "M");
        patientService.createPatient(patient);

        patientService.deletePatient(patient.getId());

        assertNull(patientService.readPatientByName("Patient1"));
    }
}

