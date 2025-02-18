package com.vehicle_app.module;

public class Registration {
    Owner vehicleOwner;
    Vehicle vehicle;

    public Registration(Owner vehicleOwner, Vehicle vehicle) {
        this.vehicleOwner = vehicleOwner;
        this.vehicle = vehicle;
    }

    public void setVehicleOwner(Owner vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
