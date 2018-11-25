package ru.geekbrains.cityinfo;

import java.io.Serializable;

public class Parcel implements Serializable {
    private int imageIndex;
    private String cityName;
    private int temperature;
    private int pressure;
    private int humidity;

    public int getImageIndex() {
        return imageIndex;
    }

    public String getCityName() {
        return cityName;
    }

    public int getTemperature(){
        return temperature;
    }

    public int getPressure(){
        return pressure;
    }

    public int getHumidity(){
        return humidity;
    }

    public Parcel(int imageIndex, String cityName, int temperature, int pressure, int humidity) {
        this.imageIndex = imageIndex;
        this.cityName = cityName;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }
}
