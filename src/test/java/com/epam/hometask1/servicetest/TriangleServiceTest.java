package com.epam.hometask1.servicetest;

import com.epam.hometask1.entity.Point;
import com.epam.hometask1.entity.Triangle;
import com.epam.hometask1.entity.TriangleType;
import com.epam.hometask1.service.impl.TriangleService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TriangleServiceTest {

    TriangleService service;

    @BeforeClass
    public void setUp() {
        service = new TriangleService();
    }

    @Test
    public void calculateSquarePositiveTest() {
        Triangle triangle = new Triangle(new Point(23.32, 78.25), new Point(89.36, 85.33)
                , new Point(89.36, -9.3));
            double actual = service.calculateSquare(triangle);
            double expected = 3124.682599999999;
            assertEquals(actual, expected);
    }

    @Test
    public void calculatePerimeterPositiveTest() {
        Triangle triangle = new Triangle(new Point(23.32, 78.25), new Point(89.36, 85.33)
                , new Point(89.36, -9.3));
        double actual = service.calculatePerimeter(triangle);
        double expected = 270.71284700992675;
        assertEquals(actual, expected);
    }

    @Test
    public void defineTypeOfTrianglePositiveTest() {
        Triangle triangle = new Triangle(new Point(23.32, 78.25), new Point(89.36, 85.33)
                , new Point(89.36, -9.3));
        TriangleType actual = service.defineTypeOfTriangle(triangle);
        TriangleType expected = TriangleType.ACUTE;
        assertEquals(actual, expected);
    }
}
