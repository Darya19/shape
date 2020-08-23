package com.epam.hometask1.service;

public interface ShapeService<Shape> {

    public double calculateSquare(Shape shape);

    public double calculatePerimeter(Shape shape);
}
