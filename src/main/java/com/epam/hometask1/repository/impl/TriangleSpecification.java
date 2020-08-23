package com.epam.hometask1.repository.impl;

import com.epam.hometask1.entity.impl.Triangle;
import com.epam.hometask1.repository.Specification;

public class TriangleSpecification implements Specification {

        private double xFrom;
        private double xTo;
    private double yFrom;
    private double yTo;

    public TriangleSpecification(double xFrom, double xTo, double yFrom, double yTo) {
        this.xFrom = xFrom;
        this.xTo = xTo;
        this.yFrom = yFrom;
        this.yTo = yTo;
    }

    @Override
        public boolean test(Triangle triangle) {
        return triangle.getA().getX() >= xTo && triangle.getA().getX() <= xFrom
                && triangle.getB().getX() >= xTo && triangle.getB().getX() <= xFrom
                && triangle.getC().getX() >= xTo && triangle.getC().getX() <= xFrom;
    }
}
