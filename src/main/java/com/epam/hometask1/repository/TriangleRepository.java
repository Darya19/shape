package com.epam.hometask1.repository;

import com.epam.hometask1.comporator.SortingType;
import com.epam.hometask1.entity.Triangle;
import com.epam.hometask1.exception.ProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository {

    private List<Triangle> triangles;
    private static TriangleRepository repository;

    private static Logger logger = LogManager.getLogger();

    private TriangleRepository() {
        this.triangles = new ArrayList<>();
        logger.log(Level.DEBUG, "repository was created");
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

    public Triangle get(int index) {
        return triangles.get(index);
    }

    public Triangle remove(int index) {
        return triangles.remove(index);
    }

    public int size() {
        return triangles.size();
    }

    public static void main(String[] args) {
        for (int i = 0; i < TriangleRepository.getRepository().size(); i++) {
            System.err.println(TriangleRepository.getRepository().get(i));}
    }
}
