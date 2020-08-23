package com.epam.hometask1.observer.impl;

import com.epam.hometask1.entity.Warehouse;
import com.epam.hometask1.entity.impl.Triangle;
import com.epam.hometask1.observer.Observer;
import com.epam.hometask1.observer.TriangleEvent;
import com.epam.hometask1.service.impl.TriangleService;

public class SquareObserver implements Observer<TriangleEvent> {

    @Override
    public void actionPerformed(TriangleEvent triangleEvent) {
        TriangleService service = new TriangleService();
        Triangle triangle = triangleEvent.getSource();
        double square = service.calculateSquare(triangle);
        Warehouse.getParameters().get(triangle.getId()).setSquare(square);

    }
}
