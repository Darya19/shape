package com.epam.hometask1.comporator;

import com.epam.hometask1.entity.Triangle;

import java.util.Comparator;

public class IdComparator  implements Comparator<Triangle> {

    @Override
    public int compare(Triangle triangle1, Triangle triangle2) {
        return triangle1.getId() - triangle2.getId();
    }
}
