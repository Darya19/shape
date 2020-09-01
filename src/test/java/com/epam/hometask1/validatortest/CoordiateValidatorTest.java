package com.epam.hometask1.validatortest;

import com.epam.hometask1.entity.Point;
import com.epam.hometask1.validator.CoordinateValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class CoordiateValidatorTest {

    CoordinateValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new CoordinateValidator();
    }

    @Test
    public void isTriangleTrueTest() {
        Point a = new Point(3.0,-2.0);
        Point b = new Point(1.0, -4.0);
        Point c = new Point(-2.0, -3.0);
        assertTrue(validator.isTriangle(a, b, c));
    }

    @Test
    public void isTriangleFalseTest() {
        Point a = new Point(1.02,24.35);
        Point b = new Point(1.02, 48.36);
        Point c = new Point(1.02, 28.352);
        assertFalse(validator.isTriangle(a, b, c));
    }

    @Test
    public void isCoordinateValidTrueTest() {

        assertTrue(validator.isCoordinateValid(5631.369));
    }

    @Test
    public void isCoordinateValidFalseTest() {
        assertFalse(validator.isCoordinateValid(-100025.02));
    }
}
