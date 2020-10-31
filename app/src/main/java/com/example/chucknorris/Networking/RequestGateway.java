package com.example.chucknorris.Networking;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestGateway
{
    private static RequestQueue requestQueue;
    private RequestGateway(){}
    public static void makeRequest(Request request, Context context)
    {
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(request);
    }
}
