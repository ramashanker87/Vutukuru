package com.revanth.app.model;

import java.util.Date;

public class ParkingEnd {
    private String parkingNo;
    private Date startTime;
    private Date endTime;
    private int price;
    private String status;
    private String regNo;

    public ParkingEnd() {}

    public ParkingEnd(String parkingNo, Date startTime, Date endTime, int price, String status, String regNo) {
        this.parkingNo = parkingNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.status = status;
        this.regNo = regNo;
    }

    public String getParkingNo() { return parkingNo; }
    public void setParkingNo(String parkingNo) { this.parkingNo = parkingNo; }

    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }

    public Date getEndTime() { return endTime; }
    public void setEndTime(Date endTime) { this.endTime = endTime; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }
}
