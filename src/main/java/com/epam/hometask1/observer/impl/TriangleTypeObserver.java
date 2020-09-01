package com.epam.hometask1.observer.impl;

import com.epam.hometask1.entity.TriangleType;
import com.epam.hometask1.entity.Warehouse;
import com.epam.hometask1.entity.Triangle;
import com.epam.hometask1.observer.Observer;
import com.epam.hometask1.observer.TriangleEvent;
import com.epam.hometask1.service.impl.TriangleService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleTypeObserver implements Observer<TriangleEvent> {

    private static Logger logger = LogManager.getLogger();

    public TriangleTypeObserver() {
        logger.log(Level.DEBUG, "TriangleTypeObserver was created");
    }

    @Override
    public void actionPerformed(TriangleEvent triangleEvent) {
        TriangleService service = new TriangleService();
        Triangle triangle = triangleEvent.getSource();
        TriangleType type = service.defineTypeOfTriangle(triangle);
        Warehouse.getParameters().get(triangle.getId()).setType(type);
        logger.log(Level.INFO, "warehouse was updated");
    }
}
