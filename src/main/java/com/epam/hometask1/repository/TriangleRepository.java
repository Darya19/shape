package com.epam.hometask1.repository;

import com.epam.hometask1.comporator.SortingType;
import com.epam.hometask1.entity.impl.Triangle;
import com.epam.hometask1.exception.ProjectException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository {

    private List<Triangle> triangles;
    private static TriangleRepository repository;

    private TriangleRepository() {
        this.triangles = new ArrayList<>();
    }

    public static TriangleRepository getRepository() {
        if (repository == null) {
            repository = new TriangleRepository();
        }
        return repository;
    }

    public boolean add(Triangle triangle) throws ProjectException {
        if (triangle == null) {
            throw new ProjectException("Incorrect data");
        }
        return triangles.add(triangle);
    }

    public boolean remove(Triangle triangle) throws ProjectException {
        if (triangle == null) {
            throw new ProjectException("Incorrect data");
        }
        return triangles.remove(triangle);
    }

    public List<Triangle> sort(SortingType type) throws ProjectException {
        if (type == null) {
            throw new ProjectException("Incorrect data");
        }
        List<Triangle> sortedList = triangles.stream().sorted(type).collect(Collectors.toList());
        return sortedList;
    }

    public List<Triangle> query(Specification specification) {
        List<Triangle> sortedList = triangles.stream().filter(specification).collect(Collectors.toList());
        return sortedList;
    }
}
