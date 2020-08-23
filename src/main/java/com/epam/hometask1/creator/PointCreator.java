package com.epam.hometask1.creator;

import com.epam.hometask1.entity.Point;
import com.epam.hometask1.exception.ProjectException;
import com.epam.hometask1.validator.CoordinateValidator;

public class PointCreator {

    CoordinateValidator validator = new CoordinateValidator();

    public Point createPoint(double x, double y) throws ProjectException {
        if(validator.validateCoordinate(x) && validator.validateCoordinate(y)){
        return new Point(x, y);}
        else {throw new ProjectException("invalid input data");}
    }
}
