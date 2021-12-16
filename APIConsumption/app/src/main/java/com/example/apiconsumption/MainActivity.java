package com.example.apiconsumption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBhelper dBhelper;
    EditText name,phone,street,email,city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.Name);
        phone = findViewById(R.id.Phone);
        email = findViewById(R.id.Email);
        city = findViewById(R.id.City);

        dBhelper = new DBhelper(this);
    }
    public void insert(View view)
    {
       boolean flag = dBhelper.InsertData(name.getText().toString(),phone.getText().toString(),email.getText().toString(),city.getText().toString());
       if(flag)
       {
           Toast.makeText(this, "Data Successfully inserted!", Toast.LENGTH_SHORT).show();
       }
    }
    public void Show(View view)
    {
        Intent intent = new Intent(this,ShowAll.class);
        startActivity(intent);
    }
    public void delete(View view)
    {
        Intent intent = new Intent(this,delete.class);
        startActivity(intent);
    }
    public void update(View view)
    {
        Intent intent = new Intent(this,update.class);
        startActivity(intent);
    }

}