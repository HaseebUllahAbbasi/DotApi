package com.example.apiconsumption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class update extends AppCompatActivity {


    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        txt = findViewById(R.id.updateName);
    }
    public void update(View view)
    {
        DBhelper dBhelper = new DBhelper(this);
        Cursor c=dBhelper.search(txt.getText().toString());
        if(c.moveToFirst())
        {
            int index = c.getColumnIndex("Name");
            String name = c.getString(index);
            Intent intent = new Intent(this,updateRecord.class);
            intent.putExtra("Name",name);
            startActivity(intent);
        }
        else
            Toast.makeText(this, "No record found with this name", Toast.LENGTH_SHORT).show();
    }
}