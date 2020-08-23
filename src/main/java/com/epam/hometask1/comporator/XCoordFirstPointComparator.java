package com.epam.hometask1.comporator;

import com.epam.hometask1.entity.impl.Triangle;

import java.util.Comparator;

public class XCoordFirstPointComparator implements Comparator<Triangle> {

    @Override
    public int compare(Triangle o1, Triangle o2) {
        return (int) (o1.getA().getX() - o2.getA().getX());
    }
}
