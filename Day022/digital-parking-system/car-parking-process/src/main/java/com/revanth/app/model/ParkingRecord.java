package com.revanth.app.model;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.util.Date;

@DynamoDbBean
public class ParkingRecord {

    private String parkingNo;
    private Date startTime;
    private Date endTime;
    private String regNo;
    private int price;

    public ParkingRecord() {}

    public ParkingRecord(String parkingNo, Date startTime, Date endTime, String regNo, int price) {
        this.parkingNo = parkingNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.regNo = regNo;
        this.price = price;
    }

    @DynamoDbPartitionKey
    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public String getParkingNo() { return parkingNo; }
    public void setParkingNo(String parkingNo) { this.parkingNo = parkingNo; }

    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }

    public Date getEndTime() { return endTime; }
    public void setEndTime(Date endTime) { this.endTime = endTime; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
}

