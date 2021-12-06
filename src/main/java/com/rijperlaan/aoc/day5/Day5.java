package com.rijperlaan.aoc.day5;

import com.rijperlaan.aoc.Util;

import java.util.Arrays;
import java.util.List;

public class Day5 {
    public static void main(String[] args) {
        List<String> input = Util.readFileAsStrings("inputs/day5-1.txt");

        System.out.println("--- Part 1 : ---");
        part1(input);

        System.out.println("\n--- Part 2 : ---");
        part2(input);
    }

    public static void part1(List<String> input) {
        int[][] occurences = new int[1000][1000];
        for (int[] line : occurences) {
            Arrays.fill(line, 0);
        }

        for (String line : input) {
            String[] fromTo = line.split(" -> ");
            String[] from = fromTo[0].split(",");
            String[] to = fromTo[1].split(",");

            int fromX = Integer.parseInt(from[0]);
            int fromY = Integer.parseInt(from[1]);
            int toX = Integer.parseInt(to[0]);
            int toY = Integer.parseInt(to[1]);


            if (fromX == toX) {
                if (fromY > toY) {
                    int temp = fromY;
                    fromY = toY;
                    toY = temp;
                }
                for (int i = fromY; i <= toY; i++) {
                    occurences[fromX][i]++;
                }
            } else if (fromY == toY) {
                if (fromX > toX) {
                    int temp = fromX;
                    fromX = toX;
                    toX = temp;
                }
                for (int i = fromX; i <= toX; i++) {
                    occurences[i][fromY]++;
                }
            }
        }

        int overlaps = 0;
        for (int[] row : occurences) {
            for (int entry : row) {
                if (entry > 1) {
                    overlaps++;
                }
            }
        }

        System.out.println("overlaps = " + overlaps);
    }

    public static void part2(List<String> input) {
        int[][] occurences = new int[1000][1000];
        for (int[] line : occurences) {
            Arrays.fill(line, 0);
        }

        for (String line : input) {
            String[] fromTo = line.split(" -> ");
            String[] from = fromTo[0].split(",");
            String[] to = fromTo[1].split(",");

            int fromX = Integer.parseInt(from[0]);
            int fromY = Integer.parseInt(from[1]);
            int toX = Integer.parseInt(to[0]);
            int toY = Integer.parseInt(to[1]);
            
            if (fromX == toX) {
                if (fromY > toY) {
                    int temp = fromY;
                    fromY = toY;
                    toY = temp;
                }
                for (int i = fromY; i <= toY; i++) {
                    occurences[fromX][i]++;
                }
            } else if (fromY == toY) {
                if (fromX > toX) {
                    int temp = fromX;
                    fromX = toX;
                    toX = temp;
                }
                for (int i = fromX; i <= toX; i++) {
                    occurences[i][fromY]++;
                }
            } else {

                for (int i = 0; i <= Math.abs(toX - fromX); i++) {
                    if (fromX < toX) {
                        if (fromY < toY) {
                            occurences[fromX + i][fromY + i]++;
                        } else {
                            occurences[fromX + i][fromY - i]++;
                        }
                    } else {
                        if (fromY < toY) {
                            occurences[fromX - i][fromY + i]++;
                        } else {
                            occurences[fromX - i][fromY - i]++;
                        }
                    }
                }
            }
        }

        int overlaps = 0;
        for (int[] row : occurences) {
            for (int entry : row) {
                if (entry > 1) {
                    overlaps++;
                }
            }
        }

        System.out.println("overlaps = " + overlaps);
    }
}
