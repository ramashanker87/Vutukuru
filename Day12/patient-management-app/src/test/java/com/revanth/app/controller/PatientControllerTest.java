package com.revanth.app.controller;

import com.revanth.app.model.Patient;
import com.revanth.app.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {

    @InjectMocks
    private PatientController patientController;

    @Mock
    private PatientService patientService;

    @Test
    public void testGetAllPatients() {
        Map<String, Patient> patientMap = new HashMap<>();
        Patient p1 = new Patient("Patient1", "1", "HospitalA", 30, "M");
        Patient p2 = new Patient("Patient2", "2", "HospitalB", 40, "F");
        Patient p3 = new Patient("Patient3", "3", "HospitalC", 50, "M");

        patientMap.put(p1.getId(), p1);
        patientMap.put(p2.getId(), p2);
        patientMap.put(p3.getId(), p3);

        when(patientService.readAllPatient()).thenReturn(patientMap);

        Map<String, Patient> result = patientController.getAllPatient();

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(p1, result.get(p1.getId()));
        assertEquals(p2, result.get(p2.getId()));
        assertEquals(p3, result.get(p3.getId()));
    }

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient("Patient1", "1", "HospitalA", 30, "M");

        when(patientService.createPatient(any(Patient.class))).thenReturn(patient);

        Patient createdPatient = patientController.createPatient(patient);

        assertNotNull(createdPatient);
        assertEquals("1", createdPatient.getId());
        assertEquals("Patient1", createdPatient.getName());
        assertEquals("HospitalA", createdPatient.getHospitalName());
    }

    @Test
    public void testUpdatePatientHospital() {
        Patient patient = new Patient("Patient1", "1", "HospitalA", 30, "M");
        when(patientService.updatePatientHospital(anyString(), anyString())).thenReturn(patient);

        Patient updatedPatient = patientController.updatePatient("1", "HospitalB");

        assertNotNull(updatedPatient);
        assertEquals("HospitalA", updatedPatient.getHospitalName());
    }

    @Test
    public void testDeletePatient() {
        doNothing().when(patientService).deletePatient(anyString());

        patientController.deletePatients("1");

        verify(patientService, atLeast(1)).deletePatient("1");

    }
}
