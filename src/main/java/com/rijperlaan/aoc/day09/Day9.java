package com.rijperlaan.aoc.day09;

import com.rijperlaan.aoc.Util;

import java.util.Arrays;
import java.util.List;

public class Day9 {
    public static void main(String[] args) {
        List<String> input = Util.readFileAsStrings("inputs/day9-1.txt");

        System.out.println("--- Part 1 : ---");
        part1(input);

        System.out.println("\n--- Part 2 : ---");
        part2(input);
    }

    public static void part1(List<String> input) {
        int columns = input.get(0).length();
        int rows = input.size();
        int[][] height = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            char[] chars = input.get(i).toCharArray();
            for (int j = 0; j < columns; j++) {
                height[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }

        int total = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int current = height[i][j];
                int left = 9, right = 9, above = 9, below = 9;

                if (j != 0) {
                    left = height[i][j - 1];
                }
                if (j != (columns - 1)) {
                    right = height[i][j + 1];
                }
                if (i != 0) {
                    above = height[i - 1][j];
                }
                if (i != (rows - 1)) {
                    below = height[i + 1][j];
                }

                if (current < left &&
                        current < right &&
                        current < above &&
                        current < below) {
                    total += current + 1;
                }
            }
        }

        System.out.println("total = " + total);
    }

    public static void part2(List<String> input) {
        int columns = input.get(0).length();
        int rows = input.size();
        int[][] height = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            char[] chars = input.get(i).toCharArray();
            for (int j = 0; j < columns; j++) {
                height[i][j] = Integer.parseInt(String.valueOf(chars[j]));
            }
        }

        int[] top3 = {0, 0, 0};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (height[i][j] < 9) {
                    int basinSize = findBasin(i, j, height);
                    for (int k = 0; k < 3; k++) {
                        if (basinSize > top3[k]) {
                            top3[k] = basinSize;
                            Arrays.sort(top3);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("top3 = " + Arrays.toString(top3));

        int total = top3[0] * top3[1] * top3[2];
        System.out.println("total = " + total);

    }

    public static int findBasin(int i, int j, int[][] height) {
        if (height[i][j] == 9) {
            return 0;
        }
        height[i][j] = 9;
        int total = 1;

        if (j != 0) {
            total += findBasin(i, j - 1, height);
        }
        if (j != (height[i].length - 1)) {
            total += findBasin(i, j + 1, height);
        }
        if (i != 0) {
            total += findBasin(i - 1, j, height);
        }
        if (i != (height.length - 1)) {
            total += findBasin(i + 1, j, height);
        }

        return total;
    }
}
