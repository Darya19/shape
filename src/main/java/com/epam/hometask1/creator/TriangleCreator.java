package com.epam.hometask1.creator;

import com.epam.hometask1.entity.Point;
import com.epam.hometask1.entity.TriangleParameters;
import com.epam.hometask1.entity.TriangleType;
import com.epam.hometask1.entity.Warehouse;
import com.epam.hometask1.entity.impl.Triangle;
import com.epam.hometask1.exception.ProjectException;
import com.epam.hometask1.repository.TriangleRepository;
import com.epam.hometask1.service.impl.TriangleService;
import com.epam.hometask1.validator.CoordinateValidator;

public class TriangleCreator {

    CoordinateValidator validator = new CoordinateValidator();

    public void createTriangle(Point a, Point b, Point c) throws ProjectException {
        if(a == null || b == null || c == null){
            throw new ProjectException("null point");
        }
        TriangleService service = new TriangleService();
        if (validator.isTriangle(a, b, c)) {
            Triangle triangle = new Triangle(a, b, c);
            TriangleRepository.getRepository().add(triangle);
            double square = service.calculateSquare(triangle);
            double perimeter = service.calculatePerimeter(triangle);
            TriangleType type = service.defineTypeOfTriangle(triangle);
            TriangleParameters parameters = new TriangleParameters(square, perimeter, type);
            Warehouse.getParameters().put(triangle.getId(), parameters);
        } else {
            throw new ProjectException("two or more points lay on the same straight");
        }
    }
}
