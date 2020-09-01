package com.epam.hometask1.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IdCreator {

    private static int id = 1;

    private static Logger logger = LogManager.getLogger();

    public static int createId() {
        id += id;
        logger.log(Level.INFO, "id is " + id);
        return id;
    }
}
