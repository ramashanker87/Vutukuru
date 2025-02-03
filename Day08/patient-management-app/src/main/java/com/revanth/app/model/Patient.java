package com.revanth.app.model;

public class Patient {
    String name;
    String id;
    String hospitalName;
    int age;
    String gender;

    public Patient(){

    }

    public Patient(String name, String id, String hospitalName, int age, String gender) {
        super();
        this.name = name;
        this.id = id;
        this.hospitalName = hospitalName;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }



    public String getId() {
        return id;
    }



    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public int getAge() {
        return age;
    }









}
