package com.rijperlaan.aoc.day12;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cave {
    private String name;
    private List<Cave> connections;
    private boolean big;

    public Cave(String name) {
        this.name = name;
        big = Character.isUpperCase(name.charAt(0));
        connections = new ArrayList<>();
    }

    public void addConnection(Cave cave) {
        if (!connections.contains(cave)) {
            connections.add(cave);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cave cave = (Cave) o;
        return name.equals(cave.name);
    }

    @Override
    public String toString() {
        StringBuilder connectionNames = new StringBuilder();
        for (Cave connection : connections) {
            connectionNames.append(connection.getName());
            if (connections.indexOf(connection) != connections.size() - 1) {
                connectionNames.append(", ");
            }
        }

        return "Cave{" +
                "name='" + name + '\'' +
                ", connections=[" + connectionNames +
                "]}";
    }
}
