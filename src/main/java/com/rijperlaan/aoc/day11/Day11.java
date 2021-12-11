package com.rijperlaan.aoc.day11;

import com.rijperlaan.aoc.Util;

import java.util.Arrays;
import java.util.List;

public class Day11 {
    public static int counter = 0;

    public static void main(String[] args) {
        List<String> input = Util.readFileAsStrings("inputs/day11-1.txt");

        System.out.println("--- Part 1 : ---");
        part1(input);

        System.out.println("\n--- Part 2 : ---");
        part2(input);
    }

    public static void part1(List<String> input) {
        int size = 10;
        int[][] octopuses = new int[size][size];
        boolean[][] flashed = new boolean[size][size];


        for (int i = 0; i < size; i++) {
            char[] line = input.get(i).toCharArray();
            for (int j = 0; j < size; j++) {
                octopuses[i][j] = Integer.parseInt(String.valueOf(line[j]));
            }
        }

        for (int step = 0; step < 100; step++) {
            for (int i = 0; i < size; i++) {
                Arrays.fill(flashed[i], false);
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    increase(i, j, octopuses, flashed);
                }
            }

        }

        System.out.println("counter = " + counter);
    }

    public static void increase(int i, int j, int[][] octopuses, boolean[][] flashed) {
        if (i < 0 || j < 0 || i >= octopuses.length || j >= octopuses[0].length) {
            return;
        }
        if (flashed[i][j]) {
            return;
        }

        octopuses[i][j]++;

        if (octopuses[i][j] > 9) {
            counter++;
            octopuses[i][j] = 0;
            flashed[i][j] = true;

            increase(i, j + 1, octopuses, flashed);
            increase(i, j - 1, octopuses, flashed);
            increase(i + 1, j, octopuses, flashed);
            increase(i - 1, j, octopuses, flashed);
            increase(i + 1, j + 1, octopuses, flashed);
            increase(i + 1, j - 1, octopuses, flashed);
            increase(i - 1, j + 1, octopuses, flashed);
            increase(i - 1, j - 1, octopuses, flashed);
        }
    }

    public static void part2(List<String> input) {
        int size = 10;
        int[][] octopuses = new int[size][size];
        boolean[][] flashed = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            char[] line = input.get(i).toCharArray();
            for (int j = 0; j < size; j++) {
                octopuses[i][j] = Integer.parseInt(String.valueOf(line[j]));
            }
        }

        for (int step = 1; step <= 1000; step++) {
            for (int i = 0; i < size; i++) {
                Arrays.fill(flashed[i], false);
            }
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    increase(i, j, octopuses, flashed);
                    boolean allFlashed = check(flashed);
                    if (allFlashed) {
                        System.out.println("step = " + step);
                        return;
                    }
                }
            }
        }
    }

    public static boolean check(boolean[][] flashed) {
        for (boolean[] row : flashed) {
            for (boolean flash : row) {
                if (!flash) {
                    return false;
                }
            }
        }
        return true;
    }
}
