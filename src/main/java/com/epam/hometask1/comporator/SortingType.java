package com.epam.hometask1.comporator;

import com.epam.hometask1.entity.Triangle;

import java.util.Comparator;

public enum SortingType implements Comparator<Triangle> {

    ID {
        public int compare(Triangle triangle1, Triangle triangle2) {
            return triangle1.getId() - triangle2.getId();}
    },
    X_COORDINATE_FIRST_POINT{
        public int compare(Triangle o1, Triangle o2) {
            return (int) (o1.getA().getX() - o2.getA().getX());
        }
    },
    Y_COORDINATE_FIRST_POINT{
        public int compare(Triangle o1, Triangle o2) {
            return (int) (o1.getA().getY() - o2.getA().getY());
        }
    },
    X_COORDINATE_SECOND_POINT{
        public int compare(Triangle o1, Triangle o2) {
            return (int) (o1.getB().getX() - o2.getB().getX());
        }
    },
    Y_COORDINATE_SECOND_POINT{
        public int compare(Triangle o1, Triangle o2) {
            return (int) (o1.getB().getY() - o2.getB().getY());
        }
    },
    X_COORDINATE_THIRD_POINT{
        public int compare(Triangle o1, Triangle o2) {
            return (int) (o1.getC().getX() - o2.getC().getX());
        }
    },
    Y_COORDINATE_THIRD_POINT{
        public int compare(Triangle o1, Triangle o2) {
            return (int) (o1.getC().getY() - o2.getC().getY());
        }
    };
}
