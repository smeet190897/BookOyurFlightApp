package com.superprojects.bookyourflightapp.Models;

public class MainModel {
    String flightname,description,price;

    public MainModel(String flightname, String description, String price) {
        this.flightname = flightname;
        this.description = description;
        this.price = price;
    }

    public String getFlightname() { return flightname; }

    public void setFlightname(String name) {
        this.flightname = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String des) {
        this.description = des;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
