package com.superprojects.bookyourflightapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.superprojects.bookyourflightapp.Adapters.BookingAdapter;
import com.superprojects.bookyourflightapp.Models.BookingsModel;
import com.superprojects.bookyourflightapp.databinding.ActivityBookingDetailsBinding;

import java.util.ArrayList;

public class BookingDetails extends AppCompatActivity {

    ActivityBookingDetailsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookingDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBHelper helper = new DBHelper(this);
        ArrayList<BookingsModel> list = helper.getBookings();

        BookingAdapter adapter = new BookingAdapter(list,this);
        binding.bookingrecyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.bookingrecyclerview.setLayoutManager(layoutManager);
    }
}