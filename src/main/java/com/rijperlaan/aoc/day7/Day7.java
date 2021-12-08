package com.rijperlaan.aoc.day7;

import java.util.Arrays;

import com.rijperlaan.aoc.Util;

public class Day7 {
    public static void main(String[] args) {
        String input = Util.readFileAsString("inputs/day7-1.txt");

        System.out.println("--- Part 1 : ---");
        part1(input);

        System.out.println("\n--- Part 2 : ---");
        part2(input);
    }

    public static void part1(String input) {
        String[] inputs = input.split(",");
        int[] array = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            array[i] = Integer.parseInt(inputs[i]);
        }
        int median = median(array);

        int total = 0;
        for (int i : array) {
            total += Math.abs(median - i);
        }
        System.out.println("total = " + total);
    }

    public static void part2(String input) {
        String[] inputs = input.split(",");
        int[] array = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            array[i] = Integer.parseInt(inputs[i]);
        }

        //Brute force
        int max = Arrays.stream(array).max().orElse(0);
        int min = Arrays.stream(array).min().orElse(0);
        int lowest = Integer.MAX_VALUE;

        for (int i = min; i <= max; i++) {
            int total = 0;
            for (int num : array) {
                int steps = Math.abs(i - num);
                // n-th triangle number
                total += (steps * (steps + 1) / 2);
            }

            if (total < lowest) {
                lowest = total;
            }
        }

        System.out.println("lowest = " + lowest);
    }

    public static int median(int[] array) {
        Arrays.sort(array);
        if (array.length % 2 == 0) {
            return (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        } else {
            return array[array.length / 2];
        }
    }
}
