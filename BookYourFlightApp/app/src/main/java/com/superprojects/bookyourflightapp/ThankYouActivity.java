package com.superprojects.bookyourflightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.superprojects.bookyourflightapp.databinding.ActivityThankYouBinding;

public class ThankYouActivity extends AppCompatActivity {

    ActivityThankYouBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThankYouBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
    }

    public void btnhome(View v) {
            Intent intent = new Intent(ThankYouActivity.this, MainActivity.class);
            startActivity(intent);
    }

}