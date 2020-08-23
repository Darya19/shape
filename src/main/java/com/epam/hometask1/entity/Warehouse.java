package com.epam.hometask1.entity;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private Map<Integer, TriangleParameters> parameters;
    private static Warehouse warehouse;

    public Warehouse() {
        this.parameters = new HashMap<>();
    }

    public static Warehouse getParameters() {
        if (warehouse == null) {
            warehouse = new Warehouse();
        }
        return warehouse;
    }

    public TriangleParameters get(Object key) {
        return parameters.get(key);
    }

    public TriangleParameters put(Integer key, TriangleParameters value) {
        return parameters.put(key, value);
    }

    public TriangleParameters remove(Object key) {
        return parameters.remove(key);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Warehouse{");
        sb.append("parameters=").append(parameters);
        sb.append('}');
        return sb.toString();
    }
}
