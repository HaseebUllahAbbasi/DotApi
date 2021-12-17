package com.example.apiconsumption;

import static android.content.ContentValues.TAG;
import static com.android.volley.Request.Method.GET;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class update extends AppCompatActivity {


    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        txt = findViewById(R.id.updateName);
    }
    JSONObject jsonObject;
    JSONArray array;
    public void update(View view)
    {
        Intent intent = new Intent(this,updateRecord.class);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://protected-inlet-55078.herokuapp.com/personByName/"+txt.getText().toString();
        StringRequest stringRequest = new StringRequest(GET, url, new Response.Listener() {
            @Override
            public synchronized void onResponse(Object response)
            {
                try {
                    jsonObject = new JSONObject(response.toString());
                    Log.d(TAG, "onResponse: "+response);
                    JSONObject object = jsonObject.getJSONObject("person");
                    String name = object.get("name").toString();
                       if(name.length()>0)
                       {
                           intent.putExtra("Name",txt.getText().toString());
                           startActivity(intent);
                       }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                Log.d(TAG, "onResponse: " + response.toString());
//                 data[0] = response.toString();
//                Log.d(TAG, "onResponse: "+data[0]);;
            }
        }, new Response.ErrorListener() {
            @Override
            public synchronized void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Record Not found", Toast.LENGTH_SHORT).show();
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);


    }
}