package com.theproject.a70k3.psupkbuilding.Managers.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataMainDao implements Parcelable{

    @SerializedName("master") private List<DataItemDao> Master ;

    public DataMainDao(){

    }

    protected DataMainDao(Parcel in) {
        Master = in.createTypedArrayList(DataItemDao.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(Master);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataMainDao> CREATOR = new Creator<DataMainDao>() {
        @Override
        public DataMainDao createFromParcel(Parcel in) {
            return new DataMainDao(in);
        }

        @Override
        public DataMainDao[] newArray(int size) {
            return new DataMainDao[size];
        }
    };

    public List<DataItemDao> getMaster() {
        return Master;
    }

    public void setMaster(List<DataItemDao> master) {
        Master = master;
    }
}
