package com.example.apiconsumption;

import static android.content.ContentValues.TAG;

import static com.android.volley.Request.Method.PUT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText name,phone,street,email,city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.Name);
        phone = findViewById(R.id.Phone);
        email = findViewById(R.id.Email);
        city = findViewById(R.id.City);
    }
    public void insert(View view)
    {
        String postUrl = "https://protected-inlet-55078.herokuapp.com/person";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JSONObject postData = new JSONObject();
        try {
            postData.put("name", name.getText().toString());
            postData.put("number", phone.getText().toString());
            postData.put("email", email.getText().toString());
            postData.put("city", city.getText().toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, postData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);

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