package com.epam.hometask1.util;

public class IdCreator {

    private static int id = 1;

    public static int createId() {
        return id++;
    }
}
