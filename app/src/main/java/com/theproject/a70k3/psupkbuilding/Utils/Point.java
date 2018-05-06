package com.theproject.a70k3.psupkbuilding.Utils;

public class Point {

    public double longitude = 0f;
    public double latitude = 0f;
    public String description;

    public float x;
    public float y  = 0;

    public Point(double lat, double lon, String desc) {
        this.latitude = lat;
        this.longitude = lon;
        this.description = desc;
    }
}
