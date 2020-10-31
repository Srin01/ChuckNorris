package com.example.chucknorris;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.chucknorris.Expert.JokeExpert;
import com.example.chucknorris.Networking.RequestGateway;
import com.example.chucknorris.Networking.URLs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity
{
    TextView textView;
    JokeExpert jokeExpert;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URLs.getUrl(),
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray value = response.getJSONArray("value");
                            for (int i = 0; i < 10; i++)
                            {
                                String joke = value.getJSONObject(i).getString("joke");
                                jokeExpert.addJoke(joke);
                                Log.d("myTag", "onResponse: " + joke);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Something happened", Toast.LENGTH_SHORT).show();
                    }
                });
        RequestGateway.makeRequest(jsonObjectRequest, this);
    }

    private void bindViews()
    {
        textView = findViewById(R.id.jokeTextView);
        jokeExpert = new JokeExpert();
        index = 0;
    }

    public void getLeftJoke(View view)
    {
        if(index <= 0)
            index = 9;
        textView.setText(jokeExpert.getJoke(index--));
    }

    public void getRightJoke(View view)
    {
        if(index >= 9)
            index = 0;
        textView.setText(jokeExpert.getJoke(index++));
    }
}