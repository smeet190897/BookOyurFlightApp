package com.superprojects.bookyourflightapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.superprojects.bookyourflightapp.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {

    ActivityPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final String flightname = getIntent().getStringExtra("flightname");
        final String description = getIntent().getStringExtra("description");
        final String price = getIntent().getStringExtra("price");

        binding.pname.setText(flightname);
        binding.pdes.setText(description);
        binding.pprice.setText(price);

        DBHelper helper = new DBHelper(this);

        binding.btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = helper.insertBooking(
                        binding.namebox.getText().toString(),
                        flightname,
                        description,
                        price);

                if(isInserted){
                    Intent intent = new Intent(PaymentActivity.this, ThankYouActivity.class);
                    startActivity(intent);                }
                else {
                    Toast.makeText(PaymentActivity.this,"Data Not Inserted",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}