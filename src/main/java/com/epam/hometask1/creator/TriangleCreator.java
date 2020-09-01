package com.epam.hometask1.creator;

import com.epam.hometask1.entity.Point;
import com.epam.hometask1.entity.TriangleParameters;
import com.epam.hometask1.entity.TriangleType;
import com.epam.hometask1.entity.Warehouse;
import com.epam.hometask1.entity.Triangle;
import com.epam.hometask1.exception.ProjectException;
import com.epam.hometask1.observer.impl.PerimeterObserver;
import com.epam.hometask1.observer.impl.SquareObserver;
import com.epam.hometask1.observer.impl.TriangleTypeObserver;
import com.epam.hometask1.repository.TriangleRepository;
import com.epam.hometask1.service.impl.TriangleService;
import com.epam.hometask1.validator.CoordinateValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleCreator {

    CoordinateValidator validator = new CoordinateValidator();

    private static Logger logger = LogManager.getLogger();

    public void createTriangle(Point a, Point b, Point c) throws ProjectException {
        if(a == null || b == null || c == null){
            throw new ProjectException("null point");
        }
        TriangleService service = new TriangleService();
        if (validator.isTriangle(a, b, c)) {
            Triangle triangle = new Triangle(a, b, c);
            logger.log(Level.INFO, "triangle was created from points:" + a + b + c);
            TriangleRepository.getRepository().add(triangle);
            logger.log(Level.INFO, "triangle was added to repository");
            double square = service.calculateSquare(triangle);
            double perimeter = service.calculatePerimeter(triangle);
            TriangleType type = service.defineTypeOfTriangle(triangle);
            TriangleParameters parameters = new TriangleParameters(square, perimeter, type);
            logger.log(Level.INFO, "triangle parameters were calculated");
            Warehouse.getParameters().put(triangle.getId(), parameters);
            logger.log(Level.INFO, "parameters were added to warehouse");
            triangle.attach(new SquareObserver());
            triangle.attach(new PerimeterObserver());
            triangle.attach(new TriangleTypeObserver());
        } else {
            throw new ProjectException("two or more points lay on the same straight");
        }
    }
}
