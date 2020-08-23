package com.epam.hometask1.repository.impl;

import com.epam.hometask1.entity.impl.Triangle;
import com.epam.hometask1.repository.Specification;

public class XCoordinateSpecification implements Specification {

    private double xFrom;
    private double xTo;

    public XCoordinateSpecification(double xFrom, double xTo) {
        this.xFrom = xFrom;
        this.xTo = xTo;
    }

    @Override
    public boolean test(Triangle triangle) {
        return triangle.getA().getX() >= xTo && triangle.getA().getX() <= xFrom
                || triangle.getB().getX() >= xTo && triangle.getB().getX() <= xFrom
                || triangle.getC().getX() >= xTo && triangle.getC().getX() <= xFrom;
    }
}
