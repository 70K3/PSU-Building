package com.theproject.a70k3.psupkbuilding.Managers;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManagers {

    private static HttpManagers instance;

    public static HttpManagers getInstance() {
        if (instance == null)
            instance = new HttpManagers();
        return instance;
    }

    private Context mContext;
    private ApiServices services;

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private HttpManagers() {
        mContext = Contextor.getInstance().getContext();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://student.coe.phuket.psu.ac.th/~s5535512074/TheEvent/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        services = retrofit.create(ApiServices.class);
    }

    public ApiServices getServices() {
        return services;
    }
}
