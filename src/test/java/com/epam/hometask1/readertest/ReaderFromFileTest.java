package com.epam.hometask1.readertest;

import com.epam.hometask1.dataprovider.StaticDataProvider;
import com.epam.hometask1.exception.ProjectException;
import com.epam.hometask1.reader.ReaderFromFile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ReaderFromFileTest {

    ReaderFromFile reader;

    @BeforeClass
    public void setUp() {
        reader = new ReaderFromFile();
    }

    @Test(dataProvider = "read coordinates", dataProviderClass = StaticDataProvider.class)
    public void readNumbersFromActualFilePositiveTest(List<String> expected) {
        try {
            List<String> actual = reader.readFromFile("data\\dataFile.txt");
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(dataProvider = "read coordinates", dataProviderClass = StaticDataProvider.class)
    public void readNumbersFromDefaultFilePositiveTest(List<String> expected) {
        try {
            List<String> actual = reader.readFromFile("data\\rrayData.txt");
            assertEquals(actual, expected);
        } catch (ProjectException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProjectException.class)
    public void readNumbersFromFileNegativeTest() throws ProjectException {
        reader.readFromFile("data\\data.mp4");
    }
}
