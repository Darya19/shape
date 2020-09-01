package com.epam.hometask1.entity;

import com.epam.hometask1.exception.ProjectException;
import com.epam.hometask1.observer.Observable;
import com.epam.hometask1.observer.Observer;
import com.epam.hometask1.util.IdCreator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class Triangle implements Observable {

    private int id;
    private Point a;
    private Point b;
    private Point c;
    private List<Observer> observers = new ArrayList<>();

    private static Logger logger = LogManager.getLogger();

    public Triangle(Point a, Point b, Point c) {
        this.id = IdCreator.createId();
        this.a = a;
        this.b = b;
        this.c = c;
        logger.log(Level.DEBUG, "Triangle was created");
    }

    public void setId(int id) {
        this.id = id;
        notifyObservers();
    }

    public int getId() {
        return id;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) throws ProjectException {
        if (a == null) {
            throw new ProjectException("point is null");
        } else {
            this.a = a;
            notifyObservers();
        }
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) throws ProjectException {
        if (a == null) {
            throw new ProjectException("point is null");
        } else {
        this.b = b;
        notifyObservers();}
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) throws ProjectException {
        if (a == null) {
            throw new ProjectException("point is null");
        } else {
        this.c = c;
        notifyObservers();}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (getId() != triangle.getId()) return false;
        if (getA() != null ? !getA().equals(triangle.getA()) : triangle.getA() != null) return false;
        if (getB() != null ? !getB().equals(triangle.getB()) : triangle.getB() != null) return false;
        return getC() != null ? getC().equals(triangle.getC()) : triangle.getC() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getA() != null ? getA().hashCode() : 0);
        result = 31 * result + (getB() != null ? getB().hashCode() : 0);
        result = 31 * result + (getC() != null ? getC().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Triangle{");
        sb.append("id=").append(id);
        sb.append(", a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", c=").append(c);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.actionPerformed(new EventObject(this));
        }
    }
}
