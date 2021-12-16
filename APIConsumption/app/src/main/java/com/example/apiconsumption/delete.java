package com.example.apiconsumption;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class delete extends AppCompatActivity {

    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        txt = findViewById(R.id.nameDelete);
    }
    public void deleteItem(View view)
    {
        DBhelper dBhelper = new DBhelper(this);
        dBhelper.deleteRecord(txt.getText().toString());
        Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
    }
}