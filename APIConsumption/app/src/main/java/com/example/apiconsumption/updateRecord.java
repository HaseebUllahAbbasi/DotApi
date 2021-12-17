package com.example.apiconsumption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class updateRecord extends AppCompatActivity {

    EditText updateName,updatePhone,updateStreet,updateEmail,updateCity;
    String oldname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        updateName = findViewById(R.id.NameUpdate);
        updatePhone = findViewById(R.id.PhoneUpdate);
        updateStreet = findViewById(R.id.StreetUpdate);
        updateEmail = findViewById(R.id.EmailUpdate);
        updateCity = findViewById(R.id.CityUpdate);
        Intent intent = getIntent();
        oldname = intent.getStringExtra("Name");
    }

    public void updateRecord(View view)
    {

    }
}