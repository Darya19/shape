package com.epam.hometask1.comporator;

import com.epam.hometask1.entity.impl.Triangle;

import java.util.Comparator;

public class YCoordFirstPointComparator implements Comparator<Triangle> {

    @Override
    public int compare(Triangle o1, Triangle o2) {
        return (int) (o1.getA().getY() - o2.getA().getY());
    }
}
