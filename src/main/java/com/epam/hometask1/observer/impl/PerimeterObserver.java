package com.epam.hometask1.observer.impl;

import com.epam.hometask1.entity.Warehouse;
import com.epam.hometask1.entity.impl.Triangle;
import com.epam.hometask1.observer.Observer;
import com.epam.hometask1.observer.TriangleEvent;
import com.epam.hometask1.service.impl.TriangleService;

import java.util.EventObject;

public class PerimeterObserver implements Observer<TriangleEvent> {

    @Override
    public void actionPerformed(TriangleEvent triangleEvent) {
        TriangleService service = new TriangleService();
        Triangle triangle = triangleEvent.getSource();
        double perimeter = service.calculatePerimeter(triangle);
        Warehouse.getParameters().get(triangle.getId()).setPerimeter(perimeter);
    }
}
