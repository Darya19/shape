package com.epam.hometask1.repository.impl;

import com.epam.hometask1.entity.Triangle;
import com.epam.hometask1.repository.Specification;

public class IdSpecification implements Specification {

    private int maxId;
    private int minId;

    public IdSpecification(int maxId, int minId) {
        this.maxId = maxId;
        this.minId = minId;
    }

    @Override
    public boolean test(Triangle triangle) {
        return triangle.getId() <= maxId && triangle.getId() > minId;
    }
}
