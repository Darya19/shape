package com.epam.hometask1.parsertest;

import com.epam.hometask1.dataprovider.StaticDataProvider;
import com.epam.hometask1.exception.ProjectException;
import com.epam.hometask1.parser.CoordinateParser;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class CoordinateParserTest {

    CoordinateParser parser = new CoordinateParser();

    @Test(dataProvider = "parsed coordinates", dataProviderClass = StaticDataProvider.class)
    public void parseToDoublePositiveTest(List<List<Double>> expected) {
       List<String> stringCoordinates = Arrays.asList("78.36 32.69 -98.36 -96.32 -7.01 8.014",
        "71.01 0.236 -3.25 -69.3 3.65 5.639", "74.36 25.32 85.36 9.36 4.352 1.253"
               , "22.30 -9.25 -7.36 23.36 9.256 36.31", "0.36 0.25 0.25 8.36 9.147 8.369");
        try {
            List<List<Double>> actual = parser.parseToDouble(stringCoordinates);
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test
    public void parseToDoubleInvalidCoordinatesPositiveTest() {
        List<String> stringCoordinates = Arrays.asList("78.36 32.69m -98.36 -96.32 -7.01 8.014",
                "71.01 0.236 -3.25 -69.3.0 3.65 5.639", "85.36 9.36 4.352 1.253"
                , "22.30 -9.25 -7.36 23.36 9.256;l", "0.36 0.25 0.25 8.36 9.147 8.369");
        List<List<Double>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0.36, 0.25, 0.25, 8.36, 9.147, 8.369));
        try {
            List<List<Double>> actual = parser.parseToDouble(stringCoordinates);
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }
}
