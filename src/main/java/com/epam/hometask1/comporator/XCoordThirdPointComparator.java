package com.epam.hometask1.comporator;

import com.epam.hometask1.entity.Triangle;

import java.util.Comparator;

public class XCoordThirdPointComparator implements Comparator<Triangle> {

    @Override
    public int compare(Triangle o1, Triangle o2) {
        return (int) (o1.getC().getX() - o2.getC().getX());
    }
}
