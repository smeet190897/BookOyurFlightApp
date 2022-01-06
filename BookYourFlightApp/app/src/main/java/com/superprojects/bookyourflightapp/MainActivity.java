package com.superprojects.bookyourflightapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.superprojects.bookyourflightapp.Adapters.MainAdapter;
import com.superprojects.bookyourflightapp.Models.MainModel;
import com.superprojects.bookyourflightapp.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        auth = FirebaseAuth.getInstance();



        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel("AirIndian","FlightID:MUMDEL01\nSource:Mumbai \nDestination:Delhi \nTime:8AM-11PM","₹4000"));
        list.add(new MainModel("SpicyJet","FlightID:MUMBAN02\nSource:Mumbai \nDestination:Bangaluru \nTime:5PM-8PM","₹3000"));
        list.add(new MainModel("EmmyRates","FlightID:BANDEL03\nSource:Bangaluru \nDestination:Delhi \nTime:8AM-11AM","₹4000"));
        list.add(new MainModel("AirIndian","FlightID:CHEDEL04\nSource:Chennai \nDestination:Delhi \nTime:6AM-9AM","₹5000"));
        list.add(new MainModel("SpicyJet","FlightID:DELJAI05\nSource:Delhi\n Destination:Jaipur \nTime:7AM-10AM","₹2000"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.detail:
                Intent intent = new Intent(MainActivity.this,BookingDetails.class);
                startActivity(intent);
                break;

            case R.id.logout:
                auth.signOut();
                intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}