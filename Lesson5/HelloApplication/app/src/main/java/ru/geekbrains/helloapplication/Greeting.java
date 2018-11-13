package ru.geekbrains.helloapplication;


public class Greeting {

    private int hour;

    public Greeting(int currentHour) {
        hour = currentHour;
    }

    public String get() {
        if (hour >= 12 && hour <= 15) {
            return "Good afternoon";
        } else if (hour >= 16 && hour <= 24) {
            return "Good evening";
        }
        else if (hour >= 4 && hour <= 11){
            return "Good morning";
        }
        return "Good night";
    }
}