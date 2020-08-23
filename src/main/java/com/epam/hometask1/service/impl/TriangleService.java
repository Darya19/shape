package com.epam.hometask1.service.impl;

import com.epam.hometask1.entity.impl.Triangle;
import com.epam.hometask1.entity.TriangleType;
import com.epam.hometask1.service.ShapeService;

import java.util.ArrayList;
import java.util.List;

public class TriangleService implements ShapeService<Triangle> {

    @Override
    public double calculateSquare(Triangle triangle) {
        double x1 = triangle.getA().getX();
        double y1 = triangle.getA().getY();
        double x2 = triangle.getB().getX();
        double y2 = triangle.getB().getY();
        double x3 = triangle.getC().getX();
        double y3 = triangle.getC().getY();
        double square = Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
        return square;
    }

    @Override
    public double calculatePerimeter(Triangle triangle) {
        double x1 = triangle.getA().getX();
        double y1 = triangle.getA().getY();
        double x2 = triangle.getB().getX();
        double y2 = triangle.getB().getY();
        double x3 = triangle.getC().getX();
        double y3 = triangle.getC().getY();
        double perimeter = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))
                + Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2))
                + Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        return perimeter;
    }

    public TriangleType defineTypeOfTriangle(Triangle triangle) {
        double x1 = triangle.getA().getX();
        double y1 = triangle.getA().getY();
        double x2 = triangle.getB().getX();
        double y2 = triangle.getB().getY();
        double x3 = triangle.getC().getX();
        double y3 = triangle.getC().getY();
        double ab = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double ac = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        double bc = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        if (ab == ac && ab == bc && ac == bc) {
            return TriangleType.EQUILATERAL;
        }
        if (ab == ac || ab == bc || ac == bc) {
            return TriangleType.ISOSCELES;
        }
        List<Double> sides = compareSides(ab, ac, bc);
        if (Math.pow(sides.get(0), 2) == (Math.pow(sides.get(1), 2) + Math.pow(sides.get(2), 2))) {
            return TriangleType.RIGHT;
        }
        if (Math.pow(sides.get(0), 2) < (Math.pow(sides.get(1), 2) + Math.pow(sides.get(2), 2))) {
            return TriangleType.ACUTE;
        }

        if (Math.pow(sides.get(0), 2) > (Math.pow(sides.get(1), 2) + Math.pow(sides.get(2), 2))) {
            return TriangleType.OBTUSE;
        }
        return TriangleType.NONTRIANGLE;
    }


    private List<Double> compareSides(double ab, double ac, double bc) {
        List<Double> comperedSides = new ArrayList<>();
        if (ab > ac && ab > bc) {
            comperedSides.add(0, ab);
            comperedSides.add(1, ac);
            comperedSides.add(2, bc);
            return comperedSides;
        }
        if (ac > ab && ac > bc) {
            comperedSides.add(0, ac);
            comperedSides.add(1, ab);
            comperedSides.add(2, bc);
            return comperedSides;
        } else {
            comperedSides.add(0, bc);
            comperedSides.add(1, ab);
            comperedSides.add(2, ac);
            return comperedSides;
        }
    }
}

