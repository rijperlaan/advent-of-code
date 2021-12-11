package com.rijperlaan.aoc.day06;

import com.rijperlaan.aoc.Util;

import java.util.HashMap;
import java.util.Map;

public class Day6 {
    public static void main(String[] args) {
        String input = Util.readFileAsString("inputs/day6-1.txt");

        System.out.println("--- Part 1 : ---");
        part1(input);

        System.out.println("\n--- Part 2 : ---");
        part2(input);
    }

    public static void part1(String input) {
        calc(input, 80);
    }

    public static void part2(String input) {
        calc(input, 256);
    }

    public static void calc(String input, int days) {
        Map<Integer, Long> map = new HashMap<>();
        String[] initial = input.split(",");

        for (String s : initial) {
            Integer entry = Integer.parseInt(s);
            Long current = map.get(entry);
            if (current == null) {
                map.put(entry, 1L);
                continue;
            }
            map.put(entry, current + 1);
        }

        for (int i = 0; i < days; i++) {
            Map<Integer, Long> newState = new HashMap<>();

            for (int key : map.keySet()) {
                long value = map.get(key);
                key--;
                if (key < 0) {
                    newState.merge(6, value, Long::sum);
                    newState.merge(8, value, Long::sum);
                } else {
                    newState.merge(key, value, Long::sum);
                }
            }
            map = newState;
        }

        long sum = 0;
        for (long value : map.values()) {
            sum += value;
        }
        System.out.println("sum = " + sum);
    }
}
