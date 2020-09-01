package com.epam.hometask1.observer;

import com.epam.hometask1.entity.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EventObject;

public class TriangleEvent extends EventObject {

    private static Logger logger = LogManager.getLogger();

    public TriangleEvent(Object source) {
        super(source);
        logger.log(Level.DEBUG, "TriangleEvent was created");
    }

    public Triangle getSource(){
        return (Triangle) super.getSource();
    }
}
