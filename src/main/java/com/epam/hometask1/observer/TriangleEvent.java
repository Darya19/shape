package com.epam.hometask1.observer;

import com.epam.hometask1.entity.impl.Triangle;

import java.util.EventObject;

public class TriangleEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public TriangleEvent(Object source) {
        super(source);
    }

    public Triangle getSource(){
        return (Triangle) super.getSource();
    }
}
