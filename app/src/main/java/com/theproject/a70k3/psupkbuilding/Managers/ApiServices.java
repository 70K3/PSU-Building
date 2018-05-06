package com.theproject.a70k3.psupkbuilding.Managers;


import com.theproject.a70k3.psupkbuilding.Managers.dao.DataMainDao;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiServices {

    @POST("show_event_db.php")
    Call<DataMainDao> loadDataList();
}
