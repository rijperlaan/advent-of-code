package com.rijperlaan.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 {
    public static void main(String[] args) {
        List<String> input = Util.readFileAsStrings("inputs/day3-1.txt");
        part1(input);
        part2(input);
    }

    public static void part1(List<String> input) {
        System.out.println("--- Part 1 : ---");

        int length = input.get(0).length();

        int[] zeros = new int[length];
        int[] ones = new int[length];
        Arrays.fill(zeros, 0);
        Arrays.fill(ones, 0);

        for (String line : input) {
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '0') {
                    zeros[i]++;
                } else if (chars[i] == '1') {
                    ones[i]++;
                }
            }
        }

        StringBuilder gammaBuilder = new StringBuilder();
        StringBuilder epsilonBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (zeros[i] > ones[i]) {
                gammaBuilder.append("0");
                epsilonBuilder.append("1");
            } else if (zeros[i] < ones[i]) {
                gammaBuilder.append("1");
                epsilonBuilder.append("0");
            } else {
                throw new RuntimeException("Equal amount of zeros and ones.");
            }
        }

        String gamma = gammaBuilder.toString();
        String epsilon = epsilonBuilder.toString();

        System.out.println("gamma = " + gamma);
        System.out.println("epsilon = " + epsilon);

        int gammaDecimal = Integer.parseInt(gamma, 2);
        int epsilonDecimal = Integer.parseInt(epsilon, 2);

        System.out.println("result = " + gammaDecimal * epsilonDecimal);

    }

    public static void part2(List<String> input) {
        System.out.println("\n--- Part 2 : ---");

        String oxygen = filterList(input, 0, true).get(0);
        String co2 = filterList(input, 0, false).get(0);

        System.out.println("oxygen = " + oxygen);
        System.out.println("co2 = " + co2);

        int oxygenDecimal = Integer.parseInt(oxygen, 2);
        int co2Decimal = Integer.parseInt(co2, 2);

        System.out.println("result = " + oxygenDecimal * co2Decimal);

    }

    public static List<String> filterList(List<String> list, int index, boolean mostCommon) {
        if (list.size() <= 1) {
            return list;
        }

        List<String> result = new ArrayList<>();

        int zeros = 0;
        int ones = 0;

        for (String line : list) {
            if (line.charAt(index) == '0') {
                zeros++;
            }
            if (line.charAt(index) == '1') {
                ones++;
            }
        }

        if (mostCommon) {
            for (String line : list) {
                if (zeros > ones && line.charAt(index) == '0') {
                    result.add(line);
                } else if (zeros <= ones && line.charAt(index) == '1') {
                    result.add(line);
                }
            }
        } else {
            for (String line : list) {
                if (zeros <= ones && line.charAt(index) == '0') {
                    result.add(line);
                } else if (zeros > ones && line.charAt(index) == '1') {
                    result.add(line);
                }
            }
        }

        return filterList(result, index + 1, mostCommon);
    }
}
