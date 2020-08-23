package com.epam.hometask1.repository.impl;

import com.epam.hometask1.entity.impl.Triangle;
import com.epam.hometask1.repository.Specification;

public class YCoordinateSpecification implements Specification {

    private double yFrom;
    private double yTo;

    public YCoordinateSpecification(double yFrom, double yTo) {
        this.yFrom = yFrom;
        this.yTo = yTo;
    }

    @Override
    public boolean test(Triangle triangle) {
        return triangle.getA().getY() >= yTo && triangle.getA().getY() <= yFrom
                || triangle.getB().getY() >= yTo && triangle.getB().getY() <= yFrom
                || triangle.getC().getY() >= yTo && triangle.getC().getY() <= yFrom;
    }
}
