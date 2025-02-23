package com.revanth.app.model;

import java.util.Date;

public class ParkingStart {
    private String parkingNo;
    private Date startTime;
    private String status;
    private String regNo;

    public ParkingStart() {}

    public ParkingStart(String parkingNo, Date startTime, String status, String regNo) {
        this.parkingNo = parkingNo;
        this.startTime = startTime;
        this.status = status;
        this.regNo = regNo;
    }

    public String getParkingNo() { return parkingNo; }
    public void setParkingNo(String parkingNo) { this.parkingNo = parkingNo; }

    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }
}

