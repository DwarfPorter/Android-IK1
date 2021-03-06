package ru.geekbrains.supertimer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Observer> observers;

    public Publisher() {
        observers = new ArrayList<>();
    }

    // Подписать
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    // Отписать
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    // Разослать событие
    public void notify(long hour, long minute, long second, long decseconds) {
        for (Observer observer : observers) {
            observer.updateTimer(hour, minute, second, decseconds);
        }
    }
}
