package com.example.apiconsumption;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import static com.android.volley.Request.Method.GET;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowAll extends AppCompatActivity {



    RequestQueue requestQueue;
    ListView listView;
    ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        listView = findViewById(R.id.list);
        list = new ArrayList();
        show();
    }
    JSONObject jsonObject;
    JSONArray array;

    public void show()
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.file,list);
        String url = "https://protected-inlet-55078.herokuapp.com/person";
        StringRequest stringRequest = new StringRequest(GET, url, new Response.Listener() {
            @Override
            public synchronized void onResponse(Object response)
            {
                try {
                    jsonObject = new JSONObject(response.toString());
                    Log.d(TAG, "onResponse: "+jsonObject.get("persons"));
                    array = jsonObject.getJSONArray("persons");
                    Log.d(TAG, "onResponse: "+array.toString());
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject objects = array.getJSONObject(i);
                        adapter.add(objects.get("name").toString());
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
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

        listView.setAdapter(adapter);
    }
}