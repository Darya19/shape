package com.epam.hometask1.repository;

import com.epam.hometask1.entity.Triangle;

import java.util.function.Predicate;

public interface Specification extends Predicate<Triangle> {
}
