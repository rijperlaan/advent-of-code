package com.rijperlaan.aoc.day12;

import com.rijperlaan.aoc.Util;

import java.util.ArrayList;
import java.util.List;

public class Day12 {
    private static int paths = 0;
    private static Cave start = null;
    private static Cave end = null;
    private static List<Cave> caves = new ArrayList<>();
    private static List<String> solutions = new ArrayList<>();


    public static void main(String[] args) {
        List<String> input = Util.readFileAsStrings("inputs/day12-1.txt");

        System.out.println("--- Part 1 : ---");
        part1(input);

        System.out.println("\n--- Part 2 : ---");
        part2(input);
    }

    public static void part1(List<String> input) {
        setup(input);

        List<Cave> visited = new ArrayList<>();
        explore(start, visited);
        System.out.println("paths = " + paths);
    }

    public static void part2(List<String> input) {
        setup(input);

        List<Cave> visited = new ArrayList<>();
        explore(start, visited, false);

        System.out.println("paths = " + paths);
    }

    private static void setup(List<String> input) {
        paths = 0;
        for (String line : input) {
            String[] nodes = line.split("-");

            Cave cave = new Cave(nodes[0]);
            Cave cave1 = new Cave(nodes[1]);

            if (caves.contains(cave)) {
                caves.get(caves.indexOf(cave)).addConnection(cave1);
            } else {
                cave.addConnection(cave1);
                caves.add(cave);
            }

            if (caves.contains(cave1)) {
                caves.get(caves.indexOf(cave1)).addConnection(cave);
            } else {
                cave1.addConnection(cave);
                caves.add(cave1);
            }
        }

        for (Cave cave : caves) {
            if (cave.getName().equals("start")) {
                start = cave;
            }
            if (cave.getName().equals("end")) {
                end = cave;
            }
        }
    }

    private static void explore(Cave cave, List<Cave> visited) {
        cave = caves.get(caves.indexOf(cave));
        if (cave.equals(end)) {
            paths++;
        } else {
            if (!cave.isBig()) {
                visited.add(cave);
            }
            for (Cave connection : cave.getConnections()) {
                if (!connection.equals(start) && !visited.contains(connection)) {
                    explore(connection, new ArrayList<>(visited));
                }
            }
        }
    }

    private static void explore(Cave cave, List<Cave> visited, boolean visitedTwice) {
        cave = caves.get(caves.indexOf(cave));
        if (cave.equals(end)) {
            paths++;
        } else {
            if (!cave.isBig()) {
                visited.add(cave);
            }
            for (Cave connection : cave.getConnections()) {
                if (!connection.equals(start)) {
                    if (!visited.contains(connection)) {
                        explore(connection, new ArrayList<>(visited), visitedTwice);
                    } else if (!visitedTwice) {
                        explore(connection, new ArrayList<>(visited), true);
                    }
                }
            }
        }
    }

}
