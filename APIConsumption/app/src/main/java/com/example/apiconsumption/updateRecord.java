package com.example.apiconsumption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class updateRecord extends AppCompatActivity {

    EditText updateName,updatePhone,updateEmail,updateCity;
    String oldname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_record);
        updateName = findViewById(R.id.NameUpdate);
        updatePhone = findViewById(R.id.PhoneUpdate);
        updateEmail = findViewById(R.id.EmailUpdate);
        updateCity = findViewById(R.id.CityUpdate);
        Intent intent = getIntent();
        oldname = intent.getStringExtra("Name");
    }

    public void updateRecord(View view)
    {
        RequestQueue queue = Volley.newRequestQueue(this);

        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name", oldname);
            jsonObject.put("name2", updateName.getText().toString());
            jsonObject.put("number", updatePhone.getText().toString());
            jsonObject.put("email", updateEmail.getText().toString());
            jsonObject.put("city", updateCity.getText().toString());

        } catch (JSONException e) {
            // handle exception
        }


        JsonObjectRequest putRequest = new JsonObjectRequest(Request.Method.PUT, "https://protected-inlet-55078.herokuapp.com/person", jsonObject,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // response
                        Toast.makeText(getApplicationContext(), "Record Updated!", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {

            @Override
            public Map<String, String> getHeaders()
            {
                Map<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("Accept", "application/json");
                return headers;
            }

            @Override
            public byte[] getBody() {

                try {
                    Log.i("json", jsonObject.toString());
                    return jsonObject.toString().getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };

        queue.add(putRequest);
    }
}