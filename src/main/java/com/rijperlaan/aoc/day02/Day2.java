package com.rijperlaan.aoc.day02;

import com.rijperlaan.aoc.Util;

import java.util.List;

public class Day2 {

    public static void main(String[] args) {
        System.out.println("--- Part 1 : ---");
        part1();
        System.out.println("\n--- Part 2 : ---");
        part2();
    }

    public static void part1() {
        List<String> input = Util.readFileAsStrings("inputs/day2-1.txt");

        int horizontal = 0;
        int depth = 0;

        for (String step : input) {
            String[] parts = step.split(" ");
            String command = parts[0];
            int amount = Integer.parseInt(parts[1]);

            switch (command) {
                case "forward" -> horizontal += amount;
                case "up" -> depth -= amount;
                case "down" -> depth += amount;
            }
        }

        System.out.println("horizontal = " + horizontal);
        System.out.println("depth = " + depth);
        System.out.println("horizontal * depth = " + horizontal * depth);
    }

    public static void part2() {
        List<String> input = Util.readFileAsStrings("inputs/day2-1.txt");

        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (String step : input) {
            String[] parts = step.split(" ");
            String command = parts[0];
            int amount = Integer.parseInt(parts[1]);

            switch (command) {
                case "forward" -> {
                    horizontal += amount;
                    depth += aim * amount;
                }
                case "up" -> aim -= amount;
                case "down" -> aim += amount;
            }
        }

        System.out.println("horizontal = " + horizontal);
        System.out.println("depth = " + depth);
        System.out.println("horizontal * depth = " + horizontal * depth);
    }
}
