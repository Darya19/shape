package com.epam.hometask1.creatortest;

import com.epam.hometask1.creator.TriangleCreator;
import com.epam.hometask1.dataprovider.StaticDataProvider;
import com.epam.hometask1.entity.*;
import com.epam.hometask1.exception.ProjectException;
import com.epam.hometask1.repository.TriangleRepository;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TriangleCreatorTest {

    TriangleCreator creator = new TriangleCreator();

    @Test
    public void createTriangleAndAddToRepositoryTest() {
        try {
            Point point1 = new Point(56.02, 496.565);
            Point point2 = new Point(5663.6598, 6893.777);
            Point point3 = new Point(543.556, 6549.5466);
            creator.createTriangle(point1, point2, point3);
            Triangle expected = new Triangle(point1, point2, point3);
            Triangle actual = TriangleRepository.getRepository().get(0);
          assertTrue (actual.getA().equals(expected.getA()) && actual.getB().equals(expected.getB())
          && actual.getC().equals(expected.getC()));
        } catch (ProjectException e) {
           fail();
        }
    }

    @Test
    public void createTriangleAndAddToWarehouseTest() {
        try {
            Point point1 = new Point(56.02, 496.565);
            Point point2 = new Point(5663.6598, 6893.777);
            Point point3 = new Point(543.556, 6549.5466);
            creator.createTriangle( point1, point2, point3);
            Triangle triangle = new Triangle(point1, point2, point3);
            TriangleParameters expected = new TriangleParameters(1.5412034689597841E7
                    ,19711.29904175087, TriangleType.OBTUSE);
            TriangleParameters actual = Warehouse.getParameters().get(triangle.getId());
            assertEquals (actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void createTriangleNegativeValidationTest() throws ProjectException {
        creator.createTriangle(new Point(2.2,1.0), new Point(2.2,0.0), new Point(2.2,3.3));
    }
}
