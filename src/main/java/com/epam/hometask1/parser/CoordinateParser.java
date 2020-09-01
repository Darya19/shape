package com.epam.hometask1.parser;

import com.epam.hometask1.exception.ProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CoordinateParser {

    private final String REGEX = "^(-?\\p{Digit}*\\.?\\p{Digit}+) (-?\\p{Digit}*\\.?\\p{Digit}+) " +
            "(-?\\p{Digit}*\\.?\\p{Digit}+) (-?\\p{Digit}*\\.?\\p{Digit}+) (-?\\p{Digit}*\\.?\\p{Digit}+)" +
            " (-?\\p{Digit}*\\.?\\p{Digit}+)$";

    private static Logger logger = LogManager.getLogger();

    public List<List<Double>> parseToDouble(List<String> values) throws ProjectException {
        List<List<Double>> listOfTriangles = new ArrayList<>();
        int i = 0;
        try {
            for (String line : values) {
                if (line.matches(REGEX)) {
                    listOfTriangles.add(i, new ArrayList<>());
                    String[] coordinates = line.split(" ");
                    for (String coordinate : coordinates) {
                        double tmp = Double.parseDouble(coordinate);
                        listOfTriangles.get(i).add(tmp);
                    }
                    ++i;
                }
            }
            logger.log(Level.INFO, "file's lines were parsed");
            return listOfTriangles;
        } catch (NumberFormatException e) {
            throw new ProjectException("parsing issues", e);
        }
    }
}
