package com.example.apiconsumption;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowAll extends AppCompatActivity {

    DBhelper dBhelper;
    ListView listView;
    ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        listView = findViewById(R.id.list);
        list = new ArrayList();
        dBhelper = new DBhelper(this);
        show();
    }
    public void show()
    {
        Cursor cursor  = dBhelper.showAll();
        if(cursor.moveToFirst()){
            do{
                int index = cursor.getColumnIndex("Name");
                list.add(cursor.getString(index));
            } while(cursor.moveToNext());
        }
        cursor.close();
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.file,list);
        listView.setAdapter(adapter);
    }
}