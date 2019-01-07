package com.cb.carbonbank;

import java.util.Date;

public class TradeRecord {

    private String dateTime;
    private String type;
    private double amount;

    public TradeRecord(String dateTime, String type, double amount) {
        this.dateTime = dateTime;
        this.type = type;
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
