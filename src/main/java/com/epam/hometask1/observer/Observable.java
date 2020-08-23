package com.epam.hometask1.observer;

public interface Observable {

    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}
