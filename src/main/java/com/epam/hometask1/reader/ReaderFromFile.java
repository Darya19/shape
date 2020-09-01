package com.epam.hometask1.reader;

import com.epam.hometask1.exception.ProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromFile {

    private static final String DEFAULT_FILE = "data\\defaultFile.txt";

    private static Logger logger = LogManager.getLogger();

    public List<String> readFromFile(String file) throws ProjectException {
        List<String> stringLines = new ArrayList<>();
        String line;
        Path path = Paths.get(file);
        if (Files.notExists(path)) {
            path = Paths.get(DEFAULT_FILE);
            logger.log(Level.INFO, "file wasn't found, was used default file");
        }
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((line = reader.readLine()) != null) {
                stringLines.add(line);
            }
            logger.log(Level.INFO, "file was read");
            return stringLines;
        } catch (IOException e) {
            throw new ProjectException("reading issues", e);
        }
    }
}
