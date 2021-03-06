package com.epam.hometask1.validator;

import com.epam.hometask1.entity.Point;

public class CoordinateValidator {

    private final double MIN_VALUE = -100000;
    private final double MAX_VALUE = 100000;

    public boolean isTriangle(Point a, Point b, Point c) {
        return !((a.getX() - b.getX()) / (a.getY() - b.getY()) == (a.getX() - c.getX()) / (a.getY() - c.getY()));
    }

    public boolean isCoordinateValid(Double coordinate) {
        return coordinate >= MIN_VALUE && coordinate <= MAX_VALUE;
    }
}
