package com.revanth.app.model;

public class Car {
    private String ownerName;
    private String regNo;
    private String model;
    private String type;

    public Car() {}

    public Car(String ownerName, String regNo, String model, String type) {
        this.ownerName = ownerName;
        this.regNo = regNo;
        this.model = model;
        this.type = type;
    }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}

