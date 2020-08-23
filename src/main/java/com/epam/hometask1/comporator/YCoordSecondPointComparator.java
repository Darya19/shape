package com.epam.hometask1.comporator;

import com.epam.hometask1.entity.impl.Triangle;

import java.util.Comparator;

public class YCoordSecondPointComparator implements Comparator<Triangle> {

    @Override
    public int compare(Triangle o1, Triangle o2) {
        return (int) (o1.getB().getY() - o2.getB().getY());
    }
}
