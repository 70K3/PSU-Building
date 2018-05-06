package com.theproject.a70k3.psupkbuilding.Managers;

import android.content.Context;

import com.theproject.a70k3.psupkbuilding.Managers.dao.DataItemDao;
import com.theproject.a70k3.psupkbuilding.Managers.dao.DataMainDao;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataListManagers {

    private static DataListManagers instance;

    public static DataListManagers getInstance() {
        if (instance == null)
            instance = new DataListManagers();
        return instance;
    }

    private Context mContext;

    private DataMainDao dao;
   //private DataItemDao dao;

    private DataListManagers() {
        mContext = Contextor.getInstance().getContext();

    }

    public DataMainDao getDao() {
        return dao;
    }

    public void setDao(DataMainDao dao) {
        this.dao = dao;
    }

    


}
