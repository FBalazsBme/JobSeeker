/*
package com.example.jobseeker.network.swagger.client;

import android.os.AsyncTask;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;

import org.json.JSONObject;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class ThreadA extends AsyncTask<Void, Void, String> {
    final String url = mBuilder.getURL("box");
    private  RequestFuture<String> rFuture;
    public ThreadA() {
    }

    public ThreadA( RequestFuture<String> inputFuture) {
        this.rFuture = inputFuture;
    }

    @Override
    protected String doInBackground(Void... params) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, (String) null, future, future);
        requestQueue.add(request);
        try {
            return this.rFuture.get(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }
}*/
