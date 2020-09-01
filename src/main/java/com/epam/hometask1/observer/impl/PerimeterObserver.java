package com.epam.hometask1.observer.impl;

import com.epam.hometask1.entity.Warehouse;
import com.epam.hometask1.entity.Triangle;
import com.epam.hometask1.observer.Observer;
import com.epam.hometask1.observer.TriangleEvent;
import com.epam.hometask1.service.impl.TriangleService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PerimeterObserver implements Observer<TriangleEvent> {

    private static Logger logger = LogManager.getLogger();

    public PerimeterObserver() {
        logger.log(Level.DEBUG, "PerimeterObserver was created");
    }

    @Override
    public void actionPerformed(TriangleEvent triangleEvent) {
        TriangleService service = new TriangleService();
        Triangle triangle = triangleEvent.getSource();
        double perimeter = service.calculatePerimeter(triangle);
        Warehouse.getParameters().get(triangle.getId()).setPerimeter(perimeter);
        logger.log(Level.INFO, "warehouse was updated");
    }
}
