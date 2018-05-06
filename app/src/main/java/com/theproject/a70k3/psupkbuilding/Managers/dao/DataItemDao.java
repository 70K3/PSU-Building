package com.theproject.a70k3.psupkbuilding.Managers.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DataItemDao implements Parcelable{

    @SerializedName("event_id") private int id;
    @SerializedName("Name") private String Name;
    @SerializedName("Date") private String Date;
    @SerializedName("Stime") private String Stime;
    @SerializedName("Etime") private String Etime;
    @SerializedName("Place") private String Place;
    @SerializedName("Detail") private String Detail;
    @SerializedName("PicFiles") private String Pic;

    public DataItemDao(){

    }

    protected DataItemDao(Parcel in) {
        id = in.readInt();
        Name = in.readString();
        Date = in.readString();
        Stime = in.readString();
        Etime = in.readString();
        Place = in.readString();
        Detail = in.readString();
        Pic = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(Name);
        dest.writeString(Date);
        dest.writeString(Stime);
        dest.writeString(Etime);
        dest.writeString(Place);
        dest.writeString(Detail);
        dest.writeString(Pic);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataItemDao> CREATOR = new Creator<DataItemDao>() {
        @Override
        public DataItemDao createFromParcel(Parcel in) {
            return new DataItemDao(in);
        }

        @Override
        public DataItemDao[] newArray(int size) {
            return new DataItemDao[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getStime() {
        return Stime;
    }

    public void setStime(String stime) {
        Stime = stime;
    }

    public String getEtime() {
        return Etime;
    }

    public void setEtime(String etime) {
        Etime = etime;
    }

    public String getPlace() {
        return Place;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getPic() {
        return Pic;
    }

    public void setPic(String pic) {
        Pic = pic;
    }
}
