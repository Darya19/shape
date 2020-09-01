package com.epam.hometask1.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleParameters {

    private double square;
    private double perimeter;
    private TriangleType type;

    private static Logger logger = LogManager.getLogger();

    public TriangleParameters(double square, double perimeter, TriangleType type) {
        this.square = square;
        this.perimeter = perimeter;
        this.type = type;
        logger.log(Level.DEBUG, "TriangleParameters object was created");
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public TriangleType getType() {
        return type;
    }

    public void setType(TriangleType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TriangleParameters that = (TriangleParameters) o;

        if (Double.compare(that.getSquare(), getSquare()) != 0) return false;
        if (Double.compare(that.getPerimeter(), getPerimeter()) != 0) return false;
        return getType() == that.getType();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getSquare());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPerimeter());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TriangleParameters{");
        sb.append("square=").append(square);
        sb.append(", perimeter=").append(perimeter);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
