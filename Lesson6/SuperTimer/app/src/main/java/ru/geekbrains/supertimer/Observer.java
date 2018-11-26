package ru.geekbrains.supertimer;

public interface Observer {
    void updateTimer(long hour, long minute, long second, long decseconds);
}
