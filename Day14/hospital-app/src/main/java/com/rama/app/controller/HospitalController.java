package com.rama.app.controller;

import com.rama.app.model.Hospital;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HospitalController {

    @GetMapping("/get/hospitals")
    public List<Hospital> getHospitals(){
         List listHospitals= new ArrayList();
         Hospital hospital1= new Hospital("1","hopspital1","Delhi");
         Hospital hospital2= new Hospital("2","hopspital2","Mumbai");
         Hospital hospital3= new Hospital("3","hopspital3","Hyderabad");

         listHospitals.add(hospital1);
         listHospitals.add(hospital2);
         listHospitals.add(hospital3);
         return  listHospitals;
    }

    @GetMapping("/map/hospitals")
    public Map mapHospitals(){
        Map hospitalMap= new HashMap();
        Hospital hospital1= new Hospital("1","hopspital1","Delhi");
        Hospital hospital2= new Hospital("2","hopspital2","Mumbai");
        Hospital hospital3= new Hospital("3","hopspital3","Hyderabad");

        hospitalMap.put(hospital1.getId(),hospital1);
        hospitalMap.put(hospital2.getId(),hospital2);
        hospitalMap.put(hospital3.getId(),hospital3);
        return  hospitalMap;
    }
}
