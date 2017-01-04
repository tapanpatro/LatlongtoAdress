package com.omniroid.tapan.latlongtoadress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;
    RequestQueue request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv_city_name);

        request = Volley.newRequestQueue(this);

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String lc = "https://maps.googleapis.com/maps/api/geocode/json?latlng=42.774955,18.955061";

                    JsonObjectRequest jsonObjectRequest  = new JsonObjectRequest("https://maps.googleapis.com/maps/api/geocode/json?latlng=42.774955,18.955061&key=AIzaSyAO2I8DAhKnZMlLOEwupBBjkMjnhZfHdWI", new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            String adress = response.getJSONArray("results").getJSONObject(0).getString("formatted_address");
                            tv.setText(adress);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

            }
        });


    }



}
