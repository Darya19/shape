package com.epam.hometask1.creatortest;

import com.epam.hometask1.creator.PointCreator;
import com.epam.hometask1.entity.Point;
import com.epam.hometask1.exception.ProjectException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class PointCreatorTest {
    PointCreator creator = new PointCreator();

    @Test
    public void createPointPositiveValidationTest() {
        try {
            Point actual = creator.createPoint(123.36, 10896.36);
            Point expected = new Point(123.36, 10896.36);
            assertEquals(actual, expected);
        } catch (ProjectException e) {
           fail();
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void createPointNegativeValidationTest() throws ProjectException {
        creator.createPoint(-10000000000.001, 1);
    }
}
