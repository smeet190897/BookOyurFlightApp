package com.superprojects.bookyourflightapp.Models;

import com.superprojects.bookyourflightapp.Adapters.BookingAdapter;

public class BookingsModel {

    String username, flightname, description, price;

    public BookingsModel(String username, String flightname, String description, String price) {
        this.username = username;
        this.flightname = flightname;
        this.description = description;
        this.price = price;
    }

    public BookingsModel() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFlightname() {
        return flightname;
    }

    public void setFlightname(String flightname) {
        this.flightname = flightname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
